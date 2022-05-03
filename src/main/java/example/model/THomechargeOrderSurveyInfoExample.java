package example.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class THomechargeOrderSurveyInfoExample {
    /**
     */
    protected String orderByClause;

    /**
     */
    protected boolean distinct;

    /**
     */
    protected List<Criteria> oredCriteria;

    public THomechargeOrderSurveyInfoExample() {
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

        public Criteria andHomechargeOrderIdIsNull() {
            addCriterion("homecharge_order_id is null");
            return (Criteria) this;
        }

        public Criteria andHomechargeOrderIdIsNotNull() {
            addCriterion("homecharge_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andHomechargeOrderIdEqualTo(Long value) {
            addCriterion("homecharge_order_id =", value, "homechargeOrderId");
            return (Criteria) this;
        }

        public Criteria andHomechargeOrderIdNotEqualTo(Long value) {
            addCriterion("homecharge_order_id <>", value, "homechargeOrderId");
            return (Criteria) this;
        }

        public Criteria andHomechargeOrderIdGreaterThan(Long value) {
            addCriterion("homecharge_order_id >", value, "homechargeOrderId");
            return (Criteria) this;
        }

        public Criteria andHomechargeOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("homecharge_order_id >=", value, "homechargeOrderId");
            return (Criteria) this;
        }

        public Criteria andHomechargeOrderIdLessThan(Long value) {
            addCriterion("homecharge_order_id <", value, "homechargeOrderId");
            return (Criteria) this;
        }

        public Criteria andHomechargeOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("homecharge_order_id <=", value, "homechargeOrderId");
            return (Criteria) this;
        }

        public Criteria andHomechargeOrderIdIn(List<Long> values) {
            addCriterion("homecharge_order_id in", values, "homechargeOrderId");
            return (Criteria) this;
        }

        public Criteria andHomechargeOrderIdNotIn(List<Long> values) {
            addCriterion("homecharge_order_id not in", values, "homechargeOrderId");
            return (Criteria) this;
        }

        public Criteria andHomechargeOrderIdBetween(Long value1, Long value2) {
            addCriterion("homecharge_order_id between", value1, value2, "homechargeOrderId");
            return (Criteria) this;
        }

        public Criteria andHomechargeOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("homecharge_order_id not between", value1, value2, "homechargeOrderId");
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

        public Criteria andCommunityNameIsNull() {
            addCriterion("community_name is null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNotNull() {
            addCriterion("community_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameEqualTo(String value) {
            addCriterion("community_name =", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotEqualTo(String value) {
            addCriterion("community_name <>", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThan(String value) {
            addCriterion("community_name >", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThanOrEqualTo(String value) {
            addCriterion("community_name >=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThan(String value) {
            addCriterion("community_name <", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThanOrEqualTo(String value) {
            addCriterion("community_name <=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLike(String value) {
            addCriterion("community_name like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotLike(String value) {
            addCriterion("community_name not like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIn(List<String> values) {
            addCriterion("community_name in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotIn(List<String> values) {
            addCriterion("community_name not in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameBetween(String value1, String value2) {
            addCriterion("community_name between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotBetween(String value1, String value2) {
            addCriterion("community_name not between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andPowerTypeIsNull() {
            addCriterion("power_type is null");
            return (Criteria) this;
        }

        public Criteria andPowerTypeIsNotNull() {
            addCriterion("power_type is not null");
            return (Criteria) this;
        }

        public Criteria andPowerTypeEqualTo(Byte value) {
            addCriterion("power_type =", value, "powerType");
            return (Criteria) this;
        }

        public Criteria andPowerTypeNotEqualTo(Byte value) {
            addCriterion("power_type <>", value, "powerType");
            return (Criteria) this;
        }

        public Criteria andPowerTypeGreaterThan(Byte value) {
            addCriterion("power_type >", value, "powerType");
            return (Criteria) this;
        }

        public Criteria andPowerTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("power_type >=", value, "powerType");
            return (Criteria) this;
        }

        public Criteria andPowerTypeLessThan(Byte value) {
            addCriterion("power_type <", value, "powerType");
            return (Criteria) this;
        }

        public Criteria andPowerTypeLessThanOrEqualTo(Byte value) {
            addCriterion("power_type <=", value, "powerType");
            return (Criteria) this;
        }

        public Criteria andPowerTypeIn(List<Byte> values) {
            addCriterion("power_type in", values, "powerType");
            return (Criteria) this;
        }

        public Criteria andPowerTypeNotIn(List<Byte> values) {
            addCriterion("power_type not in", values, "powerType");
            return (Criteria) this;
        }

        public Criteria andPowerTypeBetween(Byte value1, Byte value2) {
            addCriterion("power_type between", value1, value2, "powerType");
            return (Criteria) this;
        }

        public Criteria andPowerTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("power_type not between", value1, value2, "powerType");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementAttitudeIsNull() {
            addCriterion("property_management_attitude is null");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementAttitudeIsNotNull() {
            addCriterion("property_management_attitude is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementAttitudeEqualTo(Byte value) {
            addCriterion("property_management_attitude =", value, "propertyManagementAttitude");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementAttitudeNotEqualTo(Byte value) {
            addCriterion("property_management_attitude <>", value, "propertyManagementAttitude");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementAttitudeGreaterThan(Byte value) {
            addCriterion("property_management_attitude >", value, "propertyManagementAttitude");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementAttitudeGreaterThanOrEqualTo(Byte value) {
            addCriterion("property_management_attitude >=", value, "propertyManagementAttitude");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementAttitudeLessThan(Byte value) {
            addCriterion("property_management_attitude <", value, "propertyManagementAttitude");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementAttitudeLessThanOrEqualTo(Byte value) {
            addCriterion("property_management_attitude <=", value, "propertyManagementAttitude");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementAttitudeIn(List<Byte> values) {
            addCriterion("property_management_attitude in", values, "propertyManagementAttitude");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementAttitudeNotIn(List<Byte> values) {
            addCriterion("property_management_attitude not in", values, "propertyManagementAttitude");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementAttitudeBetween(Byte value1, Byte value2) {
            addCriterion("property_management_attitude between", value1, value2, "propertyManagementAttitude");
            return (Criteria) this;
        }

        public Criteria andPropertyManagementAttitudeNotBetween(Byte value1, Byte value2) {
            addCriterion("property_management_attitude not between", value1, value2, "propertyManagementAttitude");
            return (Criteria) this;
        }

        public Criteria andNeedInstallPostIsNull() {
            addCriterion("need_install_post is null");
            return (Criteria) this;
        }

        public Criteria andNeedInstallPostIsNotNull() {
            addCriterion("need_install_post is not null");
            return (Criteria) this;
        }

        public Criteria andNeedInstallPostEqualTo(Byte value) {
            addCriterion("need_install_post =", value, "needInstallPost");
            return (Criteria) this;
        }

        public Criteria andNeedInstallPostNotEqualTo(Byte value) {
            addCriterion("need_install_post <>", value, "needInstallPost");
            return (Criteria) this;
        }

        public Criteria andNeedInstallPostGreaterThan(Byte value) {
            addCriterion("need_install_post >", value, "needInstallPost");
            return (Criteria) this;
        }

        public Criteria andNeedInstallPostGreaterThanOrEqualTo(Byte value) {
            addCriterion("need_install_post >=", value, "needInstallPost");
            return (Criteria) this;
        }

        public Criteria andNeedInstallPostLessThan(Byte value) {
            addCriterion("need_install_post <", value, "needInstallPost");
            return (Criteria) this;
        }

        public Criteria andNeedInstallPostLessThanOrEqualTo(Byte value) {
            addCriterion("need_install_post <=", value, "needInstallPost");
            return (Criteria) this;
        }

        public Criteria andNeedInstallPostIn(List<Byte> values) {
            addCriterion("need_install_post in", values, "needInstallPost");
            return (Criteria) this;
        }

        public Criteria andNeedInstallPostNotIn(List<Byte> values) {
            addCriterion("need_install_post not in", values, "needInstallPost");
            return (Criteria) this;
        }

        public Criteria andNeedInstallPostBetween(Byte value1, Byte value2) {
            addCriterion("need_install_post between", value1, value2, "needInstallPost");
            return (Criteria) this;
        }

        public Criteria andNeedInstallPostNotBetween(Byte value1, Byte value2) {
            addCriterion("need_install_post not between", value1, value2, "needInstallPost");
            return (Criteria) this;
        }

        public Criteria andPowerInstallApplicationIsNull() {
            addCriterion("power_install_application is null");
            return (Criteria) this;
        }

        public Criteria andPowerInstallApplicationIsNotNull() {
            addCriterion("power_install_application is not null");
            return (Criteria) this;
        }

        public Criteria andPowerInstallApplicationEqualTo(Byte value) {
            addCriterion("power_install_application =", value, "powerInstallApplication");
            return (Criteria) this;
        }

        public Criteria andPowerInstallApplicationNotEqualTo(Byte value) {
            addCriterion("power_install_application <>", value, "powerInstallApplication");
            return (Criteria) this;
        }

        public Criteria andPowerInstallApplicationGreaterThan(Byte value) {
            addCriterion("power_install_application >", value, "powerInstallApplication");
            return (Criteria) this;
        }

        public Criteria andPowerInstallApplicationGreaterThanOrEqualTo(Byte value) {
            addCriterion("power_install_application >=", value, "powerInstallApplication");
            return (Criteria) this;
        }

        public Criteria andPowerInstallApplicationLessThan(Byte value) {
            addCriterion("power_install_application <", value, "powerInstallApplication");
            return (Criteria) this;
        }

        public Criteria andPowerInstallApplicationLessThanOrEqualTo(Byte value) {
            addCriterion("power_install_application <=", value, "powerInstallApplication");
            return (Criteria) this;
        }

        public Criteria andPowerInstallApplicationIn(List<Byte> values) {
            addCriterion("power_install_application in", values, "powerInstallApplication");
            return (Criteria) this;
        }

        public Criteria andPowerInstallApplicationNotIn(List<Byte> values) {
            addCriterion("power_install_application not in", values, "powerInstallApplication");
            return (Criteria) this;
        }

        public Criteria andPowerInstallApplicationBetween(Byte value1, Byte value2) {
            addCriterion("power_install_application between", value1, value2, "powerInstallApplication");
            return (Criteria) this;
        }

        public Criteria andPowerInstallApplicationNotBetween(Byte value1, Byte value2) {
            addCriterion("power_install_application not between", value1, value2, "powerInstallApplication");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthIsNull() {
            addCriterion("predict_cable_length is null");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthIsNotNull() {
            addCriterion("predict_cable_length is not null");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthEqualTo(String value) {
            addCriterion("predict_cable_length =", value, "predictCableLength");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthNotEqualTo(String value) {
            addCriterion("predict_cable_length <>", value, "predictCableLength");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthGreaterThan(String value) {
            addCriterion("predict_cable_length >", value, "predictCableLength");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthGreaterThanOrEqualTo(String value) {
            addCriterion("predict_cable_length >=", value, "predictCableLength");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthLessThan(String value) {
            addCriterion("predict_cable_length <", value, "predictCableLength");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthLessThanOrEqualTo(String value) {
            addCriterion("predict_cable_length <=", value, "predictCableLength");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthLike(String value) {
            addCriterion("predict_cable_length like", value, "predictCableLength");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthNotLike(String value) {
            addCriterion("predict_cable_length not like", value, "predictCableLength");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthIn(List<String> values) {
            addCriterion("predict_cable_length in", values, "predictCableLength");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthNotIn(List<String> values) {
            addCriterion("predict_cable_length not in", values, "predictCableLength");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthBetween(String value1, String value2) {
            addCriterion("predict_cable_length between", value1, value2, "predictCableLength");
            return (Criteria) this;
        }

        public Criteria andPredictCableLengthNotBetween(String value1, String value2) {
            addCriterion("predict_cable_length not between", value1, value2, "predictCableLength");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthIsNull() {
            addCriterion("real_cable_length is null");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthIsNotNull() {
            addCriterion("real_cable_length is not null");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthEqualTo(String value) {
            addCriterion("real_cable_length =", value, "realCableLength");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthNotEqualTo(String value) {
            addCriterion("real_cable_length <>", value, "realCableLength");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthGreaterThan(String value) {
            addCriterion("real_cable_length >", value, "realCableLength");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthGreaterThanOrEqualTo(String value) {
            addCriterion("real_cable_length >=", value, "realCableLength");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthLessThan(String value) {
            addCriterion("real_cable_length <", value, "realCableLength");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthLessThanOrEqualTo(String value) {
            addCriterion("real_cable_length <=", value, "realCableLength");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthLike(String value) {
            addCriterion("real_cable_length like", value, "realCableLength");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthNotLike(String value) {
            addCriterion("real_cable_length not like", value, "realCableLength");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthIn(List<String> values) {
            addCriterion("real_cable_length in", values, "realCableLength");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthNotIn(List<String> values) {
            addCriterion("real_cable_length not in", values, "realCableLength");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthBetween(String value1, String value2) {
            addCriterion("real_cable_length between", value1, value2, "realCableLength");
            return (Criteria) this;
        }

        public Criteria andRealCableLengthNotBetween(String value1, String value2) {
            addCriterion("real_cable_length not between", value1, value2, "realCableLength");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeIsNull() {
            addCriterion("charge_pile_code is null");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeIsNotNull() {
            addCriterion("charge_pile_code is not null");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeEqualTo(String value) {
            addCriterion("charge_pile_code =", value, "chargePileCode");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeNotEqualTo(String value) {
            addCriterion("charge_pile_code <>", value, "chargePileCode");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeGreaterThan(String value) {
            addCriterion("charge_pile_code >", value, "chargePileCode");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeGreaterThanOrEqualTo(String value) {
            addCriterion("charge_pile_code >=", value, "chargePileCode");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeLessThan(String value) {
            addCriterion("charge_pile_code <", value, "chargePileCode");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeLessThanOrEqualTo(String value) {
            addCriterion("charge_pile_code <=", value, "chargePileCode");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeLike(String value) {
            addCriterion("charge_pile_code like", value, "chargePileCode");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeNotLike(String value) {
            addCriterion("charge_pile_code not like", value, "chargePileCode");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeIn(List<String> values) {
            addCriterion("charge_pile_code in", values, "chargePileCode");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeNotIn(List<String> values) {
            addCriterion("charge_pile_code not in", values, "chargePileCode");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeBetween(String value1, String value2) {
            addCriterion("charge_pile_code between", value1, value2, "chargePileCode");
            return (Criteria) this;
        }

        public Criteria andChargePileCodeNotBetween(String value1, String value2) {
            addCriterion("charge_pile_code not between", value1, value2, "chargePileCode");
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

        public Criteria andFeeDescIsNull() {
            addCriterion("fee_desc is null");
            return (Criteria) this;
        }

        public Criteria andFeeDescIsNotNull() {
            addCriterion("fee_desc is not null");
            return (Criteria) this;
        }

        public Criteria andFeeDescEqualTo(String value) {
            addCriterion("fee_desc =", value, "feeDesc");
            return (Criteria) this;
        }

        public Criteria andFeeDescNotEqualTo(String value) {
            addCriterion("fee_desc <>", value, "feeDesc");
            return (Criteria) this;
        }

        public Criteria andFeeDescGreaterThan(String value) {
            addCriterion("fee_desc >", value, "feeDesc");
            return (Criteria) this;
        }

        public Criteria andFeeDescGreaterThanOrEqualTo(String value) {
            addCriterion("fee_desc >=", value, "feeDesc");
            return (Criteria) this;
        }

        public Criteria andFeeDescLessThan(String value) {
            addCriterion("fee_desc <", value, "feeDesc");
            return (Criteria) this;
        }

        public Criteria andFeeDescLessThanOrEqualTo(String value) {
            addCriterion("fee_desc <=", value, "feeDesc");
            return (Criteria) this;
        }

        public Criteria andFeeDescLike(String value) {
            addCriterion("fee_desc like", value, "feeDesc");
            return (Criteria) this;
        }

        public Criteria andFeeDescNotLike(String value) {
            addCriterion("fee_desc not like", value, "feeDesc");
            return (Criteria) this;
        }

        public Criteria andFeeDescIn(List<String> values) {
            addCriterion("fee_desc in", values, "feeDesc");
            return (Criteria) this;
        }

        public Criteria andFeeDescNotIn(List<String> values) {
            addCriterion("fee_desc not in", values, "feeDesc");
            return (Criteria) this;
        }

        public Criteria andFeeDescBetween(String value1, String value2) {
            addCriterion("fee_desc between", value1, value2, "feeDesc");
            return (Criteria) this;
        }

        public Criteria andFeeDescNotBetween(String value1, String value2) {
            addCriterion("fee_desc not between", value1, value2, "feeDesc");
            return (Criteria) this;
        }

        public Criteria andPredictIntallFeeIsNull() {
            addCriterion("predict_intall_fee is null");
            return (Criteria) this;
        }

        public Criteria andPredictIntallFeeIsNotNull() {
            addCriterion("predict_intall_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPredictIntallFeeEqualTo(BigDecimal value) {
            addCriterion("predict_intall_fee =", value, "predictIntallFee");
            return (Criteria) this;
        }

        public Criteria andPredictIntallFeeNotEqualTo(BigDecimal value) {
            addCriterion("predict_intall_fee <>", value, "predictIntallFee");
            return (Criteria) this;
        }

        public Criteria andPredictIntallFeeGreaterThan(BigDecimal value) {
            addCriterion("predict_intall_fee >", value, "predictIntallFee");
            return (Criteria) this;
        }

        public Criteria andPredictIntallFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("predict_intall_fee >=", value, "predictIntallFee");
            return (Criteria) this;
        }

        public Criteria andPredictIntallFeeLessThan(BigDecimal value) {
            addCriterion("predict_intall_fee <", value, "predictIntallFee");
            return (Criteria) this;
        }

        public Criteria andPredictIntallFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("predict_intall_fee <=", value, "predictIntallFee");
            return (Criteria) this;
        }

        public Criteria andPredictIntallFeeIn(List<BigDecimal> values) {
            addCriterion("predict_intall_fee in", values, "predictIntallFee");
            return (Criteria) this;
        }

        public Criteria andPredictIntallFeeNotIn(List<BigDecimal> values) {
            addCriterion("predict_intall_fee not in", values, "predictIntallFee");
            return (Criteria) this;
        }

        public Criteria andPredictIntallFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("predict_intall_fee between", value1, value2, "predictIntallFee");
            return (Criteria) this;
        }

        public Criteria andPredictIntallFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("predict_intall_fee not between", value1, value2, "predictIntallFee");
            return (Criteria) this;
        }

        public Criteria andRealInstallFeeIsNull() {
            addCriterion("real_install_fee is null");
            return (Criteria) this;
        }

        public Criteria andRealInstallFeeIsNotNull() {
            addCriterion("real_install_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRealInstallFeeEqualTo(BigDecimal value) {
            addCriterion("real_install_fee =", value, "realInstallFee");
            return (Criteria) this;
        }

        public Criteria andRealInstallFeeNotEqualTo(BigDecimal value) {
            addCriterion("real_install_fee <>", value, "realInstallFee");
            return (Criteria) this;
        }

        public Criteria andRealInstallFeeGreaterThan(BigDecimal value) {
            addCriterion("real_install_fee >", value, "realInstallFee");
            return (Criteria) this;
        }

        public Criteria andRealInstallFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_install_fee >=", value, "realInstallFee");
            return (Criteria) this;
        }

        public Criteria andRealInstallFeeLessThan(BigDecimal value) {
            addCriterion("real_install_fee <", value, "realInstallFee");
            return (Criteria) this;
        }

        public Criteria andRealInstallFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_install_fee <=", value, "realInstallFee");
            return (Criteria) this;
        }

        public Criteria andRealInstallFeeIn(List<BigDecimal> values) {
            addCriterion("real_install_fee in", values, "realInstallFee");
            return (Criteria) this;
        }

        public Criteria andRealInstallFeeNotIn(List<BigDecimal> values) {
            addCriterion("real_install_fee not in", values, "realInstallFee");
            return (Criteria) this;
        }

        public Criteria andRealInstallFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_install_fee between", value1, value2, "realInstallFee");
            return (Criteria) this;
        }

        public Criteria andRealInstallFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_install_fee not between", value1, value2, "realInstallFee");
            return (Criteria) this;
        }

        public Criteria andProcessDescIsNull() {
            addCriterion("process_desc is null");
            return (Criteria) this;
        }

        public Criteria andProcessDescIsNotNull() {
            addCriterion("process_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProcessDescEqualTo(String value) {
            addCriterion("process_desc =", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotEqualTo(String value) {
            addCriterion("process_desc <>", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescGreaterThan(String value) {
            addCriterion("process_desc >", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescGreaterThanOrEqualTo(String value) {
            addCriterion("process_desc >=", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescLessThan(String value) {
            addCriterion("process_desc <", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescLessThanOrEqualTo(String value) {
            addCriterion("process_desc <=", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescLike(String value) {
            addCriterion("process_desc like", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotLike(String value) {
            addCriterion("process_desc not like", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescIn(List<String> values) {
            addCriterion("process_desc in", values, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotIn(List<String> values) {
            addCriterion("process_desc not in", values, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescBetween(String value1, String value2) {
            addCriterion("process_desc between", value1, value2, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotBetween(String value1, String value2) {
            addCriterion("process_desc not between", value1, value2, "processDesc");
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