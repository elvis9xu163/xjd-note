package com.xjd.note.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoteDoExample() {
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

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNoteNameIsNull() {
            addCriterion("note_name is null");
            return (Criteria) this;
        }

        public Criteria andNoteNameIsNotNull() {
            addCriterion("note_name is not null");
            return (Criteria) this;
        }

        public Criteria andNoteNameEqualTo(String value) {
            addCriterion("note_name =", value, "noteName");
            return (Criteria) this;
        }

        public Criteria andNoteNameNotEqualTo(String value) {
            addCriterion("note_name <>", value, "noteName");
            return (Criteria) this;
        }

        public Criteria andNoteNameGreaterThan(String value) {
            addCriterion("note_name >", value, "noteName");
            return (Criteria) this;
        }

        public Criteria andNoteNameGreaterThanOrEqualTo(String value) {
            addCriterion("note_name >=", value, "noteName");
            return (Criteria) this;
        }

        public Criteria andNoteNameLessThan(String value) {
            addCriterion("note_name <", value, "noteName");
            return (Criteria) this;
        }

        public Criteria andNoteNameLessThanOrEqualTo(String value) {
            addCriterion("note_name <=", value, "noteName");
            return (Criteria) this;
        }

        public Criteria andNoteNameLike(String value) {
            addCriterion("note_name like", value, "noteName");
            return (Criteria) this;
        }

        public Criteria andNoteNameNotLike(String value) {
            addCriterion("note_name not like", value, "noteName");
            return (Criteria) this;
        }

        public Criteria andNoteNameIn(List<String> values) {
            addCriterion("note_name in", values, "noteName");
            return (Criteria) this;
        }

        public Criteria andNoteNameNotIn(List<String> values) {
            addCriterion("note_name not in", values, "noteName");
            return (Criteria) this;
        }

        public Criteria andNoteNameBetween(String value1, String value2) {
            addCriterion("note_name between", value1, value2, "noteName");
            return (Criteria) this;
        }

        public Criteria andNoteNameNotBetween(String value1, String value2) {
            addCriterion("note_name not between", value1, value2, "noteName");
            return (Criteria) this;
        }

        public Criteria andIsDirIsNull() {
            addCriterion("is_dir is null");
            return (Criteria) this;
        }

        public Criteria andIsDirIsNotNull() {
            addCriterion("is_dir is not null");
            return (Criteria) this;
        }

        public Criteria andIsDirEqualTo(Boolean value) {
            addCriterion("is_dir =", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirNotEqualTo(Boolean value) {
            addCriterion("is_dir <>", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirGreaterThan(Boolean value) {
            addCriterion("is_dir >", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_dir >=", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirLessThan(Boolean value) {
            addCriterion("is_dir <", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirLessThanOrEqualTo(Boolean value) {
            addCriterion("is_dir <=", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirIn(List<Boolean> values) {
            addCriterion("is_dir in", values, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirNotIn(List<Boolean> values) {
            addCriterion("is_dir not in", values, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirBetween(Boolean value1, Boolean value2) {
            addCriterion("is_dir between", value1, value2, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_dir not between", value1, value2, "isDir");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andFileKeyIsNull() {
            addCriterion("file_key is null");
            return (Criteria) this;
        }

        public Criteria andFileKeyIsNotNull() {
            addCriterion("file_key is not null");
            return (Criteria) this;
        }

        public Criteria andFileKeyEqualTo(String value) {
            addCriterion("file_key =", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyNotEqualTo(String value) {
            addCriterion("file_key <>", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyGreaterThan(String value) {
            addCriterion("file_key >", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyGreaterThanOrEqualTo(String value) {
            addCriterion("file_key >=", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyLessThan(String value) {
            addCriterion("file_key <", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyLessThanOrEqualTo(String value) {
            addCriterion("file_key <=", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyLike(String value) {
            addCriterion("file_key like", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyNotLike(String value) {
            addCriterion("file_key not like", value, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyIn(List<String> values) {
            addCriterion("file_key in", values, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyNotIn(List<String> values) {
            addCriterion("file_key not in", values, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyBetween(String value1, String value2) {
            addCriterion("file_key between", value1, value2, "fileKey");
            return (Criteria) this;
        }

        public Criteria andFileKeyNotBetween(String value1, String value2) {
            addCriterion("file_key not between", value1, value2, "fileKey");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampIsNull() {
            addCriterion("create_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampIsNotNull() {
            addCriterion("create_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(Date value) {
            addCriterion("create_timestamp =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampNotEqualTo(Date value) {
            addCriterion("create_timestamp <>", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampGreaterThan(Date value) {
            addCriterion("create_timestamp >", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("create_timestamp >=", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampLessThan(Date value) {
            addCriterion("create_timestamp <", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampLessThanOrEqualTo(Date value) {
            addCriterion("create_timestamp <=", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampIn(List<Date> values) {
            addCriterion("create_timestamp in", values, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampNotIn(List<Date> values) {
            addCriterion("create_timestamp not in", values, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampBetween(Date value1, Date value2) {
            addCriterion("create_timestamp between", value1, value2, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampNotBetween(Date value1, Date value2) {
            addCriterion("create_timestamp not between", value1, value2, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimestampIsNull() {
            addCriterion("last_modify_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimestampIsNotNull() {
            addCriterion("last_modify_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimestampEqualTo(Date value) {
            addCriterion("last_modify_timestamp =", value, "lastModifyTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimestampNotEqualTo(Date value) {
            addCriterion("last_modify_timestamp <>", value, "lastModifyTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimestampGreaterThan(Date value) {
            addCriterion("last_modify_timestamp >", value, "lastModifyTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("last_modify_timestamp >=", value, "lastModifyTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimestampLessThan(Date value) {
            addCriterion("last_modify_timestamp <", value, "lastModifyTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimestampLessThanOrEqualTo(Date value) {
            addCriterion("last_modify_timestamp <=", value, "lastModifyTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimestampIn(List<Date> values) {
            addCriterion("last_modify_timestamp in", values, "lastModifyTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimestampNotIn(List<Date> values) {
            addCriterion("last_modify_timestamp not in", values, "lastModifyTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimestampBetween(Date value1, Date value2) {
            addCriterion("last_modify_timestamp between", value1, value2, "lastModifyTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimestampNotBetween(Date value1, Date value2) {
            addCriterion("last_modify_timestamp not between", value1, value2, "lastModifyTimestamp");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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