package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.EvaluationInfo;

public interface EvaluationInfoService {

	public boolean addEvaluationInfo(EvaluationInfo evaluationInfo);
	
	public boolean updateEvaluationInfo(EvaluationInfo evaluationInfo);
	
	public List<EvaluationInfo> findEvaluationInfoList(EvaluationInfo evaluationInfo);
	
    public EvaluationInfo findEvaluationInfo(Integer evaluationId);
    
    public boolean deleteEvaluationInfo(Integer evaluationId);
}
