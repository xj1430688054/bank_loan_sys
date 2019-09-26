package com.load.dao;
import com.load.model.*;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface RemoneyInfoMapper {
    int countByExample(RemoneyInfoExample example);
    int deleteByExample(RemoneyInfoExample example);
    int deleteByPrimaryKey(Integer id);
    int insertSelectiveWithId(RemoneyInfo record);
     int insertSelective(RemoneyInfo record);
    List<RemoneyInfo> selectByExample(RemoneyInfoExample example);
    RemoneyInfo selectByPrimaryKey(Integer id);
    int updateByExampleSelective(@Param("record") RemoneyInfo record, @Param("example") RemoneyInfoExample example);
    int updateByPrimaryKeySelective(@Param("record") RemoneyInfo record);
}
