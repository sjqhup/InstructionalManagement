package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.CommunicationInfo;
import com.guigu.instructional.po.CommunicationInfoCustom;
import com.guigu.instructional.po.StudentInfo;

public interface CommunicationService {

	public boolean addCommunication(CommunicationInfo communicationInfo);
	
	public boolean updateCommunication(CommunicationInfo communicationInfo);
	
	public List<CommunicationInfoCustom> findCommunicationList(StudentInfo studentInfo);
	
	public CommunicationInfoCustom findCommunication(Integer communicationId);
	
	public boolean deleteCommunication(Integer communicationId);
}
