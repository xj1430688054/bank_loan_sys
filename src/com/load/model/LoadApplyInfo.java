package com.load.model;
public class LoadApplyInfo {
private Integer id;
private Integer stuId;
private String realName;
private String idNumber;
private String idnumberImg1;
private String idnumberImg2;
private String celPhone;
private String email;
private String pca;
private String address;
private Integer moneyAmount;
private String reason;
private String proveFile;
private String redate;
private Integer reamount;
private Integer restAmount;
private Integer schoolCheckStatus;
private String schoolCheckRemark;
private Integer bankCheckStatus;
private String bankCheckRemark;
private Integer scoolId;
private String createTime;
private String updateTime;
private Integer isDelete;

	public Integer getId(){
		return id;
}
public void setId(Integer id){
	 this.id = id;
}
	public Integer getStuId(){
		return stuId;
}
public void setStuId(Integer stuId){
	 this.stuId = stuId;
}
	public String getRealName(){
		return realName;
}
public void setRealName(String realName){
	  this.realName = realName == null ? null : realName.trim();
}
	public String getIdNumber(){
		return idNumber;
}
public void setIdNumber(String idNumber){
	  this.idNumber = idNumber == null ? null : idNumber.trim();
}
	public String getIdnumberImg1(){
		return idnumberImg1;
}
public void setIdnumberImg1(String idnumberImg1){
	  this.idnumberImg1 = idnumberImg1 == null ? null : idnumberImg1.trim();
}
	public String getIdnumberImg2(){
		return idnumberImg2;
}
public void setIdnumberImg2(String idnumberImg2){
	  this.idnumberImg2 = idnumberImg2 == null ? null : idnumberImg2.trim();
}
	public String getCelPhone(){
		return celPhone;
}
public void setCelPhone(String celPhone){
	  this.celPhone = celPhone == null ? null : celPhone.trim();
}
	public String getEmail(){
		return email;
}
public void setEmail(String email){
	  this.email = email == null ? null : email.trim();
}
	public String getPca(){
		return pca;
}
public void setPca(String pca){
	  this.pca = pca == null ? null : pca.trim();
}
	public String getAddress(){
		return address;
}
public void setAddress(String address){
	  this.address = address == null ? null : address.trim();
}
	public Integer getMoneyAmount(){
		return moneyAmount;
}
public void setMoneyAmount(Integer moneyAmount){
	 this.moneyAmount = moneyAmount;
}
	public String getReason(){
		return reason;
}
public void setReason(String reason){
	  this.reason = reason == null ? null : reason.trim();
}
	public String getProveFile(){
		return proveFile;
}
public void setProveFile(String proveFile){
	  this.proveFile = proveFile == null ? null : proveFile.trim();
}
	public String getRedate(){
		return redate;
}
public void setRedate(String redate){
	  this.redate = redate == null ? null : redate.trim();
}
	public Integer getReamount(){
		return reamount;
}
public void setReamount(Integer reamount){
	 this.reamount = reamount;
}
	public Integer getRestAmount(){
		return restAmount;
}
public void setRestAmount(Integer restAmount){
	 this.restAmount = restAmount;
}
	public Integer getSchoolCheckStatus(){
		return schoolCheckStatus;
}
public void setSchoolCheckStatus(Integer schoolCheckStatus){
	 this.schoolCheckStatus = schoolCheckStatus;
}
	public String getSchoolCheckRemark(){
		return schoolCheckRemark;
}
public void setSchoolCheckRemark(String schoolCheckRemark){
	  this.schoolCheckRemark = schoolCheckRemark == null ? null : schoolCheckRemark.trim();
}
	public Integer getBankCheckStatus(){
		return bankCheckStatus;
}
public void setBankCheckStatus(Integer bankCheckStatus){
	 this.bankCheckStatus = bankCheckStatus;
}
	public String getBankCheckRemark(){
		return bankCheckRemark;
}
public void setBankCheckRemark(String bankCheckRemark){
	  this.bankCheckRemark = bankCheckRemark == null ? null : bankCheckRemark.trim();
}
	public Integer getScoolId(){
		return scoolId;
}
public void setScoolId(Integer scoolId){
	 this.scoolId = scoolId;
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
