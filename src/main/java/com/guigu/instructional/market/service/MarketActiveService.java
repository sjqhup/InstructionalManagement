package com.guigu.instructional.market.service;

import java.util.List;

import com.guigu.instructional.po.EmailInfo;
import com.guigu.instructional.po.EmailInfoStaff;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveStaff;
import com.guigu.instructional.po.MessageInfoStaffVO;

public interface MarketActiveService {

	//���ͻ
	public boolean sendMarketActive(MarketActive marketActive);
    
	//�鿴�
    public boolean lookMarketActive(MarketActive marketActive);
    
//    //����������ѯ����
//    public List<EmailInfo> getEmailInfoList(EmailInfo emailInfo);
    
    //���ݵ绰�����ѯ����
    public MarketActive getMarketActive(Integer activeId);
    
    //ɾ���
    public boolean deleteMarketActive(Integer activeId);

    //���»����
    public boolean updateMarketActive(MarketActive marketActive);
    
    //��ѯ�
    public List<MarketActiveStaff> findMarketActiveStaffList(MessageInfoStaffVO messageInfoStaffVO) throws Exception;

	
}
