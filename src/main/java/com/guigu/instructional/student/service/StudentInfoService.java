package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.StudentInfo;

public interface StudentInfoService {

	public boolean addStudent(StudentInfo studentInfo);
	
	public boolean updateStudent(StudentInfo studentInfo);
	
	public List<StudentInfo> getStudentInfoList(StudentInfo studentInfo);
	
	public StudentInfo getStudentInfo(Integer studentId);
}
