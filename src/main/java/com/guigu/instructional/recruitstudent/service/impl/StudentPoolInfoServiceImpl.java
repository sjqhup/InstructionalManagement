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

	//��������
	@Resource(name="studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;
	
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffStudentInfoService;
	
	@Override
	public boolean addStudent(StudentInfo studentInfo) {
		
		 try {
	            int i = studentInfoMapper.insertSelective(studentInfo);
	            //�Զ����ɵ�staffInfoMapper���涼��������ɾ�Ĳ鷽��  ��ͬ����Selective��β������ĳ���ǿ�ֵ  ��һ��������
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {

	        }

	        return false;
	}

	
	//����ѧԱ����
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

	
	//�������ѧԱ��Ϣ
	@Override
	public List<StudentInfo> getStudentInfoList(StudentInfo studentInfo) {
		StudentInfoExample studentInfoExample=new StudentInfoExample();
		Criteria criteria=studentInfoExample.createCriteria();
		if(studentInfo!=null) {
			
			//����ID��ѯ
			if(studentInfo.getStudentId()!=null) {
				criteria.andStudentIdEqualTo(studentInfo.getStudentId());
			}
			//��������ģ����ѯ
			if(studentInfo.getStudentName()!=null) {
				studentInfo.setStudentName("%"+studentInfo.getStudentName()+"%");
				criteria.andStudentNameLike(studentInfo.getStudentName());
			}
		}
		
        //1������ʽѧԱ  0�������ʽѧԱ
        //��ѯ����ʽѧԱ������
//        staffInfo.setStudentState("1"); 
		criteria.andStudentStateEqualTo(0);
		//��ʶ��Mark
		//����״̬��state
		
		List<StudentInfo> studentInfoList=studentInfoMapper.selectByExample(studentInfoExample);
		
		return studentInfoList;
	}

	
	//����ѧԱID�õ�ѧԱ��Ϣ
	@Override
	public StudentInfo getStudentInfo(Integer studentId) {
		
		return studentInfoMapper.selectByPrimaryKey(studentId);
	}

	
	//��ò���staff�����ݵ� student��Ϣ  ���ڸ��ݸ��������ֲ�ѯ��Ӧ��ѧ������
	@Override
	public List<StudentInfoCustom> getStudentCustomList(StudentInfo studentInfo) {
		//�ȸ��ݶ�Ӧ��cretia�õ�studentinfo   Ȼ���װ��StudentCustom
		StudentInfoExample studentInfoExample=new StudentInfoExample();
		Criteria criteria=studentInfoExample.createCriteria();
		
		if(studentInfo!=null && studentInfo.getStudentName()!=null) {
			studentInfo.setStudentName("%"+studentInfo.getStudentName()+"%");
			criteria.andStudentNameLike(studentInfo.getStudentName());
		}
		
		criteria.andStudentStateEqualTo(0);
		//������ģ���õ���ʶΪ0 ���������ǰ���Ҫ���ȫ��ѧ����Ϣ
		//����Ϣ��װ��studentInfoList�� 
		List<StudentInfo> studentInfoList=studentInfoMapper.selectByExample(studentInfoExample);
		if(studentInfoList!=null){
			List<StudentInfoCustom> studentCustomlist=new ArrayList<>();
			//�½�һ��װ��StudentCustom�����list 
			//forѭ�� �� studentInfoList�е��������ݷ�װ��ΪStudentCustom
			for (StudentInfo stu : studentInfoList) 
			{
				StudentInfoCustom studentCustom=new StudentInfoCustom();
				studentCustom.setStudentInfo(stu);
				//StudentCustom�������StudentInfo���� �Լ��Զ��������ӵ�staff����  
				//������������Ӧ��studentinfo  staffname�����涨��
				if(stu.getStaffId()!=null) {
					studentCustom.setStaffName(staffStudentInfoService.getStaffInfo(stu.getStaffId()).getStaffName());
				//��student��Ӧ�ĸ��������ַ�װ��Ϊstudentcustom��staffname����   setStaffName(String  ***)
				}
				studentCustomlist.add(studentCustom);
				//��ӽ���list
				
			}
			return studentCustomlist;
		}else {
			return null;
		}
	}
	//���ݶ�Ӧ�ĸ����˰���  staffID �Լ�ѧ������  ȥ��ö�Ӧ����Ϣ


	@Override
	public List<StudentInfo> getStudentInfoListByName(StudentInfo studentInfo) {
		StudentInfoExample studentInfoExample=new StudentInfoExample();
		Criteria criteria=studentInfoExample.createCriteria();
		if(studentInfo!=null && studentInfo.getStudentName()!=null) {
			studentInfo.setStudentName("%"+studentInfo.getStudentName()+"%");
			criteria.andStudentNameLike(studentInfo.getStudentName());
			
		
		    criteria.andStudentStateEqualTo(0);
		//������ģ���õ���ʶΪ0 ���������ǰ���Ҫ���ȫ��ѧ����Ϣ
		//����Ϣ��װ��studentInfoList�� 
		    List<StudentInfo> studentInfoList=studentInfoMapper.selectByExample(studentInfoExample);
		
		    return studentInfoList;
	}else{
		return null;
		}


}
}
