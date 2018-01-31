package com.guigu.instructional.market.service;

import java.util.List;

import com.guigu.instructional.po.MessageInfo;
import com.guigu.instructional.po.MessageInfoStaff;
import com.guigu.instructional.po.MessageInfoStaffVO;

public interface MessageinfoService {

		//���Ͷ���
		public boolean sendMessageinfo(MessageInfo messageInfo);
	    
		//�鿴����
	    public boolean lookMessageinfo(MessageInfo messageInfo);
	    
	    //����������ѯ����
	    public List<MessageInfo> getMessageinfoList(MessageInfo messageInfo);
	    
	    //���ݵ绰�����ѯ����
	    public MessageInfo getMessageinfo(Integer messageId1);
	    
	    //ɾ������
	    public boolean deleteMessageinfo(Integer messageId1);
	
	    //���¶�������
	    public boolean updateMessageinfo(MessageInfo messageInfo);
	    
	    public List<MessageInfoStaff> findMessageInfoStaffList(MessageInfoStaffVO messageInfoStaffVO) throws Exception;

	    
//	    //����������ѯ����
//	    public List<MessageInfoStaff> getMessageinfoStaffList(MessageInfoStaff messageInfoStaff);
}
