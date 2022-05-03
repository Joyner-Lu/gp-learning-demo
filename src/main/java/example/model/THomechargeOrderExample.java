package example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class THomechargeOrderExample {
    /**
     */
    protected String orderByClause;

    /**
     */
    protected boolean distinct;

    /**
     */
    protected List<Criteria> oredCriteria;

    public THomechargeOrderExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("area_code like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("area_code not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("area_name in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("area_name not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeIsNull() {
            addCriterion("order_service_provider_code is null");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeIsNotNull() {
            addCriterion("order_service_provider_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeEqualTo(String value) {
            addCriterion("order_service_provider_code =", value, "orderServiceProviderCode");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeNotEqualTo(String value) {
            addCriterion("order_service_provider_code <>", value, "orderServiceProviderCode");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeGreaterThan(String value) {
            addCriterion("order_service_provider_code >", value, "orderServiceProviderCode");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("order_service_provider_code >=", value, "orderServiceProviderCode");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeLessThan(String value) {
            addCriterion("order_service_provider_code <", value, "orderServiceProviderCode");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeLessThanOrEqualTo(String value) {
            addCriterion("order_service_provider_code <=", value, "orderServiceProviderCode");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeLike(String value) {
            addCriterion("order_service_provider_code like", value, "orderServiceProviderCode");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeNotLike(String value) {
            addCriterion("order_service_provider_code not like", value, "orderServiceProviderCode");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeIn(List<String> values) {
            addCriterion("order_service_provider_code in", values, "orderServiceProviderCode");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeNotIn(List<String> values) {
            addCriterion("order_service_provider_code not in", values, "orderServiceProviderCode");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeBetween(String value1, String value2) {
            addCriterion("order_service_provider_code between", value1, value2, "orderServiceProviderCode");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderCodeNotBetween(String value1, String value2) {
            addCriterion("order_service_provider_code not between", value1, value2, "orderServiceProviderCode");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameIsNull() {
            addCriterion("order_service_provider_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameIsNotNull() {
            addCriterion("order_service_provider_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameEqualTo(String value) {
            addCriterion("order_service_provider_name =", value, "orderServiceProviderName");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameNotEqualTo(String value) {
            addCriterion("order_service_provider_name <>", value, "orderServiceProviderName");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameGreaterThan(String value) {
            addCriterion("order_service_provider_name >", value, "orderServiceProviderName");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_service_provider_name >=", value, "orderServiceProviderName");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameLessThan(String value) {
            addCriterion("order_service_provider_name <", value, "orderServiceProviderName");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameLessThanOrEqualTo(String value) {
            addCriterion("order_service_provider_name <=", value, "orderServiceProviderName");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameLike(String value) {
            addCriterion("order_service_provider_name like", value, "orderServiceProviderName");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameNotLike(String value) {
            addCriterion("order_service_provider_name not like", value, "orderServiceProviderName");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameIn(List<String> values) {
            addCriterion("order_service_provider_name in", values, "orderServiceProviderName");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameNotIn(List<String> values) {
            addCriterion("order_service_provider_name not in", values, "orderServiceProviderName");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameBetween(String value1, String value2) {
            addCriterion("order_service_provider_name between", value1, value2, "orderServiceProviderName");
            return (Criteria) this;
        }

        public Criteria andOrderServiceProviderNameNotBetween(String value1, String value2) {
            addCriterion("order_service_provider_name not between", value1, value2, "orderServiceProviderName");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNull() {
            addCriterion("process_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("process_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(String value) {
            addCriterion("process_id =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(String value) {
            addCriterion("process_id <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(String value) {
            addCriterion("process_id >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_id >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(String value) {
            addCriterion("process_id <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(String value) {
            addCriterion("process_id <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLike(String value) {
            addCriterion("process_id like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotLike(String value) {
            addCriterion("process_id not like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<String> values) {
            addCriterion("process_id in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<String> values) {
            addCriterion("process_id not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(String value1, String value2) {
            addCriterion("process_id between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(String value1, String value2) {
            addCriterion("process_id not between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andStoreIsNull() {
            addCriterion("store is null");
            return (Criteria) this;
        }

        public Criteria andStoreIsNotNull() {
            addCriterion("store is not null");
            return (Criteria) this;
        }

        public Criteria andStoreEqualTo(String value) {
            addCriterion("store =", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreNotEqualTo(String value) {
            addCriterion("store <>", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreGreaterThan(String value) {
            addCriterion("store >", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreGreaterThanOrEqualTo(String value) {
            addCriterion("store >=", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreLessThan(String value) {
            addCriterion("store <", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreLessThanOrEqualTo(String value) {
            addCriterion("store <=", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreLike(String value) {
            addCriterion("store like", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreNotLike(String value) {
            addCriterion("store not like", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreIn(List<String> values) {
            addCriterion("store in", values, "store");
            return (Criteria) this;
        }

        public Criteria andStoreNotIn(List<String> values) {
            addCriterion("store not in", values, "store");
            return (Criteria) this;
        }

        public Criteria andStoreBetween(String value1, String value2) {
            addCriterion("store between", value1, value2, "store");
            return (Criteria) this;
        }

        public Criteria andStoreNotBetween(String value1, String value2) {
            addCriterion("store not between", value1, value2, "store");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoIsNull() {
            addCriterion("external_order_no is null");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoIsNotNull() {
            addCriterion("external_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoEqualTo(String value) {
            addCriterion("external_order_no =", value, "externalOrderNo");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoNotEqualTo(String value) {
            addCriterion("external_order_no <>", value, "externalOrderNo");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoGreaterThan(String value) {
            addCriterion("external_order_no >", value, "externalOrderNo");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("external_order_no >=", value, "externalOrderNo");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoLessThan(String value) {
            addCriterion("external_order_no <", value, "externalOrderNo");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoLessThanOrEqualTo(String value) {
            addCriterion("external_order_no <=", value, "externalOrderNo");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoLike(String value) {
            addCriterion("external_order_no like", value, "externalOrderNo");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoNotLike(String value) {
            addCriterion("external_order_no not like", value, "externalOrderNo");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoIn(List<String> values) {
            addCriterion("external_order_no in", values, "externalOrderNo");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoNotIn(List<String> values) {
            addCriterion("external_order_no not in", values, "externalOrderNo");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoBetween(String value1, String value2) {
            addCriterion("external_order_no between", value1, value2, "externalOrderNo");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNoNotBetween(String value1, String value2) {
            addCriterion("external_order_no not between", value1, value2, "externalOrderNo");
            return (Criteria) this;
        }

        public Criteria andActivationTimeIsNull() {
            addCriterion("activation_time is null");
            return (Criteria) this;
        }

        public Criteria andActivationTimeIsNotNull() {
            addCriterion("activation_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivationTimeEqualTo(Date value) {
            addCriterion("activation_time =", value, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeNotEqualTo(Date value) {
            addCriterion("activation_time <>", value, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeGreaterThan(Date value) {
            addCriterion("activation_time >", value, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activation_time >=", value, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeLessThan(Date value) {
            addCriterion("activation_time <", value, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeLessThanOrEqualTo(Date value) {
            addCriterion("activation_time <=", value, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeIn(List<Date> values) {
            addCriterion("activation_time in", values, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeNotIn(List<Date> values) {
            addCriterion("activation_time not in", values, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeBetween(Date value1, Date value2) {
            addCriterion("activation_time between", value1, value2, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeNotBetween(Date value1, Date value2) {
            addCriterion("activation_time not between", value1, value2, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdIsNull() {
            addCriterion("activation_user_id is null");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdIsNotNull() {
            addCriterion("activation_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdEqualTo(String value) {
            addCriterion("activation_user_id =", value, "activationUserId");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdNotEqualTo(String value) {
            addCriterion("activation_user_id <>", value, "activationUserId");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdGreaterThan(String value) {
            addCriterion("activation_user_id >", value, "activationUserId");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("activation_user_id >=", value, "activationUserId");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdLessThan(String value) {
            addCriterion("activation_user_id <", value, "activationUserId");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdLessThanOrEqualTo(String value) {
            addCriterion("activation_user_id <=", value, "activationUserId");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdLike(String value) {
            addCriterion("activation_user_id like", value, "activationUserId");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdNotLike(String value) {
            addCriterion("activation_user_id not like", value, "activationUserId");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdIn(List<String> values) {
            addCriterion("activation_user_id in", values, "activationUserId");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdNotIn(List<String> values) {
            addCriterion("activation_user_id not in", values, "activationUserId");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdBetween(String value1, String value2) {
            addCriterion("activation_user_id between", value1, value2, "activationUserId");
            return (Criteria) this;
        }

        public Criteria andActivationUserIdNotBetween(String value1, String value2) {
            addCriterion("activation_user_id not between", value1, value2, "activationUserId");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameIsNull() {
            addCriterion("activation_user_name is null");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameIsNotNull() {
            addCriterion("activation_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameEqualTo(String value) {
            addCriterion("activation_user_name =", value, "activationUserName");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameNotEqualTo(String value) {
            addCriterion("activation_user_name <>", value, "activationUserName");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameGreaterThan(String value) {
            addCriterion("activation_user_name >", value, "activationUserName");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("activation_user_name >=", value, "activationUserName");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameLessThan(String value) {
            addCriterion("activation_user_name <", value, "activationUserName");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameLessThanOrEqualTo(String value) {
            addCriterion("activation_user_name <=", value, "activationUserName");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameLike(String value) {
            addCriterion("activation_user_name like", value, "activationUserName");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameNotLike(String value) {
            addCriterion("activation_user_name not like", value, "activationUserName");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameIn(List<String> values) {
            addCriterion("activation_user_name in", values, "activationUserName");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameNotIn(List<String> values) {
            addCriterion("activation_user_name not in", values, "activationUserName");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameBetween(String value1, String value2) {
            addCriterion("activation_user_name between", value1, value2, "activationUserName");
            return (Criteria) this;
        }

        public Criteria andActivationUserNameNotBetween(String value1, String value2) {
            addCriterion("activation_user_name not between", value1, value2, "activationUserName");
            return (Criteria) this;
        }

        public Criteria andCreateSourceIsNull() {
            addCriterion("create_source is null");
            return (Criteria) this;
        }

        public Criteria andCreateSourceIsNotNull() {
            addCriterion("create_source is not null");
            return (Criteria) this;
        }

        public Criteria andCreateSourceEqualTo(Byte value) {
            addCriterion("create_source =", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotEqualTo(Byte value) {
            addCriterion("create_source <>", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceGreaterThan(Byte value) {
            addCriterion("create_source >", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("create_source >=", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceLessThan(Byte value) {
            addCriterion("create_source <", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceLessThanOrEqualTo(Byte value) {
            addCriterion("create_source <=", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceIn(List<Byte> values) {
            addCriterion("create_source in", values, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotIn(List<Byte> values) {
            addCriterion("create_source not in", values, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceBetween(Byte value1, Byte value2) {
            addCriterion("create_source between", value1, value2, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("create_source not between", value1, value2, "createSource");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultIsNull() {
            addCriterion("order_installation_result is null");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultIsNotNull() {
            addCriterion("order_installation_result is not null");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultEqualTo(String value) {
            addCriterion("order_installation_result =", value, "orderInstallationResult");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultNotEqualTo(String value) {
            addCriterion("order_installation_result <>", value, "orderInstallationResult");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultGreaterThan(String value) {
            addCriterion("order_installation_result >", value, "orderInstallationResult");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultGreaterThanOrEqualTo(String value) {
            addCriterion("order_installation_result >=", value, "orderInstallationResult");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultLessThan(String value) {
            addCriterion("order_installation_result <", value, "orderInstallationResult");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultLessThanOrEqualTo(String value) {
            addCriterion("order_installation_result <=", value, "orderInstallationResult");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultLike(String value) {
            addCriterion("order_installation_result like", value, "orderInstallationResult");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultNotLike(String value) {
            addCriterion("order_installation_result not like", value, "orderInstallationResult");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultIn(List<String> values) {
            addCriterion("order_installation_result in", values, "orderInstallationResult");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultNotIn(List<String> values) {
            addCriterion("order_installation_result not in", values, "orderInstallationResult");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultBetween(String value1, String value2) {
            addCriterion("order_installation_result between", value1, value2, "orderInstallationResult");
            return (Criteria) this;
        }

        public Criteria andOrderInstallationResultNotBetween(String value1, String value2) {
            addCriterion("order_installation_result not between", value1, value2, "orderInstallationResult");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIsNull() {
            addCriterion("customer_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIsNotNull() {
            addCriterion("customer_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneEqualTo(String value) {
            addCriterion("customer_phone =", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotEqualTo(String value) {
            addCriterion("customer_phone <>", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneGreaterThan(String value) {
            addCriterion("customer_phone >", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("customer_phone >=", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLessThan(String value) {
            addCriterion("customer_phone <", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLessThanOrEqualTo(String value) {
            addCriterion("customer_phone <=", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLike(String value) {
            addCriterion("customer_phone like", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotLike(String value) {
            addCriterion("customer_phone not like", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIn(List<String> values) {
            addCriterion("customer_phone in", values, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotIn(List<String> values) {
            addCriterion("customer_phone not in", values, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneBetween(String value1, String value2) {
            addCriterion("customer_phone between", value1, value2, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotBetween(String value1, String value2) {
            addCriterion("customer_phone not between", value1, value2, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Byte value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Byte value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Byte value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Byte value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Byte value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Byte value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Byte> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Byte> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Byte value1, Byte value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Byte value1, Byte value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("province_code is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("province_code is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("province_code =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("province_code <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("province_code >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("province_code >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("province_code <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("province_code <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("province_code like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("province_code not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("province_code in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("province_code not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("province_code between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("province_code not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("city_code is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("city_code is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("city_code =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("city_code <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("city_code >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_code >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("city_code <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("city_code <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("city_code like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("city_code not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("city_code in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("city_code not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("city_code between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("city_code not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIsNull() {
            addCriterion("district_code is null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIsNotNull() {
            addCriterion("district_code is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeEqualTo(String value) {
            addCriterion("district_code =", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotEqualTo(String value) {
            addCriterion("district_code <>", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeGreaterThan(String value) {
            addCriterion("district_code >", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeGreaterThanOrEqualTo(String value) {
            addCriterion("district_code >=", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLessThan(String value) {
            addCriterion("district_code <", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLessThanOrEqualTo(String value) {
            addCriterion("district_code <=", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLike(String value) {
            addCriterion("district_code like", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotLike(String value) {
            addCriterion("district_code not like", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIn(List<String> values) {
            addCriterion("district_code in", values, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotIn(List<String> values) {
            addCriterion("district_code not in", values, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeBetween(String value1, String value2) {
            addCriterion("district_code between", value1, value2, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotBetween(String value1, String value2) {
            addCriterion("district_code not between", value1, value2, "districtCode");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
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
            addCriterion("address >=", value, "address");
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

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
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

        public Criteria andHouseTypeIsNull() {
            addCriterion("house_type is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("house_type is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(Byte value) {
            addCriterion("house_type =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(Byte value) {
            addCriterion("house_type <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(Byte value) {
            addCriterion("house_type >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("house_type >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(Byte value) {
            addCriterion("house_type <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(Byte value) {
            addCriterion("house_type <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<Byte> values) {
            addCriterion("house_type in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<Byte> values) {
            addCriterion("house_type not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(Byte value1, Byte value2) {
            addCriterion("house_type between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("house_type not between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHousePropertyIsNull() {
            addCriterion("house_property is null");
            return (Criteria) this;
        }

        public Criteria andHousePropertyIsNotNull() {
            addCriterion("house_property is not null");
            return (Criteria) this;
        }

        public Criteria andHousePropertyEqualTo(Byte value) {
            addCriterion("house_property =", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyNotEqualTo(Byte value) {
            addCriterion("house_property <>", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyGreaterThan(Byte value) {
            addCriterion("house_property >", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyGreaterThanOrEqualTo(Byte value) {
            addCriterion("house_property >=", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyLessThan(Byte value) {
            addCriterion("house_property <", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyLessThanOrEqualTo(Byte value) {
            addCriterion("house_property <=", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyIn(List<Byte> values) {
            addCriterion("house_property in", values, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyNotIn(List<Byte> values) {
            addCriterion("house_property not in", values, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyBetween(Byte value1, Byte value2) {
            addCriterion("house_property between", value1, value2, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyNotBetween(Byte value1, Byte value2) {
            addCriterion("house_property not between", value1, value2, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andCarpotTypeIsNull() {
            addCriterion("carpot_type is null");
            return (Criteria) this;
        }

        public Criteria andCarpotTypeIsNotNull() {
            addCriterion("carpot_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarpotTypeEqualTo(Byte value) {
            addCriterion("carpot_type =", value, "carpotType");
            return (Criteria) this;
        }

        public Criteria andCarpotTypeNotEqualTo(Byte value) {
            addCriterion("carpot_type <>", value, "carpotType");
            return (Criteria) this;
        }

        public Criteria andCarpotTypeGreaterThan(Byte value) {
            addCriterion("carpot_type >", value, "carpotType");
            return (Criteria) this;
        }

        public Criteria andCarpotTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("carpot_type >=", value, "carpotType");
            return (Criteria) this;
        }

        public Criteria andCarpotTypeLessThan(Byte value) {
            addCriterion("carpot_type <", value, "carpotType");
            return (Criteria) this;
        }

        public Criteria andCarpotTypeLessThanOrEqualTo(Byte value) {
            addCriterion("carpot_type <=", value, "carpotType");
            return (Criteria) this;
        }

        public Criteria andCarpotTypeIn(List<Byte> values) {
            addCriterion("carpot_type in", values, "carpotType");
            return (Criteria) this;
        }

        public Criteria andCarpotTypeNotIn(List<Byte> values) {
            addCriterion("carpot_type not in", values, "carpotType");
            return (Criteria) this;
        }

        public Criteria andCarpotTypeBetween(Byte value1, Byte value2) {
            addCriterion("carpot_type between", value1, value2, "carpotType");
            return (Criteria) this;
        }

        public Criteria andCarpotTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("carpot_type not between", value1, value2, "carpotType");
            return (Criteria) this;
        }

        public Criteria andInstallationStatusIsNull() {
            addCriterion("installation_status is null");
            return (Criteria) this;
        }

        public Criteria andInstallationStatusIsNotNull() {
            addCriterion("installation_status is not null");
            return (Criteria) this;
        }

        public Criteria andInstallationStatusEqualTo(Byte value) {
            addCriterion("installation_status =", value, "installationStatus");
            return (Criteria) this;
        }

        public Criteria andInstallationStatusNotEqualTo(Byte value) {
            addCriterion("installation_status <>", value, "installationStatus");
            return (Criteria) this;
        }

        public Criteria andInstallationStatusGreaterThan(Byte value) {
            addCriterion("installation_status >", value, "installationStatus");
            return (Criteria) this;
        }

        public Criteria andInstallationStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("installation_status >=", value, "installationStatus");
            return (Criteria) this;
        }

        public Criteria andInstallationStatusLessThan(Byte value) {
            addCriterion("installation_status <", value, "installationStatus");
            return (Criteria) this;
        }

        public Criteria andInstallationStatusLessThanOrEqualTo(Byte value) {
            addCriterion("installation_status <=", value, "installationStatus");
            return (Criteria) this;
        }

        public Criteria andInstallationStatusIn(List<Byte> values) {
            addCriterion("installation_status in", values, "installationStatus");
            return (Criteria) this;
        }

        public Criteria andInstallationStatusNotIn(List<Byte> values) {
            addCriterion("installation_status not in", values, "installationStatus");
            return (Criteria) this;
        }

        public Criteria andInstallationStatusBetween(Byte value1, Byte value2) {
            addCriterion("installation_status between", value1, value2, "installationStatus");
            return (Criteria) this;
        }

        public Criteria andInstallationStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("installation_status not between", value1, value2, "installationStatus");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementStatusIsNull() {
            addCriterion("property_management_status is null");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementStatusIsNotNull() {
            addCriterion("property_management_status is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementStatusEqualTo(Byte value) {
            addCriterion("property_management_status =", value, "propertyManagementStatus");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementStatusNotEqualTo(Byte value) {
            addCriterion("property_management_status <>", value, "propertyManagementStatus");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementStatusGreaterThan(Byte value) {
            addCriterion("property_management_status >", value, "propertyManagementStatus");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("property_management_status >=", value, "propertyManagementStatus");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementStatusLessThan(Byte value) {
            addCriterion("property_management_status <", value, "propertyManagementStatus");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementStatusLessThanOrEqualTo(Byte value) {
            addCriterion("property_management_status <=", value, "propertyManagementStatus");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementStatusIn(List<Byte> values) {
            addCriterion("property_management_status in", values, "propertyManagementStatus");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementStatusNotIn(List<Byte> values) {
            addCriterion("property_management_status not in", values, "propertyManagementStatus");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementStatusBetween(Byte value1, Byte value2) {
            addCriterion("property_management_status between", value1, value2, "propertyManagementStatus");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("property_management_status not between", value1, value2, "propertyManagementStatus");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeIsNull() {
            addCriterion("car_series_code is null");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeIsNotNull() {
            addCriterion("car_series_code is not null");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeEqualTo(String value) {
            addCriterion("car_series_code =", value, "carSeriesCode");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeNotEqualTo(String value) {
            addCriterion("car_series_code <>", value, "carSeriesCode");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeGreaterThan(String value) {
            addCriterion("car_series_code >", value, "carSeriesCode");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeGreaterThanOrEqualTo(String value) {
            addCriterion("car_series_code >=", value, "carSeriesCode");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeLessThan(String value) {
            addCriterion("car_series_code <", value, "carSeriesCode");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeLessThanOrEqualTo(String value) {
            addCriterion("car_series_code <=", value, "carSeriesCode");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeLike(String value) {
            addCriterion("car_series_code like", value, "carSeriesCode");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeNotLike(String value) {
            addCriterion("car_series_code not like", value, "carSeriesCode");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeIn(List<String> values) {
            addCriterion("car_series_code in", values, "carSeriesCode");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeNotIn(List<String> values) {
            addCriterion("car_series_code not in", values, "carSeriesCode");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeBetween(String value1, String value2) {
            addCriterion("car_series_code between", value1, value2, "carSeriesCode");
            return (Criteria) this;
        }

        public Criteria andCarSeriesCodeNotBetween(String value1, String value2) {
            addCriterion("car_series_code not between", value1, value2, "carSeriesCode");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameIsNull() {
            addCriterion("car_series_name is null");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameIsNotNull() {
            addCriterion("car_series_name is not null");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameEqualTo(String value) {
            addCriterion("car_series_name =", value, "carSeriesName");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameNotEqualTo(String value) {
            addCriterion("car_series_name <>", value, "carSeriesName");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameGreaterThan(String value) {
            addCriterion("car_series_name >", value, "carSeriesName");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameGreaterThanOrEqualTo(String value) {
            addCriterion("car_series_name >=", value, "carSeriesName");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameLessThan(String value) {
            addCriterion("car_series_name <", value, "carSeriesName");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameLessThanOrEqualTo(String value) {
            addCriterion("car_series_name <=", value, "carSeriesName");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameLike(String value) {
            addCriterion("car_series_name like", value, "carSeriesName");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameNotLike(String value) {
            addCriterion("car_series_name not like", value, "carSeriesName");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameIn(List<String> values) {
            addCriterion("car_series_name in", values, "carSeriesName");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameNotIn(List<String> values) {
            addCriterion("car_series_name not in", values, "carSeriesName");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameBetween(String value1, String value2) {
            addCriterion("car_series_name between", value1, value2, "carSeriesName");
            return (Criteria) this;
        }

        public Criteria andCarSeriesNameNotBetween(String value1, String value2) {
            addCriterion("car_series_name not between", value1, value2, "carSeriesName");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeIsNull() {
            addCriterion("vehicle_type_code is null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeIsNotNull() {
            addCriterion("vehicle_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeEqualTo(String value) {
            addCriterion("vehicle_type_code =", value, "vehicleTypeCode");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeNotEqualTo(String value) {
            addCriterion("vehicle_type_code <>", value, "vehicleTypeCode");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeGreaterThan(String value) {
            addCriterion("vehicle_type_code >", value, "vehicleTypeCode");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_type_code >=", value, "vehicleTypeCode");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeLessThan(String value) {
            addCriterion("vehicle_type_code <", value, "vehicleTypeCode");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("vehicle_type_code <=", value, "vehicleTypeCode");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeLike(String value) {
            addCriterion("vehicle_type_code like", value, "vehicleTypeCode");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeNotLike(String value) {
            addCriterion("vehicle_type_code not like", value, "vehicleTypeCode");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeIn(List<String> values) {
            addCriterion("vehicle_type_code in", values, "vehicleTypeCode");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeNotIn(List<String> values) {
            addCriterion("vehicle_type_code not in", values, "vehicleTypeCode");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeBetween(String value1, String value2) {
            addCriterion("vehicle_type_code between", value1, value2, "vehicleTypeCode");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeCodeNotBetween(String value1, String value2) {
            addCriterion("vehicle_type_code not between", value1, value2, "vehicleTypeCode");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameIsNull() {
            addCriterion("vehicle_type_name is null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameIsNotNull() {
            addCriterion("vehicle_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameEqualTo(String value) {
            addCriterion("vehicle_type_name =", value, "vehicleTypeName");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameNotEqualTo(String value) {
            addCriterion("vehicle_type_name <>", value, "vehicleTypeName");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameGreaterThan(String value) {
            addCriterion("vehicle_type_name >", value, "vehicleTypeName");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_type_name >=", value, "vehicleTypeName");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameLessThan(String value) {
            addCriterion("vehicle_type_name <", value, "vehicleTypeName");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameLessThanOrEqualTo(String value) {
            addCriterion("vehicle_type_name <=", value, "vehicleTypeName");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameLike(String value) {
            addCriterion("vehicle_type_name like", value, "vehicleTypeName");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameNotLike(String value) {
            addCriterion("vehicle_type_name not like", value, "vehicleTypeName");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameIn(List<String> values) {
            addCriterion("vehicle_type_name in", values, "vehicleTypeName");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameNotIn(List<String> values) {
            addCriterion("vehicle_type_name not in", values, "vehicleTypeName");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameBetween(String value1, String value2) {
            addCriterion("vehicle_type_name between", value1, value2, "vehicleTypeName");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNameNotBetween(String value1, String value2) {
            addCriterion("vehicle_type_name not between", value1, value2, "vehicleTypeName");
            return (Criteria) this;
        }

        public Criteria andVehicleIsNull() {
            addCriterion("vehicle is null");
            return (Criteria) this;
        }

        public Criteria andVehicleIsNotNull() {
            addCriterion("vehicle is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleEqualTo(String value) {
            addCriterion("vehicle =", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotEqualTo(String value) {
            addCriterion("vehicle <>", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleGreaterThan(String value) {
            addCriterion("vehicle >", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle >=", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleLessThan(String value) {
            addCriterion("vehicle <", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleLessThanOrEqualTo(String value) {
            addCriterion("vehicle <=", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleLike(String value) {
            addCriterion("vehicle like", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotLike(String value) {
            addCriterion("vehicle not like", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleIn(List<String> values) {
            addCriterion("vehicle in", values, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotIn(List<String> values) {
            addCriterion("vehicle not in", values, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleBetween(String value1, String value2) {
            addCriterion("vehicle between", value1, value2, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotBetween(String value1, String value2) {
            addCriterion("vehicle not between", value1, value2, "vehicle");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameIsNull() {
            addCriterion("ca_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameIsNotNull() {
            addCriterion("ca_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameEqualTo(String value) {
            addCriterion("ca_emp_name =", value, "caEmpName");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameNotEqualTo(String value) {
            addCriterion("ca_emp_name <>", value, "caEmpName");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameGreaterThan(String value) {
            addCriterion("ca_emp_name >", value, "caEmpName");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("ca_emp_name >=", value, "caEmpName");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameLessThan(String value) {
            addCriterion("ca_emp_name <", value, "caEmpName");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameLessThanOrEqualTo(String value) {
            addCriterion("ca_emp_name <=", value, "caEmpName");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameLike(String value) {
            addCriterion("ca_emp_name like", value, "caEmpName");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameNotLike(String value) {
            addCriterion("ca_emp_name not like", value, "caEmpName");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameIn(List<String> values) {
            addCriterion("ca_emp_name in", values, "caEmpName");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameNotIn(List<String> values) {
            addCriterion("ca_emp_name not in", values, "caEmpName");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameBetween(String value1, String value2) {
            addCriterion("ca_emp_name between", value1, value2, "caEmpName");
            return (Criteria) this;
        }

        public Criteria andCaEmpNameNotBetween(String value1, String value2) {
            addCriterion("ca_emp_name not between", value1, value2, "caEmpName");
            return (Criteria) this;
        }

        public Criteria andPreDeliverDateIsNull() {
            addCriterion("pre_deliver_date is null");
            return (Criteria) this;
        }

        public Criteria andPreDeliverDateIsNotNull() {
            addCriterion("pre_deliver_date is not null");
            return (Criteria) this;
        }

        public Criteria andPreDeliverDateEqualTo(Date value) {
            addCriterion("pre_deliver_date =", value, "preDeliverDate");
            return (Criteria) this;
        }

        public Criteria andPreDeliverDateNotEqualTo(Date value) {
            addCriterion("pre_deliver_date <>", value, "preDeliverDate");
            return (Criteria) this;
        }

        public Criteria andPreDeliverDateGreaterThan(Date value) {
            addCriterion("pre_deliver_date >", value, "preDeliverDate");
            return (Criteria) this;
        }

        public Criteria andPreDeliverDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pre_deliver_date >=", value, "preDeliverDate");
            return (Criteria) this;
        }

        public Criteria andPreDeliverDateLessThan(Date value) {
            addCriterion("pre_deliver_date <", value, "preDeliverDate");
            return (Criteria) this;
        }

        public Criteria andPreDeliverDateLessThanOrEqualTo(Date value) {
            addCriterion("pre_deliver_date <=", value, "preDeliverDate");
            return (Criteria) this;
        }

        public Criteria andPreDeliverDateIn(List<Date> values) {
            addCriterion("pre_deliver_date in", values, "preDeliverDate");
            return (Criteria) this;
        }

        public Criteria andPreDeliverDateNotIn(List<Date> values) {
            addCriterion("pre_deliver_date not in", values, "preDeliverDate");
            return (Criteria) this;
        }

        public Criteria andPreDeliverDateBetween(Date value1, Date value2) {
            addCriterion("pre_deliver_date between", value1, value2, "preDeliverDate");
            return (Criteria) this;
        }

        public Criteria andPreDeliverDateNotBetween(Date value1, Date value2) {
            addCriterion("pre_deliver_date not between", value1, value2, "preDeliverDate");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateIsNull() {
            addCriterion("sale_order_state is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateIsNotNull() {
            addCriterion("sale_order_state is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateEqualTo(String value) {
            addCriterion("sale_order_state =", value, "saleOrderState");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateNotEqualTo(String value) {
            addCriterion("sale_order_state <>", value, "saleOrderState");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateGreaterThan(String value) {
            addCriterion("sale_order_state >", value, "saleOrderState");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateGreaterThanOrEqualTo(String value) {
            addCriterion("sale_order_state >=", value, "saleOrderState");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateLessThan(String value) {
            addCriterion("sale_order_state <", value, "saleOrderState");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateLessThanOrEqualTo(String value) {
            addCriterion("sale_order_state <=", value, "saleOrderState");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateLike(String value) {
            addCriterion("sale_order_state like", value, "saleOrderState");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateNotLike(String value) {
            addCriterion("sale_order_state not like", value, "saleOrderState");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateIn(List<String> values) {
            addCriterion("sale_order_state in", values, "saleOrderState");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateNotIn(List<String> values) {
            addCriterion("sale_order_state not in", values, "saleOrderState");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateBetween(String value1, String value2) {
            addCriterion("sale_order_state between", value1, value2, "saleOrderState");
            return (Criteria) this;
        }

        public Criteria andSaleOrderStateNotBetween(String value1, String value2) {
            addCriterion("sale_order_state not between", value1, value2, "saleOrderState");
            return (Criteria) this;
        }

        public Criteria andVinIsNull() {
            addCriterion("vin is null");
            return (Criteria) this;
        }

        public Criteria andVinIsNotNull() {
            addCriterion("vin is not null");
            return (Criteria) this;
        }

        public Criteria andVinEqualTo(String value) {
            addCriterion("vin =", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotEqualTo(String value) {
            addCriterion("vin <>", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThan(String value) {
            addCriterion("vin >", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThanOrEqualTo(String value) {
            addCriterion("vin >=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThan(String value) {
            addCriterion("vin <", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThanOrEqualTo(String value) {
            addCriterion("vin <=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLike(String value) {
            addCriterion("vin like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotLike(String value) {
            addCriterion("vin not like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinIn(List<String> values) {
            addCriterion("vin in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotIn(List<String> values) {
            addCriterion("vin not in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinBetween(String value1, String value2) {
            addCriterion("vin between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotBetween(String value1, String value2) {
            addCriterion("vin not between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andChargingPoleTypeIsNull() {
            addCriterion("charging_pole_type is null");
            return (Criteria) this;
        }

        public Criteria andChargingPoleTypeIsNotNull() {
            addCriterion("charging_pole_type is not null");
            return (Criteria) this;
        }

        public Criteria andChargingPoleTypeEqualTo(Byte value) {
            addCriterion("charging_pole_type =", value, "chargingPoleType");
            return (Criteria) this;
        }

        public Criteria andChargingPoleTypeNotEqualTo(Byte value) {
            addCriterion("charging_pole_type <>", value, "chargingPoleType");
            return (Criteria) this;
        }

        public Criteria andChargingPoleTypeGreaterThan(Byte value) {
            addCriterion("charging_pole_type >", value, "chargingPoleType");
            return (Criteria) this;
        }

        public Criteria andChargingPoleTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("charging_pole_type >=", value, "chargingPoleType");
            return (Criteria) this;
        }

        public Criteria andChargingPoleTypeLessThan(Byte value) {
            addCriterion("charging_pole_type <", value, "chargingPoleType");
            return (Criteria) this;
        }

        public Criteria andChargingPoleTypeLessThanOrEqualTo(Byte value) {
            addCriterion("charging_pole_type <=", value, "chargingPoleType");
            return (Criteria) this;
        }

        public Criteria andChargingPoleTypeIn(List<Byte> values) {
            addCriterion("charging_pole_type in", values, "chargingPoleType");
            return (Criteria) this;
        }

        public Criteria andChargingPoleTypeNotIn(List<Byte> values) {
            addCriterion("charging_pole_type not in", values, "chargingPoleType");
            return (Criteria) this;
        }

        public Criteria andChargingPoleTypeBetween(Byte value1, Byte value2) {
            addCriterion("charging_pole_type between", value1, value2, "chargingPoleType");
            return (Criteria) this;
        }

        public Criteria andChargingPoleTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("charging_pole_type not between", value1, value2, "chargingPoleType");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameIsNull() {
            addCriterion("signatory_name is null");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameIsNotNull() {
            addCriterion("signatory_name is not null");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameEqualTo(String value) {
            addCriterion("signatory_name =", value, "signatoryName");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameNotEqualTo(String value) {
            addCriterion("signatory_name <>", value, "signatoryName");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameGreaterThan(String value) {
            addCriterion("signatory_name >", value, "signatoryName");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("signatory_name >=", value, "signatoryName");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameLessThan(String value) {
            addCriterion("signatory_name <", value, "signatoryName");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameLessThanOrEqualTo(String value) {
            addCriterion("signatory_name <=", value, "signatoryName");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameLike(String value) {
            addCriterion("signatory_name like", value, "signatoryName");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameNotLike(String value) {
            addCriterion("signatory_name not like", value, "signatoryName");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameIn(List<String> values) {
            addCriterion("signatory_name in", values, "signatoryName");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameNotIn(List<String> values) {
            addCriterion("signatory_name not in", values, "signatoryName");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameBetween(String value1, String value2) {
            addCriterion("signatory_name between", value1, value2, "signatoryName");
            return (Criteria) this;
        }

        public Criteria andSignatoryNameNotBetween(String value1, String value2) {
            addCriterion("signatory_name not between", value1, value2, "signatoryName");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneIsNull() {
            addCriterion("signatory_phone is null");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneIsNotNull() {
            addCriterion("signatory_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneEqualTo(String value) {
            addCriterion("signatory_phone =", value, "signatoryPhone");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneNotEqualTo(String value) {
            addCriterion("signatory_phone <>", value, "signatoryPhone");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneGreaterThan(String value) {
            addCriterion("signatory_phone >", value, "signatoryPhone");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("signatory_phone >=", value, "signatoryPhone");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneLessThan(String value) {
            addCriterion("signatory_phone <", value, "signatoryPhone");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneLessThanOrEqualTo(String value) {
            addCriterion("signatory_phone <=", value, "signatoryPhone");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneLike(String value) {
            addCriterion("signatory_phone like", value, "signatoryPhone");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneNotLike(String value) {
            addCriterion("signatory_phone not like", value, "signatoryPhone");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneIn(List<String> values) {
            addCriterion("signatory_phone in", values, "signatoryPhone");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneNotIn(List<String> values) {
            addCriterion("signatory_phone not in", values, "signatoryPhone");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneBetween(String value1, String value2) {
            addCriterion("signatory_phone between", value1, value2, "signatoryPhone");
            return (Criteria) this;
        }

        public Criteria andSignatoryPhoneNotBetween(String value1, String value2) {
            addCriterion("signatory_phone not between", value1, value2, "signatoryPhone");
            return (Criteria) this;
        }

        public Criteria andSceneCodeIsNull() {
            addCriterion("scene_code is null");
            return (Criteria) this;
        }

        public Criteria andSceneCodeIsNotNull() {
            addCriterion("scene_code is not null");
            return (Criteria) this;
        }

        public Criteria andSceneCodeEqualTo(Byte value) {
            addCriterion("scene_code =", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeNotEqualTo(Byte value) {
            addCriterion("scene_code <>", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeGreaterThan(Byte value) {
            addCriterion("scene_code >", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeGreaterThanOrEqualTo(Byte value) {
            addCriterion("scene_code >=", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeLessThan(Byte value) {
            addCriterion("scene_code <", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeLessThanOrEqualTo(Byte value) {
            addCriterion("scene_code <=", value, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeIn(List<Byte> values) {
            addCriterion("scene_code in", values, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeNotIn(List<Byte> values) {
            addCriterion("scene_code not in", values, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeBetween(Byte value1, Byte value2) {
            addCriterion("scene_code between", value1, value2, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andSceneCodeNotBetween(Byte value1, Byte value2) {
            addCriterion("scene_code not between", value1, value2, "sceneCode");
            return (Criteria) this;
        }

        public Criteria andEarnestMoneyPayTimeIsNull() {
            addCriterion("earnest_money_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andEarnestMoneyPayTimeIsNotNull() {
            addCriterion("earnest_money_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andEarnestMoneyPayTimeEqualTo(Date value) {
            addCriterion("earnest_money_pay_time =", value, "earnestMoneyPayTime");
            return (Criteria) this;
        }

        public Criteria andEarnestMoneyPayTimeNotEqualTo(Date value) {
            addCriterion("earnest_money_pay_time <>", value, "earnestMoneyPayTime");
            return (Criteria) this;
        }

        public Criteria andEarnestMoneyPayTimeGreaterThan(Date value) {
            addCriterion("earnest_money_pay_time >", value, "earnestMoneyPayTime");
            return (Criteria) this;
        }

        public Criteria andEarnestMoneyPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("earnest_money_pay_time >=", value, "earnestMoneyPayTime");
            return (Criteria) this;
        }

        public Criteria andEarnestMoneyPayTimeLessThan(Date value) {
            addCriterion("earnest_money_pay_time <", value, "earnestMoneyPayTime");
            return (Criteria) this;
        }

        public Criteria andEarnestMoneyPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("earnest_money_pay_time <=", value, "earnestMoneyPayTime");
            return (Criteria) this;
        }

        public Criteria andEarnestMoneyPayTimeIn(List<Date> values) {
            addCriterion("earnest_money_pay_time in", values, "earnestMoneyPayTime");
            return (Criteria) this;
        }

        public Criteria andEarnestMoneyPayTimeNotIn(List<Date> values) {
            addCriterion("earnest_money_pay_time not in", values, "earnestMoneyPayTime");
            return (Criteria) this;
        }

        public Criteria andEarnestMoneyPayTimeBetween(Date value1, Date value2) {
            addCriterion("earnest_money_pay_time between", value1, value2, "earnestMoneyPayTime");
            return (Criteria) this;
        }

        public Criteria andEarnestMoneyPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("earnest_money_pay_time not between", value1, value2, "earnestMoneyPayTime");
            return (Criteria) this;
        }

        public Criteria andDlrTypeIsNull() {
            addCriterion("dlr_type is null");
            return (Criteria) this;
        }

        public Criteria andDlrTypeIsNotNull() {
            addCriterion("dlr_type is not null");
            return (Criteria) this;
        }

        public Criteria andDlrTypeEqualTo(Byte value) {
            addCriterion("dlr_type =", value, "dlrType");
            return (Criteria) this;
        }

        public Criteria andDlrTypeNotEqualTo(Byte value) {
            addCriterion("dlr_type <>", value, "dlrType");
            return (Criteria) this;
        }

        public Criteria andDlrTypeGreaterThan(Byte value) {
            addCriterion("dlr_type >", value, "dlrType");
            return (Criteria) this;
        }

        public Criteria andDlrTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("dlr_type >=", value, "dlrType");
            return (Criteria) this;
        }

        public Criteria andDlrTypeLessThan(Byte value) {
            addCriterion("dlr_type <", value, "dlrType");
            return (Criteria) this;
        }

        public Criteria andDlrTypeLessThanOrEqualTo(Byte value) {
            addCriterion("dlr_type <=", value, "dlrType");
            return (Criteria) this;
        }

        public Criteria andDlrTypeIn(List<Byte> values) {
            addCriterion("dlr_type in", values, "dlrType");
            return (Criteria) this;
        }

        public Criteria andDlrTypeNotIn(List<Byte> values) {
            addCriterion("dlr_type not in", values, "dlrType");
            return (Criteria) this;
        }

        public Criteria andDlrTypeBetween(Byte value1, Byte value2) {
            addCriterion("dlr_type between", value1, value2, "dlrType");
            return (Criteria) this;
        }

        public Criteria andDlrTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("dlr_type not between", value1, value2, "dlrType");
            return (Criteria) this;
        }

        public Criteria andRevenueIsNull() {
            addCriterion("revenue is null");
            return (Criteria) this;
        }

        public Criteria andRevenueIsNotNull() {
            addCriterion("revenue is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueEqualTo(String value) {
            addCriterion("revenue =", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotEqualTo(String value) {
            addCriterion("revenue <>", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueGreaterThan(String value) {
            addCriterion("revenue >", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueGreaterThanOrEqualTo(String value) {
            addCriterion("revenue >=", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLessThan(String value) {
            addCriterion("revenue <", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLessThanOrEqualTo(String value) {
            addCriterion("revenue <=", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLike(String value) {
            addCriterion("revenue like", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotLike(String value) {
            addCriterion("revenue not like", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueIn(List<String> values) {
            addCriterion("revenue in", values, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotIn(List<String> values) {
            addCriterion("revenue not in", values, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueBetween(String value1, String value2) {
            addCriterion("revenue between", value1, value2, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotBetween(String value1, String value2) {
            addCriterion("revenue not between", value1, value2, "revenue");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodIsNull() {
            addCriterion("purchase_method is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodIsNotNull() {
            addCriterion("purchase_method is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodEqualTo(Byte value) {
            addCriterion("purchase_method =", value, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodNotEqualTo(Byte value) {
            addCriterion("purchase_method <>", value, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodGreaterThan(Byte value) {
            addCriterion("purchase_method >", value, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodGreaterThanOrEqualTo(Byte value) {
            addCriterion("purchase_method >=", value, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodLessThan(Byte value) {
            addCriterion("purchase_method <", value, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodLessThanOrEqualTo(Byte value) {
            addCriterion("purchase_method <=", value, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodIn(List<Byte> values) {
            addCriterion("purchase_method in", values, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodNotIn(List<Byte> values) {
            addCriterion("purchase_method not in", values, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodBetween(Byte value1, Byte value2) {
            addCriterion("purchase_method between", value1, value2, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodNotBetween(Byte value1, Byte value2) {
            addCriterion("purchase_method not between", value1, value2, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andCommodityIsNull() {
            addCriterion("commodity is null");
            return (Criteria) this;
        }

        public Criteria andCommodityIsNotNull() {
            addCriterion("commodity is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityEqualTo(String value) {
            addCriterion("commodity =", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityNotEqualTo(String value) {
            addCriterion("commodity <>", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityGreaterThan(String value) {
            addCriterion("commodity >", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityGreaterThanOrEqualTo(String value) {
            addCriterion("commodity >=", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityLessThan(String value) {
            addCriterion("commodity <", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityLessThanOrEqualTo(String value) {
            addCriterion("commodity <=", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityLike(String value) {
            addCriterion("commodity like", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityNotLike(String value) {
            addCriterion("commodity not like", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityIn(List<String> values) {
            addCriterion("commodity in", values, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityNotIn(List<String> values) {
            addCriterion("commodity not in", values, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityBetween(String value1, String value2) {
            addCriterion("commodity between", value1, value2, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityNotBetween(String value1, String value2) {
            addCriterion("commodity not between", value1, value2, "commodity");
            return (Criteria) this;
        }

        public Criteria andCashIsNull() {
            addCriterion("cash is null");
            return (Criteria) this;
        }

        public Criteria andCashIsNotNull() {
            addCriterion("cash is not null");
            return (Criteria) this;
        }

        public Criteria andCashEqualTo(String value) {
            addCriterion("cash =", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotEqualTo(String value) {
            addCriterion("cash <>", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashGreaterThan(String value) {
            addCriterion("cash >", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashGreaterThanOrEqualTo(String value) {
            addCriterion("cash >=", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLessThan(String value) {
            addCriterion("cash <", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLessThanOrEqualTo(String value) {
            addCriterion("cash <=", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLike(String value) {
            addCriterion("cash like", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotLike(String value) {
            addCriterion("cash not like", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashIn(List<String> values) {
            addCriterion("cash in", values, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotIn(List<String> values) {
            addCriterion("cash not in", values, "cash");
            return (Criteria) this;
        }

        public Criteria andCashBetween(String value1, String value2) {
            addCriterion("cash between", value1, value2, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotBetween(String value1, String value2) {
            addCriterion("cash not between", value1, value2, "cash");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(String value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(String value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(String value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(String value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(String value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(String value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLike(String value) {
            addCriterion("integral like", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotLike(String value) {
            addCriterion("integral not like", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<String> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<String> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(String value1, String value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(String value1, String value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(String value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(String value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(String value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(String value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(String value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLike(String value) {
            addCriterion("discount like", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotLike(String value) {
            addCriterion("discount not like", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<String> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<String> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(String value1, String value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(String value1, String value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andPaymentDateIsNull() {
            addCriterion("payment_date is null");
            return (Criteria) this;
        }

        public Criteria andPaymentDateIsNotNull() {
            addCriterion("payment_date is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentDateEqualTo(Date value) {
            addCriterion("payment_date =", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateNotEqualTo(Date value) {
            addCriterion("payment_date <>", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateGreaterThan(Date value) {
            addCriterion("payment_date >", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateGreaterThanOrEqualTo(Date value) {
            addCriterion("payment_date >=", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateLessThan(Date value) {
            addCriterion("payment_date <", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateLessThanOrEqualTo(Date value) {
            addCriterion("payment_date <=", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateIn(List<Date> values) {
            addCriterion("payment_date in", values, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateNotIn(List<Date> values) {
            addCriterion("payment_date not in", values, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateBetween(Date value1, Date value2) {
            addCriterion("payment_date between", value1, value2, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateNotBetween(Date value1, Date value2) {
            addCriterion("payment_date not between", value1, value2, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andInstallFinishTimeIsNull() {
            addCriterion("install_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andInstallFinishTimeIsNotNull() {
            addCriterion("install_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andInstallFinishTimeEqualTo(Date value) {
            addCriterion("install_finish_time =", value, "installFinishTime");
            return (Criteria) this;
        }

        public Criteria andInstallFinishTimeNotEqualTo(Date value) {
            addCriterion("install_finish_time <>", value, "installFinishTime");
            return (Criteria) this;
        }

        public Criteria andInstallFinishTimeGreaterThan(Date value) {
            addCriterion("install_finish_time >", value, "installFinishTime");
            return (Criteria) this;
        }

        public Criteria andInstallFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("install_finish_time >=", value, "installFinishTime");
            return (Criteria) this;
        }

        public Criteria andInstallFinishTimeLessThan(Date value) {
            addCriterion("install_finish_time <", value, "installFinishTime");
            return (Criteria) this;
        }

        public Criteria andInstallFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("install_finish_time <=", value, "installFinishTime");
            return (Criteria) this;
        }

        public Criteria andInstallFinishTimeIn(List<Date> values) {
            addCriterion("install_finish_time in", values, "installFinishTime");
            return (Criteria) this;
        }

        public Criteria andInstallFinishTimeNotIn(List<Date> values) {
            addCriterion("install_finish_time not in", values, "installFinishTime");
            return (Criteria) this;
        }

        public Criteria andInstallFinishTimeBetween(Date value1, Date value2) {
            addCriterion("install_finish_time between", value1, value2, "installFinishTime");
            return (Criteria) this;
        }

        public Criteria andInstallFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("install_finish_time not between", value1, value2, "installFinishTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNull() {
            addCriterion("cancel_time is null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNotNull() {
            addCriterion("cancel_time is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeEqualTo(Date value) {
            addCriterion("cancel_time =", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotEqualTo(Date value) {
            addCriterion("cancel_time <>", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThan(Date value) {
            addCriterion("cancel_time >", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cancel_time >=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThan(Date value) {
            addCriterion("cancel_time <", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThanOrEqualTo(Date value) {
            addCriterion("cancel_time <=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIn(List<Date> values) {
            addCriterion("cancel_time in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotIn(List<Date> values) {
            addCriterion("cancel_time not in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeBetween(Date value1, Date value2) {
            addCriterion("cancel_time between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotBetween(Date value1, Date value2) {
            addCriterion("cancel_time not between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andStopStatusIsNull() {
            addCriterion("stop_status is null");
            return (Criteria) this;
        }

        public Criteria andStopStatusIsNotNull() {
            addCriterion("stop_status is not null");
            return (Criteria) this;
        }

        public Criteria andStopStatusEqualTo(Byte value) {
            addCriterion("stop_status =", value, "stopStatus");
            return (Criteria) this;
        }

        public Criteria andStopStatusNotEqualTo(Byte value) {
            addCriterion("stop_status <>", value, "stopStatus");
            return (Criteria) this;
        }

        public Criteria andStopStatusGreaterThan(Byte value) {
            addCriterion("stop_status >", value, "stopStatus");
            return (Criteria) this;
        }

        public Criteria andStopStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("stop_status >=", value, "stopStatus");
            return (Criteria) this;
        }

        public Criteria andStopStatusLessThan(Byte value) {
            addCriterion("stop_status <", value, "stopStatus");
            return (Criteria) this;
        }

        public Criteria andStopStatusLessThanOrEqualTo(Byte value) {
            addCriterion("stop_status <=", value, "stopStatus");
            return (Criteria) this;
        }

        public Criteria andStopStatusIn(List<Byte> values) {
            addCriterion("stop_status in", values, "stopStatus");
            return (Criteria) this;
        }

        public Criteria andStopStatusNotIn(List<Byte> values) {
            addCriterion("stop_status not in", values, "stopStatus");
            return (Criteria) this;
        }

        public Criteria andStopStatusBetween(Byte value1, Byte value2) {
            addCriterion("stop_status between", value1, value2, "stopStatus");
            return (Criteria) this;
        }

        public Criteria andStopStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("stop_status not between", value1, value2, "stopStatus");
            return (Criteria) this;
        }

        public Criteria andStopReasonIsNull() {
            addCriterion("stop_reason is null");
            return (Criteria) this;
        }

        public Criteria andStopReasonIsNotNull() {
            addCriterion("stop_reason is not null");
            return (Criteria) this;
        }

        public Criteria andStopReasonEqualTo(String value) {
            addCriterion("stop_reason =", value, "stopReason");
            return (Criteria) this;
        }

        public Criteria andStopReasonNotEqualTo(String value) {
            addCriterion("stop_reason <>", value, "stopReason");
            return (Criteria) this;
        }

        public Criteria andStopReasonGreaterThan(String value) {
            addCriterion("stop_reason >", value, "stopReason");
            return (Criteria) this;
        }

        public Criteria andStopReasonGreaterThanOrEqualTo(String value) {
            addCriterion("stop_reason >=", value, "stopReason");
            return (Criteria) this;
        }

        public Criteria andStopReasonLessThan(String value) {
            addCriterion("stop_reason <", value, "stopReason");
            return (Criteria) this;
        }

        public Criteria andStopReasonLessThanOrEqualTo(String value) {
            addCriterion("stop_reason <=", value, "stopReason");
            return (Criteria) this;
        }

        public Criteria andStopReasonLike(String value) {
            addCriterion("stop_reason like", value, "stopReason");
            return (Criteria) this;
        }

        public Criteria andStopReasonNotLike(String value) {
            addCriterion("stop_reason not like", value, "stopReason");
            return (Criteria) this;
        }

        public Criteria andStopReasonIn(List<String> values) {
            addCriterion("stop_reason in", values, "stopReason");
            return (Criteria) this;
        }

        public Criteria andStopReasonNotIn(List<String> values) {
            addCriterion("stop_reason not in", values, "stopReason");
            return (Criteria) this;
        }

        public Criteria andStopReasonBetween(String value1, String value2) {
            addCriterion("stop_reason between", value1, value2, "stopReason");
            return (Criteria) this;
        }

        public Criteria andStopReasonNotBetween(String value1, String value2) {
            addCriterion("stop_reason not between", value1, value2, "stopReason");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNull() {
            addCriterion("stop_time is null");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNotNull() {
            addCriterion("stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andStopTimeEqualTo(Date value) {
            addCriterion("stop_time =", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotEqualTo(Date value) {
            addCriterion("stop_time <>", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThan(Date value) {
            addCriterion("stop_time >", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stop_time >=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThan(Date value) {
            addCriterion("stop_time <", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThanOrEqualTo(Date value) {
            addCriterion("stop_time <=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeIn(List<Date> values) {
            addCriterion("stop_time in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotIn(List<Date> values) {
            addCriterion("stop_time not in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeBetween(Date value1, Date value2) {
            addCriterion("stop_time between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotBetween(Date value1, Date value2) {
            addCriterion("stop_time not between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeIsNull() {
            addCriterion("ark_order_code is null");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeIsNotNull() {
            addCriterion("ark_order_code is not null");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeEqualTo(String value) {
            addCriterion("ark_order_code =", value, "arkOrderCode");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeNotEqualTo(String value) {
            addCriterion("ark_order_code <>", value, "arkOrderCode");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeGreaterThan(String value) {
            addCriterion("ark_order_code >", value, "arkOrderCode");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ark_order_code >=", value, "arkOrderCode");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeLessThan(String value) {
            addCriterion("ark_order_code <", value, "arkOrderCode");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("ark_order_code <=", value, "arkOrderCode");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeLike(String value) {
            addCriterion("ark_order_code like", value, "arkOrderCode");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeNotLike(String value) {
            addCriterion("ark_order_code not like", value, "arkOrderCode");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeIn(List<String> values) {
            addCriterion("ark_order_code in", values, "arkOrderCode");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeNotIn(List<String> values) {
            addCriterion("ark_order_code not in", values, "arkOrderCode");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeBetween(String value1, String value2) {
            addCriterion("ark_order_code between", value1, value2, "arkOrderCode");
            return (Criteria) this;
        }

        public Criteria andArkOrderCodeNotBetween(String value1, String value2) {
            addCriterion("ark_order_code not between", value1, value2, "arkOrderCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNull() {
            addCriterion("org_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("org_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("org_code =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("org_code <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("org_code >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_code >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("org_code <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("org_code <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("org_code like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("org_code not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("org_code in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("org_code not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("org_code between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("org_code not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdIsNull() {
            addCriterion("service_provider_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdIsNotNull() {
            addCriterion("service_provider_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdEqualTo(String value) {
            addCriterion("service_provider_manager_id =", value, "serviceProviderManagerId");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdNotEqualTo(String value) {
            addCriterion("service_provider_manager_id <>", value, "serviceProviderManagerId");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdGreaterThan(String value) {
            addCriterion("service_provider_manager_id >", value, "serviceProviderManagerId");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdGreaterThanOrEqualTo(String value) {
            addCriterion("service_provider_manager_id >=", value, "serviceProviderManagerId");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdLessThan(String value) {
            addCriterion("service_provider_manager_id <", value, "serviceProviderManagerId");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdLessThanOrEqualTo(String value) {
            addCriterion("service_provider_manager_id <=", value, "serviceProviderManagerId");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdLike(String value) {
            addCriterion("service_provider_manager_id like", value, "serviceProviderManagerId");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdNotLike(String value) {
            addCriterion("service_provider_manager_id not like", value, "serviceProviderManagerId");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdIn(List<String> values) {
            addCriterion("service_provider_manager_id in", values, "serviceProviderManagerId");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdNotIn(List<String> values) {
            addCriterion("service_provider_manager_id not in", values, "serviceProviderManagerId");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdBetween(String value1, String value2) {
            addCriterion("service_provider_manager_id between", value1, value2, "serviceProviderManagerId");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerIdNotBetween(String value1, String value2) {
            addCriterion("service_provider_manager_id not between", value1, value2, "serviceProviderManagerId");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameIsNull() {
            addCriterion("service_provider_manager_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameIsNotNull() {
            addCriterion("service_provider_manager_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameEqualTo(String value) {
            addCriterion("service_provider_manager_name =", value, "serviceProviderManagerName");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameNotEqualTo(String value) {
            addCriterion("service_provider_manager_name <>", value, "serviceProviderManagerName");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameGreaterThan(String value) {
            addCriterion("service_provider_manager_name >", value, "serviceProviderManagerName");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_provider_manager_name >=", value, "serviceProviderManagerName");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameLessThan(String value) {
            addCriterion("service_provider_manager_name <", value, "serviceProviderManagerName");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameLessThanOrEqualTo(String value) {
            addCriterion("service_provider_manager_name <=", value, "serviceProviderManagerName");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameLike(String value) {
            addCriterion("service_provider_manager_name like", value, "serviceProviderManagerName");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameNotLike(String value) {
            addCriterion("service_provider_manager_name not like", value, "serviceProviderManagerName");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameIn(List<String> values) {
            addCriterion("service_provider_manager_name in", values, "serviceProviderManagerName");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameNotIn(List<String> values) {
            addCriterion("service_provider_manager_name not in", values, "serviceProviderManagerName");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameBetween(String value1, String value2) {
            addCriterion("service_provider_manager_name between", value1, value2, "serviceProviderManagerName");
            return (Criteria) this;
        }

        public Criteria andServiceProviderManagerNameNotBetween(String value1, String value2) {
            addCriterion("service_provider_manager_name not between", value1, value2, "serviceProviderManagerName");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdIsNull() {
            addCriterion("group_leader_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdIsNotNull() {
            addCriterion("group_leader_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdEqualTo(String value) {
            addCriterion("group_leader_id =", value, "groupLeaderId");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdNotEqualTo(String value) {
            addCriterion("group_leader_id <>", value, "groupLeaderId");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdGreaterThan(String value) {
            addCriterion("group_leader_id >", value, "groupLeaderId");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_leader_id >=", value, "groupLeaderId");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdLessThan(String value) {
            addCriterion("group_leader_id <", value, "groupLeaderId");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdLessThanOrEqualTo(String value) {
            addCriterion("group_leader_id <=", value, "groupLeaderId");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdLike(String value) {
            addCriterion("group_leader_id like", value, "groupLeaderId");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdNotLike(String value) {
            addCriterion("group_leader_id not like", value, "groupLeaderId");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdIn(List<String> values) {
            addCriterion("group_leader_id in", values, "groupLeaderId");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdNotIn(List<String> values) {
            addCriterion("group_leader_id not in", values, "groupLeaderId");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdBetween(String value1, String value2) {
            addCriterion("group_leader_id between", value1, value2, "groupLeaderId");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderIdNotBetween(String value1, String value2) {
            addCriterion("group_leader_id not between", value1, value2, "groupLeaderId");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameIsNull() {
            addCriterion("group_leader_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameIsNotNull() {
            addCriterion("group_leader_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameEqualTo(String value) {
            addCriterion("group_leader_name =", value, "groupLeaderName");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameNotEqualTo(String value) {
            addCriterion("group_leader_name <>", value, "groupLeaderName");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameGreaterThan(String value) {
            addCriterion("group_leader_name >", value, "groupLeaderName");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_leader_name >=", value, "groupLeaderName");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameLessThan(String value) {
            addCriterion("group_leader_name <", value, "groupLeaderName");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameLessThanOrEqualTo(String value) {
            addCriterion("group_leader_name <=", value, "groupLeaderName");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameLike(String value) {
            addCriterion("group_leader_name like", value, "groupLeaderName");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameNotLike(String value) {
            addCriterion("group_leader_name not like", value, "groupLeaderName");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameIn(List<String> values) {
            addCriterion("group_leader_name in", values, "groupLeaderName");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameNotIn(List<String> values) {
            addCriterion("group_leader_name not in", values, "groupLeaderName");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameBetween(String value1, String value2) {
            addCriterion("group_leader_name between", value1, value2, "groupLeaderName");
            return (Criteria) this;
        }

        public Criteria andGroupLeaderNameNotBetween(String value1, String value2) {
            addCriterion("group_leader_name not between", value1, value2, "groupLeaderName");
            return (Criteria) this;
        }

        public Criteria andBstkdIsNull() {
            addCriterion("bstkd is null");
            return (Criteria) this;
        }

        public Criteria andBstkdIsNotNull() {
            addCriterion("bstkd is not null");
            return (Criteria) this;
        }

        public Criteria andBstkdEqualTo(String value) {
            addCriterion("bstkd =", value, "bstkd");
            return (Criteria) this;
        }

        public Criteria andBstkdNotEqualTo(String value) {
            addCriterion("bstkd <>", value, "bstkd");
            return (Criteria) this;
        }

        public Criteria andBstkdGreaterThan(String value) {
            addCriterion("bstkd >", value, "bstkd");
            return (Criteria) this;
        }

        public Criteria andBstkdGreaterThanOrEqualTo(String value) {
            addCriterion("bstkd >=", value, "bstkd");
            return (Criteria) this;
        }

        public Criteria andBstkdLessThan(String value) {
            addCriterion("bstkd <", value, "bstkd");
            return (Criteria) this;
        }

        public Criteria andBstkdLessThanOrEqualTo(String value) {
            addCriterion("bstkd <=", value, "bstkd");
            return (Criteria) this;
        }

        public Criteria andBstkdLike(String value) {
            addCriterion("bstkd like", value, "bstkd");
            return (Criteria) this;
        }

        public Criteria andBstkdNotLike(String value) {
            addCriterion("bstkd not like", value, "bstkd");
            return (Criteria) this;
        }

        public Criteria andBstkdIn(List<String> values) {
            addCriterion("bstkd in", values, "bstkd");
            return (Criteria) this;
        }

        public Criteria andBstkdNotIn(List<String> values) {
            addCriterion("bstkd not in", values, "bstkd");
            return (Criteria) this;
        }

        public Criteria andBstkdBetween(String value1, String value2) {
            addCriterion("bstkd between", value1, value2, "bstkd");
            return (Criteria) this;
        }

        public Criteria andBstkdNotBetween(String value1, String value2) {
            addCriterion("bstkd not between", value1, value2, "bstkd");
            return (Criteria) this;
        }

        public Criteria andZbstkdIsNull() {
            addCriterion("zbstkd is null");
            return (Criteria) this;
        }

        public Criteria andZbstkdIsNotNull() {
            addCriterion("zbstkd is not null");
            return (Criteria) this;
        }

        public Criteria andZbstkdEqualTo(String value) {
            addCriterion("zbstkd =", value, "zbstkd");
            return (Criteria) this;
        }

        public Criteria andZbstkdNotEqualTo(String value) {
            addCriterion("zbstkd <>", value, "zbstkd");
            return (Criteria) this;
        }

        public Criteria andZbstkdGreaterThan(String value) {
            addCriterion("zbstkd >", value, "zbstkd");
            return (Criteria) this;
        }

        public Criteria andZbstkdGreaterThanOrEqualTo(String value) {
            addCriterion("zbstkd >=", value, "zbstkd");
            return (Criteria) this;
        }

        public Criteria andZbstkdLessThan(String value) {
            addCriterion("zbstkd <", value, "zbstkd");
            return (Criteria) this;
        }

        public Criteria andZbstkdLessThanOrEqualTo(String value) {
            addCriterion("zbstkd <=", value, "zbstkd");
            return (Criteria) this;
        }

        public Criteria andZbstkdLike(String value) {
            addCriterion("zbstkd like", value, "zbstkd");
            return (Criteria) this;
        }

        public Criteria andZbstkdNotLike(String value) {
            addCriterion("zbstkd not like", value, "zbstkd");
            return (Criteria) this;
        }

        public Criteria andZbstkdIn(List<String> values) {
            addCriterion("zbstkd in", values, "zbstkd");
            return (Criteria) this;
        }

        public Criteria andZbstkdNotIn(List<String> values) {
            addCriterion("zbstkd not in", values, "zbstkd");
            return (Criteria) this;
        }

        public Criteria andZbstkdBetween(String value1, String value2) {
            addCriterion("zbstkd between", value1, value2, "zbstkd");
            return (Criteria) this;
        }

        public Criteria andZbstkdNotBetween(String value1, String value2) {
            addCriterion("zbstkd not between", value1, value2, "zbstkd");
            return (Criteria) this;
        }

        public Criteria andMallDataIsNull() {
            addCriterion("mall_data is null");
            return (Criteria) this;
        }

        public Criteria andMallDataIsNotNull() {
            addCriterion("mall_data is not null");
            return (Criteria) this;
        }

        public Criteria andMallDataEqualTo(String value) {
            addCriterion("mall_data =", value, "mallData");
            return (Criteria) this;
        }

        public Criteria andMallDataNotEqualTo(String value) {
            addCriterion("mall_data <>", value, "mallData");
            return (Criteria) this;
        }

        public Criteria andMallDataGreaterThan(String value) {
            addCriterion("mall_data >", value, "mallData");
            return (Criteria) this;
        }

        public Criteria andMallDataGreaterThanOrEqualTo(String value) {
            addCriterion("mall_data >=", value, "mallData");
            return (Criteria) this;
        }

        public Criteria andMallDataLessThan(String value) {
            addCriterion("mall_data <", value, "mallData");
            return (Criteria) this;
        }

        public Criteria andMallDataLessThanOrEqualTo(String value) {
            addCriterion("mall_data <=", value, "mallData");
            return (Criteria) this;
        }

        public Criteria andMallDataLike(String value) {
            addCriterion("mall_data like", value, "mallData");
            return (Criteria) this;
        }

        public Criteria andMallDataNotLike(String value) {
            addCriterion("mall_data not like", value, "mallData");
            return (Criteria) this;
        }

        public Criteria andMallDataIn(List<String> values) {
            addCriterion("mall_data in", values, "mallData");
            return (Criteria) this;
        }

        public Criteria andMallDataNotIn(List<String> values) {
            addCriterion("mall_data not in", values, "mallData");
            return (Criteria) this;
        }

        public Criteria andMallDataBetween(String value1, String value2) {
            addCriterion("mall_data between", value1, value2, "mallData");
            return (Criteria) this;
        }

        public Criteria andMallDataNotBetween(String value1, String value2) {
            addCriterion("mall_data not between", value1, value2, "mallData");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Byte value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Byte value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Byte value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Byte value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Byte> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Byte> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
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