package com.guigu.instructional.classinfo.mapper;

import com.guigu.instructional.po.SyllabusInfo;
import com.guigu.instructional.po.SyllabusInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyllabusInfoMapper {
    int countByExample(SyllabusInfoExample example);

    int deleteByExample(SyllabusInfoExample example);

    int deleteByPrimaryKey(Integer syllabusId);

    int insert(SyllabusInfo record);

    int insertSelective(SyllabusInfo record);

    List<SyllabusInfo> selectByExample(SyllabusInfoExample example);

    SyllabusInfo selectByPrimaryKey(Integer syllabusId);

    int updateByExampleSelective(@Param("record") SyllabusInfo record, @Param("example") SyllabusInfoExample example);

    int updateByExample(@Param("record") SyllabusInfo record, @Param("example") SyllabusInfoExample example);

    int updateByPrimaryKeySelective(SyllabusInfo record);

    int updateByPrimaryKey(SyllabusInfo record);
}