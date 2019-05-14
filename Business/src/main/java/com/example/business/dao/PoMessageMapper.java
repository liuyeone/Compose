package com.example.business.dao;

import com.example.business.entity.PoMessage;
import com.example.business.entity.PoMessageExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PoMessageMapper {
    int countByExample(PoMessageExample example);

    int deleteByExample(PoMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PoMessage record);

    int insertSelective(PoMessage record);

    List<PoMessage> selectByExampleWithBLOBs(PoMessageExample example);

    List<PoMessage> selectByExample(PoMessageExample example);

    PoMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PoMessage record, @Param("example") PoMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") PoMessage record, @Param("example") PoMessageExample example);

    int updateByExample(@Param("record") PoMessage record, @Param("example") PoMessageExample example);

    int updateByPrimaryKeySelective(PoMessage record);

    int updateByPrimaryKeyWithBLOBs(PoMessage record);

    int updateByPrimaryKey(PoMessage record);
}