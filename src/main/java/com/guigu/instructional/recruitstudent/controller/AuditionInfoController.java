package com.guigu.instructional.recruitstudent.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.recruitstudent.service.AuditionInfoService;
import com.guigu.instructional.recruitstudent.service.DisciplineAuditionInfoService;
import com.guigu.instructional.recruitstudent.service.StudentPoolInfoService;

@Controller
@RequestMapping("/recruitstudent/auditioninfo")
public class AuditionInfoController {

	@Resource(name ="auditionInfoServiceImpl")
	private AuditionInfoService auditionInfoService;

	@Resource(name ="studentPoolInfoServiceImpl")
	private StudentPoolInfoService studentPoolInfoService;

	@Resource(name ="disciplineAuditionInfoServiceImpl")
	private DisciplineAuditionInfoService disciplineAuditionInfoService;



	
	
	

	@RequestMapping("list.action")
	public String list(AuditionInfo auditionInfo, Model model) throws Exception{
		List<AuditionInfo> list = auditionInfoService.getAuditionInfoList(auditionInfo);
		model.addAttribute("auditionlist", list);
		return "recruitstudent/auditioninfo/auditioninfo_list";
	}
	

	@RequestMapping("add.action")
	public String addAudition(Model model,@Validated AuditionInfo auditionInfo,BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			
			//查询所有的员工
			List<StudentInfo> studentPoolInfolist=studentPoolInfoService.getStudentInfoList(null);
			model.addAttribute("studentPoolInfolist",studentPoolInfolist);
			
			List<DisciplineInfo> disciplineAuditionInfolist=disciplineAuditionInfoService.getDisciplineInfoList(null);
			model.addAttribute("disciplineAuditionInfolist",disciplineAuditionInfolist);
			 
			model.addAttribute("auditionInfo", auditionInfo);
			
			return "recruitstudent/auditioninfo/auditioninfo_add";
		}
		
		
		boolean result=auditionInfoService.addAudition(auditionInfo);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.list(null, model);
	}
	
	
	@RequestMapping("addload.action")
	public String listStudentId(Integer studentId,Model model) {
		StudentInfo studentPoolInfo=studentPoolInfoService.getStudentInfo(studentId);
		model.addAttribute("studentInfo",studentPoolInfo);
		//查询所有的学生
		List<StudentInfo> studentPoolInfolist=studentPoolInfoService.getStudentInfoList(null);
		model.addAttribute("studentPoolInfolist",studentPoolInfolist);
		return "recruitstudent/audition/audition_add";
	}
		
	
	
	@RequestMapping("load.action")
	 public String loadUpate(Integer auditionId,Model model) {
	        AuditionInfo auditionInfo =auditionInfoService.getAuditionInfo(auditionId);
	        
	      //查询所有的员工
			List<StudentInfo> studentPoolInfolist=studentPoolInfoService.getStudentInfoList(null);
			model.addAttribute("studentPoolInfolist",studentPoolInfolist);
			
			List<DisciplineInfo> disciplineAuditionInfolist=disciplineAuditionInfoService.getDisciplineInfoList(null);
			model.addAttribute("disciplineAuditionInfolist",disciplineAuditionInfolist);
	        
	        model.addAttribute("auditionInfo", auditionInfo);
	        return "recruitstudent/studentpool/studentpool_update";
	    }
	
	
	

	  @RequestMapping("update.action")
	public String updateAudition(Model model,@Validated AuditionInfo auditionInfo,BindingResult bindingResult) throws Exception {
		  if(bindingResult.hasErrors()) {
				
				List<ObjectError> allErrors=bindingResult.getAllErrors();
				model.addAttribute("allErrors", allErrors);
				
				
				//查询所有的员工
				List<StudentInfo> studentPoolInfolist=studentPoolInfoService.getStudentInfoList(null);
				model.addAttribute("studentPoolInfolist",studentPoolInfolist);
				
				List<DisciplineInfo> disciplineAuditionInfolist=disciplineAuditionInfoService.getDisciplineInfoList(null);
				model.addAttribute("disciplineAuditionInfolist",disciplineAuditionInfolist);
				model.addAttribute("auditionInfo", auditionInfo);
				
				return "recruitstudent/auditioninfo/auditioninfo_update";
			}
		  
		  
		boolean result=auditionInfoService.updateAudition(auditionInfo);
		if(result) {
			model.addAttribute("info","更新成功");
		}else {
			model.addAttribute("info","更新失败");
		}
		
		return this.list(null, model);
		
	}
	
	
	

	//删除操作
	@RequestMapping("delete.action")
	public String delete(Integer auditionId, Model model) throws Exception{

		int reuslt = auditionInfoService.deleteAudition(auditionId);
		if (reuslt > 0) {
			model.addAttribute("info", "删除成功");
		} else {
			model.addAttribute("info", "删除失败");
		}
		return this.list(null, model);
	}


	
	
	///
	


}
