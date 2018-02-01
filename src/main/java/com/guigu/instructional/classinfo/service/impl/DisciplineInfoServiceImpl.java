package com.guigu.instructional.classinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.DisciplineInfoMapper;
import com.guigu.instructional.classinfo.service.DisciplineInfoService;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.DisciplineInfoExample;
import com.guigu.instructional.po.DisciplineInfoExample.Criteria;
import com.sun.org.apache.bcel.internal.generic.IRETURN;

@Service("disciplineInfoServiceImpl")
public class DisciplineInfoServiceImpl implements DisciplineInfoService{

	
    @Resource(name="disciplineInfoMapper")
	private DisciplineInfoMapper disciplineInfoMapper;
	
    
    @Override
	public boolean addDiscipline(DisciplineInfo disciplineInfo) {
         try {
        	int i=disciplineInfoMapper.insertSelective(disciplineInfo);
         	if(i>0) {
         		return true;
         	}
         } catch (Exception e) {
         }

		return false;
	}

	@Override
	public boolean updateDiscipline(DisciplineInfo disciplineInfo) {
		try {
			int i=disciplineInfoMapper.updateByPrimaryKeySelective(disciplineInfo);
		    if(i>0) {
		    	 return true;
		    }
		} catch (Exception e) {
           
        }
		return false;
	}

	@Override
	public List<DisciplineInfo> getDisciplineInfoList(DisciplineInfo disciplineInfo) {
		// TODO Auto-generated method stub
		DisciplineInfoExample disciplineInfoExample =new DisciplineInfoExample();
		Criteria criteria=disciplineInfoExample.createCriteria();
		if(disciplineInfo!=null) {

			if(disciplineInfo.getDisciplineName()!=null) {
				disciplineInfo.setDisciplineName("%"+disciplineInfo.getDisciplineName()+"%");
				criteria.andDisciplineNameLike(disciplineInfo.getDisciplineName());
			}
		}
        criteria.andDisciplineIsusedEqualTo("1");
		
		return disciplineInfoMapper.selectByExample(disciplineInfoExample);
	}

	@Override
	public DisciplineInfo getDisciplineInfo(Integer disciplineId) {
		// TODO Auto-generated method stub
		return disciplineInfoMapper.selectByPrimaryKey(disciplineId);
	}

}
