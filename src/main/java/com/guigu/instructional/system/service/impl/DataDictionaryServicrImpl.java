package com.guigu.instructional.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.DataDictionary;
import com.guigu.instructional.po.DataDictionaryExample;
import com.guigu.instructional.po.DataDictionaryExample.Criteria;
import com.guigu.instructional.system.mapper.DataDictionaryMapper;
import com.guigu.instructional.system.service.DataDictionaryService;

@Service("dataDictionaryServicrImpl")
public class DataDictionaryServicrImpl implements DataDictionaryService{

	@Resource(name="dataDictionaryMapper")
	public  DataDictionaryMapper dataDictionaryMapper;
	
	@Override
	public boolean addDateDictionary(DataDictionary dataDictionary) {
		int i=dataDictionaryMapper.insertSelective(dataDictionary);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateDataDictionary(DataDictionary dataDictionary) {
		int i=dataDictionaryMapper.updateByPrimaryKeySelective(dataDictionary);
		if(i>0) {
			return true;
		}
		return false;
	}
	

	@Override
	public boolean deleteDataDictionary(Integer dataId) {
		int i=dataDictionaryMapper.deleteByPrimaryKey(dataId);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<DataDictionary> findDataDictionaryList(DataDictionary dataDictionary) {
		DataDictionaryExample dataDictionaryExample=new DataDictionaryExample();
		Criteria criteria=dataDictionaryExample.createCriteria();
		if(dataDictionary!=null) {
			if(dataDictionary.getDataType()!=null) {
				dataDictionary.setDataType("%"+dataDictionary.getDataType()+"%");
				criteria.andDataTypeLike(dataDictionary.getDataType());
			}
		}
		return dataDictionaryMapper.selectByExample(dataDictionaryExample);
	}

	@Override
	public DataDictionary findDataDictionary(Integer dataId) {
		return dataDictionaryMapper.selectByPrimaryKey(dataId);
	}

}
