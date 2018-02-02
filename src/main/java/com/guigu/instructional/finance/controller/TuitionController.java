package com.guigu.instructional.finance.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.finance.service.SalaryService;
import com.guigu.instructional.finance.service.TuitionService;
import com.guigu.instructional.finance.service.impl.TuitionServiceImpl;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StaffSalary;
import com.guigu.instructional.po.StudentPayment;
import com.guigu.instructional.po.StudentPaymentOrder;

@Controller
@RequestMapping("/finance/tuition")
public class TuitionController {
	
	@Resource(name="tuitionServiceImpl")
	private TuitionService tuitionService;
	
	@RequestMapping("list.action")
	public String findTuitionForList(StudentPaymentOrder studentPaymentOrder,Model model) {
		System.out.println(studentPaymentOrder);
		List<StudentPaymentOrder> list =tuitionService.findTuitionForList(studentPaymentOrder);
        model.addAttribute("list", list);
        
        return "finance/tuition/Tuition_list";
	}
	@RequestMapping("show.action")
	public String showTuition(Integer studentPaymentId,Model model){
		StudentPayment studentPayment=tuitionService.findTuitionForId(studentPaymentId);
		model.addAttribute("studentPayment", studentPayment);
        return "finance/tuition/Tuition_show";
	}
	@RequestMapping("add.action")
	public String addTuition(Model model,@Validated StudentPayment studentPayment,BindingResult bindingResult){
		this.tuitionValidation(studentPayment, bindingResult);
		if(bindingResult.hasErrors()) {
			List<ObjectError> Errors=bindingResult.getAllErrors();
			model.addAttribute("Errors",Errors);
			return "finance/tuition/Tuition_add";
		}
		boolean result=tuitionService.addTuition(studentPayment);
		if(result) {
	           model.addAttribute("info","��ӳɹ�");
	       }else {
	           model.addAttribute("info","���ʧ��");
	       }
	       return this.findTuitionForList(new StudentPaymentOrder(), model);
	}
	@RequestMapping("update.action")
	public String updateTuition(Model model,@Validated StudentPayment studentPayment,BindingResult bindingResult) {
		this.tuitionValidation(studentPayment, bindingResult);
		if(bindingResult.hasErrors()) {
			List<ObjectError> Errors=bindingResult.getAllErrors();
			for (ObjectError objectError : Errors) {
				System.out.println(objectError);
			}
			model.addAttribute("Errors",Errors);
			return "finance/tuition/Tuition_update";
		}
		boolean result=tuitionService.updateTuition(studentPayment);
		if(result) {
	           model.addAttribute("info","�޸ĳɹ�");
	       }else {
	           model.addAttribute("info","�޸�ʧ��");
	       }
	     return this.findTuitionForList(new StudentPaymentOrder(), model);
	}
	@RequestMapping("load.action")
	public String loadTuition(Integer studentPaymentId,Model model) {
		System.out.println(studentPaymentId);
		StudentPayment studentPayment=tuitionService.findTuitionForId(studentPaymentId);
		System.out.println(studentPayment);
		model.addAttribute("studentPayment",studentPayment);
		return "finance/tuition/Tuition_update";
	}
	
	
	@RequestMapping("delete.action")
	public String deleteTuition(Integer studentPaymentId,Model model) {
		boolean result=tuitionService.deleteTuition(studentPaymentId);
		if(result) {
	           model.addAttribute("info","ɾ���ɹ�");
	       }else {
	           model.addAttribute("info","ɾ��ʧ��");
	       }
	     return this.findTuitionForList(new StudentPaymentOrder(), model);
	}
	public void tuitionValidation( StudentPayment studentPayment,BindingResult bindingResult){
		Double ShouldAmount=studentPayment.getPaymentShouldAmount();
		Double RealAmount=studentPayment.getPaymentRealAmount();
		Double DebtAmount=studentPayment.getPaymentDebtAmount();
		Double DiscountAmount=studentPayment.getPaymentDiscountAmount();
		if(ShouldAmount!=null&&RealAmount!=null&&DebtAmount!=null&&DiscountAmount!=null) {
			if(ShouldAmount!=RealAmount+DiscountAmount+DebtAmount) {
				bindingResult.addError(new ObjectError("studentPayment","Ӧ��ѧ��Ӧ����������Ŀ���ܺ�"));
				//list.add(new ObjectError(objectName, defaultMessage));
			}
		}
		
	}
}
