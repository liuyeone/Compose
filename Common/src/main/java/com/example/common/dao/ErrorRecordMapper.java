package com.example.common.dao;

import com.example.common.entity.ErrorRecord;
import com.example.common.entity.ErrorRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ErrorRecordMapper {
    int countByExample(ErrorRecordExample example);

    int deleteByExample(ErrorRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ErrorRecord record);

    int insertSelective(ErrorRecord record);

    List<ErrorRecord> selectByExampleWithBLOBs(ErrorRecordExample example);

    List<ErrorRecord> selectByExample(ErrorRecordExample example);

    ErrorRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ErrorRecord record, @Param("example") ErrorRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") ErrorRecord record, @Param("example") ErrorRecordExample example);

    int updateByExample(@Param("record") ErrorRecord record, @Param("example") ErrorRecordExample example);

    int updateByPrimaryKeySelective(ErrorRecord record);

    int updateByPrimaryKeyWithBLOBs(ErrorRecord record);

    int updateByPrimaryKey(ErrorRecord record);
}