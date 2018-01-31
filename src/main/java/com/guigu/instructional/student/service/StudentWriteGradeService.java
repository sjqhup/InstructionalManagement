package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeCustom;

public interface StudentWriteGradeService {

	public boolean addStudnetWriteGrade(StudentWriteGrade studentWriteGrade);
	
	public boolean updateStudnetWriteGrade(StudentWriteGrade studentWriteGrade);
	
	public List<StudentWriteGradeCustom> findStudentWriteGradeList(StudentInfo studentInfo);
	
	public StudentWriteGradeCustom findStudentWriteGrade(Integer writeGradeId);
	
	public boolean deleteStudentWriteGrade(Integer writeGradeId);
}
