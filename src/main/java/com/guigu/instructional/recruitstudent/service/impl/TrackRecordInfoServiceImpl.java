package com.guigu.instructional.recruitstudent.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.TrackRecordCustom;
import com.guigu.instructional.po.TrackRecordInfo;
import com.guigu.instructional.po.TrackRecordInfoExample;
import com.guigu.instructional.po.TrackRecordInfoExample.Criteria;
import com.guigu.instructional.recruitstudent.mapper.TrackRecordInfoMapper;
import com.guigu.instructional.recruitstudent.service.StudentPoolInfoService;
import com.guigu.instructional.recruitstudent.service.TrackRecordInfoService;
import com.guigu.instructional.student.service.StudentInfoService;

@Service("trackRecordInfoServiceImpl")
public class TrackRecordInfoServiceImpl implements TrackRecordInfoService{

	@Resource(name="trackRecordInfoMapper")
	private TrackRecordInfoMapper trackRecordInfoMapper;
	
	//ֻ��Ҫ�õ�ѧ����Ϣ  ��������
	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	
	//��Ӹ��ټ�¼
	@Override
	public boolean addTrackRecord(TrackRecordInfo trackRecordInfo) {
		try {
            int i = trackRecordInfoMapper.insertSelective(trackRecordInfo);
           
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }
		return false;
	}

	
	//���¸��ټ�¼
	@Override
	public boolean updateTrackRecord(TrackRecordInfo trackRecordInfo) {
		 try {
	            int i = trackRecordInfoMapper.updateByPrimaryKeySelective(trackRecordInfo);
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {
	    }

		return false;
	}

	




	@Override
	public Integer deleteTrackRecord(Integer trackRecordId) {
		
		return trackRecordInfoMapper.deleteByPrimaryKey(trackRecordId);
	}


	
	
	@Override
	public List<TrackRecordCustom> getTrackRecordCustomList(StudentInfo studentInfo) {
		
		//��װ��TrackRecordCustom  ������Ӷ�Ӧ��studentname���� �Լ�studentstate����
		TrackRecordInfoExample trackRecordInfoExample=new TrackRecordInfoExample();
		Criteria criteria=trackRecordInfoExample.createCriteria();
		
		if(studentInfo!=null && studentInfo.getStudentName()!=null) {
			//�������ݿ������ѧ����Ϣ  ȥ�������Ȼ��������ֵõ����ϲ�ѯ������ѧ������
			List<StudentInfo> studentList=studentInfoService.getStudentInfoList(null);
			if(studentList!=null) {
				List<Integer> studentIdList=new ArrayList<>();
				
				for (StudentInfo student : studentList) {
					studentIdList.add(student.getStudentId());
				}
				criteria.andStudentIdIn(studentIdList);
			}
		}
		
		List<TrackRecordInfo> trackRecordList=trackRecordInfoMapper.selectByExample(trackRecordInfoExample);
		
		if(trackRecordList!=null) {
			List<TrackRecordCustom> trackRecordCustomsList=new ArrayList<>();
			for (TrackRecordInfo trackRecordInfo : trackRecordList) {
				TrackRecordCustom trackRecordCustom=new TrackRecordCustom();
				trackRecordCustom.setTrackRecordInfo(trackRecordInfo);
				if(trackRecordInfo.getStudentId()!=null) {
					trackRecordCustom.setStudentName(studentInfoService.getStudentInfo(trackRecordInfo.getStudentId()).getStudentName());
				}
				//��ѧ���������� ���뵽custom����
				trackRecordCustomsList.add(trackRecordCustom);
			}
			return trackRecordCustomsList;
		}else {
			return null;
			//�����汾������ѧ��ID  ���Ը���ѧ��IDֱ�ӻ�ö�Ӧ�ĸ��ټ�¼
	}
	}


	@Override
	public TrackRecordInfo getTrackRecordInfo(Integer trackRecordId) {
		
		return trackRecordInfoMapper.selectByPrimaryKey(trackRecordId);
	}

	
	

	@Override
	public List<TrackRecordInfo> getTrackRecordInfoList(TrackRecordInfo trackRecordInfo) {
		
		TrackRecordInfoExample trackRecordInfoExample=new TrackRecordInfoExample();
		Criteria criteria=trackRecordInfoExample.createCriteria();
		if(trackRecordInfo!=null) {
			
			//����ID��ѯ
			if(trackRecordInfo.getTrackRecordId()!=null) {
				criteria.andTrackRecordIdEqualTo(trackRecordInfo.getTrackRecordId());
			}
			//����zhutiģ����ѯ
			if(trackRecordInfo.getTrackRecordTitle()!=null) {
				trackRecordInfo.setTrackRecordTitle("%"+trackRecordInfo.getTrackRecordTitle()+"%");
				criteria.andTrackRecordTitleLike(trackRecordInfo.getTrackRecordTitle());
			}
		}
		
      
	
		
		List<TrackRecordInfo> trackRecordInfolist=trackRecordInfoMapper.selectByExample(trackRecordInfoExample);
		
		return trackRecordInfolist;
	}

	

}
