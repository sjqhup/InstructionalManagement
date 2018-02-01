package com.guigu.instructional.classinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.ClassroomInfoMapper;
import com.guigu.instructional.classinfo.service.ClassroomInfoService;
import com.guigu.instructional.po.ClassroomInfo;
import com.guigu.instructional.po.ClassroomInfoExample;
import com.guigu.instructional.po.ClassroomInfoExample.Criteria;
import com.guigu.instructional.po.DisciplineInfoExample;

@Service("classroomInfoServiceImpl")
public class ClassroomInfoServiceImpl implements ClassroomInfoService{

	 @Resource(name="classroomInfoMapper")
	 private ClassroomInfoMapper classroomInfoMapper;
	 
	 
	@Override
	public boolean addClassroom(ClassroomInfo classroomInfo) {
		 try {
	        	int i=classroomInfoMapper.insertSelective(classroomInfo);
	         	if(i>0) {
	         		return true;
	         	}
	         } catch (Exception e) {
	         }

			return false;
	}

	@Override
	public boolean updateClassroom(ClassroomInfo classroomInfo) {
		try {
			int i=classroomInfoMapper.updateByPrimaryKeySelective(classroomInfo);
		    if(i>0) {
		    	 return true;
		    }
		} catch (Exception e) {
           
        }
		return false;
	}

	@Override
	public List<ClassroomInfo> getClassroomInfoList(ClassroomInfo classroomInfo) {
		ClassroomInfoExample classroomInfoExample=new ClassroomInfoExample();
		Criteria criteria=classroomInfoExample.createCriteria();
		if(classroomInfo!=null) {
			if(classroomInfo.getClassroomName()!=null) {
				classroomInfo.setClassroomName("%"+classroomInfo.getClassroomName()+"%");
				criteria.andClassroomNameLike(classroomInfo.getClassroomName());
			}
		}
		criteria.andClassroomMarkEqualTo("1");
		
		return classroomInfoMapper.selectByExample(classroomInfoExample);
	}

	@Override
	public ClassroomInfo getClassroomInfo(Integer classroomId) {
		// TODO Auto-generated method stub
		return classroomInfoMapper.selectByPrimaryKey(classroomId);

	}

}
