package com.guigu.instructional.edumanage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.edumanage.service.AttendanceInfoService;
import com.guigu.instructional.po.AttendanceInfo;
import com.guigu.instructional.po.RoleInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.student.service.StudentInfoService;


@Controller
@RequestMapping("/edumanage/attendance/")
public class AttendanceInfoController {

	  @Resource(name="attendanceInfoServiceImpl")
	  private AttendanceInfoService attendanceInfoService;
	
	  @Resource(name="studentInfoServiceImpl")
	  private StudentInfoService studentInfoService;
	  
	    @RequestMapping("list.action")
	    public String list(AttendanceInfo attendanceInfo,Model model) {   	
	        List<AttendanceInfo> list =attendanceInfoService.getAttendanceInfoList(attendanceInfo);
	        System.out.println(list);
	        model.addAttribute("list", list);	        
	        return "edumanage/attendance/attendance_list";
	    }
	    
	    
	    @RequestMapping("loadadd.action")
	    public String loadadd(AttendanceInfo attendanceInfo,Model model) {
	    	
	  	List<StudentInfo> studentList = studentInfoService.getStudentInfoList(null);
	    	
	 	model.addAttribute("studentList", studentList);
	    	
	        return "edumanage/attendance/attendance_add";
	    }
	    
	    @RequestMapping("add.action")
	    public String add(AttendanceInfo attendanceInfo,Model model) {
	    
	    	attendanceInfo.setAttendanceState("1");
	    	
	        boolean reuslt = attendanceInfoService.addAttendanceInfo(attendanceInfo);
	 
	        if(reuslt) {
	            model.addAttribute("info", "添加成功");
	        }else {
	            model.addAttribute("info", "添加失败");
	        }
	        
	        return this.list(null, model);
	                
	    }
	    
	    @RequestMapping("load.action")
	    public String load(Integer attendanceId,Model model) {
	    	AttendanceInfo attendanceInfo =attendanceInfoService.getAttendanceInfo(attendanceId);
	        model.addAttribute("attendanceInfo", attendanceInfo);
	        return "edumanage/attendance/attendance_update";
	        
	    }
	    @RequestMapping("delete.action")
	    public String delete(Integer attendanceId,Model model) {
	    	AttendanceInfo attendanceInfo=attendanceInfoService.getAttendanceInfo(attendanceId);
	    	attendanceInfo.setAttendanceState("0");
	        
	        boolean reuslt = attendanceInfoService.updateAttendanceInfo(attendanceInfo);
	        if(reuslt) {
	            model.addAttribute("info", "删除成功");
	        }else {
	            model.addAttribute("info", "删除失败");
	        }
	        return this.list(null, model);
	    }
	    
	    @RequestMapping("update.action")
	    public String update(AttendanceInfo attendanceInfo,Model model) {
	        boolean result=attendanceInfoService.updateAttendanceInfo(attendanceInfo);
	        if(result) {
	            model.addAttribute("info", "修改成功");
	        }else {
	            model.addAttribute("info", "修改失败");
	        }
	        return this.list(null, model);
	    }
	    
	  
}
