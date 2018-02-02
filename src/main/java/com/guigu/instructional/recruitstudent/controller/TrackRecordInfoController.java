package com.guigu.instructional.recruitstudent.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.TrackRecordCustom;
import com.guigu.instructional.po.TrackRecordInfo;
import com.guigu.instructional.recruitstudent.service.StudentPoolInfoService;
import com.guigu.instructional.recruitstudent.service.TrackRecordInfoService;

@Controller
@RequestMapping("/recruitstudent/trackrecord")
public class TrackRecordInfoController {
	
	@Resource(name="trackRecordInfoServiceImpl")
	private TrackRecordInfoService trackRecordInfoService;
	
	@Resource(name = "studentPoolInfoServiceImpl")
	private StudentPoolInfoService studentPoolInfoService;
	
	
	

	@RequestMapping("list.action")
	public String list(TrackRecordInfo trackRecordInfo,Model model) {
		List<TrackRecordInfo> list=trackRecordInfoService.getTrackRecordInfoList(trackRecordInfo);
		model.addAttribute("list",list);
		return "recruitstudent/trackrecord/trackrecord_list";
	}
	//display里面的元素  list  保持一致
	
	
	@RequestMapping("addload.action")
	public String listTrackRecordInfoId(Integer trackRecordId,Model model) {
		TrackRecordInfo trackRecordInfo=trackRecordInfoService.getTrackRecordInfo(trackRecordId);
		model.addAttribute("trackRecordInfo",trackRecordInfo);
		//查询所有的员工
		List<TrackRecordInfo> trackRecordInfolist=trackRecordInfoService.getTrackRecordInfoList(null);
		model.addAttribute("trackRecordInfolist",trackRecordInfolist);
		return "recruitstudent/trackrecord/trackrecord_add";
	}
	
	
	@RequestMapping("add.action")
	public String addTrackRecord(Model model,@Validated TrackRecordInfo trackRecordInfo,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			
			//查询所有的员工
			List<StudentInfo> studentPoolInfolist=studentPoolInfoService.getStudentInfoList(null);
			
			model.addAttribute("studentPoolInfolist",studentPoolInfolist);
			 
			model.addAttribute("trackRecordInfo",trackRecordInfo);
			
			return "recruitstudent/trackrecord/trackrecord_add";
		}
		
		boolean result=trackRecordInfoService.addTrackRecord(trackRecordInfo);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		
		return this.list(null, model);
	}
	
	
	

	//删除操作
	@RequestMapping("delete.action")
	public String delete(Integer trackRecordId, Model model) throws Exception{
		int reuslt = trackRecordInfoService.deleteTrackRecord(trackRecordId);
		if (reuslt > 0) {
			model.addAttribute("info", "删除成功");
		} else {
			model.addAttribute("info", "删除失败");
		}
		return this.list(null, model);
	}

	@RequestMapping("load.action")
	public String loadUpdate(Integer trackRecordId, Model model) {

		TrackRecordInfo trackRecordInfo = trackRecordInfoService.getTrackRecordInfo(trackRecordId);
		model.addAttribute("trackRecordInfo", trackRecordInfo);

		List<StudentInfo> slist = studentPoolInfoService.getStudentInfoList(null);
		model.addAttribute("studentPoolInfolist", slist);

		return "recruitstudent/trackrecord/trackrecord_update";
	}
	    //加载数据的操作  结果是跳转到修改数据的页面
	
	
	  @RequestMapping("update.action")
		public String updateTrackRecord(Model model,@Validated TrackRecordInfo trackRecordInfo,BindingResult bindingResult) {
			  if(bindingResult.hasErrors()) {
					
					List<ObjectError> allErrors=bindingResult.getAllErrors();
					model.addAttribute("allErrors", allErrors);
					
					
					//查询所有的员工
					List<StudentInfo> studentPoolInfolist=studentPoolInfoService.getStudentInfoList(null);
					model.addAttribute("studentPoolInfolist",studentPoolInfolist);
					 
					model.addAttribute("trackRecordInfo", trackRecordInfo);
					
					return "recruitstudent/trackrecord/trackrecord_update";
				}
			boolean result=trackRecordInfoService.updateTrackRecord(trackRecordInfo);
			if(result) {
				model.addAttribute("info","更新成功");
			}else {
				model.addAttribute("info","更新失败");
			}
			
			return this.list(null, model);
			
		}
	
	

}
