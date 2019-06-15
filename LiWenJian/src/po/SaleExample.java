package edu.cuit.gcsj.po;

import java.util.ArrayList;
import java.util.List;

public class SaleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SaleExample() {
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
            addCriterion("id >=", value, "id");
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

        public Criteria andYearmonthIsNull() {
            addCriterion("yearmonth is null");
            return (Criteria) this;
        }

        public Criteria andYearmonthIsNotNull() {
            addCriterion("yearmonth is not null");
            return (Criteria) this;
        }

        public Criteria andYearmonthEqualTo(String value) {
            addCriterion("yearmonth =", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthNotEqualTo(String value) {
            addCriterion("yearmonth <>", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthGreaterThan(String value) {
            addCriterion("yearmonth >", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthGreaterThanOrEqualTo(String value) {
            addCriterion("yearmonth >=", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthLessThan(String value) {
            addCriterion("yearmonth <", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthLessThanOrEqualTo(String value) {
            addCriterion("yearmonth <=", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthLike(String value) {
            addCriterion("yearmonth like", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthNotLike(String value) {
            addCriterion("yearmonth not like", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthIn(List<String> values) {
            addCriterion("yearmonth in", values, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthNotIn(List<String> values) {
            addCriterion("yearmonth not in", values, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthBetween(String value1, String value2) {
            addCriterion("yearmonth between", value1, value2, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthNotBetween(String value1, String value2) {
            addCriterion("yearmonth not between", value1, value2, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andHubTypeIsNull() {
            addCriterion("hub_type is null");
            return (Criteria) this;
        }

        public Criteria andHubTypeIsNotNull() {
            addCriterion("hub_type is not null");
            return (Criteria) this;
        }

        public Criteria andHubTypeEqualTo(String value) {
            addCriterion("hub_type =", value, "hubType");
            return (Criteria) this;
        }

        public Criteria andHubTypeNotEqualTo(String value) {
            addCriterion("hub_type <>", value, "hubType");
            return (Criteria) this;
        }

        public Criteria andHubTypeGreaterThan(String value) {
            addCriterion("hub_type >", value, "hubType");
            return (Criteria) this;
        }

        public Criteria andHubTypeGreaterThanOrEqualTo(String value) {
            addCriterion("hub_type >=", value, "hubType");
            return (Criteria) this;
        }

        public Criteria andHubTypeLessThan(String value) {
            addCriterion("hub_type <", value, "hubType");
            return (Criteria) this;
        }

        public Criteria andHubTypeLessThanOrEqualTo(String value) {
            addCriterion("hub_type <=", value, "hubType");
            return (Criteria) this;
        }

        public Criteria andHubTypeLike(String value) {
            addCriterion("hub_type like", value, "hubType");
            return (Criteria) this;
        }

        public Criteria andHubTypeNotLike(String value) {
            addCriterion("hub_type not like", value, "hubType");
            return (Criteria) this;
        }

        public Criteria andHubTypeIn(List<String> values) {
            addCriterion("hub_type in", values, "hubType");
            return (Criteria) this;
        }

        public Criteria andHubTypeNotIn(List<String> values) {
            addCriterion("hub_type not in", values, "hubType");
            return (Criteria) this;
        }

        public Criteria andHubTypeBetween(String value1, String value2) {
            addCriterion("hub_type between", value1, value2, "hubType");
            return (Criteria) this;
        }

        public Criteria andHubTypeNotBetween(String value1, String value2) {
            addCriterion("hub_type not between", value1, value2, "hubType");
            return (Criteria) this;
        }

        public Criteria andStoreSeqIsNull() {
            addCriterion("store_seq is null");
            return (Criteria) this;
        }

        public Criteria andStoreSeqIsNotNull() {
            addCriterion("store_seq is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSeqEqualTo(String value) {
            addCriterion("store_seq =", value, "storeSeq");
            return (Criteria) this;
        }

        public Criteria andStoreSeqNotEqualTo(String value) {
            addCriterion("store_seq <>", value, "storeSeq");
            return (Criteria) this;
        }

        public Criteria andStoreSeqGreaterThan(String value) {
            addCriterion("store_seq >", value, "storeSeq");
            return (Criteria) this;
        }

        public Criteria andStoreSeqGreaterThanOrEqualTo(String value) {
            addCriterion("store_seq >=", value, "storeSeq");
            return (Criteria) this;
        }

        public Criteria andStoreSeqLessThan(String value) {
            addCriterion("store_seq <", value, "storeSeq");
            return (Criteria) this;
        }

        public Criteria andStoreSeqLessThanOrEqualTo(String value) {
            addCriterion("store_seq <=", value, "storeSeq");
            return (Criteria) this;
        }

        public Criteria andStoreSeqLike(String value) {
            addCriterion("store_seq like", value, "storeSeq");
            return (Criteria) this;
        }

        public Criteria andStoreSeqNotLike(String value) {
            addCriterion("store_seq not like", value, "storeSeq");
            return (Criteria) this;
        }

        public Criteria andStoreSeqIn(List<String> values) {
            addCriterion("store_seq in", values, "storeSeq");
            return (Criteria) this;
        }

        public Criteria andStoreSeqNotIn(List<String> values) {
            addCriterion("store_seq not in", values, "storeSeq");
            return (Criteria) this;
        }

        public Criteria andStoreSeqBetween(String value1, String value2) {
            addCriterion("store_seq between", value1, value2, "storeSeq");
            return (Criteria) this;
        }

        public Criteria andStoreSeqNotBetween(String value1, String value2) {
            addCriterion("store_seq not between", value1, value2, "storeSeq");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeIsNull() {
            addCriterion("local_channel_type is null");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeIsNotNull() {
            addCriterion("local_channel_type is not null");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeEqualTo(String value) {
            addCriterion("local_channel_type =", value, "localChannelType");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeNotEqualTo(String value) {
            addCriterion("local_channel_type <>", value, "localChannelType");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeGreaterThan(String value) {
            addCriterion("local_channel_type >", value, "localChannelType");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("local_channel_type >=", value, "localChannelType");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeLessThan(String value) {
            addCriterion("local_channel_type <", value, "localChannelType");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeLessThanOrEqualTo(String value) {
            addCriterion("local_channel_type <=", value, "localChannelType");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeLike(String value) {
            addCriterion("local_channel_type like", value, "localChannelType");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeNotLike(String value) {
            addCriterion("local_channel_type not like", value, "localChannelType");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeIn(List<String> values) {
            addCriterion("local_channel_type in", values, "localChannelType");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeNotIn(List<String> values) {
            addCriterion("local_channel_type not in", values, "localChannelType");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeBetween(String value1, String value2) {
            addCriterion("local_channel_type between", value1, value2, "localChannelType");
            return (Criteria) this;
        }

        public Criteria andLocalChannelTypeNotBetween(String value1, String value2) {
            addCriterion("local_channel_type not between", value1, value2, "localChannelType");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeIsNull() {
            addCriterion("local_store_type is null");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeIsNotNull() {
            addCriterion("local_store_type is not null");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeEqualTo(String value) {
            addCriterion("local_store_type =", value, "localStoreType");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeNotEqualTo(String value) {
            addCriterion("local_store_type <>", value, "localStoreType");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeGreaterThan(String value) {
            addCriterion("local_store_type >", value, "localStoreType");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeGreaterThanOrEqualTo(String value) {
            addCriterion("local_store_type >=", value, "localStoreType");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeLessThan(String value) {
            addCriterion("local_store_type <", value, "localStoreType");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeLessThanOrEqualTo(String value) {
            addCriterion("local_store_type <=", value, "localStoreType");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeLike(String value) {
            addCriterion("local_store_type like", value, "localStoreType");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeNotLike(String value) {
            addCriterion("local_store_type not like", value, "localStoreType");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeIn(List<String> values) {
            addCriterion("local_store_type in", values, "localStoreType");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeNotIn(List<String> values) {
            addCriterion("local_store_type not in", values, "localStoreType");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeBetween(String value1, String value2) {
            addCriterion("local_store_type between", value1, value2, "localStoreType");
            return (Criteria) this;
        }

        public Criteria andLocalStoreTypeNotBetween(String value1, String value2) {
            addCriterion("local_store_type not between", value1, value2, "localStoreType");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagIsNull() {
            addCriterion("golden_store_flag is null");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagIsNotNull() {
            addCriterion("golden_store_flag is not null");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagEqualTo(String value) {
            addCriterion("golden_store_flag =", value, "goldenStoreFlag");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagNotEqualTo(String value) {
            addCriterion("golden_store_flag <>", value, "goldenStoreFlag");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagGreaterThan(String value) {
            addCriterion("golden_store_flag >", value, "goldenStoreFlag");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagGreaterThanOrEqualTo(String value) {
            addCriterion("golden_store_flag >=", value, "goldenStoreFlag");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagLessThan(String value) {
            addCriterion("golden_store_flag <", value, "goldenStoreFlag");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagLessThanOrEqualTo(String value) {
            addCriterion("golden_store_flag <=", value, "goldenStoreFlag");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagLike(String value) {
            addCriterion("golden_store_flag like", value, "goldenStoreFlag");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagNotLike(String value) {
            addCriterion("golden_store_flag not like", value, "goldenStoreFlag");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagIn(List<String> values) {
            addCriterion("golden_store_flag in", values, "goldenStoreFlag");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagNotIn(List<String> values) {
            addCriterion("golden_store_flag not in", values, "goldenStoreFlag");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagBetween(String value1, String value2) {
            addCriterion("golden_store_flag between", value1, value2, "goldenStoreFlag");
            return (Criteria) this;
        }

        public Criteria andGoldenStoreFlagNotBetween(String value1, String value2) {
            addCriterion("golden_store_flag not between", value1, value2, "goldenStoreFlag");
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

        public Criteria andTownIsNull() {
            addCriterion("town is null");
            return (Criteria) this;
        }

        public Criteria andTownIsNotNull() {
            addCriterion("town is not null");
            return (Criteria) this;
        }

        public Criteria andTownEqualTo(String value) {
            addCriterion("town =", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotEqualTo(String value) {
            addCriterion("town <>", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThan(String value) {
            addCriterion("town >", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThanOrEqualTo(String value) {
            addCriterion("town >=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThan(String value) {
            addCriterion("town <", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThanOrEqualTo(String value) {
            addCriterion("town <=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLike(String value) {
            addCriterion("town like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotLike(String value) {
            addCriterion("town not like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownIn(List<String> values) {
            addCriterion("town in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotIn(List<String> values) {
            addCriterion("town not in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownBetween(String value1, String value2) {
            addCriterion("town between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotBetween(String value1, String value2) {
            addCriterion("town not between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andCityLevelIsNull() {
            addCriterion("city_level is null");
            return (Criteria) this;
        }

        public Criteria andCityLevelIsNotNull() {
            addCriterion("city_level is not null");
            return (Criteria) this;
        }

        public Criteria andCityLevelEqualTo(String value) {
            addCriterion("city_level =", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelNotEqualTo(String value) {
            addCriterion("city_level <>", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelGreaterThan(String value) {
            addCriterion("city_level >", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelGreaterThanOrEqualTo(String value) {
            addCriterion("city_level >=", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelLessThan(String value) {
            addCriterion("city_level <", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelLessThanOrEqualTo(String value) {
            addCriterion("city_level <=", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelLike(String value) {
            addCriterion("city_level like", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelNotLike(String value) {
            addCriterion("city_level not like", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelIn(List<String> values) {
            addCriterion("city_level in", values, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelNotIn(List<String> values) {
            addCriterion("city_level not in", values, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelBetween(String value1, String value2) {
            addCriterion("city_level between", value1, value2, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelNotBetween(String value1, String value2) {
            addCriterion("city_level not between", value1, value2, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNull() {
            addCriterion("item_code is null");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNotNull() {
            addCriterion("item_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemCodeEqualTo(String value) {
            addCriterion("item_code =", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotEqualTo(String value) {
            addCriterion("item_code <>", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThan(String value) {
            addCriterion("item_code >", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_code >=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThan(String value) {
            addCriterion("item_code <", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThanOrEqualTo(String value) {
            addCriterion("item_code <=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLike(String value) {
            addCriterion("item_code like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotLike(String value) {
            addCriterion("item_code not like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeIn(List<String> values) {
            addCriterion("item_code in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotIn(List<String> values) {
            addCriterion("item_code not in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeBetween(String value1, String value2) {
            addCriterion("item_code between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotBetween(String value1, String value2) {
            addCriterion("item_code not between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameIsNull() {
            addCriterion("product_chinese_name is null");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameIsNotNull() {
            addCriterion("product_chinese_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameEqualTo(String value) {
            addCriterion("product_chinese_name =", value, "productChineseName");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameNotEqualTo(String value) {
            addCriterion("product_chinese_name <>", value, "productChineseName");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameGreaterThan(String value) {
            addCriterion("product_chinese_name >", value, "productChineseName");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_chinese_name >=", value, "productChineseName");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameLessThan(String value) {
            addCriterion("product_chinese_name <", value, "productChineseName");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameLessThanOrEqualTo(String value) {
            addCriterion("product_chinese_name <=", value, "productChineseName");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameLike(String value) {
            addCriterion("product_chinese_name like", value, "productChineseName");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameNotLike(String value) {
            addCriterion("product_chinese_name not like", value, "productChineseName");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameIn(List<String> values) {
            addCriterion("product_chinese_name in", values, "productChineseName");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameNotIn(List<String> values) {
            addCriterion("product_chinese_name not in", values, "productChineseName");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameBetween(String value1, String value2) {
            addCriterion("product_chinese_name between", value1, value2, "productChineseName");
            return (Criteria) this;
        }

        public Criteria andProductChineseNameNotBetween(String value1, String value2) {
            addCriterion("product_chinese_name not between", value1, value2, "productChineseName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andTierNameIsNull() {
            addCriterion("tier_name is null");
            return (Criteria) this;
        }

        public Criteria andTierNameIsNotNull() {
            addCriterion("tier_name is not null");
            return (Criteria) this;
        }

        public Criteria andTierNameEqualTo(String value) {
            addCriterion("tier_name =", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameNotEqualTo(String value) {
            addCriterion("tier_name <>", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameGreaterThan(String value) {
            addCriterion("tier_name >", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameGreaterThanOrEqualTo(String value) {
            addCriterion("tier_name >=", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameLessThan(String value) {
            addCriterion("tier_name <", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameLessThanOrEqualTo(String value) {
            addCriterion("tier_name <=", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameLike(String value) {
            addCriterion("tier_name like", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameNotLike(String value) {
            addCriterion("tier_name not like", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameIn(List<String> values) {
            addCriterion("tier_name in", values, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameNotIn(List<String> values) {
            addCriterion("tier_name not in", values, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameBetween(String value1, String value2) {
            addCriterion("tier_name between", value1, value2, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameNotBetween(String value1, String value2) {
            addCriterion("tier_name not between", value1, value2, "tierName");
            return (Criteria) this;
        }

        public Criteria andVariantNameIsNull() {
            addCriterion("variant_name is null");
            return (Criteria) this;
        }

        public Criteria andVariantNameIsNotNull() {
            addCriterion("variant_name is not null");
            return (Criteria) this;
        }

        public Criteria andVariantNameEqualTo(String value) {
            addCriterion("variant_name =", value, "variantName");
            return (Criteria) this;
        }

        public Criteria andVariantNameNotEqualTo(String value) {
            addCriterion("variant_name <>", value, "variantName");
            return (Criteria) this;
        }

        public Criteria andVariantNameGreaterThan(String value) {
            addCriterion("variant_name >", value, "variantName");
            return (Criteria) this;
        }

        public Criteria andVariantNameGreaterThanOrEqualTo(String value) {
            addCriterion("variant_name >=", value, "variantName");
            return (Criteria) this;
        }

        public Criteria andVariantNameLessThan(String value) {
            addCriterion("variant_name <", value, "variantName");
            return (Criteria) this;
        }

        public Criteria andVariantNameLessThanOrEqualTo(String value) {
            addCriterion("variant_name <=", value, "variantName");
            return (Criteria) this;
        }

        public Criteria andVariantNameLike(String value) {
            addCriterion("variant_name like", value, "variantName");
            return (Criteria) this;
        }

        public Criteria andVariantNameNotLike(String value) {
            addCriterion("variant_name not like", value, "variantName");
            return (Criteria) this;
        }

        public Criteria andVariantNameIn(List<String> values) {
            addCriterion("variant_name in", values, "variantName");
            return (Criteria) this;
        }

        public Criteria andVariantNameNotIn(List<String> values) {
            addCriterion("variant_name not in", values, "variantName");
            return (Criteria) this;
        }

        public Criteria andVariantNameBetween(String value1, String value2) {
            addCriterion("variant_name between", value1, value2, "variantName");
            return (Criteria) this;
        }

        public Criteria andVariantNameNotBetween(String value1, String value2) {
            addCriterion("variant_name not between", value1, value2, "variantName");
            return (Criteria) this;
        }

        public Criteria andLocIsNull() {
            addCriterion("loc is null");
            return (Criteria) this;
        }

        public Criteria andLocIsNotNull() {
            addCriterion("loc is not null");
            return (Criteria) this;
        }

        public Criteria andLocEqualTo(String value) {
            addCriterion("loc =", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotEqualTo(String value) {
            addCriterion("loc <>", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocGreaterThan(String value) {
            addCriterion("loc >", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocGreaterThanOrEqualTo(String value) {
            addCriterion("loc >=", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLessThan(String value) {
            addCriterion("loc <", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLessThanOrEqualTo(String value) {
            addCriterion("loc <=", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLike(String value) {
            addCriterion("loc like", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotLike(String value) {
            addCriterion("loc not like", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocIn(List<String> values) {
            addCriterion("loc in", values, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotIn(List<String> values) {
            addCriterion("loc not in", values, "loc");
            return (Criteria) this;
        }

        public Criteria andLocBetween(String value1, String value2) {
            addCriterion("loc between", value1, value2, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotBetween(String value1, String value2) {
            addCriterion("loc not between", value1, value2, "loc");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(String value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(String value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(String value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(String value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(String value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(String value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLike(String value) {
            addCriterion("county like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotLike(String value) {
            addCriterion("county not like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<String> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<String> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(String value1, String value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(String value1, String value2) {
            addCriterion("county not between", value1, value2, "county");
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