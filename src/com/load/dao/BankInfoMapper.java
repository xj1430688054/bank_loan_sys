package com.load.dao;
import com.load.model.*;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface BankInfoMapper {
    int countByExample(BankInfoExample example);
    int deleteByExample(BankInfoExample example);
    int deleteByPrimaryKey(Integer id);
    int insertSelectiveWithId(BankInfo record);
     int insertSelective(BankInfo record);
    List<BankInfo> selectByExample(BankInfoExample example);
    BankInfo selectByPrimaryKey(Integer id);
    int updateByExampleSelective(@Param("record") BankInfo record, @Param("example") BankInfoExample example);
    int updateByPrimaryKeySelective(@Param("record") BankInfo record);
}
