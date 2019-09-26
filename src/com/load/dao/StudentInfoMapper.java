package com.load.dao;
import com.load.model.*;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface StudentInfoMapper {
    int countByExample(StudentInfoExample example);
    int deleteByExample(StudentInfoExample example);
    int deleteByPrimaryKey(Integer id);
    int insertSelectiveWithId(StudentInfo record);
     int insertSelective(StudentInfo record);
    List<StudentInfo> selectByExample(StudentInfoExample example);
    StudentInfo selectByPrimaryKey(Integer id);
    int updateByExampleSelective(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);
    int updateByPrimaryKeySelective(@Param("record") StudentInfo record);
}
