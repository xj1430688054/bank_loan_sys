package com.load.model;
public class RemoneyInfo {
private Integer id;
private Integer amount;
private Integer applyId;
private Integer userId;
private String createTime;
private String updateTime;
private Integer isDelete;

	public Integer getId(){
		return id;
}
public void setId(Integer id){
	 this.id = id;
}
	public Integer getAmount(){
		return amount;
}
public void setAmount(Integer amount){
	 this.amount = amount;
}
	public Integer getApplyId(){
		return applyId;
}
public void setApplyId(Integer applyId){
	 this.applyId = applyId;
}
	public Integer getUserId(){
		return userId;
}
public void setUserId(Integer userId){
	 this.userId = userId;
}
	public String getCreateTime(){
		return createTime;
}
public void setCreateTime(String createTime){
	  this.createTime = createTime == null ? null : createTime.trim();
}
	public String getUpdateTime(){
		return updateTime;
}
public void setUpdateTime(String updateTime){
	  this.updateTime = updateTime == null ? null : updateTime.trim();
}
	public Integer getIsDelete(){
		return isDelete;
}
public void setIsDelete(Integer isDelete){
	 this.isDelete = isDelete;
}

}
