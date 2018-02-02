package com.guigu.instructional.edumanage.service;

import java.util.List;

import com.guigu.instructional.po.AttendanceInfo;

public interface AttendanceInfoService {
	
    public boolean addAttendanceInfo(AttendanceInfo attendanceInfo);
    
    public boolean updateAttendanceInfo(AttendanceInfo attendanceInfo);
    
    public List<AttendanceInfo> getAttendanceInfoList(AttendanceInfo attendanceInfo);
    
    public AttendanceInfo getAttendanceInfo(Integer attendanceId);
}
