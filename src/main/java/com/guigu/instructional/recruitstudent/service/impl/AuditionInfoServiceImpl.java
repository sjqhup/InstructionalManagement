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
	//��Ҫ�õ� ѧ����Ϣ  �Լ�ѧ�����ֲ�ѯ  ����Ҫ��������
	
	@Resource(name="studentPoolInfoServiceImpl")
	private StudentPoolInfoService studentPoolInfoService;
	
	@Resource(name="disciplineAuditionInfoServiceImpl")
	private DisciplineAuditionInfoService disciplineAuditionInfoService;
	
	
	@Override
	public boolean addAudition(AuditionInfo auditionInfo) {
		try {
            int i = auditionInfoMapper.insertSelective(auditionInfo);
            //�Զ����ɵ�staffInfoMapper���涼��������ɾ�Ĳ鷽��  ��ͬ����Selective��β������ĳ���ǿ�ֵ  ��һ��������
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
			
			//����ID��ѯ
			if(auditionInfo.getAuditionId()!=null) {
				criteria.andAuditionIdEqualTo(auditionInfo.getAuditionId());
			}
			//���ݿ�Ŀ��ѯ
			if(auditionInfo.getAuditionCourse()!=null) {
				auditionInfo.setAuditionCourse("%"+auditionInfo.getAuditionCourse()+"%");
				criteria.andAuditionCourseLike(auditionInfo.getAuditionCourse());
			}
			
			
		}
		return auditionInfoMapper.selectByExample(auditionInfoExample);
	}

	
	//ͨ��id��ѯ��ص�������¼
	@Override
	public AuditionInfo getAuditionInfo(Integer auditionId) {
		
		return auditionInfoMapper.selectByPrimaryKey(auditionId);
	}

	
	//delete ��ص�������¼ û�������������ɾ��
	@Override
	public int deleteAudition(Integer auditionId) {
		
		return auditionInfoMapper.deleteByPrimaryKey(auditionId);
	}
	
	
//����������Ǿ����ͨ����ѯѧ���������Լ�ѧ����Ϣ����ȡ��Ӧ��������¼
	@Override
	public List<AuditionCustom> getAuditionCustomList(StudentInfo studentInfo, DisciplineInfo disciplineInfo) {
		AuditionInfoExample auditionInfoExample=new AuditionInfoExample();
		Criteria criteria=auditionInfoExample.createCriteria();
		//ͨ����Ӧexample��ȡ����
		if(studentInfo!=null&&studentInfo.getStudentName()!=null) {
			//�����studentinfo 
			
			//�������ֻ�ö�Ӧ��studentinfo   Ȼ���list�������Ϣ���е���  �����Щѧ����id
			List<StudentInfo> studentInfoList=studentPoolInfoService.getStudentInfoListByName(studentInfo);
			if(studentInfoList!=null) {
				List<Integer> studentIdlist=new ArrayList<>();
				
				for (StudentInfo student : studentInfoList) {
					studentIdlist.add(student.getStudentId());
				}
				criteria.andStudentIdIn(studentIdlist);
				//AuditionCustom���������AuditionInfo  
				//AuditionInfo��ѧ����Ϣ�����������   ���о���ѧ����id ����ֱ��ͨ��ID��ö�Ӧ������¼
				//�ﵽͨ�����ֻ�ö�Ӧ������¼��Ŀ��
			}
		}
		if(disciplineInfo!=null&& disciplineInfo.getDisciplineName()!=null) {
			List<DisciplineInfo> disciplineInfoList=disciplineAuditionInfoService.getDisciplineListByName(disciplineInfo);
			if(disciplineInfoList!=null) {
				//ͨ����Ŀ���ֻ����Ӧ�Ŀ�Ŀ��ϢDisciplineInfo  Ȼ�󽫶�Ӧ��<��Ŀ��Ϣ��ID��װ��ȥ  Ȼ����ݿ�Ŀ��Ϣ��idȥ��ö�Ӧ��������¼
				List<Integer> disciplineAudtionIdlist=new ArrayList<>();
				//�½�һ��list  �洢��Ӧ��disciplineID��Ϣ
				//��list������
				for(DisciplineInfo discipline:disciplineInfoList) {
					//�Է�װ�� DisciplineInfo��list�����discipline������е���   ������ǵ�id��װ��disciplineIdlist����
					disciplineAudtionIdlist.add(discipline.getDisciplineId());
				}
				
				criteria.andAuditionCourseIn(disciplineAudtionIdlist);
				
			}
		}
		//��������ֻ�Ƕ�����������õ���Example
		
		
		List<AuditionInfo> auditionInfoList=auditionInfoMapper.selectByExample(auditionInfoExample);
		if(auditionInfoList!=null) {
		
			//�����в�ѯ������auditioninfo���е���  ��װ��AuditionCustom����   ����ֵ��AuditionCustom���͵�
			List<AuditionCustom> auditionCustomList=new ArrayList<>();
			for(AuditionInfo auditionInfo:auditionInfoList) {
				
				AuditionCustom auditionCustom=new AuditionCustom();
				auditionCustom.setAuditionInfo(auditionInfo);
				//��auditioninfo��װ��ΪauditionCustom�����һ������
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
