package com.example.common.dao;

import com.example.common.entity.PoUser;
import com.example.common.entity.PoUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PoUserMapper {
    int countByExample(PoUserExample example);

    int deleteByExample(PoUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PoUser record);

    int insertSelective(PoUser record);

    List<PoUser> selectByExample(PoUserExample example);

    PoUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PoUser record, @Param("example") PoUserExample example);

    int updateByExample(@Param("record") PoUser record, @Param("example") PoUserExample example);

    int updateByPrimaryKeySelective(PoUser record);

    int updateByPrimaryKey(PoUser record);
}