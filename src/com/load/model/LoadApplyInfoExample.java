package com.load.model;
import java.util.ArrayList;
import java.util.List;
public class LoadApplyInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    public LoadApplyInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    public String getOrderByClause() {
        return orderByClause;
    }
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    public boolean isDistinct() {
        return distinct;
    }
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;
        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }
        public boolean isValid() {
            return criteria.size() > 0;
        }
        public List<Criterion> getAllCriteria() {
            return criteria;
        }
        public List<Criterion> getCriteria() {
            return criteria;
        }
        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
	 public Criteria andIdIsNull() {
		 addCriterion("id is null");
		return (Criteria) this;
		}
  public Criteria andIdIsNotNull(){
		addCriterion("id is not null");
		return (Criteria) this;
		}
  public Criteria andIdEqualTo(Integer value) {
		  addCriterion("id =", value, "id");
		return (Criteria) this;
		}
   public Criteria andIdNotEqualTo(Integer value) {
		  addCriterion("id <>", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdGreaterThan(Integer value) {
		 addCriterion("id >", value, "id");
		return (Criteria) this;
		}
  public Criteria andIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("id >=", value, "Id");
		return (Criteria) this;
		}
   public Criteria andIdLessThan(Integer value) {
		  addCriterion("id <", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdLessThanOrEqualTo(Integer value) {
		  addCriterion("id <=", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdIn(List<Integer> values) {
		  addCriterion("id in", values, "id");
		return (Criteria) this;
		}
    public Criteria andIdNotIn(List<Integer> values) {
		  addCriterion("id not in", values, "id");
		return (Criteria) this;
		}
     public Criteria andIdBetween(Integer value1, Integer value2) {
		   addCriterion("id between", value1, value2, "id");
		return (Criteria) this;
		}
     public Criteria andIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("id not between", value1, value2, "id");
		return (Criteria) this;
		}
    public Criteria andIdLike(Integer value) {
		  addCriterion("id like", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdNotLike(Integer value) {
		  addCriterion("id not like", value, "id");
		return (Criteria) this;
		}
 public Criteria andStuIdIsNull() {
		 addCriterion("stu_id is null");
		return (Criteria) this;
		}
  public Criteria andStuIdIsNotNull(){
		addCriterion("stu_id is not null");
		return (Criteria) this;
		}
  public Criteria andStuIdEqualTo(Integer value) {
		  addCriterion("stu_id =", value, "stuId");
		return (Criteria) this;
		}
   public Criteria andStuIdNotEqualTo(Integer value) {
		  addCriterion("stu_id <>", value, "stuId");
		return (Criteria) this;
		}
    public Criteria andStuIdGreaterThan(Integer value) {
		 addCriterion("stu_id >", value, "stuId");
		return (Criteria) this;
		}
  public Criteria andStuIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("stu_id >=", value, "StuId");
		return (Criteria) this;
		}
   public Criteria andStuIdLessThan(Integer value) {
		  addCriterion("stu_id <", value, "stuId");
		return (Criteria) this;
		}
    public Criteria andStuIdLessThanOrEqualTo(Integer value) {
		  addCriterion("stu_id <=", value, "stuId");
		return (Criteria) this;
		}
    public Criteria andStuIdIn(List<Integer> values) {
		  addCriterion("stu_id in", values, "stuId");
		return (Criteria) this;
		}
    public Criteria andStuIdNotIn(List<Integer> values) {
		  addCriterion("stu_id not in", values, "stuId");
		return (Criteria) this;
		}
     public Criteria andStuIdBetween(Integer value1, Integer value2) {
		   addCriterion("stu_id between", value1, value2, "stuId");
		return (Criteria) this;
		}
     public Criteria andStuIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("stu_id not between", value1, value2, "stuId");
		return (Criteria) this;
		}
    public Criteria andStuIdLike(Integer value) {
		  addCriterion("stu_id like", value, "stuId");
		return (Criteria) this;
		}
    public Criteria andStuIdNotLike(Integer value) {
		  addCriterion("stu_id not like", value, "stuId");
		return (Criteria) this;
		}
 public Criteria andRealNameIsNull() {
		 addCriterion("real_name is null");
		return (Criteria) this;
		}
  public Criteria andRealNameIsNotNull(){
		addCriterion("real_name is not null");
		return (Criteria) this;
		}
  public Criteria andRealNameEqualTo(String value) {
		  addCriterion("real_name =", value, "realName");
		return (Criteria) this;
		}
   public Criteria andRealNameNotEqualTo(String value) {
		  addCriterion("real_name <>", value, "realName");
		return (Criteria) this;
		}
    public Criteria andRealNameGreaterThan(String value) {
		 addCriterion("real_name >", value, "realName");
		return (Criteria) this;
		}
  public Criteria andRealNameGreaterThanOrEqualTo(String value) {
		  addCriterion("real_name >=", value, "RealName");
		return (Criteria) this;
		}
   public Criteria andRealNameLessThan(String value) {
		  addCriterion("real_name <", value, "realName");
		return (Criteria) this;
		}
    public Criteria andRealNameLessThanOrEqualTo(String value) {
		  addCriterion("real_name <=", value, "realName");
		return (Criteria) this;
		}
    public Criteria andRealNameIn(List<String> values) {
		  addCriterion("real_name in", values, "realName");
		return (Criteria) this;
		}
    public Criteria andRealNameNotIn(List<String> values) {
		  addCriterion("real_name not in", values, "realName");
		return (Criteria) this;
		}
     public Criteria andRealNameBetween(String value1, String value2) {
		   addCriterion("real_name between", value1, value2, "realName");
		return (Criteria) this;
		}
     public Criteria andRealNameNotBetween(String value1, String value2) {
		   addCriterion("real_name not between", value1, value2, "realName");
		return (Criteria) this;
		}
    public Criteria andRealNameLike(String value) {
		  addCriterion("real_name like", value, "realName");
		return (Criteria) this;
		}
    public Criteria andRealNameNotLike(String value) {
		  addCriterion("real_name not like", value, "realName");
		return (Criteria) this;
		}
 public Criteria andIdNumberIsNull() {
		 addCriterion("id_number is null");
		return (Criteria) this;
		}
  public Criteria andIdNumberIsNotNull(){
		addCriterion("id_number is not null");
		return (Criteria) this;
		}
  public Criteria andIdNumberEqualTo(String value) {
		  addCriterion("id_number =", value, "idNumber");
		return (Criteria) this;
		}
   public Criteria andIdNumberNotEqualTo(String value) {
		  addCriterion("id_number <>", value, "idNumber");
		return (Criteria) this;
		}
    public Criteria andIdNumberGreaterThan(String value) {
		 addCriterion("id_number >", value, "idNumber");
		return (Criteria) this;
		}
  public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
		  addCriterion("id_number >=", value, "IdNumber");
		return (Criteria) this;
		}
   public Criteria andIdNumberLessThan(String value) {
		  addCriterion("id_number <", value, "idNumber");
		return (Criteria) this;
		}
    public Criteria andIdNumberLessThanOrEqualTo(String value) {
		  addCriterion("id_number <=", value, "idNumber");
		return (Criteria) this;
		}
    public Criteria andIdNumberIn(List<String> values) {
		  addCriterion("id_number in", values, "idNumber");
		return (Criteria) this;
		}
    public Criteria andIdNumberNotIn(List<String> values) {
		  addCriterion("id_number not in", values, "idNumber");
		return (Criteria) this;
		}
     public Criteria andIdNumberBetween(String value1, String value2) {
		   addCriterion("id_number between", value1, value2, "idNumber");
		return (Criteria) this;
		}
     public Criteria andIdNumberNotBetween(String value1, String value2) {
		   addCriterion("id_number not between", value1, value2, "idNumber");
		return (Criteria) this;
		}
    public Criteria andIdNumberLike(String value) {
		  addCriterion("id_number like", value, "idNumber");
		return (Criteria) this;
		}
    public Criteria andIdNumberNotLike(String value) {
		  addCriterion("id_number not like", value, "idNumber");
		return (Criteria) this;
		}
 public Criteria andIdnumberImg1IsNull() {
		 addCriterion("idnumber_img1 is null");
		return (Criteria) this;
		}
  public Criteria andIdnumberImg1IsNotNull(){
		addCriterion("idnumber_img1 is not null");
		return (Criteria) this;
		}
  public Criteria andIdnumberImg1EqualTo(String value) {
		  addCriterion("idnumber_img1 =", value, "idnumberImg1");
		return (Criteria) this;
		}
   public Criteria andIdnumberImg1NotEqualTo(String value) {
		  addCriterion("idnumber_img1 <>", value, "idnumberImg1");
		return (Criteria) this;
		}
    public Criteria andIdnumberImg1GreaterThan(String value) {
		 addCriterion("idnumber_img1 >", value, "idnumberImg1");
		return (Criteria) this;
		}
  public Criteria andIdnumberImg1GreaterThanOrEqualTo(String value) {
		  addCriterion("idnumber_img1 >=", value, "IdnumberImg1");
		return (Criteria) this;
		}
   public Criteria andIdnumberImg1LessThan(String value) {
		  addCriterion("idnumber_img1 <", value, "idnumberImg1");
		return (Criteria) this;
		}
    public Criteria andIdnumberImg1LessThanOrEqualTo(String value) {
		  addCriterion("idnumber_img1 <=", value, "idnumberImg1");
		return (Criteria) this;
		}
    public Criteria andIdnumberImg1In(List<String> values) {
		  addCriterion("idnumber_img1 in", values, "idnumberImg1");
		return (Criteria) this;
		}
    public Criteria andIdnumberImg1NotIn(List<String> values) {
		  addCriterion("idnumber_img1 not in", values, "idnumberImg1");
		return (Criteria) this;
		}
     public Criteria andIdnumberImg1Between(String value1, String value2) {
		   addCriterion("idnumber_img1 between", value1, value2, "idnumberImg1");
		return (Criteria) this;
		}
     public Criteria andIdnumberImg1NotBetween(String value1, String value2) {
		   addCriterion("idnumber_img1 not between", value1, value2, "idnumberImg1");
		return (Criteria) this;
		}
    public Criteria andIdnumberImg1Like(String value) {
		  addCriterion("idnumber_img1 like", value, "idnumberImg1");
		return (Criteria) this;
		}
    public Criteria andIdnumberImg1NotLike(String value) {
		  addCriterion("idnumber_img1 not like", value, "idnumberImg1");
		return (Criteria) this;
		}
 public Criteria andIdnumberImg2IsNull() {
		 addCriterion("idnumber_img2 is null");
		return (Criteria) this;
		}
  public Criteria andIdnumberImg2IsNotNull(){
		addCriterion("idnumber_img2 is not null");
		return (Criteria) this;
		}
  public Criteria andIdnumberImg2EqualTo(String value) {
		  addCriterion("idnumber_img2 =", value, "idnumberImg2");
		return (Criteria) this;
		}
   public Criteria andIdnumberImg2NotEqualTo(String value) {
		  addCriterion("idnumber_img2 <>", value, "idnumberImg2");
		return (Criteria) this;
		}
    public Criteria andIdnumberImg2GreaterThan(String value) {
		 addCriterion("idnumber_img2 >", value, "idnumberImg2");
		return (Criteria) this;
		}
  public Criteria andIdnumberImg2GreaterThanOrEqualTo(String value) {
		  addCriterion("idnumber_img2 >=", value, "IdnumberImg2");
		return (Criteria) this;
		}
   public Criteria andIdnumberImg2LessThan(String value) {
		  addCriterion("idnumber_img2 <", value, "idnumberImg2");
		return (Criteria) this;
		}
    public Criteria andIdnumberImg2LessThanOrEqualTo(String value) {
		  addCriterion("idnumber_img2 <=", value, "idnumberImg2");
		return (Criteria) this;
		}
    public Criteria andIdnumberImg2In(List<String> values) {
		  addCriterion("idnumber_img2 in", values, "idnumberImg2");
		return (Criteria) this;
		}
    public Criteria andIdnumberImg2NotIn(List<String> values) {
		  addCriterion("idnumber_img2 not in", values, "idnumberImg2");
		return (Criteria) this;
		}
     public Criteria andIdnumberImg2Between(String value1, String value2) {
		   addCriterion("idnumber_img2 between", value1, value2, "idnumberImg2");
		return (Criteria) this;
		}
     public Criteria andIdnumberImg2NotBetween(String value1, String value2) {
		   addCriterion("idnumber_img2 not between", value1, value2, "idnumberImg2");
		return (Criteria) this;
		}
    public Criteria andIdnumberImg2Like(String value) {
		  addCriterion("idnumber_img2 like", value, "idnumberImg2");
		return (Criteria) this;
		}
    public Criteria andIdnumberImg2NotLike(String value) {
		  addCriterion("idnumber_img2 not like", value, "idnumberImg2");
		return (Criteria) this;
		}
 public Criteria andCelPhoneIsNull() {
		 addCriterion("cel_phone is null");
		return (Criteria) this;
		}
  public Criteria andCelPhoneIsNotNull(){
		addCriterion("cel_phone is not null");
		return (Criteria) this;
		}
  public Criteria andCelPhoneEqualTo(String value) {
		  addCriterion("cel_phone =", value, "celPhone");
		return (Criteria) this;
		}
   public Criteria andCelPhoneNotEqualTo(String value) {
		  addCriterion("cel_phone <>", value, "celPhone");
		return (Criteria) this;
		}
    public Criteria andCelPhoneGreaterThan(String value) {
		 addCriterion("cel_phone >", value, "celPhone");
		return (Criteria) this;
		}
  public Criteria andCelPhoneGreaterThanOrEqualTo(String value) {
		  addCriterion("cel_phone >=", value, "CelPhone");
		return (Criteria) this;
		}
   public Criteria andCelPhoneLessThan(String value) {
		  addCriterion("cel_phone <", value, "celPhone");
		return (Criteria) this;
		}
    public Criteria andCelPhoneLessThanOrEqualTo(String value) {
		  addCriterion("cel_phone <=", value, "celPhone");
		return (Criteria) this;
		}
    public Criteria andCelPhoneIn(List<String> values) {
		  addCriterion("cel_phone in", values, "celPhone");
		return (Criteria) this;
		}
    public Criteria andCelPhoneNotIn(List<String> values) {
		  addCriterion("cel_phone not in", values, "celPhone");
		return (Criteria) this;
		}
     public Criteria andCelPhoneBetween(String value1, String value2) {
		   addCriterion("cel_phone between", value1, value2, "celPhone");
		return (Criteria) this;
		}
     public Criteria andCelPhoneNotBetween(String value1, String value2) {
		   addCriterion("cel_phone not between", value1, value2, "celPhone");
		return (Criteria) this;
		}
    public Criteria andCelPhoneLike(String value) {
		  addCriterion("cel_phone like", value, "celPhone");
		return (Criteria) this;
		}
    public Criteria andCelPhoneNotLike(String value) {
		  addCriterion("cel_phone not like", value, "celPhone");
		return (Criteria) this;
		}
 public Criteria andEmailIsNull() {
		 addCriterion("email is null");
		return (Criteria) this;
		}
  public Criteria andEmailIsNotNull(){
		addCriterion("email is not null");
		return (Criteria) this;
		}
  public Criteria andEmailEqualTo(String value) {
		  addCriterion("email =", value, "email");
		return (Criteria) this;
		}
   public Criteria andEmailNotEqualTo(String value) {
		  addCriterion("email <>", value, "email");
		return (Criteria) this;
		}
    public Criteria andEmailGreaterThan(String value) {
		 addCriterion("email >", value, "email");
		return (Criteria) this;
		}
  public Criteria andEmailGreaterThanOrEqualTo(String value) {
		  addCriterion("email >=", value, "Email");
		return (Criteria) this;
		}
   public Criteria andEmailLessThan(String value) {
		  addCriterion("email <", value, "email");
		return (Criteria) this;
		}
    public Criteria andEmailLessThanOrEqualTo(String value) {
		  addCriterion("email <=", value, "email");
		return (Criteria) this;
		}
    public Criteria andEmailIn(List<String> values) {
		  addCriterion("email in", values, "email");
		return (Criteria) this;
		}
    public Criteria andEmailNotIn(List<String> values) {
		  addCriterion("email not in", values, "email");
		return (Criteria) this;
		}
     public Criteria andEmailBetween(String value1, String value2) {
		   addCriterion("email between", value1, value2, "email");
		return (Criteria) this;
		}
     public Criteria andEmailNotBetween(String value1, String value2) {
		   addCriterion("email not between", value1, value2, "email");
		return (Criteria) this;
		}
    public Criteria andEmailLike(String value) {
		  addCriterion("email like", value, "email");
		return (Criteria) this;
		}
    public Criteria andEmailNotLike(String value) {
		  addCriterion("email not like", value, "email");
		return (Criteria) this;
		}
 public Criteria andPcaIsNull() {
		 addCriterion("pca is null");
		return (Criteria) this;
		}
  public Criteria andPcaIsNotNull(){
		addCriterion("pca is not null");
		return (Criteria) this;
		}
  public Criteria andPcaEqualTo(String value) {
		  addCriterion("pca =", value, "pca");
		return (Criteria) this;
		}
   public Criteria andPcaNotEqualTo(String value) {
		  addCriterion("pca <>", value, "pca");
		return (Criteria) this;
		}
    public Criteria andPcaGreaterThan(String value) {
		 addCriterion("pca >", value, "pca");
		return (Criteria) this;
		}
  public Criteria andPcaGreaterThanOrEqualTo(String value) {
		  addCriterion("pca >=", value, "Pca");
		return (Criteria) this;
		}
   public Criteria andPcaLessThan(String value) {
		  addCriterion("pca <", value, "pca");
		return (Criteria) this;
		}
    public Criteria andPcaLessThanOrEqualTo(String value) {
		  addCriterion("pca <=", value, "pca");
		return (Criteria) this;
		}
    public Criteria andPcaIn(List<String> values) {
		  addCriterion("pca in", values, "pca");
		return (Criteria) this;
		}
    public Criteria andPcaNotIn(List<String> values) {
		  addCriterion("pca not in", values, "pca");
		return (Criteria) this;
		}
     public Criteria andPcaBetween(String value1, String value2) {
		   addCriterion("pca between", value1, value2, "pca");
		return (Criteria) this;
		}
     public Criteria andPcaNotBetween(String value1, String value2) {
		   addCriterion("pca not between", value1, value2, "pca");
		return (Criteria) this;
		}
    public Criteria andPcaLike(String value) {
		  addCriterion("pca like", value, "pca");
		return (Criteria) this;
		}
    public Criteria andPcaNotLike(String value) {
		  addCriterion("pca not like", value, "pca");
		return (Criteria) this;
		}
 public Criteria andAddressIsNull() {
		 addCriterion("address is null");
		return (Criteria) this;
		}
  public Criteria andAddressIsNotNull(){
		addCriterion("address is not null");
		return (Criteria) this;
		}
  public Criteria andAddressEqualTo(String value) {
		  addCriterion("address =", value, "address");
		return (Criteria) this;
		}
   public Criteria andAddressNotEqualTo(String value) {
		  addCriterion("address <>", value, "address");
		return (Criteria) this;
		}
    public Criteria andAddressGreaterThan(String value) {
		 addCriterion("address >", value, "address");
		return (Criteria) this;
		}
  public Criteria andAddressGreaterThanOrEqualTo(String value) {
		  addCriterion("address >=", value, "Address");
		return (Criteria) this;
		}
   public Criteria andAddressLessThan(String value) {
		  addCriterion("address <", value, "address");
		return (Criteria) this;
		}
    public Criteria andAddressLessThanOrEqualTo(String value) {
		  addCriterion("address <=", value, "address");
		return (Criteria) this;
		}
    public Criteria andAddressIn(List<String> values) {
		  addCriterion("address in", values, "address");
		return (Criteria) this;
		}
    public Criteria andAddressNotIn(List<String> values) {
		  addCriterion("address not in", values, "address");
		return (Criteria) this;
		}
     public Criteria andAddressBetween(String value1, String value2) {
		   addCriterion("address between", value1, value2, "address");
		return (Criteria) this;
		}
     public Criteria andAddressNotBetween(String value1, String value2) {
		   addCriterion("address not between", value1, value2, "address");
		return (Criteria) this;
		}
    public Criteria andAddressLike(String value) {
		  addCriterion("address like", value, "address");
		return (Criteria) this;
		}
    public Criteria andAddressNotLike(String value) {
		  addCriterion("address not like", value, "address");
		return (Criteria) this;
		}
 public Criteria andMoneyAmountIsNull() {
		 addCriterion("money_amount is null");
		return (Criteria) this;
		}
  public Criteria andMoneyAmountIsNotNull(){
		addCriterion("money_amount is not null");
		return (Criteria) this;
		}
  public Criteria andMoneyAmountEqualTo(Integer value) {
		  addCriterion("money_amount =", value, "moneyAmount");
		return (Criteria) this;
		}
   public Criteria andMoneyAmountNotEqualTo(Integer value) {
		  addCriterion("money_amount <>", value, "moneyAmount");
		return (Criteria) this;
		}
    public Criteria andMoneyAmountGreaterThan(Integer value) {
		 addCriterion("money_amount >", value, "moneyAmount");
		return (Criteria) this;
		}
  public Criteria andMoneyAmountGreaterThanOrEqualTo(Integer value) {
		  addCriterion("money_amount >=", value, "MoneyAmount");
		return (Criteria) this;
		}
   public Criteria andMoneyAmountLessThan(Integer value) {
		  addCriterion("money_amount <", value, "moneyAmount");
		return (Criteria) this;
		}
    public Criteria andMoneyAmountLessThanOrEqualTo(Integer value) {
		  addCriterion("money_amount <=", value, "moneyAmount");
		return (Criteria) this;
		}
    public Criteria andMoneyAmountIn(List<Integer> values) {
		  addCriterion("money_amount in", values, "moneyAmount");
		return (Criteria) this;
		}
    public Criteria andMoneyAmountNotIn(List<Integer> values) {
		  addCriterion("money_amount not in", values, "moneyAmount");
		return (Criteria) this;
		}
     public Criteria andMoneyAmountBetween(Integer value1, Integer value2) {
		   addCriterion("money_amount between", value1, value2, "moneyAmount");
		return (Criteria) this;
		}
     public Criteria andMoneyAmountNotBetween(Integer value1, Integer value2) {
		   addCriterion("money_amount not between", value1, value2, "moneyAmount");
		return (Criteria) this;
		}
    public Criteria andMoneyAmountLike(Integer value) {
		  addCriterion("money_amount like", value, "moneyAmount");
		return (Criteria) this;
		}
    public Criteria andMoneyAmountNotLike(Integer value) {
		  addCriterion("money_amount not like", value, "moneyAmount");
		return (Criteria) this;
		}
 public Criteria andReasonIsNull() {
		 addCriterion("reason is null");
		return (Criteria) this;
		}
  public Criteria andReasonIsNotNull(){
		addCriterion("reason is not null");
		return (Criteria) this;
		}
  public Criteria andReasonEqualTo(String value) {
		  addCriterion("reason =", value, "reason");
		return (Criteria) this;
		}
   public Criteria andReasonNotEqualTo(String value) {
		  addCriterion("reason <>", value, "reason");
		return (Criteria) this;
		}
    public Criteria andReasonGreaterThan(String value) {
		 addCriterion("reason >", value, "reason");
		return (Criteria) this;
		}
  public Criteria andReasonGreaterThanOrEqualTo(String value) {
		  addCriterion("reason >=", value, "Reason");
		return (Criteria) this;
		}
   public Criteria andReasonLessThan(String value) {
		  addCriterion("reason <", value, "reason");
		return (Criteria) this;
		}
    public Criteria andReasonLessThanOrEqualTo(String value) {
		  addCriterion("reason <=", value, "reason");
		return (Criteria) this;
		}
    public Criteria andReasonIn(List<String> values) {
		  addCriterion("reason in", values, "reason");
		return (Criteria) this;
		}
    public Criteria andReasonNotIn(List<String> values) {
		  addCriterion("reason not in", values, "reason");
		return (Criteria) this;
		}
     public Criteria andReasonBetween(String value1, String value2) {
		   addCriterion("reason between", value1, value2, "reason");
		return (Criteria) this;
		}
     public Criteria andReasonNotBetween(String value1, String value2) {
		   addCriterion("reason not between", value1, value2, "reason");
		return (Criteria) this;
		}
    public Criteria andReasonLike(String value) {
		  addCriterion("reason like", value, "reason");
		return (Criteria) this;
		}
    public Criteria andReasonNotLike(String value) {
		  addCriterion("reason not like", value, "reason");
		return (Criteria) this;
		}
 public Criteria andProveFileIsNull() {
		 addCriterion("prove_file is null");
		return (Criteria) this;
		}
  public Criteria andProveFileIsNotNull(){
		addCriterion("prove_file is not null");
		return (Criteria) this;
		}
  public Criteria andProveFileEqualTo(String value) {
		  addCriterion("prove_file =", value, "proveFile");
		return (Criteria) this;
		}
   public Criteria andProveFileNotEqualTo(String value) {
		  addCriterion("prove_file <>", value, "proveFile");
		return (Criteria) this;
		}
    public Criteria andProveFileGreaterThan(String value) {
		 addCriterion("prove_file >", value, "proveFile");
		return (Criteria) this;
		}
  public Criteria andProveFileGreaterThanOrEqualTo(String value) {
		  addCriterion("prove_file >=", value, "ProveFile");
		return (Criteria) this;
		}
   public Criteria andProveFileLessThan(String value) {
		  addCriterion("prove_file <", value, "proveFile");
		return (Criteria) this;
		}
    public Criteria andProveFileLessThanOrEqualTo(String value) {
		  addCriterion("prove_file <=", value, "proveFile");
		return (Criteria) this;
		}
    public Criteria andProveFileIn(List<String> values) {
		  addCriterion("prove_file in", values, "proveFile");
		return (Criteria) this;
		}
    public Criteria andProveFileNotIn(List<String> values) {
		  addCriterion("prove_file not in", values, "proveFile");
		return (Criteria) this;
		}
     public Criteria andProveFileBetween(String value1, String value2) {
		   addCriterion("prove_file between", value1, value2, "proveFile");
		return (Criteria) this;
		}
     public Criteria andProveFileNotBetween(String value1, String value2) {
		   addCriterion("prove_file not between", value1, value2, "proveFile");
		return (Criteria) this;
		}
    public Criteria andProveFileLike(String value) {
		  addCriterion("prove_file like", value, "proveFile");
		return (Criteria) this;
		}
    public Criteria andProveFileNotLike(String value) {
		  addCriterion("prove_file not like", value, "proveFile");
		return (Criteria) this;
		}
 public Criteria andRedateIsNull() {
		 addCriterion("redate is null");
		return (Criteria) this;
		}
  public Criteria andRedateIsNotNull(){
		addCriterion("redate is not null");
		return (Criteria) this;
		}
  public Criteria andRedateEqualTo(String value) {
		  addCriterion("redate =", value, "redate");
		return (Criteria) this;
		}
   public Criteria andRedateNotEqualTo(String value) {
		  addCriterion("redate <>", value, "redate");
		return (Criteria) this;
		}
    public Criteria andRedateGreaterThan(String value) {
		 addCriterion("redate >", value, "redate");
		return (Criteria) this;
		}
  public Criteria andRedateGreaterThanOrEqualTo(String value) {
		  addCriterion("redate >=", value, "Redate");
		return (Criteria) this;
		}
   public Criteria andRedateLessThan(String value) {
		  addCriterion("redate <", value, "redate");
		return (Criteria) this;
		}
    public Criteria andRedateLessThanOrEqualTo(String value) {
		  addCriterion("redate <=", value, "redate");
		return (Criteria) this;
		}
    public Criteria andRedateIn(List<String> values) {
		  addCriterion("redate in", values, "redate");
		return (Criteria) this;
		}
    public Criteria andRedateNotIn(List<String> values) {
		  addCriterion("redate not in", values, "redate");
		return (Criteria) this;
		}
     public Criteria andRedateBetween(String value1, String value2) {
		   addCriterion("redate between", value1, value2, "redate");
		return (Criteria) this;
		}
     public Criteria andRedateNotBetween(String value1, String value2) {
		   addCriterion("redate not between", value1, value2, "redate");
		return (Criteria) this;
		}
    public Criteria andRedateLike(String value) {
		  addCriterion("redate like", value, "redate");
		return (Criteria) this;
		}
    public Criteria andRedateNotLike(String value) {
		  addCriterion("redate not like", value, "redate");
		return (Criteria) this;
		}
 public Criteria andReamountIsNull() {
		 addCriterion("reamount is null");
		return (Criteria) this;
		}
  public Criteria andReamountIsNotNull(){
		addCriterion("reamount is not null");
		return (Criteria) this;
		}
  public Criteria andReamountEqualTo(Integer value) {
		  addCriterion("reamount =", value, "reamount");
		return (Criteria) this;
		}
   public Criteria andReamountNotEqualTo(Integer value) {
		  addCriterion("reamount <>", value, "reamount");
		return (Criteria) this;
		}
    public Criteria andReamountGreaterThan(Integer value) {
		 addCriterion("reamount >", value, "reamount");
		return (Criteria) this;
		}
  public Criteria andReamountGreaterThanOrEqualTo(Integer value) {
		  addCriterion("reamount >=", value, "Reamount");
		return (Criteria) this;
		}
   public Criteria andReamountLessThan(Integer value) {
		  addCriterion("reamount <", value, "reamount");
		return (Criteria) this;
		}
    public Criteria andReamountLessThanOrEqualTo(Integer value) {
		  addCriterion("reamount <=", value, "reamount");
		return (Criteria) this;
		}
    public Criteria andReamountIn(List<Integer> values) {
		  addCriterion("reamount in", values, "reamount");
		return (Criteria) this;
		}
    public Criteria andReamountNotIn(List<Integer> values) {
		  addCriterion("reamount not in", values, "reamount");
		return (Criteria) this;
		}
     public Criteria andReamountBetween(Integer value1, Integer value2) {
		   addCriterion("reamount between", value1, value2, "reamount");
		return (Criteria) this;
		}
     public Criteria andReamountNotBetween(Integer value1, Integer value2) {
		   addCriterion("reamount not between", value1, value2, "reamount");
		return (Criteria) this;
		}
    public Criteria andReamountLike(Integer value) {
		  addCriterion("reamount like", value, "reamount");
		return (Criteria) this;
		}
    public Criteria andReamountNotLike(Integer value) {
		  addCriterion("reamount not like", value, "reamount");
		return (Criteria) this;
		}
 public Criteria andRestAmountIsNull() {
		 addCriterion("rest_amount is null");
		return (Criteria) this;
		}
  public Criteria andRestAmountIsNotNull(){
		addCriterion("rest_amount is not null");
		return (Criteria) this;
		}
  public Criteria andRestAmountEqualTo(Integer value) {
		  addCriterion("rest_amount =", value, "restAmount");
		return (Criteria) this;
		}
   public Criteria andRestAmountNotEqualTo(Integer value) {
		  addCriterion("rest_amount <>", value, "restAmount");
		return (Criteria) this;
		}
    public Criteria andRestAmountGreaterThan(Integer value) {
		 addCriterion("rest_amount >", value, "restAmount");
		return (Criteria) this;
		}
  public Criteria andRestAmountGreaterThanOrEqualTo(Integer value) {
		  addCriterion("rest_amount >=", value, "RestAmount");
		return (Criteria) this;
		}
   public Criteria andRestAmountLessThan(Integer value) {
		  addCriterion("rest_amount <", value, "restAmount");
		return (Criteria) this;
		}
    public Criteria andRestAmountLessThanOrEqualTo(Integer value) {
		  addCriterion("rest_amount <=", value, "restAmount");
		return (Criteria) this;
		}
    public Criteria andRestAmountIn(List<Integer> values) {
		  addCriterion("rest_amount in", values, "restAmount");
		return (Criteria) this;
		}
    public Criteria andRestAmountNotIn(List<Integer> values) {
		  addCriterion("rest_amount not in", values, "restAmount");
		return (Criteria) this;
		}
     public Criteria andRestAmountBetween(Integer value1, Integer value2) {
		   addCriterion("rest_amount between", value1, value2, "restAmount");
		return (Criteria) this;
		}
     public Criteria andRestAmountNotBetween(Integer value1, Integer value2) {
		   addCriterion("rest_amount not between", value1, value2, "restAmount");
		return (Criteria) this;
		}
    public Criteria andRestAmountLike(Integer value) {
		  addCriterion("rest_amount like", value, "restAmount");
		return (Criteria) this;
		}
    public Criteria andRestAmountNotLike(Integer value) {
		  addCriterion("rest_amount not like", value, "restAmount");
		return (Criteria) this;
		}
 public Criteria andSchoolCheckStatusIsNull() {
		 addCriterion("school_check_status is null");
		return (Criteria) this;
		}
  public Criteria andSchoolCheckStatusIsNotNull(){
		addCriterion("school_check_status is not null");
		return (Criteria) this;
		}
  public Criteria andSchoolCheckStatusEqualTo(Integer value) {
		  addCriterion("school_check_status =", value, "schoolCheckStatus");
		return (Criteria) this;
		}
   public Criteria andSchoolCheckStatusNotEqualTo(Integer value) {
		  addCriterion("school_check_status <>", value, "schoolCheckStatus");
		return (Criteria) this;
		}
    public Criteria andSchoolCheckStatusGreaterThan(Integer value) {
		 addCriterion("school_check_status >", value, "schoolCheckStatus");
		return (Criteria) this;
		}
  public Criteria andSchoolCheckStatusGreaterThanOrEqualTo(Integer value) {
		  addCriterion("school_check_status >=", value, "SchoolCheckStatus");
		return (Criteria) this;
		}
   public Criteria andSchoolCheckStatusLessThan(Integer value) {
		  addCriterion("school_check_status <", value, "schoolCheckStatus");
		return (Criteria) this;
		}
    public Criteria andSchoolCheckStatusLessThanOrEqualTo(Integer value) {
		  addCriterion("school_check_status <=", value, "schoolCheckStatus");
		return (Criteria) this;
		}
    public Criteria andSchoolCheckStatusIn(List<Integer> values) {
		  addCriterion("school_check_status in", values, "schoolCheckStatus");
		return (Criteria) this;
		}
    public Criteria andSchoolCheckStatusNotIn(List<Integer> values) {
		  addCriterion("school_check_status not in", values, "schoolCheckStatus");
		return (Criteria) this;
		}
     public Criteria andSchoolCheckStatusBetween(Integer value1, Integer value2) {
		   addCriterion("school_check_status between", value1, value2, "schoolCheckStatus");
		return (Criteria) this;
		}
     public Criteria andSchoolCheckStatusNotBetween(Integer value1, Integer value2) {
		   addCriterion("school_check_status not between", value1, value2, "schoolCheckStatus");
		return (Criteria) this;
		}
    public Criteria andSchoolCheckStatusLike(Integer value) {
		  addCriterion("school_check_status like", value, "schoolCheckStatus");
		return (Criteria) this;
		}
    public Criteria andSchoolCheckStatusNotLike(Integer value) {
		  addCriterion("school_check_status not like", value, "schoolCheckStatus");
		return (Criteria) this;
		}
 public Criteria andSchoolCheckRemarkIsNull() {
		 addCriterion("school_check_remark is null");
		return (Criteria) this;
		}
  public Criteria andSchoolCheckRemarkIsNotNull(){
		addCriterion("school_check_remark is not null");
		return (Criteria) this;
		}
  public Criteria andSchoolCheckRemarkEqualTo(String value) {
		  addCriterion("school_check_remark =", value, "schoolCheckRemark");
		return (Criteria) this;
		}
   public Criteria andSchoolCheckRemarkNotEqualTo(String value) {
		  addCriterion("school_check_remark <>", value, "schoolCheckRemark");
		return (Criteria) this;
		}
    public Criteria andSchoolCheckRemarkGreaterThan(String value) {
		 addCriterion("school_check_remark >", value, "schoolCheckRemark");
		return (Criteria) this;
		}
  public Criteria andSchoolCheckRemarkGreaterThanOrEqualTo(String value) {
		  addCriterion("school_check_remark >=", value, "SchoolCheckRemark");
		return (Criteria) this;
		}
   public Criteria andSchoolCheckRemarkLessThan(String value) {
		  addCriterion("school_check_remark <", value, "schoolCheckRemark");
		return (Criteria) this;
		}
    public Criteria andSchoolCheckRemarkLessThanOrEqualTo(String value) {
		  addCriterion("school_check_remark <=", value, "schoolCheckRemark");
		return (Criteria) this;
		}
    public Criteria andSchoolCheckRemarkIn(List<String> values) {
		  addCriterion("school_check_remark in", values, "schoolCheckRemark");
		return (Criteria) this;
		}
    public Criteria andSchoolCheckRemarkNotIn(List<String> values) {
		  addCriterion("school_check_remark not in", values, "schoolCheckRemark");
		return (Criteria) this;
		}
     public Criteria andSchoolCheckRemarkBetween(String value1, String value2) {
		   addCriterion("school_check_remark between", value1, value2, "schoolCheckRemark");
		return (Criteria) this;
		}
     public Criteria andSchoolCheckRemarkNotBetween(String value1, String value2) {
		   addCriterion("school_check_remark not between", value1, value2, "schoolCheckRemark");
		return (Criteria) this;
		}
    public Criteria andSchoolCheckRemarkLike(String value) {
		  addCriterion("school_check_remark like", value, "schoolCheckRemark");
		return (Criteria) this;
		}
    public Criteria andSchoolCheckRemarkNotLike(String value) {
		  addCriterion("school_check_remark not like", value, "schoolCheckRemark");
		return (Criteria) this;
		}
 public Criteria andBankCheckStatusIsNull() {
		 addCriterion("bank_check_status is null");
		return (Criteria) this;
		}
  public Criteria andBankCheckStatusIsNotNull(){
		addCriterion("bank_check_status is not null");
		return (Criteria) this;
		}
  public Criteria andBankCheckStatusEqualTo(Integer value) {
		  addCriterion("bank_check_status =", value, "bankCheckStatus");
		return (Criteria) this;
		}
   public Criteria andBankCheckStatusNotEqualTo(Integer value) {
		  addCriterion("bank_check_status <>", value, "bankCheckStatus");
		return (Criteria) this;
		}
    public Criteria andBankCheckStatusGreaterThan(Integer value) {
		 addCriterion("bank_check_status >", value, "bankCheckStatus");
		return (Criteria) this;
		}
  public Criteria andBankCheckStatusGreaterThanOrEqualTo(Integer value) {
		  addCriterion("bank_check_status >=", value, "BankCheckStatus");
		return (Criteria) this;
		}
   public Criteria andBankCheckStatusLessThan(Integer value) {
		  addCriterion("bank_check_status <", value, "bankCheckStatus");
		return (Criteria) this;
		}
    public Criteria andBankCheckStatusLessThanOrEqualTo(Integer value) {
		  addCriterion("bank_check_status <=", value, "bankCheckStatus");
		return (Criteria) this;
		}
    public Criteria andBankCheckStatusIn(List<Integer> values) {
		  addCriterion("bank_check_status in", values, "bankCheckStatus");
		return (Criteria) this;
		}
    public Criteria andBankCheckStatusNotIn(List<Integer> values) {
		  addCriterion("bank_check_status not in", values, "bankCheckStatus");
		return (Criteria) this;
		}
     public Criteria andBankCheckStatusBetween(Integer value1, Integer value2) {
		   addCriterion("bank_check_status between", value1, value2, "bankCheckStatus");
		return (Criteria) this;
		}
     public Criteria andBankCheckStatusNotBetween(Integer value1, Integer value2) {
		   addCriterion("bank_check_status not between", value1, value2, "bankCheckStatus");
		return (Criteria) this;
		}
    public Criteria andBankCheckStatusLike(Integer value) {
		  addCriterion("bank_check_status like", value, "bankCheckStatus");
		return (Criteria) this;
		}
    public Criteria andBankCheckStatusNotLike(Integer value) {
		  addCriterion("bank_check_status not like", value, "bankCheckStatus");
		return (Criteria) this;
		}
 public Criteria andBankCheckRemarkIsNull() {
		 addCriterion("bank_check_remark is null");
		return (Criteria) this;
		}
  public Criteria andBankCheckRemarkIsNotNull(){
		addCriterion("bank_check_remark is not null");
		return (Criteria) this;
		}
  public Criteria andBankCheckRemarkEqualTo(String value) {
		  addCriterion("bank_check_remark =", value, "bankCheckRemark");
		return (Criteria) this;
		}
   public Criteria andBankCheckRemarkNotEqualTo(String value) {
		  addCriterion("bank_check_remark <>", value, "bankCheckRemark");
		return (Criteria) this;
		}
    public Criteria andBankCheckRemarkGreaterThan(String value) {
		 addCriterion("bank_check_remark >", value, "bankCheckRemark");
		return (Criteria) this;
		}
  public Criteria andBankCheckRemarkGreaterThanOrEqualTo(String value) {
		  addCriterion("bank_check_remark >=", value, "BankCheckRemark");
		return (Criteria) this;
		}
   public Criteria andBankCheckRemarkLessThan(String value) {
		  addCriterion("bank_check_remark <", value, "bankCheckRemark");
		return (Criteria) this;
		}
    public Criteria andBankCheckRemarkLessThanOrEqualTo(String value) {
		  addCriterion("bank_check_remark <=", value, "bankCheckRemark");
		return (Criteria) this;
		}
    public Criteria andBankCheckRemarkIn(List<String> values) {
		  addCriterion("bank_check_remark in", values, "bankCheckRemark");
		return (Criteria) this;
		}
    public Criteria andBankCheckRemarkNotIn(List<String> values) {
		  addCriterion("bank_check_remark not in", values, "bankCheckRemark");
		return (Criteria) this;
		}
     public Criteria andBankCheckRemarkBetween(String value1, String value2) {
		   addCriterion("bank_check_remark between", value1, value2, "bankCheckRemark");
		return (Criteria) this;
		}
     public Criteria andBankCheckRemarkNotBetween(String value1, String value2) {
		   addCriterion("bank_check_remark not between", value1, value2, "bankCheckRemark");
		return (Criteria) this;
		}
    public Criteria andBankCheckRemarkLike(String value) {
		  addCriterion("bank_check_remark like", value, "bankCheckRemark");
		return (Criteria) this;
		}
    public Criteria andBankCheckRemarkNotLike(String value) {
		  addCriterion("bank_check_remark not like", value, "bankCheckRemark");
		return (Criteria) this;
		}
 public Criteria andScoolIdIsNull() {
		 addCriterion("scool_id is null");
		return (Criteria) this;
		}
  public Criteria andScoolIdIsNotNull(){
		addCriterion("scool_id is not null");
		return (Criteria) this;
		}
  public Criteria andScoolIdEqualTo(Integer value) {
		  addCriterion("scool_id =", value, "scoolId");
		return (Criteria) this;
		}
   public Criteria andScoolIdNotEqualTo(Integer value) {
		  addCriterion("scool_id <>", value, "scoolId");
		return (Criteria) this;
		}
    public Criteria andScoolIdGreaterThan(Integer value) {
		 addCriterion("scool_id >", value, "scoolId");
		return (Criteria) this;
		}
  public Criteria andScoolIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("scool_id >=", value, "ScoolId");
		return (Criteria) this;
		}
   public Criteria andScoolIdLessThan(Integer value) {
		  addCriterion("scool_id <", value, "scoolId");
		return (Criteria) this;
		}
    public Criteria andScoolIdLessThanOrEqualTo(Integer value) {
		  addCriterion("scool_id <=", value, "scoolId");
		return (Criteria) this;
		}
    public Criteria andScoolIdIn(List<Integer> values) {
		  addCriterion("scool_id in", values, "scoolId");
		return (Criteria) this;
		}
    public Criteria andScoolIdNotIn(List<Integer> values) {
		  addCriterion("scool_id not in", values, "scoolId");
		return (Criteria) this;
		}
     public Criteria andScoolIdBetween(Integer value1, Integer value2) {
		   addCriterion("scool_id between", value1, value2, "scoolId");
		return (Criteria) this;
		}
     public Criteria andScoolIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("scool_id not between", value1, value2, "scoolId");
		return (Criteria) this;
		}
    public Criteria andScoolIdLike(Integer value) {
		  addCriterion("scool_id like", value, "scoolId");
		return (Criteria) this;
		}
    public Criteria andScoolIdNotLike(Integer value) {
		  addCriterion("scool_id not like", value, "scoolId");
		return (Criteria) this;
		}
 public Criteria andCreateTimeIsNull() {
		 addCriterion("create_time is null");
		return (Criteria) this;
		}
  public Criteria andCreateTimeIsNotNull(){
		addCriterion("create_time is not null");
		return (Criteria) this;
		}
  public Criteria andCreateTimeEqualTo(String value) {
		  addCriterion("create_time =", value, "createTime");
		return (Criteria) this;
		}
   public Criteria andCreateTimeNotEqualTo(String value) {
		  addCriterion("create_time <>", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeGreaterThan(String value) {
		 addCriterion("create_time >", value, "createTime");
		return (Criteria) this;
		}
  public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("create_time >=", value, "CreateTime");
		return (Criteria) this;
		}
   public Criteria andCreateTimeLessThan(String value) {
		  addCriterion("create_time <", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeLessThanOrEqualTo(String value) {
		  addCriterion("create_time <=", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeIn(List<String> values) {
		  addCriterion("create_time in", values, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeNotIn(List<String> values) {
		  addCriterion("create_time not in", values, "createTime");
		return (Criteria) this;
		}
     public Criteria andCreateTimeBetween(String value1, String value2) {
		   addCriterion("create_time between", value1, value2, "createTime");
		return (Criteria) this;
		}
     public Criteria andCreateTimeNotBetween(String value1, String value2) {
		   addCriterion("create_time not between", value1, value2, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeLike(String value) {
		  addCriterion("create_time like", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeNotLike(String value) {
		  addCriterion("create_time not like", value, "createTime");
		return (Criteria) this;
		}
 public Criteria andUpdateTimeIsNull() {
		 addCriterion("update_time is null");
		return (Criteria) this;
		}
  public Criteria andUpdateTimeIsNotNull(){
		addCriterion("update_time is not null");
		return (Criteria) this;
		}
  public Criteria andUpdateTimeEqualTo(String value) {
		  addCriterion("update_time =", value, "updateTime");
		return (Criteria) this;
		}
   public Criteria andUpdateTimeNotEqualTo(String value) {
		  addCriterion("update_time <>", value, "updateTime");
		return (Criteria) this;
		}
    public Criteria andUpdateTimeGreaterThan(String value) {
		 addCriterion("update_time >", value, "updateTime");
		return (Criteria) this;
		}
  public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("update_time >=", value, "UpdateTime");
		return (Criteria) this;
		}
   public Criteria andUpdateTimeLessThan(String value) {
		  addCriterion("update_time <", value, "updateTime");
		return (Criteria) this;
		}
    public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
		  addCriterion("update_time <=", value, "updateTime");
		return (Criteria) this;
		}
    public Criteria andUpdateTimeIn(List<String> values) {
		  addCriterion("update_time in", values, "updateTime");
		return (Criteria) this;
		}
    public Criteria andUpdateTimeNotIn(List<String> values) {
		  addCriterion("update_time not in", values, "updateTime");
		return (Criteria) this;
		}
     public Criteria andUpdateTimeBetween(String value1, String value2) {
		   addCriterion("update_time between", value1, value2, "updateTime");
		return (Criteria) this;
		}
     public Criteria andUpdateTimeNotBetween(String value1, String value2) {
		   addCriterion("update_time not between", value1, value2, "updateTime");
		return (Criteria) this;
		}
    public Criteria andUpdateTimeLike(String value) {
		  addCriterion("update_time like", value, "updateTime");
		return (Criteria) this;
		}
    public Criteria andUpdateTimeNotLike(String value) {
		  addCriterion("update_time not like", value, "updateTime");
		return (Criteria) this;
		}
 public Criteria andIsDeleteIsNull() {
		 addCriterion("is_delete is null");
		return (Criteria) this;
		}
  public Criteria andIsDeleteIsNotNull(){
		addCriterion("is_delete is not null");
		return (Criteria) this;
		}
  public Criteria andIsDeleteEqualTo(Integer value) {
		  addCriterion("is_delete =", value, "isDelete");
		return (Criteria) this;
		}
   public Criteria andIsDeleteNotEqualTo(Integer value) {
		  addCriterion("is_delete <>", value, "isDelete");
		return (Criteria) this;
		}
    public Criteria andIsDeleteGreaterThan(Integer value) {
		 addCriterion("is_delete >", value, "isDelete");
		return (Criteria) this;
		}
  public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
		  addCriterion("is_delete >=", value, "IsDelete");
		return (Criteria) this;
		}
   public Criteria andIsDeleteLessThan(Integer value) {
		  addCriterion("is_delete <", value, "isDelete");
		return (Criteria) this;
		}
    public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
		  addCriterion("is_delete <=", value, "isDelete");
		return (Criteria) this;
		}
    public Criteria andIsDeleteIn(List<Integer> values) {
		  addCriterion("is_delete in", values, "isDelete");
		return (Criteria) this;
		}
    public Criteria andIsDeleteNotIn(List<Integer> values) {
		  addCriterion("is_delete not in", values, "isDelete");
		return (Criteria) this;
		}
     public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
		   addCriterion("is_delete between", value1, value2, "isDelete");
		return (Criteria) this;
		}
     public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
		   addCriterion("is_delete not between", value1, value2, "isDelete");
		return (Criteria) this;
		}
    public Criteria andIsDeleteLike(Integer value) {
		  addCriterion("is_delete like", value, "isDelete");
		return (Criteria) this;
		}
    public Criteria andIsDeleteNotLike(Integer value) {
		  addCriterion("is_delete not like", value, "isDelete");
		return (Criteria) this;
		}

        public Criteria andTableIdIsNull() {
            addCriterion("table_id is null");
            return (Criteria) this;
        }
        public Criteria andTableIdIsNotNull() {
            addCriterion("table_id is not null");
            return (Criteria) this;
        }
        public Criteria andTableIdEqualTo(Integer value) {
            addCriterion("table_id =", value, "tableId");
            return (Criteria) this;
        }
        public Criteria andTableIdNotEqualTo(Integer value) {
            addCriterion("table_id <>", value, "tableId");
            return (Criteria) this;
        }
        public Criteria andTableIdGreaterThan(Integer value) {
            addCriterion("table_id >", value, "tableId");
            return (Criteria) this;
        }
        public Criteria andTableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("table_id >=", value, "tableId");
            return (Criteria) this;
        }
        public Criteria andTableIdLessThan(Integer value) {
            addCriterion("table_id <", value, "tableId");
            return (Criteria) this;
        }
        public Criteria andTableIdLessThanOrEqualTo(Integer value) {
            addCriterion("table_id <=", value, "tableId");
            return (Criteria) this;
        }
        public Criteria andTableIdIn(List<Integer> values) {
            addCriterion("table_id in", values, "tableId");
            return (Criteria) this;
        }
        public Criteria andTableIdNotIn(List<Integer> values) {
            addCriterion("table_id not in", values, "tableId");
            return (Criteria) this;
        }
        public Criteria andTableIdBetween(Integer value1, Integer value2) {
            addCriterion("table_id between", value1, value2, "tableId");
            return (Criteria) this;
        }
        public Criteria andTableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("table_id not between", value1, value2, "tableId");
            return (Criteria) this;
        }
    }
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
    public static class Criterion {
        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String typeHandler;
        public String getCondition() {
            return condition;
        }
        public Object getValue() {
            return value;
        }
        public Object getSecondValue() {
            return secondValue;
        }
        public boolean isNoValue() {
            return noValue;
        }
        public boolean isSingleValue() {
            return singleValue;
        }
        public boolean isBetweenValue() {
            return betweenValue;
        }
        public boolean isListValue() {
            return listValue;
        }
        public String getTypeHandler() {
            return typeHandler;
        }
        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }
        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }
        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }
        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
