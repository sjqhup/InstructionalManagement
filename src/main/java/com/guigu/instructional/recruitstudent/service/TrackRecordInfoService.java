package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.TrackRecordCustom;
import com.guigu.instructional.po.TrackRecordInfo;

public interface TrackRecordInfoService {

	public boolean addTrackRecord(TrackRecordInfo trackRecordInfo);
	
	public boolean updateTrackRecord(TrackRecordInfo trackRecordInfo);
	//É¾³ý  
	public Integer deleteTrackRecord(Integer trackRecordId);
	
	public TrackRecordInfo getTrackRecordInfo(Integer trackRecordId);
	

//	public boolean addTrackRecordCustom(TrackRecordInfo trackRecordInfo,StudentInfo studentInfo);
//	public boolean updateTrackRecordCustom(TrackRecordInfo trackRecordInfo,StudentInfo studentInfo);
	public List<TrackRecordCustom> getTrackRecordCustomList(StudentInfo studentInfo);

	public List<TrackRecordInfo> getTrackRecordInfoList(TrackRecordInfo trackRecordInfo);
	
	


	
}
