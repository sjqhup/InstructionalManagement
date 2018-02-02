package com.guigu.instructional.recruitstudent.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoCustom;
import com.guigu.instructional.po.StudentInfoExample;
import com.guigu.instructional.po.StudentInfoExample.Criteria;
import com.guigu.instructional.recruitstudent.service.StudentPoolInfoService;
import com.guigu.instructional.student.mapper.StudentInfoMapper;
import com.guigu.instructional.system.service.StaffInfoService;

@Service("studentPoolInfoServiceImpl")
public class StudentPoolInfoServiceImpl implements StudentPoolInfoService{

	//导入数据
	@Resource(name="studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;
	
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffStudentInfoService;
	
	@Override
	public boolean addStudent(StudentInfo studentInfo) {
		
		 try {
	            int i = studentInfoMapper.insertSelective(studentInfo);
	            //自动生成的staffInfoMapper里面都有两种增删改查方法  不同的是Selective结尾的允许某个是空值  另一个则不允许
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {

	        }

	        return false;
	}

	
	//更新学员数据
	@Override
	public boolean updateStudent(StudentInfo studentInfo) {
		 try {
	            int i = studentInfoMapper.updateByPrimaryKeySelective(studentInfo);
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {

	        }

		
		return false;
	}

	
	//获得所有学员信息
	@Override
	public List<StudentInfo> getStudentInfoList(StudentInfo studentInfo) {
		StudentInfoExample studentInfoExample=new StudentInfoExample();
		Criteria criteria=studentInfoExample.createCriteria();
		if(studentInfo!=null) {
			
			//根据ID查询
			if(studentInfo.getStudentId()!=null) {
				criteria.andStudentIdEqualTo(studentInfo.getStudentId());
			}
			//根据名字模糊查询
			if(studentInfo.getStudentName()!=null) {
				studentInfo.setStudentName("%"+studentInfo.getStudentName()+"%");
				criteria.andStudentNameLike(studentInfo.getStudentName());
			}
		}
		
        //1代表正式学员  0代表非正式学员
        //查询非正式学员的数据
//        staffInfo.setStudentState("1"); 
		criteria.andStudentStateEqualTo(0);
		//标识是Mark
		//意向状态是state
		
		List<StudentInfo> studentInfoList=studentInfoMapper.selectByExample(studentInfoExample);
		
		return studentInfoList;
	}

	
	//根据学员ID得到学员信息
	@Override
	public StudentInfo getStudentInfo(Integer studentId) {
		
		return studentInfoMapper.selectByPrimaryKey(studentId);
	}

	
	//获得参有staff表数据的 student信息  便于根据负责人名字查询对应的学生数据
	@Override
	public List<StudentInfoCustom> getStudentCustomList(StudentInfo studentInfo) {
		//先根据对应的cretia得到studentinfo   然后封装成StudentCustom
		StudentInfoExample studentInfoExample=new StudentInfoExample();
		Criteria criteria=studentInfoExample.createCriteria();
		
		if(studentInfo!=null && studentInfo.getStudentName()!=null) {
			studentInfo.setStudentName("%"+studentInfo.getStudentName()+"%");
			criteria.andStudentNameLike(studentInfo.getStudentName());
		}
		
		criteria.andStudentStateEqualTo(0);
		//按名字模糊得到标识为0 并且名字是按照要求的全部学生信息
		//把信息封装到studentInfoList中 
		List<StudentInfo> studentInfoList=studentInfoMapper.selectByExample(studentInfoExample);
		if(studentInfoList!=null){
			List<StudentInfoCustom> studentCustomlist=new ArrayList<>();
			//新建一个装了StudentCustom对象的list 
			//for循环 将 studentInfoList中的所有数据封装成为StudentCustom
			for (StudentInfo stu : studentInfoList) 
			{
				StudentInfoCustom studentCustom=new StudentInfoCustom();
				studentCustom.setStudentInfo(stu);
				//StudentCustom里面包含StudentInfo部分 以及自定义额外添加的staff属性  
				//上面设置了相应的studentinfo  staffname在下面定义
				if(stu.getStaffId()!=null) {
					studentCustom.setStaffName(staffStudentInfoService.getStaffInfo(stu.getStaffId()).getStaffName());
				//将student对应的负责人名字封装成为studentcustom的staffname属性   setStaffName(String  ***)
				}
				studentCustomlist.add(studentCustom);
				//添加进入list
				
			}
			return studentCustomlist;
		}else {
			return null;
		}
	}
	//根据对应的负责人艾迪  staffID 以及学生名字  去获得对应的信息


	@Override
	public List<StudentInfo> getStudentInfoListByName(StudentInfo studentInfo) {
		StudentInfoExample studentInfoExample=new StudentInfoExample();
		Criteria criteria=studentInfoExample.createCriteria();
		if(studentInfo!=null && studentInfo.getStudentName()!=null) {
			studentInfo.setStudentName("%"+studentInfo.getStudentName()+"%");
			criteria.andStudentNameLike(studentInfo.getStudentName());
			
		
		    criteria.andStudentStateEqualTo(0);
		//按名字模糊得到标识为0 并且名字是按照要求的全部学生信息
		//把信息封装到studentInfoList中 
		    List<StudentInfo> studentInfoList=studentInfoMapper.selectByExample(studentInfoExample);
		
		    return studentInfoList;
	}else{
		return null;
		}


}
}
