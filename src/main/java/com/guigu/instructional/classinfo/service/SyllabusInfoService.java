package com.guigu.instructional.classinfo.service;

import java.util.List;
import com.guigu.instructional.po.SyllabusInfo;

public interface SyllabusInfoService {
	
	public boolean addSyllabus(SyllabusInfo syllabusInfo);
	
	public boolean updateSyllabus(SyllabusInfo syllabusInfo);
	
	public List<SyllabusInfo> getSyllabusInfoList(SyllabusInfo syllabusInfo);
	
	public SyllabusInfo getSyllabusInfo(Integer syllabusId);


}
