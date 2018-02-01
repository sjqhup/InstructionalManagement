package com.guigu.instructional.classinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.service.TeacherService;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StaffInfoExample;
import com.guigu.instructional.po.StaffInfoExample.Criteria;
import com.guigu.instructional.system.mapper.StaffInfoMapper;

@Service("teacherServiceImpl")
public class TeacherServiceImpl implements TeacherService{
	
	@Resource(name = "staffInfoMapper")
    private StaffInfoMapper staffInfoMapper;

	@Override
	public boolean addStaff(StaffInfo staffInfo) {
	     try {
	            int i = staffInfoMapper.insertSelective(staffInfo);
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {

	        }

	        return false;
	}

	@Override
	public boolean updateStaff(StaffInfo staffInfo) {
        try {
            int i = staffInfoMapper.updateByPrimaryKeySelective(staffInfo);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
	}

	@Override
	public List<StaffInfo> getStaffInfoList(StaffInfo staffInfo) {

		 StaffInfoExample staffInfoExample =new StaffInfoExample();
	        
	        Criteria criteria =staffInfoExample.createCriteria();
	        if(staffInfo!=null) {
	            //����id��ѯ
	            if(staffInfo.getStaffId()!=null) {
	                criteria.andStaffIdEqualTo(staffInfo.getStaffId());
	            }
	            //����name��ѯ
	            if(staffInfo.getStaffName()!=null) {
	                staffInfo.setStaffName("%"+staffInfo.getStaffName()+"%");
	                criteria.andStaffNameLike(staffInfo.getStaffName());
	            }
	            //���ݵ绰�����ѯ
	            if(staffInfo.getStaffMobilePhone()!=null) {
	                criteria.andStaffMobilePhoneEqualTo(staffInfo.getStaffMobilePhone());
	            }
	        }
	        criteria.andStaffStateEqualTo("1");
	        
	        
	        return staffInfoMapper.selectByExample(staffInfoExample);
	}

	@Override
	public StaffInfo getStaffInfo(Integer staffId) {

		return staffInfoMapper.selectByPrimaryKey(staffId);
	}

}
