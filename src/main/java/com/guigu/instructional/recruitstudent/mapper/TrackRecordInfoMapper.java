package com.guigu.instructional.recruitstudent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.instructional.po.TrackRecordInfo;
import com.guigu.instructional.po.TrackRecordInfoExample;

public interface TrackRecordInfoMapper {
    int countByExample(TrackRecordInfoExample example);

    int deleteByExample(TrackRecordInfoExample example);

    int deleteByPrimaryKey(Integer trackRecordId);

    int insert(TrackRecordInfo record);

    int insertSelective(TrackRecordInfo record);

    List<TrackRecordInfo> selectByExample(TrackRecordInfoExample example);

    TrackRecordInfo selectByPrimaryKey(Integer trackRecordId);

    int updateByExampleSelective(@Param("record") TrackRecordInfo record, @Param("example") TrackRecordInfoExample example);

    int updateByExample(@Param("record") TrackRecordInfo record, @Param("example") TrackRecordInfoExample example);

    int updateByPrimaryKeySelective(TrackRecordInfo record);

    int updateByPrimaryKey(TrackRecordInfo record);
}