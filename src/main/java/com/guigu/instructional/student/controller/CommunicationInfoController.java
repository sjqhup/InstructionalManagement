package com.guigu.instructional.student.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.CommunicationInfo;
import com.guigu.instructional.po.CommunicationInfoCustom;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.student.service.CommunicationService;
import com.guigu.instructional.student.service.StudentInfoService;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/student/communicateinfo/")
public class CommunicationInfoController {

	@Resource(name="communicationServiceImpl")
	public CommunicationService communicationService;
	
	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	@Resource(name="staffInfoServiceImpl")
	public StaffInfoService staffInfoService;
	
	@RequestMapping("list.action")
	public String findCommunicationList(StudentInfo studentInfo,Model model) {
		List<CommunicationInfoCustom> list=communicationService.findCommunicationList(studentInfo);
		model.addAttribute("list",list);
		return "student/communicateinfo/communicateinfo_list";
	}
	
	@RequestMapping("add.action")
	public String addCommunication(Model model,@Validated CommunicationInfo communicationInfo,BindingResult bindingResult) {
	 if(bindingResult.hasErrors()) {
				
		List<ObjectError> allErrors=bindingResult.getAllErrors();
		model.addAttribute("allErrors", allErrors);
		
		List<StudentInfo> studentInfolist=studentInfoService.getStudentInfoList(null);
		model.addAttribute("studentInfolist",studentInfolist);
		
		List<StaffInfo> staffInfolist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("staffInfolist",staffInfolist);
		
		model.addAttribute("communicationInfo",communicationInfo);
		
		return "student/communicateinfo/communicateinfo_add";
	 }
		boolean result=communicationService.addCommunication(communicationInfo);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		
		return this.findCommunicationList(null, model);
	}
	
	@RequestMapping("addload.action")
	public String list(Integer communicationId,Model model) {
//		CommunicationInfoCustom communicationInfoCustom=communicationService.findCommunication(communicationId);
//		model.addAttribute("communicationInfoCustom",communicationInfoCustom);
		
		List<StudentInfo> studentInfolist=studentInfoService.getStudentInfoList(null);
		model.addAttribute("studentInfolist",studentInfolist);
		
		List<StaffInfo> staffInfolist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("staffInfolist",staffInfolist);
		
		return "student/communicateinfo/communicateinfo_add";
	}
	
	@RequestMapping("load.action")
	public String loadUpdate(Integer communicationId,Model model) {
		CommunicationInfoCustom communicationInfoCustom=communicationService.findCommunication(communicationId);
		model.addAttribute("communicationInfoCustom",communicationInfoCustom);
		
		List<StudentInfo> studentInfolist=studentInfoService.getStudentInfoList(null);
		model.addAttribute("studentInfolist",studentInfolist);
		
		List<StaffInfo> staffInfolist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("staffInfolist",staffInfolist);
		return "student/communicateinfo/communicateinfo_update";
	}
	
	@RequestMapping("update.action")
	public String updateCommunication(Model model,@Validated CommunicationInfo communicationInfo,BindingResult bindingResult) {
		 if(bindingResult.hasErrors()) {
				
				List<ObjectError> allErrors=bindingResult.getAllErrors();
				model.addAttribute("allErrors", allErrors);
				
				List<StudentInfo> studentInfolist=studentInfoService.getStudentInfoList(null);
				model.addAttribute("studentInfolist",studentInfolist);
				
				List<StaffInfo> staffInfolist=staffInfoService.getStaffInfoList(null);
				model.addAttribute("staffInfolist",staffInfolist);
				
				model.addAttribute("communicationInfo",communicationInfo);
				
				return this.loadUpdate(communicationInfo.getCommunicationId(), model);
			 }	
		boolean result=communicationService.updateCommunication(communicationInfo);
		if(result) {
			model.addAttribute("info","修改成功");
		}else {
			model.addAttribute("info","修改失败");
		}
		return this.findCommunicationList(null, model);
	}
	
	@RequestMapping("delete.action")
	public String deleteCommunication(Integer communicationId,Model model) {
		boolean result=communicationService.deleteCommunication(communicationId);
		if(result) {
			model.addAttribute("info","删除成功");
		}else {
			model.addAttribute("info","删除失败");
		}
		return this.findCommunicationList(null, model);
	}
}
