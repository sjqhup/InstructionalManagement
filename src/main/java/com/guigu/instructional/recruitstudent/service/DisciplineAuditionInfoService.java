package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.DisciplineInfo;



public interface DisciplineAuditionInfoService {
	
   
	public List<DisciplineInfo> getDisciplineListByName(DisciplineInfo disciplineAuditionInfo);
	
   
	public DisciplineInfo getDisciplineInfo(Integer disciplineId);
	
   
	public List<DisciplineInfo> getDisciplineList(DisciplineInfo disciplineInfo) ;

	public List<DisciplineInfo> getDisciplineInfoList(DisciplineInfo disciplineInfo);
}
