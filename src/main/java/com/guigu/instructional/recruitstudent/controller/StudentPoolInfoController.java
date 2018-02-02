package com.guigu.instructional.recruitstudent.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.recruitstudent.service.StudentPoolInfoService;
import com.guigu.instructional.system.service.StaffInfoService;


@Controller
@RequestMapping("/recruitstudent/studentpool/")
public class StudentPoolInfoController {

	@Resource(name="studentPoolInfoServiceImpl")
	private StudentPoolInfoService studentPoolInfoService;
	
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffStudentInfoService;
	
	@RequestMapping("list.action")
	public String list(StudentInfo studentInfo,Model model) {
		List<StudentInfo> list=studentPoolInfoService.getStudentInfoList(studentInfo);
		model.addAttribute("list",list);
		return "recruitstudent/studentpool/studentpool_list";
	}
	
	@RequestMapping("add.action")
	public String addStudent(Model model,@Validated StudentInfo studentPoolInfo,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			
			//��ѯ���е�Ա��
			List<StaffInfo> staffStudentInfolist=staffStudentInfoService.getStaffInfoList(null);
			model.addAttribute("staffStudentInfolist",staffStudentInfolist);
			 
			model.addAttribute("studentPoolInfo", studentPoolInfo);
			
			return "recruitstudent/studentpool/studentpool_add";
		}
		
		studentPoolInfo.setStudentState(0);
		boolean result=studentPoolInfoService.addStudent(studentPoolInfo);
		if(result) {
			model.addAttribute("info","��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		
		return this.list(null, model);
	}
	
	@RequestMapping("addload.action")
	public String listStaffId(Integer studentId,Model model) {
		StudentInfo studentPoolInfo=studentPoolInfoService.getStudentInfo(studentId);
		model.addAttribute("studentInfo",studentPoolInfo);
		//��ѯ���е�Ա��
		List<StaffInfo> staffStudentInfolist=staffStudentInfoService.getStaffInfoList(null);
		model.addAttribute("staffStudentInfolist",staffStudentInfolist);
		return "recruitstudent/studentpool/studentpool_add";
	}
	
	 @RequestMapping("load.action")
	 public String loadUpate(Integer studentId,Model model) {
	        StudentInfo studentPoolInfo =studentPoolInfoService.getStudentInfo(studentId);
	        
	      //��ѯ���е�Ա��
			List<StaffInfo> staffStudentInfolist=staffStudentInfoService.getStaffInfoList(null);
			model.addAttribute("staffStudentInfolist",staffStudentInfolist);
	        
	        model.addAttribute("studentPoolInfo", studentPoolInfo);
	        return "recruitstudent/studentpool/studentpool_update";
	    }
	  
	  @RequestMapping("update.action")
	public String updateStudent(Model model,@Validated StudentInfo studentPoolInfo,BindingResult bindingResult) {
		  if(bindingResult.hasErrors()) {
				
				List<ObjectError> allErrors=bindingResult.getAllErrors();
				model.addAttribute("allErrors", allErrors);
				
				
				//��ѯ���е�Ա��
				List<StaffInfo> staffStudentInfolist=staffStudentInfoService.getStaffInfoList(null);
				model.addAttribute("staffStudentInfolist",staffStudentInfolist);
				 
				model.addAttribute("studentPoolInfo", studentPoolInfo);
				
				return "recruitstudent/studentpool/studentpool_update";
			}
		boolean result=studentPoolInfoService.updateStudent(studentPoolInfo);
		if(result) {
			model.addAttribute("info","���³ɹ�");
		}else {
			model.addAttribute("info","����ʧ��");
		}
		
		return this.list(null, model);
		
	}
	  @RequestMapping("delete.action")
	  public String deleteStudent(StudentInfo studentPoolInfo,Model model) {
		  studentPoolInfo.setStudentState(null);
		  
		  boolean result=studentPoolInfoService.updateStudent(studentPoolInfo);
		  if(result) {
			  model.addAttribute("info","ɾ���ɹ�");
		  }else {
			  model.addAttribute("info","ɾ��ʧ��");
		  }
		  return this.list(null, model);
	  }


@RequestMapping("register.action")
public String updateStudent(StudentInfo studentPoolInfo,Model model) {
	  studentPoolInfo.setStudentState(1);
	  
	  boolean result=studentPoolInfoService.updateStudent(studentPoolInfo);
	  if(result) {
		  model.addAttribute("info","ɾ���ɹ�");
	  }else {
		  model.addAttribute("info","ɾ��ʧ��");
	  }
	  return this.list(null, model);
}
}

