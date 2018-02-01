package com.guigu.instructional.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/classinfo/teacher/")
public class TeacherController {
	@Resource(name = "staffInfoServiceImpl")
    private StaffInfoService staffInfoService;

	@RequestMapping("add.action")
    public String addStaffInfo(@Validated StaffInfo staffInfo,BindingResult bindingResult,Model model) {
	if(bindingResult.hasErrors()) {
	           //���������Ϣ
	           List<ObjectError> allErrors=bindingResult.getAllErrors();
	           //��������Ϣ���ݵ�ҳ��
	           model.addAttribute("allErrors", allErrors);
	           return "classinfo/teacher/teacher_add";
	       }
       staffInfo.setStaffState("1");
       boolean result= staffInfoService.addStaff(staffInfo);
       if(result) {
           model.addAttribute("info","��ӳɹ�");
       }else {
           model.addAttribute("info","���ʧ��");
       }
       return this.list(null, model);      
    }
	
	 @RequestMapping("list.action")
	    public String list(StaffInfo staffInfo,Model model) {
	        List<StaffInfo> list =staffInfoService.getStaffInfoList(staffInfo);
	        model.addAttribute("list", list);
	        
	        return "classinfo/teacher/teacher_list";
	    }
	 
	 @RequestMapping("show.action")
	    public String showStaffInfo(Integer staffId,Model model) {
	        StaffInfo staffInfo =staffInfoService.getStaffInfo(staffId);
	        model.addAttribute("staffInfo", staffInfo);
	        return "classinfo/teacher/teacher_show";
	        
	    }
	 
	 @RequestMapping("load.action")
	    public String loadUpate(Integer staffId,Model model) {
	        StaffInfo staffInfo =staffInfoService.getStaffInfo(staffId);
	        model.addAttribute("staffInfo", staffInfo);
	        return "classinfo/teacher/teacher_update";
	    }
	 
	 @RequestMapping("update.action")
	    public String updateStaffInfo(@Validated StaffInfo staffInfo,BindingResult bindingResult,Model model) {
		    if(bindingResult.hasErrors()) {
	            //���������Ϣ
	            List<ObjectError> allErrors=bindingResult.getAllErrors();
	            //��������Ϣ���ݵ�ҳ��
	            model.addAttribute("allErrors", allErrors);
	            return "classinfo/teacher/teacher_update";
	        }
	        boolean result=staffInfoService.updateStaff(staffInfo);
	        if(result) {
	            model.addAttribute("info", "�޸ĳɹ�");
	        }else {
	            model.addAttribute("info", "�޸�ʧ��");
	        }

	        return this.list(null, model);
	    }
	 
	 @RequestMapping("delete.action")
	    public String deleteStaffInfo(StaffInfo staffInfo,Model model) {
	        
	        //����Ա��Ϊ 0   ������Ч
	        staffInfo.setStaffState("0");
	        
	        boolean result =staffInfoService.updateStaff(staffInfo);
	        if(result) {
	            model.addAttribute("info", "ɾ���ɹ�");
	        }else {
	            model.addAttribute("info", "ɾ��ʧ��");
	        }
	        return this.list(null, model);
	    }
}
