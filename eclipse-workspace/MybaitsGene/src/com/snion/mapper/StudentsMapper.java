package com.snion.mapper;

import com.snion.mapper.Students;
import com.snion.mapper.StudentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentsMapper {
    long countByExample(StudentsExample example);

    int deleteByExample(StudentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Students row);

    int insertSelective(Students row);

    List<Students> selectByExample(StudentsExample example);

    Students selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Students row, @Param("example") StudentsExample example);

    int updateByExample(@Param("row") Students row, @Param("example") StudentsExample example);

    int updateByPrimaryKeySelective(Students row);

    int updateByPrimaryKey(Students row);
}