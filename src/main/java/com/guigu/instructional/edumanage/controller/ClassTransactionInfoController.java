package com.guigu.instructional.edumanage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.edumanage.service.ClasstranService;
import com.guigu.instructional.po.ClassTransactionInfo;

@Controller
@RequestMapping("/edumanage/transaction")
public class ClassTransactionInfoController {
	
	@Resource(name="classtranServiceImpl")
	private ClasstranService classtranService;

	@RequestMapping("add.action")
    public String add(ClassTransactionInfo classTransactionInfo,Model model) {
				
		System.out.println("11111111");
		
	   boolean result= classtranService.addClasstran(classTransactionInfo);
	   
	   System.out.println(result);
	   
       if(result) {
           model.addAttribute("info","添加成功");
       }else {
           model.addAttribute("info","添加失败");
       }
       return this.list(null, model);       
    }
    
    @RequestMapping("list.action")
    public String list(ClassTransactionInfo classTransactionInfo,Model model) {
    	
        List<ClassTransactionInfo> list =classtranService.getClasstranInfoList(classTransactionInfo);
        
        System.out.println(list);
        model.addAttribute("list", list);      
        return "edumanage/transaction/transaction_list";
    }
    
//    @RequestMapping("show.action")
//    public String showStaffInfo(Integer staffId,Model model) {
//        StaffInfo staffInfo =staffInfoService.getStaffInfo(staffId);
//        model.addAttribute("staffInfo", staffInfo);
//        return "system/staffinfo/staffinfo_show";
//        
//    }
    
    @RequestMapping("load.action")
    public String loadUpdate(Integer classTransactionId,Model model) {
    	ClassTransactionInfo classTransactionInfo =classtranService.getClasstranInfo(classTransactionId);
        model.addAttribute("classTransactionInfo", classTransactionInfo);
        return "edumanage/transaction/transaction_update";
    }
    
    @RequestMapping("update.action")
    public String updateClassTransactionInfo(ClassTransactionInfo classTransactionInfo,Model model) {
        boolean result=classtranService.updateClasstran(classTransactionInfo);
        if(result) {
            model.addAttribute("info", "修改成功");
        }else {
            model.addAttribute("info", "修改失败");
        }
        return this.list(null, model);
    }
    
    @RequestMapping("delete.action")
    public String deleteClassTransactionInfo(ClassTransactionInfo classTransactionInfo,Model model) {
        
        
        
        boolean result =classtranService.updateClasstran(classTransactionInfo);
        if(result) {
            model.addAttribute("info", "删除成功");
        }else {
            model.addAttribute("info", "删除失败");
        }
        return this.list(null, model);
    }
	

	
	
}
