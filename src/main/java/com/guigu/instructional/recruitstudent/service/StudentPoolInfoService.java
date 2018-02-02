package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoCustom;

public interface StudentPoolInfoService {
	
	//学生持里面都是标识为0的非正式学员
	    public boolean addStudent(StudentInfo studentInfo);
	    
	 //添加相关的方法
	    public boolean updateStudent(StudentInfo studentInfo);
	    
	//得到所有学生信息
	    public List<StudentInfo> getStudentInfoList(StudentInfo studentInfo);
	
	    
	    public List<StudentInfo> getStudentInfoListByName(StudentInfo studentInfo);
	//这个是为了其他表格的应用   通过学生名字获得相应的id  然后根据外键查询  另一个表的数据
	    
	
	    public StudentInfo getStudentInfo(Integer studentId);
	    
    
       public List<StudentInfoCustom> getStudentCustomList(StudentInfo studentInfo);
//得到自定义的student
//	    
	    

}
