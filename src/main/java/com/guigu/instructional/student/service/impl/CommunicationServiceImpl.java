package com.guigu.instructional.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.CommunicationInfo;
import com.guigu.instructional.po.CommunicationInfoCustom;
import com.guigu.instructional.po.CommunicationInfoExample;
import com.guigu.instructional.po.CommunicationInfoExample.Criteria;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoExample;
import com.guigu.instructional.student.mapper.CommunicationInfoMapper;
import com.guigu.instructional.student.mapper.StudentInfoMapper;
import com.guigu.instructional.student.service.CommunicationService;
import com.guigu.instructional.student.service.StudentInfoService;
import com.guigu.instructional.system.service.StaffInfoService;

@Service("communicationServiceImpl")
public class CommunicationServiceImpl implements CommunicationService{

	@Autowired
	private CommunicationInfoMapper communicationInfoMapper;
	
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	@Override
	public boolean addCommunication(CommunicationInfo communicationInfo) {
		try{
			int i=communicationInfoMapper.insertSelective(communicationInfo);
	        if(i>0) {
			return true;
		}
		}catch(Exception e) {
			
		}
		return false;
		
	}

	@Override
	public boolean updateCommunication(CommunicationInfo communicationInfo) {
		try {
			int i=communicationInfoMapper.updateByPrimaryKeySelective(communicationInfo);
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return false;
	}

	@Override
	public List<CommunicationInfoCustom> findCommunicationList(StudentInfo studentInfo) {
        CommunicationInfoExample communicationInfoExample=new CommunicationInfoExample();
        Criteria criteria=communicationInfoExample.createCriteria();
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
        
        List<CommunicationInfo> communicationInfoList=communicationInfoMapper.selectByExample(communicationInfoExample);
        if(communicationInfoList!=null) {
        	List<CommunicationInfoCustom> communicationInfoCustomsList=new ArrayList<>();
        	for (CommunicationInfo communicationInfo : communicationInfoList) {
			   CommunicationInfoCustom communicationInfoCustom=this.findCommunication(communicationInfo.getCommunicationId());
			   communicationInfoCustomsList.add(communicationInfoCustom);
        	}
        	return communicationInfoCustomsList;
        }
        return null;
	}
	        
	


	@Override
	public CommunicationInfoCustom findCommunication(Integer communicationId) {
		CommunicationInfoCustom communicationInfoCustom=new CommunicationInfoCustom();
		CommunicationInfo communicationInfo=communicationInfoMapper.selectByPrimaryKey(communicationId);
		communicationInfoCustom.setCommunicationInfo(communicationInfo);
		String studentName=studentInfoService.getStudentInfo(communicationInfo.getStudentId()).getStudentName();
		String teacherName=staffInfoService.getStaffInfo(communicationInfo.getStaffId()).getStaffName();
		communicationInfoCustom.setStudentName(studentName);
		communicationInfoCustom.setTeacherName(teacherName);
		return communicationInfoCustom;
	}

	@Override
	public boolean deleteCommunication(Integer communicationId) {
		try {
			int i=communicationInfoMapper.deleteByPrimaryKey(communicationId);
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return false;
	}


}
