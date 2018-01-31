package com.guigu.instructional.student.controller;

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
import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeCustom;
import com.guigu.instructional.student.mapper.StudentWriteGradeMapper;
import com.guigu.instructional.student.service.StudentInfoService;
import com.guigu.instructional.student.service.StudentWriteGradeService;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/student/studentwritegrade/")
public class StudentWriteGradeController {

	@Resource(name="studentWriteGradeServiceImpl")
	private StudentWriteGradeService studentWriteGradeService;
	
	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	@Resource(name="staffInfoServiceImpl")
	public StaffInfoService staffInfoService;
	
	@RequestMapping("list.action")
	public String ListStudentWriteGrade(StudentInfo studentInfo,Model model) {
		List<StudentWriteGradeCustom> list =studentWriteGradeService.findStudentWriteGradeList(studentInfo);
		model.addAttribute("list",list);
		return "student/studentwritegrade/studentwritegrade_list";
	}
	
	@RequestMapping("add.action")
	public String addStudentWriteGrade(Model model,@Validated StudentWriteGrade studentWriteGrade,BindingResult bindingResult) {
	if(bindingResult.hasErrors()) {
		List<ObjectError> allErrors=bindingResult.getAllErrors();
		model.addAttribute("allErrors", allErrors);
		
		List<StudentInfo> studentInfolist=studentInfoService.getStudentInfoList(null);
		model.addAttribute("studentInfolist",studentInfolist);
		
		List<StaffInfo> staffInfolist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("staffInfolist",staffInfolist);
		
		model.addAttribute("studentWriteGrade",studentWriteGrade);
		return "student/studentwritegrade/studentwritegrade_add";
	}
		boolean result=studentWriteGradeService.addStudnetWriteGrade(studentWriteGrade);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		
		return this.ListStudentWriteGrade(null, model);
	}
	
	@RequestMapping("addload.action")
	public String list(Integer writeGradeId,Model model) {
	
		
		List<StudentInfo> studentInfolist=studentInfoService.getStudentInfoList(null);
		model.addAttribute("studentInfolist",studentInfolist);
		
		
		List<StaffInfo> staffInfolist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("staffInfolist",staffInfolist);
		
		return "student/studentwritegrade/studentwritegrade_add";
		
	}
	@RequestMapping("load.action")
	public String lodaUpdate(Integer writeGradeId,Model model) {
		StudentWriteGradeCustom studentWriteGradeCustom=studentWriteGradeService.findStudentWriteGrade(writeGradeId);
		model.addAttribute("studentWriteGradeCustom",studentWriteGradeCustom);
		
		List<StudentInfo> studentInfolist=studentInfoService.getStudentInfoList(null);
		model.addAttribute("studentInfolist",studentInfolist);
		
		List<StaffInfo> staffInfolist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("staffInfolist",staffInfolist);
		return "student/studentwritegrade/studentwritegrade_update";
	}
	
	@RequestMapping("update.action")
	public String updateStudentWriteGrade(Model model,@Validated StudentWriteGrade studentWriteGrade,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			List<StudentInfo> studentInfolist=studentInfoService.getStudentInfoList(null);
			model.addAttribute("studentInfolist",studentInfolist);
			
			List<StaffInfo> staffInfolist=staffInfoService.getStaffInfoList(null);
			model.addAttribute("staffInfolist",staffInfolist);
			
			model.addAttribute("studentWriteGrade",studentWriteGrade);
			return this.lodaUpdate(studentWriteGrade.getWriteGradeId(), model);
		}
		boolean result=studentWriteGradeService.updateStudnetWriteGrade(studentWriteGrade);
		if(result) {
			model.addAttribute("info","修改成功");
		}else {
			model.addAttribute("info","修改失败");
		}
		
		return this.ListStudentWriteGrade(null, model);
	}
	
	@RequestMapping("delete.action")
	public String deleteStudentWriteGrade(Integer writeGradeId,Model model) {
		boolean result=studentWriteGradeService.deleteStudentWriteGrade(writeGradeId);
		if(result) {
			model.addAttribute("info","删除成功");
		}else {
			model.addAttribute("info","删除失败");
		}
		
		return this.ListStudentWriteGrade(null, model);
	}
}
