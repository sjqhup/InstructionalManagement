package com.guigu.instructional.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.ClassroomInfoService;
import com.guigu.instructional.classinfo.service.CrossService;
import com.guigu.instructional.classinfo.service.DisciplineInfoService;
import com.guigu.instructional.classinfo.service.SyllabusInfoService;
import com.guigu.instructional.classinfo.service.TeacherService;
import com.guigu.instructional.po.ClassInfo;
import com.guigu.instructional.po.ClassroomInfo;
import com.guigu.instructional.po.Cross;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.RoleInfo;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.SyllabusInfo;

@Controller
@RequestMapping("/classinfo/classinfo")
public class CrossController {

	@Resource(name="crossServiceImpl")
	private CrossService crossservice;
	
	@Resource(name="disciplineInfoServiceImpl")
	private DisciplineInfoService disciplineInfoService;
	
	@Resource(name="classroomInfoServiceImpl")
	private ClassroomInfoService classroomInfoService;
	
	@Resource(name="syllabusInfoServiceImpl")
	private SyllabusInfoService syllabusInfoService;
	
	@Resource(name="teacherServiceImpl")
	private TeacherService teacherService;
	
	
	 @RequestMapping("add.action")
	    public String addCross(@Validated ClassInfo classInfo,BindingResult bindingResult,Model model) {
		 
		 if(bindingResult.hasErrors()) {
	            //输出错误信息
	            List<ObjectError> allErrors=bindingResult.getAllErrors();
	            //将错误信息传递到页面
	            List<DisciplineInfo> disciplineInfoList =disciplineInfoService.getDisciplineInfoList(null);
	   		    List<ClassroomInfo> classroomInfoList =classroomInfoService.getClassroomInfoList(null);
	   		    List<SyllabusInfo> syllabusInfoList =syllabusInfoService.getSyllabusInfoList(null);
	   		    List<StaffInfo> teacherList=teacherService.getStaffInfoList(null);
	   		    model.addAttribute("disciplineInfoList", disciplineInfoList);
			    model.addAttribute("classroomInfoList", classroomInfoList);
			    model.addAttribute("syllabusInfoList", syllabusInfoList);
			    model.addAttribute("teacherList", teacherList);
	            model.addAttribute("allErrors", allErrors);
	            return "classinfo/classinfo/classinfo_add";
	        }
		 classInfo.setClassIsused("1");
		 classInfo.setClassState("1");
	       boolean result= crossservice.addCross(classInfo);
	       if(result) {
	           model.addAttribute("info","添加成功");
	       }else {
	           model.addAttribute("info","添加失败");
	       }
	       return this.listCross(null, model);
	       
	    }
	 
	 @RequestMapping("loadCross.action")
	    public String loadCross(Integer classId,Model model) {
		 ClassInfo classInfo =crossservice.getClassInfo(classId);
		 
		 List<DisciplineInfo> disciplineInfoList =disciplineInfoService.getDisciplineInfoList(null);
		 List<ClassroomInfo> classroomInfoList =classroomInfoService.getClassroomInfoList(null);
		 List<SyllabusInfo> syllabusInfoList =syllabusInfoService.getSyllabusInfoList(null);
		 List<StaffInfo> teacherList=teacherService.getStaffInfoList(null);
		 
		 model.addAttribute("disciplineInfoList", disciplineInfoList);
		 model.addAttribute("classroomInfoList", classroomInfoList);
		 model.addAttribute("syllabusInfoList", syllabusInfoList);
		 model.addAttribute("teacherList", teacherList);
		 
	     return "classinfo/classinfo/classinfo_add";
	    } 
	 
	 
	 
	 
	 @RequestMapping("loadCross1.action")
	    public String loadCross1(Integer classId,Model model) {	 
		 ClassInfo classInfo =crossservice.getClassInfo(classId);
		 
		 List<DisciplineInfo> disciplineInfoList =disciplineInfoService.getDisciplineInfoList(null);
		 List<ClassroomInfo> classroomInfoList =classroomInfoService.getClassroomInfoList(null);
		 List<SyllabusInfo> syllabusInfoList =syllabusInfoService.getSyllabusInfoList(null);
		 List<StaffInfo> teacherList=teacherService.getStaffInfoList(null);
		 
		 model.addAttribute("classInfo", classInfo);
		 model.addAttribute("disciplineInfoList", disciplineInfoList);
		 model.addAttribute("classroomInfoList", classroomInfoList);
		 model.addAttribute("syllabusInfoList", syllabusInfoList);
		 model.addAttribute("teacherList", teacherList);
		 
	     return "classinfo/classinfo/classinfo_update";
	    } 
	 @RequestMapping("update.action")
	 public String updateClassInfo(@Validated ClassInfo classInfo,BindingResult bindingResult,Model model) {
		 if(bindingResult.hasErrors()) {
	            //输出错误信息
	            List<ObjectError> allErrors=bindingResult.getAllErrors();
	            //将错误信息传递到页面
	            model.addAttribute("allErrors", allErrors);
	            return "classinfo/classinfo/classinfo_update";
	        }
		 boolean result =crossservice.updateCross(classInfo);
		 if(result) {
	            model.addAttribute("info", "变更成功");
	        }else {
	            model.addAttribute("info", "变更失败");
	        }
		
		 return this.listCross(null, model);
	 }

	
	 
	@RequestMapping("list.action")
	public String listCross(ClassInfo classInfo,Model model) {
		List<Cross> list=crossservice.getCrossList(classInfo);
		model.addAttribute("list", list);
		return "classinfo/classinfo/classinfo_list";
	}
	
	
	 @RequestMapping("delete.action")
	    public String deleteClassInfo(ClassInfo classInfo,Model model) {
		     classInfo.setClassIsused("0");
	        
	        boolean reuslt = crossservice.updateCross(classInfo);
	        if(reuslt) {
	            model.addAttribute("info", "删除成功");
	        }else {
	            model.addAttribute("info", "删除失败");
	        }
	        return this.listCross(null, model);
	    }
	
}
