package com.guigu.instructional.classinfo.service;

import java.util.List;

import com.guigu.instructional.po.StaffInfo;

public interface TeacherService {
	 public boolean addStaff(StaffInfo staffInfo);
	 
	 public boolean updateStaff(StaffInfo staffInfo);
	 
	 public List<StaffInfo> getStaffInfoList(StaffInfo staffInfo);
	 
	 public StaffInfo getStaffInfo(Integer staffId);
}
