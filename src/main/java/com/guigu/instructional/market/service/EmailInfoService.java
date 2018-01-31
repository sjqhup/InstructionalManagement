package com.guigu.instructional.market.service;

import java.util.List;

import com.guigu.instructional.po.EmailInfo;
import com.guigu.instructional.po.EmailInfoStaff;
import com.guigu.instructional.po.MessageInfoStaffVO;

public interface EmailInfoService {

			//���Ͷ���
			public boolean sendEmailInfo(EmailInfo emailInfo);
		    
			//�鿴����
		    public boolean lookEmailInfo(EmailInfo emailInfo);
		    
		    //����������ѯ����
		    public List<EmailInfo> getEmailInfoList(EmailInfo emailInfo);
		    
		    //���ݵ绰�����ѯ����
		    public EmailInfo getEmailInfo(Integer emailId);
		    
		    //ɾ������
		    public boolean deleteEmailInfo(Integer emailId);
		
		    //���¶�������
		    public boolean updateEmailInfo(EmailInfo emailInfo);
		    
		    public List<EmailInfoStaff> findEmailInfoStaffList(MessageInfoStaffVO messageInfoStaffVO) throws Exception;

	
}
