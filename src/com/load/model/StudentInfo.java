package com.load.model;
public class StudentInfo {
private Integer id;
private String name;
private String passWord;
private Integer schoolId;
private Integer isBlack;
private String createTime;
private String updateTime;
private Integer isDelete;

	public Integer getId(){
		return id;
}
public void setId(Integer id){
	 this.id = id;
}
	public String getName(){
		return name;
}
public void setName(String name){
	  this.name = name == null ? null : name.trim();
}
	public String getPassWord(){
		return passWord;
}
public void setPassWord(String passWord){
	  this.passWord = passWord == null ? null : passWord.trim();
}
	public Integer getSchoolId(){
		return schoolId;
}
public void setSchoolId(Integer schoolId){
	 this.schoolId = schoolId;
}
	public Integer getIsBlack(){
		return isBlack;
}
public void setIsBlack(Integer isBlack){
	 this.isBlack = isBlack;
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
