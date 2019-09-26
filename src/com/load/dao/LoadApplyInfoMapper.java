package com.load.dao;
import com.load.model.*;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface LoadApplyInfoMapper {
    int countByExample(LoadApplyInfoExample example);
    int deleteByExample(LoadApplyInfoExample example);
    int deleteByPrimaryKey(Integer id);
    int insertSelectiveWithId(LoadApplyInfo record);
     int insertSelective(LoadApplyInfo record);
    List<LoadApplyInfo> selectByExample(LoadApplyInfoExample example);
    LoadApplyInfo selectByPrimaryKey(Integer id);
    int updateByExampleSelective(@Param("record") LoadApplyInfo record, @Param("example") LoadApplyInfoExample example);
    int updateByPrimaryKeySelective(@Param("record") LoadApplyInfo record);
}
