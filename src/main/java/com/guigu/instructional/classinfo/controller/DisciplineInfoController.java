package com.guigu.instructional.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.DisciplineInfoService;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.SyllabusInfo;

@Controller
@RequestMapping("/classinfo/disciplineinfo/")
public class DisciplineInfoController {
     
	@Resource(name="disciplineInfoServiceImpl")
	private DisciplineInfoService disciplineInfoService;
	
	
	 @RequestMapping("add.action")
	    public String addStaffInfo(Model model,@Validated DisciplineInfo disciplineInfo, BindingResult bindingResult) throws Exception{
			if (bindingResult.hasErrors()) {
				
				List<ObjectError> allErrors= bindingResult.getAllErrors();
				
				model.addAttribute("allErrors", allErrors);
				model.addAttribute("disciplineInfo",disciplineInfo);
				return "classinfo/disciplineinfo/disciplineinfo_add";
			}  
		 
		 disciplineInfo.setDisciplineIsused("1");
	       boolean result= disciplineInfoService.addDiscipline(disciplineInfo);
	       if(result) {
	           model.addAttribute("info","添加成功");
	       }else {
	           model.addAttribute("info","添加失败");
	       }
	       return this.list(null, model);
	       
	    }
	
	
    @RequestMapping("list.action")
	public String list(DisciplineInfo disciplineInfo,Model model) {
		List<DisciplineInfo> list=disciplineInfoService.getDisciplineInfoList(disciplineInfo);
		model.addAttribute("list",list);
		return "classinfo/disciplineinfo/disciplineinfo_list";
	
	}
    
    
    
    @RequestMapping("load.action")
    public String loadUpate(Integer disciplineId,Model model) {
        DisciplineInfo disciplineInfo =disciplineInfoService.getDisciplineInfo(disciplineId);
        model.addAttribute("disciplineInfo", disciplineInfo);
        return "classinfo/disciplineinfo/disciplineinfo_update";
    }
    
    
    @RequestMapping("update.action")
    public String updateStaffInfo(Model model,@Validated DisciplineInfo disciplineInfo, BindingResult bindingResult) throws Exception{
		if (bindingResult.hasErrors()) {
			
			List<ObjectError> allErrors= bindingResult.getAllErrors();
			
			model.addAttribute("allErrors", allErrors);
			model.addAttribute("disciplineInfo",disciplineInfo);
			return "classinfo/disciplineinfo/disciplineinfo_update";
		}  
        
    	
    	boolean result=disciplineInfoService.updateDiscipline(disciplineInfo);
        if(result) {
            model.addAttribute("info", "修改成功");
        }else {
            model.addAttribute("info", "修改失败");
        }
        return this.list(null, model);
    }
    
    
    
    @RequestMapping("delete.action")
    public String deleteStaffInfo(DisciplineInfo disciplineInfo,Model model) {
        
        //设置员工为 0   代表无效
    	disciplineInfo.setDisciplineIsused("0");
        
        boolean result =disciplineInfoService.updateDiscipline(disciplineInfo);
        if(result) {
            model.addAttribute("info", "删除成功");
        }else {
            model.addAttribute("info", "删除失败");
        }
        return this.list(null, model);
    }
  
    
}
