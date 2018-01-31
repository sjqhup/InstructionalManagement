package com.guigu.instructional.market.service;

import java.util.List;

import com.guigu.instructional.po.TemplateInfo;

	
public interface TemplateinfoService {

	//����ģ��
	public boolean addTemplate(TemplateInfo templateInfo);
    
	//�޸�ģ��
    public boolean updateTemplate(TemplateInfo templateInfo);
    
    //��ѯģ��(����������ѯ��
    public List<TemplateInfo> getTemplateinfoList(TemplateInfo templateInfo);
    
    //���ݱ�Ų�ѯģ��
    public TemplateInfo getTemplateinfo(Integer templateId);
    
    
    public boolean deleteTemplate(Integer templateId);
    
	
}
