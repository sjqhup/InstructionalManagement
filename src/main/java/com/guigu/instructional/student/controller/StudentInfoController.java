package com.guigu.instructional.student.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guigu.instructional.po.DataDictionary;
import com.guigu.instructional.po.ExportExcelUtils;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.student.service.StudentInfoService;
import com.guigu.instructional.system.service.StaffInfoService;


@Controller
@RequestMapping("/student/student/")
public class StudentInfoController {

	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	@RequestMapping("list.action")
	public String list(StudentInfo studentInfo,Model model) {
		List<StudentInfo> list=studentInfoService.getStudentInfoList(studentInfo);
		model.addAttribute("list",list);
		return "student/student/student_list";
	}
	
	@RequestMapping("add.action")
	public String addStudent(Model model,@Validated StudentInfo studentInfo,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			
			//查询所有的员工
			List<StaffInfo> staffInfolist=staffInfoService.getStaffInfoList(null);
			model.addAttribute("staffInfolist",staffInfolist);
			 
			model.addAttribute("studentInfo", studentInfo);
			
			return "student/student/student_add";
		}
		
		studentInfo.setStudentState(1);
		boolean result=studentInfoService.addStudent(studentInfo);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		
		return this.list(null, model);
	}
	
	@RequestMapping("addload.action")
	public String listStaffId(Integer studentId,Model model) {
		StudentInfo studentInfo=studentInfoService.getStudentInfo(studentId);
		model.addAttribute("studentInfo",studentInfo);
		//查询所有的员工
		List<StaffInfo> staffInfolist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("staffInfolist",staffInfolist);
		return "student/student/student_add";
	}
	
	 @RequestMapping("load.action")
	 public String loadUpate(Integer studentId,Model model) {
	        StudentInfo studentInfo =studentInfoService.getStudentInfo(studentId);
	        
	      //查询所有的员工
			List<StaffInfo> staffInfolist=staffInfoService.getStaffInfoList(null);
			model.addAttribute("staffInfolist",staffInfolist);
	        
	        model.addAttribute("studentInfo", studentInfo);
	        return "student/student/student_update";
	    }
	  
	  @RequestMapping("update.action")
	public String updateStudent(Model model,@Validated StudentInfo studentInfo,BindingResult bindingResult) {
		  if(bindingResult.hasErrors()) {
				
				List<ObjectError> allErrors=bindingResult.getAllErrors();
				model.addAttribute("allErrors", allErrors);
				
				
				//查询所有的员工
				List<StaffInfo> staffInfolist=staffInfoService.getStaffInfoList(null);
				model.addAttribute("staffInfolist",staffInfolist);
				 
				model.addAttribute("studentInfo", studentInfo);
				
				return "student/student/student_update";
			}
		boolean result=studentInfoService.updateStudent(studentInfo);
		if(result) {
			model.addAttribute("info","更新成功");
		}else {
			model.addAttribute("info","更新失败");
		}
		
		return this.list(null, model);
		
	}
	  @RequestMapping("delete.action")
	  public String deleteStudent(StudentInfo studentInfo,Model model) {
		  studentInfo.setStudentState(0);
		  
		  boolean result=studentInfoService.updateStudent(studentInfo);
		  if(result) {
			  model.addAttribute("info","删除成功");
		  }else {
			  model.addAttribute("info","删除失败");
		  }
		  return this.list(null, model);
	  }
	  
}   
		   
