package com.guigu.instructional.student.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.student.service.EvaluationInfoService;
import com.guigu.instructional.student.service.StudentInfoService;

@Controller
@RequestMapping("/student/evaluationinfo/")
public class EvaluationInfoController {

	@Resource(name = "evaluationInfoServiceImpl")
	public EvaluationInfoService evaluationInfoService;

	@Resource(name = "studentInfoServiceImpl")
	public StudentInfoService studentInfoService;

	@RequestMapping("list.action")
	public String listEvaluationList(EvaluationInfo evaluationInfo, Model model) {
		List<EvaluationInfo> list = evaluationInfoService.findEvaluationInfoList(evaluationInfo);
		model.addAttribute("list", list);
		return "student/evaluationinfo/evaluationinfo_list";
	}

	@RequestMapping("add.action")
	public String addEvaluation(Model model,@Validated EvaluationInfo evaluationInfo,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
			
		List<ObjectError> allErrors=bindingResult.getAllErrors();
		model.addAttribute("allErrors", allErrors);
		
		List<StudentInfo> studentlist = studentInfoService.getStudentInfoList(null);
		model.addAttribute("studentlist", studentlist);
		
		model.addAttribute("evaluationInfo",evaluationInfo);
		return "student/evaluationinfo/evaluationinfo_add";
        }
		boolean result=evaluationInfoService.addEvaluationInfo(evaluationInfo);
		if(result) {
			model.addAttribute("info","��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		
		return this.listEvaluationList(null, model);
		
	}

	@RequestMapping("addload.action")
	public String listStudentId(Integer evaluationId, Model model) {
		EvaluationInfo evaluationInfo = evaluationInfoService.findEvaluationInfo(evaluationId);
		model.addAttribute("evaluationInfo", evaluationInfo);

		List<StudentInfo> studentlist = studentInfoService.getStudentInfoList(null);
		model.addAttribute("studentlist", studentlist);

		return "student/evaluationinfo/evaluationinfo_add";
	}

	@RequestMapping("load.action")
	public String loadUpate(Integer evaluationId, Model model) {
		EvaluationInfo evaluationInfo = evaluationInfoService.findEvaluationInfo(evaluationId);
		model.addAttribute("evaluationInfo", evaluationInfo);
		List<StudentInfo> studentlist = studentInfoService.getStudentInfoList(null);
		model.addAttribute("studentlist", studentlist);
		return "student/evaluationinfo/evaluationinfo_update";
	}

	@RequestMapping("update.action")
	public String updateEvaluation(Model model,@Validated EvaluationInfo evaluationInfo,BindingResult bindingResult) {
	 if(bindingResult.hasErrors()) {
				
		List<ObjectError> allErrors=bindingResult.getAllErrors();
		model.addAttribute("allErrors", allErrors);				
		List<StudentInfo> studentlist = studentInfoService.getStudentInfoList(null);
		model.addAttribute("studentlist", studentlist);
				
		model.addAttribute("evaluationInfo",evaluationInfo);
		return "student/evaluationinfo/evaluationinfo_update";
		
}
		boolean result = evaluationInfoService.updateEvaluationInfo(evaluationInfo);
		if (result) {
			model.addAttribute("info", "�޸ĳɹ�");
		} else {
			model.addAttribute("info", "�޸�ʧ��");
		}
		return this.listEvaluationList(null, model);

	}

	@RequestMapping("delete.action")
	public String deleteEvaluationResult(Integer evaluationId, Model model) {
		boolean result = evaluationInfoService.deleteEvaluationInfo(evaluationId);

		if (result) {
			model.addAttribute("info", "ɾ���ɹ�");
		} else {
			model.addAttribute("info", "ɾ��ʧ��");
		}
		return this.listEvaluationList(null, model);

	}
}
