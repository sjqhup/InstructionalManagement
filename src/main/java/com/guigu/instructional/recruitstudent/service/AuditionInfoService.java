package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.AuditionCustom;
import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StudentInfo;


public interface AuditionInfoService {

	public boolean addAudition(AuditionInfo auditionInfo);
	//添加
	public boolean updateAudition(AuditionInfo auditionInfo);
	//更新
	public List<AuditionInfo> getAuditionInfoList(AuditionInfo auditionInfo);

	public AuditionInfo getAuditionInfo(Integer auditionId);
	//根据ID去查询
	
	public int deleteAudition(Integer auditionId);
    //直接根据跟踪记录来进行对应的删除  删除成功之后返回1 不成功返回0
	public List<AuditionCustom> getAuditionCustomList(StudentInfo studentInfo,DisciplineInfo disciplineInfo);
	
}
