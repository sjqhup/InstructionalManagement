package com.guigu.instructional.classinfo.service;

import java.util.List;

import com.guigu.instructional.po.ClassroomInfo;

public interface ClassroomInfoService {

    public boolean addClassroom(ClassroomInfo classroomInfo);
	
	public boolean updateClassroom(ClassroomInfo classroomInfo);

	public List<ClassroomInfo> getClassroomInfoList(ClassroomInfo classroomInfo);

	public ClassroomInfo getClassroomInfo(Integer classroomId);

}
