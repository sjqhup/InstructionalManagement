package com.guigu.instructional.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeCustom;
import com.guigu.instructional.po.StudentWriteGradeExample;
import com.guigu.instructional.po.StudentWriteGradeExample.Criteria;
import com.guigu.instructional.student.mapper.StudentWriteGradeMapper;
import com.guigu.instructional.student.service.StudentInfoService;
import com.guigu.instructional.student.service.StudentWriteGradeService;
import com.guigu.instructional.system.service.StaffInfoService;

@Service("studentWriteGradeServiceImpl")
public class StudentWriteGradeServiceImpl implements StudentWriteGradeService{

	@Autowired
	private StudentWriteGradeMapper studentWriteGradeMapper;
	
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@Override
	public boolean addStudnetWriteGrade(StudentWriteGrade studentWriteGrade) {
	    try {
			int i=studentWriteGradeMapper.insertSelective(studentWriteGrade);
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
		} 
		return false;
	}

	@Override
	public boolean updateStudnetWriteGrade(StudentWriteGrade studentWriteGrade) {   
	    try {
			int i=studentWriteGradeMapper.updateByPrimaryKeySelective(studentWriteGrade);
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
		} 
		return false;
	}

	@Override
	public boolean deleteStudentWriteGrade(Integer writeGradeId) { 
	    try {
			int i=studentWriteGradeMapper.deleteByPrimaryKey(writeGradeId);
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
		} 
		return false;
	}
	
	@Override
	public List<StudentWriteGradeCustom> findStudentWriteGradeList(StudentInfo studentInfo) {
		StudentWriteGradeExample studentWriteGradeExample=new StudentWriteGradeExample();
		Criteria criteria=studentWriteGradeExample.createCriteria();
		if(studentInfo!=null) {
			if(studentInfo.getStudentName()!=null) {
				List<StudentInfo> studentInfoList=studentInfoService.getStudentInfoList(studentInfo);
				List<Integer> list=new ArrayList<>();
				if(!studentInfoList.isEmpty()) {
				for (StudentInfo stu : studentInfoList) {
					list.add(stu.getStudentId());
				}
				criteria.andStudentIdIn(list);
			}else {
				return null;
			      }
		        }
         	}
				List<StudentWriteGrade> studentWriteGradeList=studentWriteGradeMapper.selectByExample(studentWriteGradeExample);
				if(studentWriteGradeList !=null) {
					List<StudentWriteGradeCustom> studentWriteGradeCustomList=new ArrayList<>();
					for (StudentWriteGrade student : studentWriteGradeList) {
						StudentWriteGradeCustom studentWriteGradeCustom=this.findStudentWriteGrade(student.getWriteGradeId());
						studentWriteGradeCustomList.add(studentWriteGradeCustom);
					}
					return studentWriteGradeCustomList;
				}
				return null;
}
	

	@Override
	public StudentWriteGradeCustom findStudentWriteGrade(Integer writeGradeId) {
		StudentWriteGrade studentWriteGrade=studentWriteGradeMapper.selectByPrimaryKey(writeGradeId);
		StudentWriteGradeCustom studentWriteGradeCustom=new StudentWriteGradeCustom();
		studentWriteGradeCustom.setStudentWriteGrade(studentWriteGrade);
		String studentName=studentInfoService.getStudentInfo(studentWriteGrade.getStudentId()).getStudentName();
		String teacherName=staffInfoService.getStaffInfo(studentWriteGrade.getStaffId()).getStaffName();
		studentWriteGradeCustom.setStudentName(studentName);
		studentWriteGradeCustom.setTeacherName(teacherName);
		return studentWriteGradeCustom;
	}
}
