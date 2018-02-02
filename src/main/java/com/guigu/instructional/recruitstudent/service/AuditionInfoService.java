package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.AuditionCustom;
import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StudentInfo;


public interface AuditionInfoService {

	public boolean addAudition(AuditionInfo auditionInfo);
	//���
	public boolean updateAudition(AuditionInfo auditionInfo);
	//����
	public List<AuditionInfo> getAuditionInfoList(AuditionInfo auditionInfo);

	public AuditionInfo getAuditionInfo(Integer auditionId);
	//����IDȥ��ѯ
	
	public int deleteAudition(Integer auditionId);
    //ֱ�Ӹ��ݸ��ټ�¼�����ж�Ӧ��ɾ��  ɾ���ɹ�֮�󷵻�1 ���ɹ�����0
	public List<AuditionCustom> getAuditionCustomList(StudentInfo studentInfo,DisciplineInfo disciplineInfo);
	
}
