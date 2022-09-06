package com.snion.mapper;

import com.snion.mapper.Teachers;
import com.snion.mapper.TeachersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeachersMapper {
    long countByExample(TeachersExample example);

    int deleteByExample(TeachersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teachers row);

    int insertSelective(Teachers row);

    List<Teachers> selectByExample(TeachersExample example);

    Teachers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Teachers row, @Param("example") TeachersExample example);

    int updateByExample(@Param("row") Teachers row, @Param("example") TeachersExample example);

    int updateByPrimaryKeySelective(Teachers row);

    int updateByPrimaryKey(Teachers row);
}