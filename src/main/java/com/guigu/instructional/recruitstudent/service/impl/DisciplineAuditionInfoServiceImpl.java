package com.guigu.instructional.recruitstudent.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.DisciplineInfoExample;
import com.guigu.instructional.po.DisciplineInfoExample.Criteria;
import com.guigu.instructional.classinfo.mapper.DisciplineInfoMapper;
import com.guigu.instructional.recruitstudent.service.DisciplineAuditionInfoService;

@Service(value="disciplineAuditionInfoServiceImpl")
public class DisciplineAuditionInfoServiceImpl implements DisciplineAuditionInfoService{
	
	@Resource(name="disciplineInfoMapper")
	private DisciplineInfoMapper disciplineInfoMapper;

	@Override
	public List<DisciplineInfo> getDisciplineListByName(DisciplineInfo disciplineInfo) {
		
		DisciplineInfoExample disciplineInfoExample=new DisciplineInfoExample();
		Criteria criteria=disciplineInfoExample.createCriteria();
		
        if(disciplineInfo!=null && disciplineInfo.getDisciplineName()!=null) {
        	disciplineInfo.setDisciplineName("%"+disciplineInfo.getDisciplineName()+"%");
        	criteria.andDisciplineNameLike(disciplineInfo.getDisciplineName());
        }
		
		return disciplineInfoMapper.selectByExample(disciplineInfoExample);
	}
	
	@Override
	public List<DisciplineInfo> getDisciplineList(DisciplineInfo disciplineInfo) {
		
		DisciplineInfoExample disciplineInfoExample=new DisciplineInfoExample();
		return disciplineInfoMapper.selectByExample(disciplineInfoExample);
	}

	@Override
	public DisciplineInfo getDisciplineInfo(Integer disciplineId) {
		return disciplineInfoMapper.selectByPrimaryKey(disciplineId);
	}

	@Override
	public List<DisciplineInfo> getDisciplineInfoList(DisciplineInfo disciplineInfo) {
		DisciplineInfoExample disciplineInfoExample=new DisciplineInfoExample();
		Criteria criteria=disciplineInfoExample.createCriteria();
		if(disciplineInfo!=null) {
			
			
			//��������ģ����ѯ
			if(disciplineInfo.getDisciplineName()!=null) {
				disciplineInfo.setDisciplineName("%"+disciplineInfo.getDisciplineName()+"%");
				criteria.andDisciplineNameLike(disciplineInfo.getDisciplineName());
			}
		}
		
        //1������ʽѧԱ  0�������ʽѧԱ
        //��ѯ����ʽѧԱ������
//        staffInfo.setStudentState("1"); 
		
		//��ʶ��Mark
		//����״̬��state
		
		List<DisciplineInfo> disciplineInfoList=disciplineInfoMapper.selectByExample(disciplineInfoExample);
		
		return disciplineInfoList;
	}
	
}
