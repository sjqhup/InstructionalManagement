package com.guigu.instructional.classinfo.service;

import java.util.List;

import com.guigu.instructional.po.ClassInfo;
import com.guigu.instructional.po.Cross;



public interface CrossService {
	public boolean addCross(ClassInfo classInfo);
	
	public boolean updateCross(ClassInfo classInfo);
	
	public List<Cross> getCrossList(ClassInfo classInfo);
	
	public ClassInfo getClassInfo(Integer classId);
}
