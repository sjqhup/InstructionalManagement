package com.guigu.instructional.recruitstudent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.AuditionInfoExample;

public interface AuditionInfoMapper {
    int countByExample(AuditionInfoExample example);

    int deleteByExample(AuditionInfoExample example);

    int deleteByPrimaryKey(Integer auditionId);

    int insert(AuditionInfo record);

    int insertSelective(AuditionInfo record);

    List<AuditionInfo> selectByExample(AuditionInfoExample example);

    AuditionInfo selectByPrimaryKey(Integer auditionId);

    int updateByExampleSelective(@Param("record") AuditionInfo record, @Param("example") AuditionInfoExample example);

    int updateByExample(@Param("record") AuditionInfo record, @Param("example") AuditionInfoExample example);

    int updateByPrimaryKeySelective(AuditionInfo record);

    int updateByPrimaryKey(AuditionInfo record);
}