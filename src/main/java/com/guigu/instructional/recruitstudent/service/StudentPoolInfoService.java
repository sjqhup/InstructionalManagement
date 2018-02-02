package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoCustom;

public interface StudentPoolInfoService {
	
	//ѧ�������涼�Ǳ�ʶΪ0�ķ���ʽѧԱ
	    public boolean addStudent(StudentInfo studentInfo);
	    
	 //�����صķ���
	    public boolean updateStudent(StudentInfo studentInfo);
	    
	//�õ�����ѧ����Ϣ
	    public List<StudentInfo> getStudentInfoList(StudentInfo studentInfo);
	
	    
	    public List<StudentInfo> getStudentInfoListByName(StudentInfo studentInfo);
	//�����Ϊ����������Ӧ��   ͨ��ѧ�����ֻ����Ӧ��id  Ȼ����������ѯ  ��һ���������
	    
	
	    public StudentInfo getStudentInfo(Integer studentId);
	    
    
       public List<StudentInfoCustom> getStudentCustomList(StudentInfo studentInfo);
//�õ��Զ����student
//	    
	    

}
