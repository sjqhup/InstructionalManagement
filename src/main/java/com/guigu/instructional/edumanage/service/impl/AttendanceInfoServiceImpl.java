package com.guigu.instructional.edumanage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.edumanage.mapper.AttendanceInfoMapper;
import com.guigu.instructional.edumanage.service.AttendanceInfoService;
import com.guigu.instructional.po.AttendanceInfo;
import com.guigu.instructional.po.AttendanceInfoExample;
import com.guigu.instructional.po.AttendanceInfoExample.Criteria;
import com.guigu.instructional.po.StaffInfoExample;
import com.guigu.instructional.system.mapper.StaffInfoMapper;


@Service("attendanceInfoServiceImpl")
public class AttendanceInfoServiceImpl implements AttendanceInfoService{


    @Resource(name="attendanceInfoMapper")
    private AttendanceInfoMapper attendanceInfoMapper ;


	@Override
	public boolean addAttendanceInfo(AttendanceInfo attendanceInfo) {
        try {
            int i = attendanceInfoMapper.insertSelective(attendanceInfo);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
	}

	@Override
	public boolean updateAttendanceInfo(AttendanceInfo attendanceInfo) {
	      try {
	            int i = attendanceInfoMapper.updateByPrimaryKeySelective(attendanceInfo);
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {

	        }

	        return false;
	}

	@Override
	public List<AttendanceInfo> getAttendanceInfoList(AttendanceInfo attendanceInfo) {
		AttendanceInfoExample attendanceInfoExample =new AttendanceInfoExample();
        
        Criteria criteria =attendanceInfoExample.createCriteria();
        if(attendanceInfo!=null) {
           /* //根据id查询
            if(staffInfo.getStaffId()!=null) {
                criteria.andStaffIdEqualTo(staffInfo.getStaffId());
            }
            //根据name查询
            if(staffInfo.getStaffName()!=null) {
                staffInfo.setStaffName("%"+staffInfo.getStaffName()+"%");
                criteria.andStaffNameLike(staffInfo.getStaffName());
            }
            //根据电话号码查询
            if(staffInfo.getStaffMobilePhone()!=null) {
                criteria.andStaffMobilePhoneEqualTo(staffInfo.getStaffMobilePhone());
            }
            //1代表正常  0代表删除
            //查询所有正常的员工的数据
//            staffInfo.setStaffState("1");
            */
        }
        criteria.andAttendanceStateEqualTo("1");
       
        
        return attendanceInfoMapper.selectByExample(attendanceInfoExample);
	}

	@Override
	public AttendanceInfo getAttendanceInfo(Integer attendanceId) {
		  return attendanceInfoMapper.selectByPrimaryKey(attendanceId);
	}

}
