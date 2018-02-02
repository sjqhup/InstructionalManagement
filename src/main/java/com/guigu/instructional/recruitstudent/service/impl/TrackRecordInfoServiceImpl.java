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
	
	//只需要用到学生信息  导入数据
	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	
	//添加跟踪记录
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

	
	//更新跟踪记录
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
		
		//封装成TrackRecordCustom  里面添加对应的studentname属性 以及studentstate属性
		TrackRecordInfoExample trackRecordInfoExample=new TrackRecordInfoExample();
		Criteria criteria=trackRecordInfoExample.createCriteria();
		
		if(studentInfo!=null && studentInfo.getStudentName()!=null) {
			//根据数据库里面的学生信息  去获得名字然后根据名字得到符合查询条件的学生集合
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
				//讲学生名字属性 加入到custom里面
				trackRecordCustomsList.add(trackRecordCustom);
			}
			return trackRecordCustomsList;
		}else {
			return null;
			//表里面本来就有学生ID  可以根据学生ID直接获得对应的跟踪记录
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
			
			//根据ID查询
			if(trackRecordInfo.getTrackRecordId()!=null) {
				criteria.andTrackRecordIdEqualTo(trackRecordInfo.getTrackRecordId());
			}
			//根据zhuti模糊查询
			if(trackRecordInfo.getTrackRecordTitle()!=null) {
				trackRecordInfo.setTrackRecordTitle("%"+trackRecordInfo.getTrackRecordTitle()+"%");
				criteria.andTrackRecordTitleLike(trackRecordInfo.getTrackRecordTitle());
			}
		}
		
      
	
		
		List<TrackRecordInfo> trackRecordInfolist=trackRecordInfoMapper.selectByExample(trackRecordInfoExample);
		
		return trackRecordInfolist;
	}

	

}
