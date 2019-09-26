package com.load.model;
import java.util.ArrayList;
import java.util.List;
public class RemoneyInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    public RemoneyInfoExample() {
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
 public Criteria andAmountIsNull() {
		 addCriterion("amount is null");
		return (Criteria) this;
		}
  public Criteria andAmountIsNotNull(){
		addCriterion("amount is not null");
		return (Criteria) this;
		}
  public Criteria andAmountEqualTo(Integer value) {
		  addCriterion("amount =", value, "amount");
		return (Criteria) this;
		}
   public Criteria andAmountNotEqualTo(Integer value) {
		  addCriterion("amount <>", value, "amount");
		return (Criteria) this;
		}
    public Criteria andAmountGreaterThan(Integer value) {
		 addCriterion("amount >", value, "amount");
		return (Criteria) this;
		}
  public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
		  addCriterion("amount >=", value, "Amount");
		return (Criteria) this;
		}
   public Criteria andAmountLessThan(Integer value) {
		  addCriterion("amount <", value, "amount");
		return (Criteria) this;
		}
    public Criteria andAmountLessThanOrEqualTo(Integer value) {
		  addCriterion("amount <=", value, "amount");
		return (Criteria) this;
		}
    public Criteria andAmountIn(List<Integer> values) {
		  addCriterion("amount in", values, "amount");
		return (Criteria) this;
		}
    public Criteria andAmountNotIn(List<Integer> values) {
		  addCriterion("amount not in", values, "amount");
		return (Criteria) this;
		}
     public Criteria andAmountBetween(Integer value1, Integer value2) {
		   addCriterion("amount between", value1, value2, "amount");
		return (Criteria) this;
		}
     public Criteria andAmountNotBetween(Integer value1, Integer value2) {
		   addCriterion("amount not between", value1, value2, "amount");
		return (Criteria) this;
		}
    public Criteria andAmountLike(Integer value) {
		  addCriterion("amount like", value, "amount");
		return (Criteria) this;
		}
    public Criteria andAmountNotLike(Integer value) {
		  addCriterion("amount not like", value, "amount");
		return (Criteria) this;
		}
 public Criteria andApplyIdIsNull() {
		 addCriterion("apply_id is null");
		return (Criteria) this;
		}
  public Criteria andApplyIdIsNotNull(){
		addCriterion("apply_id is not null");
		return (Criteria) this;
		}
  public Criteria andApplyIdEqualTo(Integer value) {
		  addCriterion("apply_id =", value, "applyId");
		return (Criteria) this;
		}
   public Criteria andApplyIdNotEqualTo(Integer value) {
		  addCriterion("apply_id <>", value, "applyId");
		return (Criteria) this;
		}
    public Criteria andApplyIdGreaterThan(Integer value) {
		 addCriterion("apply_id >", value, "applyId");
		return (Criteria) this;
		}
  public Criteria andApplyIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("apply_id >=", value, "ApplyId");
		return (Criteria) this;
		}
   public Criteria andApplyIdLessThan(Integer value) {
		  addCriterion("apply_id <", value, "applyId");
		return (Criteria) this;
		}
    public Criteria andApplyIdLessThanOrEqualTo(Integer value) {
		  addCriterion("apply_id <=", value, "applyId");
		return (Criteria) this;
		}
    public Criteria andApplyIdIn(List<Integer> values) {
		  addCriterion("apply_id in", values, "applyId");
		return (Criteria) this;
		}
    public Criteria andApplyIdNotIn(List<Integer> values) {
		  addCriterion("apply_id not in", values, "applyId");
		return (Criteria) this;
		}
     public Criteria andApplyIdBetween(Integer value1, Integer value2) {
		   addCriterion("apply_id between", value1, value2, "applyId");
		return (Criteria) this;
		}
     public Criteria andApplyIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("apply_id not between", value1, value2, "applyId");
		return (Criteria) this;
		}
    public Criteria andApplyIdLike(Integer value) {
		  addCriterion("apply_id like", value, "applyId");
		return (Criteria) this;
		}
    public Criteria andApplyIdNotLike(Integer value) {
		  addCriterion("apply_id not like", value, "applyId");
		return (Criteria) this;
		}
 public Criteria andUserIdIsNull() {
		 addCriterion("user_id is null");
		return (Criteria) this;
		}
  public Criteria andUserIdIsNotNull(){
		addCriterion("user_id is not null");
		return (Criteria) this;
		}
  public Criteria andUserIdEqualTo(Integer value) {
		  addCriterion("user_id =", value, "userId");
		return (Criteria) this;
		}
   public Criteria andUserIdNotEqualTo(Integer value) {
		  addCriterion("user_id <>", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdGreaterThan(Integer value) {
		 addCriterion("user_id >", value, "userId");
		return (Criteria) this;
		}
  public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("user_id >=", value, "UserId");
		return (Criteria) this;
		}
   public Criteria andUserIdLessThan(Integer value) {
		  addCriterion("user_id <", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdLessThanOrEqualTo(Integer value) {
		  addCriterion("user_id <=", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdIn(List<Integer> values) {
		  addCriterion("user_id in", values, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdNotIn(List<Integer> values) {
		  addCriterion("user_id not in", values, "userId");
		return (Criteria) this;
		}
     public Criteria andUserIdBetween(Integer value1, Integer value2) {
		   addCriterion("user_id between", value1, value2, "userId");
		return (Criteria) this;
		}
     public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("user_id not between", value1, value2, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdLike(Integer value) {
		  addCriterion("user_id like", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdNotLike(Integer value) {
		  addCriterion("user_id not like", value, "userId");
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
