package com.guigu.instructional.system.service;

import java.util.List;

import com.guigu.instructional.po.DataDictionary;

public interface DataDictionaryService {

	public boolean addDateDictionary(DataDictionary dataDictionary);
	
	public boolean updateDataDictionary(DataDictionary dataDictionary);
	
	public boolean deleteDataDictionary(Integer dataId);
	
	public List<DataDictionary> findDataDictionaryList(DataDictionary dataDictionary);
	
	public DataDictionary findDataDictionary(Integer dataId);
}
