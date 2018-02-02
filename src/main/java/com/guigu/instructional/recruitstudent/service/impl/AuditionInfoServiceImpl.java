package com.guigu.instructional.recruitstudent.service.impl;

import java.util.ArrayList;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.AuditionCustom;
import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.AuditionInfoExample;
import com.guigu.instructional.po.AuditionInfoExample.Criteria;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.recruitstudent.mapper.AuditionInfoMapper;

import com.guigu.instructional.recruitstudent.service.AuditionInfoService;
import com.guigu.instructional.recruitstudent.service.DisciplineAuditionInfoService;
import com.guigu.instructional.recruitstudent.service.StudentPoolInfoService;
@Service("auditionInfoServiceImpl")
public class AuditionInfoServiceImpl implements AuditionInfoService{

	@Resource(name="auditionInfoMapper")
	private AuditionInfoMapper auditionInfoMapper;
	//需要用到 学科信息  以及学生名字查询  所以要导入这两
	
	@Resource(name="studentPoolInfoServiceImpl")
	private StudentPoolInfoService studentPoolInfoService;
	
	@Resource(name="disciplineAuditionInfoServiceImpl")
	private DisciplineAuditionInfoService disciplineAuditionInfoService;
	
	
	@Override
	public boolean addAudition(AuditionInfo auditionInfo) {
		try {
            int i = auditionInfoMapper.insertSelective(auditionInfo);
            //自动生成的staffInfoMapper里面都有两种增删改查方法  不同的是Selective结尾的允许某个是空值  另一个则不允许
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

		return false;
	}

	@Override
	public boolean updateAudition(AuditionInfo auditionInfo) {
		try {
            int i = auditionInfoMapper.updateByPrimaryKeySelective(auditionInfo);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }
		return false;
	}

	@Override
	public List<AuditionInfo> getAuditionInfoList(AuditionInfo auditionInfo) {
		AuditionInfoExample auditionInfoExample=new AuditionInfoExample();
        Criteria criteria=auditionInfoExample.createCriteria();
		if(auditionInfo!=null) {
			
			//根据ID查询
			if(auditionInfo.getAuditionId()!=null) {
				criteria.andAuditionIdEqualTo(auditionInfo.getAuditionId());
			}
			//根据科目查询
			if(auditionInfo.getAuditionCourse()!=null) {
				auditionInfo.setAuditionCourse("%"+auditionInfo.getAuditionCourse()+"%");
				criteria.andAuditionCourseLike(auditionInfo.getAuditionCourse());
			}
			
			
		}
		return auditionInfoMapper.selectByExample(auditionInfoExample);
	}

	
	//通过id查询相关的视听记录
	@Override
	public AuditionInfo getAuditionInfo(Integer auditionId) {
		
		return auditionInfoMapper.selectByPrimaryKey(auditionId);
	}

	
	//delete 相关的试听记录 没有其他外键可以删除
	@Override
	public int deleteAudition(Integer auditionId) {
		
		return auditionInfoMapper.deleteByPrimaryKey(auditionId);
	}
	
	
//这个方法就是具体的通过查询学生的名字以及学科信息来获取相应的试听记录
	@Override
	public List<AuditionCustom> getAuditionCustomList(StudentInfo studentInfo, DisciplineInfo disciplineInfo) {
		AuditionInfoExample auditionInfoExample=new AuditionInfoExample();
		Criteria criteria=auditionInfoExample.createCriteria();
		//通过相应example获取数据
		if(studentInfo!=null&&studentInfo.getStudentName()!=null) {
			//传入的studentinfo 
			
			//根据名字获得对应的studentinfo   然后对list里面的信息进行迭代  获得这些学生的id
			List<StudentInfo> studentInfoList=studentPoolInfoService.getStudentInfoListByName(studentInfo);
			if(studentInfoList!=null) {
				List<Integer> studentIdlist=new ArrayList<>();
				
				for (StudentInfo student : studentInfoList) {
					studentIdlist.add(student.getStudentId());
				}
				criteria.andStudentIdIn(studentIdlist);
				//AuditionCustom里面包含了AuditionInfo  
				//AuditionInfo与学生信息表有外键连接   表中就有学生的id 可以直接通过ID获得对应试听记录
				//达到通过名字获得对应试听记录的目的
			}
		}
		if(disciplineInfo!=null&& disciplineInfo.getDisciplineName()!=null) {
			List<DisciplineInfo> disciplineInfoList=disciplineAuditionInfoService.getDisciplineListByName(disciplineInfo);
			if(disciplineInfoList!=null) {
				//通过科目名字获得相应的科目信息DisciplineInfo  然后将对应的<科目信息的ID封装进去  然后根据科目信息的id去获得对应的视听记录
				List<Integer> disciplineAudtionIdlist=new ArrayList<>();
				//新建一个list  存储对应的disciplineID信息
				//对list做迭代
				for(DisciplineInfo discipline:disciplineInfoList) {
					//对封装了 DisciplineInfo的list里面的discipline对象进行迭代   获得他们的id封装进disciplineIdlist里面
					disciplineAudtionIdlist.add(discipline.getDisciplineId());
				}
				
				criteria.andAuditionCourseIn(disciplineAudtionIdlist);
				
			}
		}
		//上面两个只是定义了下面该用到的Example
		
		
		List<AuditionInfo> auditionInfoList=auditionInfoMapper.selectByExample(auditionInfoExample);
		if(auditionInfoList!=null) {
		
			//对所有查询出来的auditioninfo进行迭代  封装成AuditionCustom类型   返回值是AuditionCustom类型的
			List<AuditionCustom> auditionCustomList=new ArrayList<>();
			for(AuditionInfo auditionInfo:auditionInfoList) {
				
				AuditionCustom auditionCustom=new AuditionCustom();
				auditionCustom.setAuditionInfo(auditionInfo);
				//将auditioninfo封装成为auditionCustom里面的一个属性
				if(auditionInfo.getStudentId()!=null) {
					auditionCustom.setStudentName(studentPoolInfoService.getStudentInfo(auditionInfo.getStudentId()).getStudentName());
				}
				
				if(auditionInfo.getAuditionCourse()!=null) {
					auditionCustom.setDisciplineName(disciplineAuditionInfoService.getDisciplineInfo(auditionInfo.getAuditionId()).getDisciplineName());
				}
				auditionCustomList.add(auditionCustom);
			}
			return auditionCustomList;
			
			
		}else {
		
		return null;
		}
	}



}
