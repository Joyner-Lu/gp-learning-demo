package example.model;

import lombok.Data;

import java.util.Date;

/**
 *
 * create by qsm
 * t_homecharge_order
 */
@Data
public class THomechargeOrder {
    /**
     * 主键
     */
    private Long id;

    /**
     * 工单所属区域编码(根据建单城市来反查确定)
     */
    private String areaCode;

    /**
     * 工单所属区域名称(根据建单城市来反查确定)
     */
    private String areaName;

    /**
     * 工单派单给到的服务商code(派单进行选择之后会更新该值)
     */
    private String orderServiceProviderCode;

    /**
     * 工单派单给到的服务商name(派单进行选择之后会更新该值)
     */
    private String orderServiceProviderName;

    /**
     * 流程ID
     */
    private String processId;

    /**
     * 门店号
     */
    private String store;

    /**
     * 家充工单号
     */
    private String orderNo;

    /**
     * 外部工单号，如果是自建的时候则为空
     */
    private String externalOrderNo;

    /**
     * 激活时间
     */
    private Date activationTime;

    /**
     * 激活人ID
     */
    private String activationUserId;

    /**
     * 激活人姓名
     */
    private String activationUserName;

    /**
     * 创建来源, 0:手动创建，1：麒麟 2：骁龙 3：商城
     */
    private Byte createSource;

    /**
     * 订单状态：00：未激活，01：休眠-未激活，03：派单，06：签收，09：勘测，12：确认勘测，15：安装，18：确认安装，21：安装复核，24：归档审核，30：作废，33：完成
     */
    private String orderStatus;

    /**
     * 工单安装结果，00：未激活，03：准备， 06：勘测，09：安装， 12：完成， 15：作废
     */
    private String orderInstallationResult;

    /**
     * 车主(下订人)姓名
     */
    private String customerName;

    /**
     * 车主(下订人)电话
     */
    private String customerPhone;

    /**
     * 车主(下订人)uid
     */
    private String uid;

    /**
     * 车主性别,0:未填写 1:男、2:女
     */
    private Byte gender;

    /**
     * 省
     */
    private String province;

    /**
     * 省-编码
     */
    private String provinceCode;

    /**
     * 市
     */
    private String city;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 区
     */
    private String district;

    /**
     * 区域编码
     */
    private String districtCode;

    /**
     * 建桩地址
     */
    private String address;

    /**
     * 住宅类型,0:未填写、1:高层住宅、2:自建房、4:别墅、8:工厂、16:写字楼、32:其他
     */
    private Byte houseType;

    /**
     * 住宅性质,0:未填写、1:自有、2:租赁
     */
    private Byte houseProperty;

    /**
     * 车位类型,0:未填写，1:无车位、2:地下停车位、4:地面停车位、8:独立车库、16:立体车库、32:其他
     */
    private Byte carpotType;

    /**
     * 是否电力报装申请,1:无需报装、2:需要报装、4:未知
     */
    private Byte installationStatus;

    /**
     * 物业态度,1:同意、2:不同意、3:未知
     */
    private Byte propertyManagementStatus;

    /**
     * 报装联系人(建桩人)姓名
     */
    private String contactName;

    /**
     * 报装联系人(建桩人)电话
     */
    private String contactPhone;

    /**
     * 车系编码
     */
    private String carSeriesCode;

    /**
     * 车系名称
     */
    private String carSeriesName;

    /**
     * 车型编码
     */
    private String vehicleTypeCode;

    /**
     * 车型名称
     */
    private String vehicleTypeName;

    /**
     * 车型配置编码
     */
    private String vehicle;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 跟进人姓名
     */
    private String caEmpName;

    /**
     * 预计交车日期
     */
    private Date preDeliverDate;

    /**
     * OAS订单状态，例：合同已签署
     */
    private String saleOrderState;

    /**
     * VIN码
     */
    private String vin;

    /**
     * 充电桩类型,1=安装权益；2=保留权益（未激活）；默认等于1
     */
    private Byte chargingPoleType;

    /**
     * 签署人姓名
     */
    private String signatoryName;

    /**
     * 签署人电话
     */
    private String signatoryPhone;

    /**
     * 触发场景编码，0:未填写 1、合同签订；2、充电方案修改；3、合同签署人修改；4、交车确认；
     */
    private Byte sceneCode;

    /**
     * 定金支付时间
     */
    private Date earnestMoneyPayTime;

    /**
     * 门店类型,0-未填写,1-直营店,2-加盟店
     */
    private Byte dlrType;

    /**
     * 收入金额
     */
    private String revenue;

    /**
     * 购买方式,0:未填写，1是积分，2是现金，4是现金+积分
     */
    private Byte purchaseMethod;

    /**
     * 商品名称
     */
    private String commodity;

    /**
     * 现金支付金额
     */
    private String cash;

    /**
     * 积分
     */
    private String integral;

    /**
     * 折扣
     */
    private String discount;

    /**
     * 支付日期
     */
    private Date paymentDate;

    /**
     * 安装完成时间
     */
    private Date installFinishTime;

    /**
     * 工单作废时间
     */
    private Date cancelTime;

    /**
     * 暂停状态，0:未暂停，1：已暂停
     */
    private Byte stopStatus;

    /**
     * 暂停原因
     */
    private String stopReason;

    /**
     * 暂停时间
     */
    private Date stopTime;

    /**
     * ARK单号，商城用到的字段
     */
    private String arkOrderCode;

    /**
     * 查询到的区域对应的组织编码
     */
    private String orgCode;

    /**
     * 查询到的区域对应的组织名称
     */
    private String orgName;

    /**
     * 服务商管理员id
     */
    private String serviceProviderManagerId;

    /**
     * 服务商管理员姓名
     */
    private String serviceProviderManagerName;

    /**
     * 班组长id
     */
    private String groupLeaderId;

    /**
     * 班组长姓名
     */
    private String groupLeaderName;

    /**
     * 主单号，商城用字段
     */
    private String bstkd;

    /**
     * 子单号，商城用字段
     */
    private String zbstkd;

    /**
     * 商城传来的抛账数据
     */
    private String mallData;

    /**
     * 是否删除：0-未删除，1-已删除
     */
    private Byte isDeleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改人
     */
    private String updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getOrderServiceProviderCode() {
        return orderServiceProviderCode;
    }

    public void setOrderServiceProviderCode(String orderServiceProviderCode) {
        this.orderServiceProviderCode = orderServiceProviderCode;
    }

    public String getOrderServiceProviderName() {
        return orderServiceProviderName;
    }

    public void setOrderServiceProviderName(String orderServiceProviderName) {
        this.orderServiceProviderName = orderServiceProviderName;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getExternalOrderNo() {
        return externalOrderNo;
    }

    public void setExternalOrderNo(String externalOrderNo) {
        this.externalOrderNo = externalOrderNo;
    }

    public Date getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(Date activationTime) {
        this.activationTime = activationTime;
    }

    public String getActivationUserId() {
        return activationUserId;
    }

    public void setActivationUserId(String activationUserId) {
        this.activationUserId = activationUserId;
    }

    public String getActivationUserName() {
        return activationUserName;
    }

    public void setActivationUserName(String activationUserName) {
        this.activationUserName = activationUserName;
    }

    public Byte getCreateSource() {
        return createSource;
    }

    public void setCreateSource(Byte createSource) {
        this.createSource = createSource;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderInstallationResult() {
        return orderInstallationResult;
    }

    public void setOrderInstallationResult(String orderInstallationResult) {
        this.orderInstallationResult = orderInstallationResult;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Byte getHouseType() {
        return houseType;
    }

    public void setHouseType(Byte houseType) {
        this.houseType = houseType;
    }

    public Byte getHouseProperty() {
        return houseProperty;
    }

    public void setHouseProperty(Byte houseProperty) {
        this.houseProperty = houseProperty;
    }

    public Byte getCarpotType() {
        return carpotType;
    }

    public void setCarpotType(Byte carpotType) {
        this.carpotType = carpotType;
    }

    public Byte getInstallationStatus() {
        return installationStatus;
    }

    public void setInstallationStatus(Byte installationStatus) {
        this.installationStatus = installationStatus;
    }

    public Byte getPropertyManagementStatus() {
        return propertyManagementStatus;
    }

    public void setPropertyManagementStatus(Byte propertyManagementStatus) {
        this.propertyManagementStatus = propertyManagementStatus;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCarSeriesCode() {
        return carSeriesCode;
    }

    public void setCarSeriesCode(String carSeriesCode) {
        this.carSeriesCode = carSeriesCode;
    }

    public String getCarSeriesName() {
        return carSeriesName;
    }

    public void setCarSeriesName(String carSeriesName) {
        this.carSeriesName = carSeriesName;
    }

    public String getVehicleTypeCode() {
        return vehicleTypeCode;
    }

    public void setVehicleTypeCode(String vehicleTypeCode) {
        this.vehicleTypeCode = vehicleTypeCode;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCaEmpName() {
        return caEmpName;
    }

    public void setCaEmpName(String caEmpName) {
        this.caEmpName = caEmpName;
    }

    public Date getPreDeliverDate() {
        return preDeliverDate;
    }

    public void setPreDeliverDate(Date preDeliverDate) {
        this.preDeliverDate = preDeliverDate;
    }

    public String getSaleOrderState() {
        return saleOrderState;
    }

    public void setSaleOrderState(String saleOrderState) {
        this.saleOrderState = saleOrderState;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Byte getChargingPoleType() {
        return chargingPoleType;
    }

    public void setChargingPoleType(Byte chargingPoleType) {
        this.chargingPoleType = chargingPoleType;
    }

    public String getSignatoryName() {
        return signatoryName;
    }

    public void setSignatoryName(String signatoryName) {
        this.signatoryName = signatoryName;
    }

    public String getSignatoryPhone() {
        return signatoryPhone;
    }

    public void setSignatoryPhone(String signatoryPhone) {
        this.signatoryPhone = signatoryPhone;
    }

    public Byte getSceneCode() {
        return sceneCode;
    }

    public void setSceneCode(Byte sceneCode) {
        this.sceneCode = sceneCode;
    }

    public Date getEarnestMoneyPayTime() {
        return earnestMoneyPayTime;
    }

    public void setEarnestMoneyPayTime(Date earnestMoneyPayTime) {
        this.earnestMoneyPayTime = earnestMoneyPayTime;
    }

    public Byte getDlrType() {
        return dlrType;
    }

    public void setDlrType(Byte dlrType) {
        this.dlrType = dlrType;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public Byte getPurchaseMethod() {
        return purchaseMethod;
    }

    public void setPurchaseMethod(Byte purchaseMethod) {
        this.purchaseMethod = purchaseMethod;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getInstallFinishTime() {
        return installFinishTime;
    }

    public void setInstallFinishTime(Date installFinishTime) {
        this.installFinishTime = installFinishTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Byte getStopStatus() {
        return stopStatus;
    }

    public void setStopStatus(Byte stopStatus) {
        this.stopStatus = stopStatus;
    }

    public String getStopReason() {
        return stopReason;
    }

    public void setStopReason(String stopReason) {
        this.stopReason = stopReason;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public String getArkOrderCode() {
        return arkOrderCode;
    }

    public void setArkOrderCode(String arkOrderCode) {
        this.arkOrderCode = arkOrderCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getServiceProviderManagerId() {
        return serviceProviderManagerId;
    }

    public void setServiceProviderManagerId(String serviceProviderManagerId) {
        this.serviceProviderManagerId = serviceProviderManagerId;
    }

    public String getServiceProviderManagerName() {
        return serviceProviderManagerName;
    }

    public void setServiceProviderManagerName(String serviceProviderManagerName) {
        this.serviceProviderManagerName = serviceProviderManagerName;
    }

    public String getGroupLeaderId() {
        return groupLeaderId;
    }

    public void setGroupLeaderId(String groupLeaderId) {
        this.groupLeaderId = groupLeaderId;
    }

    public String getGroupLeaderName() {
        return groupLeaderName;
    }

    public void setGroupLeaderName(String groupLeaderName) {
        this.groupLeaderName = groupLeaderName;
    }

    public String getBstkd() {
        return bstkd;
    }

    public void setBstkd(String bstkd) {
        this.bstkd = bstkd;
    }

    public String getZbstkd() {
        return zbstkd;
    }

    public void setZbstkd(String zbstkd) {
        this.zbstkd = zbstkd;
    }

    public String getMallData() {
        return mallData;
    }

    public void setMallData(String mallData) {
        this.mallData = mallData;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}