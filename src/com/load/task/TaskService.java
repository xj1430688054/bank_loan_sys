package com.load.task;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.load.dao.LoadApplyInfoMapper;
import com.load.dao.StudentInfoMapper;
import com.load.model.LoadApplyInfo;
import com.load.model.LoadApplyInfoExample;
import com.load.model.StudentInfo;


@Component 
public class TaskService {

	@Autowired
	LoadApplyInfoMapper loadApplyInfoMapper;
	@Autowired
	StudentInfoMapper studentInfoMapper;
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	 @Scheduled(cron="0 */1 * * * ?")  
	public void saveAccessToken(){
		//判断有没有延期，如果延期，则将该用户拉入黑名单
		 String now = sdf.format(new Date());
		 LoadApplyInfoExample le = new LoadApplyInfoExample();
		 LoadApplyInfoExample.Criteria lc = le.createCriteria();
		 lc.andIsDeleteEqualTo(0);
		 lc.andSchoolCheckStatusEqualTo(2);
		 lc.andBankCheckStatusEqualTo(2);
		 lc.andRestAmountGreaterThan(0);//查询剩余金额大于0的数据
		 lc.andRedateLessThanOrEqualTo(now);//查询到期了的数据
		 List<LoadApplyInfo> ll = loadApplyInfoMapper.selectByExample(le);
		 for(LoadApplyInfo l:ll){
			 StudentInfo stu = studentInfoMapper.selectByPrimaryKey(l.getStuId());
			 stu.setIsBlack(1);//拉入黑名单
			 studentInfoMapper.updateByPrimaryKeySelective(stu);
		 }
		 
		 
	}
}
