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
import com.guigu.instructional.po.ClassroomInfo;
import com.guigu.instructional.po.DisciplineInfo;

@Controller
@RequestMapping("/classinfo/classroominfo/")
public class ClassroomInfoController {

	@Resource(name="classroomInfoServiceImpl")
	private ClassroomInfoService classroomInfoService;
	
	 @RequestMapping("add.action")
	    public String addClassroomInfo(Model model,@Validated ClassroomInfo classroomInfo, BindingResult bindingResult) throws Exception {
			if (bindingResult.hasErrors()) {
				
				List<ObjectError> allErrors= bindingResult.getAllErrors();
				
				model.addAttribute("allErrors", allErrors);
				model.addAttribute("classroomInfo",classroomInfo);
				return "classinfo/classroominfo/classroominfo_add";
			}
		 
		 classroomInfo.setClassroomMark("1");
	       boolean result= classroomInfoService.addClassroom(classroomInfo);
	       if(result) {
	           model.addAttribute("info","��ӳɹ�");
	       }else {
	           model.addAttribute("info","���ʧ��");
	       }
	       return this.list(null, model);
	       
	    }
	 
	  @RequestMapping("list.action")
		public String list(ClassroomInfo classroomInfo,Model model) {
			List<ClassroomInfo> list=classroomInfoService.getClassroomInfoList(classroomInfo);
			model.addAttribute("list",list);
			return "classinfo/classroominfo/classroominfo_list";
		
		}
	  

	    @RequestMapping("load.action")
	    public String loadUpate(Integer classroomId,Model model) {
	    	ClassroomInfo classroomInfo =classroomInfoService.getClassroomInfo(classroomId);
	        model.addAttribute("classroomInfo", classroomInfo);
	        return "classinfo/classroominfo/classroominfo_update";
	    }
	    
	    @RequestMapping("update.action")
	    public String updateStaffInfo(Model model,@Validated ClassroomInfo classroomInfo, BindingResult bindingResult) throws Exception {
			if (bindingResult.hasErrors()) {
				
				List<ObjectError> allErrors= bindingResult.getAllErrors();
				
				model.addAttribute("allErrors", allErrors);
				model.addAttribute("classroomInfo",classroomInfo);
				return "classinfo/classroominfo/classroominfo_update";
			}
	    	
	    	boolean result=classroomInfoService.updateClassroom(classroomInfo);
	        if(result) {
	            model.addAttribute("info", "�޸ĳɹ�");
	        }else {
	            model.addAttribute("info", "�޸�ʧ��");
	        }
	        return this.list(null, model);
	    }
	    
	    @RequestMapping("delete.action")
	    public String deleteStaffInfo(ClassroomInfo classroomInfo,Model model) {
	        
	        //����Ա��Ϊ 0   ������Ч
	    	classroomInfo.setClassroomMark("0");
	        
	        boolean result =classroomInfoService.updateClassroom(classroomInfo);
	        if(result) {
	            model.addAttribute("info", "ɾ���ɹ�");
	        }else {
	            model.addAttribute("info", "ɾ��ʧ��");
	        }
	        return this.list(null, model);
	    }
	    
}
