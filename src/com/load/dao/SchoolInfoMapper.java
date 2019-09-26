package com.load.dao;
import com.load.model.*;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface SchoolInfoMapper {
    int countByExample(SchoolInfoExample example);
    int deleteByExample(SchoolInfoExample example);
    int deleteByPrimaryKey(Integer id);
    int insertSelectiveWithId(SchoolInfo record);
     int insertSelective(SchoolInfo record);
    List<SchoolInfo> selectByExample(SchoolInfoExample example);
    SchoolInfo selectByPrimaryKey(Integer id);
    int updateByExampleSelective(@Param("record") SchoolInfo record, @Param("example") SchoolInfoExample example);
    int updateByPrimaryKeySelective(@Param("record") SchoolInfo record);
}
