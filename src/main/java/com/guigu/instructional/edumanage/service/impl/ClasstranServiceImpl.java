package com.guigu.instructional.edumanage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.ClassTransactionInfoMapper;
import com.guigu.instructional.edumanage.service.ClasstranService;
import com.guigu.instructional.po.ClassTransactionInfo;
import com.guigu.instructional.po.ClassTransactionInfoExample;
import com.guigu.instructional.po.ClassTransactionInfoExample.Criteria;

@Service("classtranServiceImpl")
public class ClasstranServiceImpl implements ClasstranService {

	 @Resource(name = "classTransactionInfoMapper")
	    private ClassTransactionInfoMapper classTransactionInfoMapper;

	    @Override
	    public boolean addClasstran(ClassTransactionInfo classTransactionInfo) {
	        try {
	            int i = classTransactionInfoMapper.insertSelective(classTransactionInfo);
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {

	        }

	        return false;
	    }

	    @Override
	    public boolean updateClasstran(ClassTransactionInfo classTransactionInfo) {
	        try {
	            int i = classTransactionInfoMapper.updateByPrimaryKeySelective(classTransactionInfo);
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {

	        }

	        return false;
	    }
	    
	    @Override
	    public List<ClassTransactionInfo> getClasstranInfoList(ClassTransactionInfo classTransactionInfo) {
	    	ClassTransactionInfoExample classTransactionInfoExample =new ClassTransactionInfoExample();
	        
	        Criteria criteria =classTransactionInfoExample.createCriteria();
	        if(classTransactionInfo!=null) {
	            //根据id查询
	            if(classTransactionInfo.getClassTransactionId()!=null) {
	                criteria.andClassTransactionIdEqualTo(classTransactionInfo.getClassTransactionId());
	            }
	            
	            //1代表正常  0代表删除
	            //查询所有正常的员工的数据
//	            ClassTransactionInfo.setClassTransactionState("1");
//	  删除掉之后状态1变为0 ，staff是staff-state变化
	            
	        }
//	        criteria.andClassTransactionStateEqualTo("1");
	       
	        
	        return classTransactionInfoMapper.selectByExample(classTransactionInfoExample);
	    }

	    @Override
	    public ClassTransactionInfo getClasstranInfo(Integer classId) {
	        
	        return classTransactionInfoMapper.selectByPrimaryKey(classId);
	    }

	
	

}
