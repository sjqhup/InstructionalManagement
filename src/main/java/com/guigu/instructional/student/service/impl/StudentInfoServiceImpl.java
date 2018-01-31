package com.guigu.instructional.student.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.student.mapper.StudentInfoMapper;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoExample;
import com.guigu.instructional.po.StudentInfoExample.Criteria;
import com.guigu.instructional.student.service.StudentInfoService;

@Service("studentInfoServiceImpl")
public class StudentInfoServiceImpl implements StudentInfoService{

	@Resource(name="studentInfoMapper")
	public StudentInfoMapper studentInfoMapper;
	@Override
	public boolean addStudent(StudentInfo studentInfo) {
		int i=studentInfoMapper.insertSelective(studentInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStudent(StudentInfo studentInfo) {
		int i=studentInfoMapper.updateByPrimaryKeySelective(studentInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<StudentInfo> getStudentInfoList(StudentInfo studentInfo) {
		StudentInfoExample studentInfoExample=new StudentInfoExample();
		Criteria criteria=studentInfoExample.createCriteria();
		if(studentInfo!=null &&studentInfo.getStudentName()!=null) {
				studentInfo.setStudentName("%"+studentInfo.getStudentName()+"%");
				criteria.andStudentNameLike(studentInfo.getStudentName());
			
		}else {
			criteria.andStudentStateEqualTo(1);
			return studentInfoMapper.selectByExample(studentInfoExample);
		}
		criteria.andStudentStateEqualTo(1);
		return studentInfoMapper.selectByExample(studentInfoExample);
	}

	@Override
	public StudentInfo getStudentInfo(Integer studentId) {
		return studentInfoMapper.selectByPrimaryKey(studentId);
	}

}
