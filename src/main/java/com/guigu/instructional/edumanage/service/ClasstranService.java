package com.guigu.instructional.edumanage.service;

import java.util.List;

import com.guigu.instructional.po.ClassTransactionInfo;


public interface ClasstranService {

	
//添加事务信息
	public boolean addClasstran(ClassTransactionInfo classTransactionInfo);
//	更新事务信息
	
	public boolean updateClasstran(ClassTransactionInfo classTransactionInfo);
	
//	根据条件查询事务信息
	
	public  List<ClassTransactionInfo> getClasstranInfoList(ClassTransactionInfo classTransactionInfo);
//根据编号查询事务信息
	
	public ClassTransactionInfo getClasstranInfo(Integer classId);
}
