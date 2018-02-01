package com.guigu.instructional.classinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.ClassInfoMapper;
import com.guigu.instructional.classinfo.mapper.ClassroomInfoMapper;
import com.guigu.instructional.classinfo.mapper.DisciplineInfoMapper;
import com.guigu.instructional.classinfo.mapper.SyllabusInfoMapper;
import com.guigu.instructional.classinfo.service.CrossService;
import com.guigu.instructional.po.ClassInfo;
import com.guigu.instructional.po.ClassInfoExample;
import com.guigu.instructional.po.ClassroomInfo;
import com.guigu.instructional.po.ClassInfoExample.Criteria;
import com.guigu.instructional.po.Cross;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.SyllabusInfo;
import com.guigu.instructional.system.mapper.StaffInfoMapper;




@Service("crossServiceImpl")
public class CrossServiceImpl implements CrossService{

	@Resource(name = "classInfoMapper")
    private ClassInfoMapper classInfoMapper;
	
	@Resource(name="classroomInfoMapper")
	private ClassroomInfoMapper classroomInfoMapper;
	
	@Resource(name="disciplineInfoMapper")
	private DisciplineInfoMapper disciplineInfoMapper;
	
	@Resource(name="syllabusInfoMapper")
	private SyllabusInfoMapper syllabusInfoMapper;
	
	@Resource(name="staffInfoMapper")
	private StaffInfoMapper staffInfoMapper;
	@Override
	public boolean addCross(ClassInfo classInfo) {
		if (classInfo != null) {
            // 1 是有效 0是无效
			classInfo.setClassIsused("1");
			classInfo.setClassState("1");
        }
        int i = classInfoMapper.insertSelective(classInfo);
        if (i > 0) {
            return true;
        }
        return false;
	}

	@Override
	public boolean updateCross(ClassInfo classInfo) {
		int i=classInfoMapper.updateByPrimaryKeySelective(classInfo);
        if(i>0) {
            return true;
        }
        return false;
	}

	@Override
	public List<Cross> getCrossList(ClassInfo classInfo) {
		List<Cross> listCross=new ArrayList<Cross>();
		ClassInfoExample classInfoExample =new ClassInfoExample();
		
		Criteria criteria =classInfoExample.createCriteria();
		if(classInfo !=null&&classInfo.getClassName()!=null) {
			classInfo.setClassName("%"+classInfo.getClassName()+"%");
			criteria.andClassNameLike(classInfo.getClassName());
		}
		criteria.andClassIsusedEqualTo("1");
		criteria.andClassStateEqualTo("1");
		List<ClassInfo> classInfoList=classInfoMapper.selectByExample(classInfoExample);
           if(classInfoList!=null) {
			
			for(ClassInfo classInfo2 : classInfoList) {
		       Cross cross=new Cross();

				ClassroomInfo classroomInfo=classroomInfoMapper.selectByPrimaryKey(classInfo2.getClassroomId());
				SyllabusInfo syllabusInfo=syllabusInfoMapper.selectByPrimaryKey(classInfo2.getSyllabusId());
				DisciplineInfo disciplineInfo=disciplineInfoMapper.selectByPrimaryKey(classInfo2.getDisciplineId());
				StaffInfo staffInfo=staffInfoMapper.selectByPrimaryKey(classInfo2.getStaffId());
				
				cross.setClassInfo(classInfo2);
				cross.setClassroomInfo(classroomInfo);
				cross.setSyllabusInfo(syllabusInfo);
				cross.setDisciplineInfo(disciplineInfo);
				cross.setStaffInfo(staffInfo);
				listCross.add(cross);	
			}
		}
		
		return listCross;
	}

	@Override
	public ClassInfo getClassInfo(Integer classId) {
		return classInfoMapper.selectByPrimaryKey(classId);
	}

}
