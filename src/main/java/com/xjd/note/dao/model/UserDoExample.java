package com.xjd.note.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserDoExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
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
            addCriterion("email >=", value, "email");
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

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
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

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Boolean value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Boolean value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Boolean value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Boolean value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Boolean> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Boolean> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andLockedIsNull() {
            addCriterion("locked is null");
            return (Criteria) this;
        }

        public Criteria andLockedIsNotNull() {
            addCriterion("locked is not null");
            return (Criteria) this;
        }

        public Criteria andLockedEqualTo(Boolean value) {
            addCriterion("locked =", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotEqualTo(Boolean value) {
            addCriterion("locked <>", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedGreaterThan(Boolean value) {
            addCriterion("locked >", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("locked >=", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedLessThan(Boolean value) {
            addCriterion("locked <", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedLessThanOrEqualTo(Boolean value) {
            addCriterion("locked <=", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedIn(List<Boolean> values) {
            addCriterion("locked in", values, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotIn(List<Boolean> values) {
            addCriterion("locked not in", values, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedBetween(Boolean value1, Boolean value2) {
            addCriterion("locked between", value1, value2, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("locked not between", value1, value2, "locked");
            return (Criteria) this;
        }

        public Criteria andPwdErrorTimesIsNull() {
            addCriterion("pwd_error_times is null");
            return (Criteria) this;
        }

        public Criteria andPwdErrorTimesIsNotNull() {
            addCriterion("pwd_error_times is not null");
            return (Criteria) this;
        }

        public Criteria andPwdErrorTimesEqualTo(Short value) {
            addCriterion("pwd_error_times =", value, "pwdErrorTimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrorTimesNotEqualTo(Short value) {
            addCriterion("pwd_error_times <>", value, "pwdErrorTimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrorTimesGreaterThan(Short value) {
            addCriterion("pwd_error_times >", value, "pwdErrorTimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrorTimesGreaterThanOrEqualTo(Short value) {
            addCriterion("pwd_error_times >=", value, "pwdErrorTimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrorTimesLessThan(Short value) {
            addCriterion("pwd_error_times <", value, "pwdErrorTimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrorTimesLessThanOrEqualTo(Short value) {
            addCriterion("pwd_error_times <=", value, "pwdErrorTimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrorTimesIn(List<Short> values) {
            addCriterion("pwd_error_times in", values, "pwdErrorTimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrorTimesNotIn(List<Short> values) {
            addCriterion("pwd_error_times not in", values, "pwdErrorTimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrorTimesBetween(Short value1, Short value2) {
            addCriterion("pwd_error_times between", value1, value2, "pwdErrorTimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrorTimesNotBetween(Short value1, Short value2) {
            addCriterion("pwd_error_times not between", value1, value2, "pwdErrorTimes");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimestampIsNull() {
            addCriterion("last_login_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimestampIsNotNull() {
            addCriterion("last_login_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimestampEqualTo(Date value) {
            addCriterion("last_login_timestamp =", value, "lastLoginTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimestampNotEqualTo(Date value) {
            addCriterion("last_login_timestamp <>", value, "lastLoginTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimestampGreaterThan(Date value) {
            addCriterion("last_login_timestamp >", value, "lastLoginTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_timestamp >=", value, "lastLoginTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimestampLessThan(Date value) {
            addCriterion("last_login_timestamp <", value, "lastLoginTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimestampLessThanOrEqualTo(Date value) {
            addCriterion("last_login_timestamp <=", value, "lastLoginTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimestampIn(List<Date> values) {
            addCriterion("last_login_timestamp in", values, "lastLoginTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimestampNotIn(List<Date> values) {
            addCriterion("last_login_timestamp not in", values, "lastLoginTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimestampBetween(Date value1, Date value2) {
            addCriterion("last_login_timestamp between", value1, value2, "lastLoginTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimestampNotBetween(Date value1, Date value2) {
            addCriterion("last_login_timestamp not between", value1, value2, "lastLoginTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNull() {
            addCriterion("last_login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNotNull() {
            addCriterion("last_login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpEqualTo(String value) {
            addCriterion("last_login_ip =", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotEqualTo(String value) {
            addCriterion("last_login_ip <>", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThan(String value) {
            addCriterion("last_login_ip >", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_ip >=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThan(String value) {
            addCriterion("last_login_ip <", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("last_login_ip <=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLike(String value) {
            addCriterion("last_login_ip like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotLike(String value) {
            addCriterion("last_login_ip not like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIn(List<String> values) {
            addCriterion("last_login_ip in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotIn(List<String> values) {
            addCriterion("last_login_ip not in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpBetween(String value1, String value2) {
            addCriterion("last_login_ip between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("last_login_ip not between", value1, value2, "lastLoginIp");
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

        public Criteria andResetPwdTokenIsNull() {
            addCriterion("reset_pwd_token is null");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenIsNotNull() {
            addCriterion("reset_pwd_token is not null");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenEqualTo(String value) {
            addCriterion("reset_pwd_token =", value, "resetPwdToken");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenNotEqualTo(String value) {
            addCriterion("reset_pwd_token <>", value, "resetPwdToken");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenGreaterThan(String value) {
            addCriterion("reset_pwd_token >", value, "resetPwdToken");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenGreaterThanOrEqualTo(String value) {
            addCriterion("reset_pwd_token >=", value, "resetPwdToken");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenLessThan(String value) {
            addCriterion("reset_pwd_token <", value, "resetPwdToken");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenLessThanOrEqualTo(String value) {
            addCriterion("reset_pwd_token <=", value, "resetPwdToken");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenLike(String value) {
            addCriterion("reset_pwd_token like", value, "resetPwdToken");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenNotLike(String value) {
            addCriterion("reset_pwd_token not like", value, "resetPwdToken");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenIn(List<String> values) {
            addCriterion("reset_pwd_token in", values, "resetPwdToken");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenNotIn(List<String> values) {
            addCriterion("reset_pwd_token not in", values, "resetPwdToken");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenBetween(String value1, String value2) {
            addCriterion("reset_pwd_token between", value1, value2, "resetPwdToken");
            return (Criteria) this;
        }

        public Criteria andResetPwdTokenNotBetween(String value1, String value2) {
            addCriterion("reset_pwd_token not between", value1, value2, "resetPwdToken");
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