package example.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * create by qsm
 * t_homecharge_order_survey_info
 */
@Data
public class THomechargeOrderSurveyInfo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 家充工单ID(t_homecharge_order表的id)
     */
    private Long homechargeOrderId;

    /**
     * 家充工单号
     */
    private String orderNo;

    /**
     * 小区名称
     */
    private String communityName;

    /**
     * 0:未填写，1：从电力报装表接入，2：从物业电表接入，3：从用户现有电表接入
     */
    private Byte powerType;

    /**
     * 0:不同意,1：同意，2：待定
     */
    private Byte propertyManagementAttitude;

    /**
     * 是否安装立柱，0：不需要， 1：需要
     */
    private Byte needInstallPost;

    /**
     * 是否电力报装申请，0：无需报装，1：需要报装，2：未知
     */
    private Byte powerInstallApplication;

    /**
     * 预估电缆长度
     */
    private String predictCableLength;

    /**
     * 实际电缆长度
     */
    private String realCableLength;

    /**
     * 充电桩编码
     */
    private String chargePileCode;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 收费详情描述
     */
    private String feeDesc;

    /**
     * 预估安装费用
     */
    private BigDecimal predictIntallFee;

    /**
     * 实际安装费用
     */
    private BigDecimal realInstallFee;

    /**
     * 进展描述
     */
    private String processDesc;

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

    public Long getHomechargeOrderId() {
        return homechargeOrderId;
    }

    public void setHomechargeOrderId(Long homechargeOrderId) {
        this.homechargeOrderId = homechargeOrderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Byte getPowerType() {
        return powerType;
    }

    public void setPowerType(Byte powerType) {
        this.powerType = powerType;
    }

    public Byte getPropertyManagementAttitude() {
        return propertyManagementAttitude;
    }

    public void setPropertyManagementAttitude(Byte propertyManagementAttitude) {
        this.propertyManagementAttitude = propertyManagementAttitude;
    }

    public Byte getNeedInstallPost() {
        return needInstallPost;
    }

    public void setNeedInstallPost(Byte needInstallPost) {
        this.needInstallPost = needInstallPost;
    }

    public Byte getPowerInstallApplication() {
        return powerInstallApplication;
    }

    public void setPowerInstallApplication(Byte powerInstallApplication) {
        this.powerInstallApplication = powerInstallApplication;
    }

    public String getPredictCableLength() {
        return predictCableLength;
    }

    public void setPredictCableLength(String predictCableLength) {
        this.predictCableLength = predictCableLength;
    }

    public String getRealCableLength() {
        return realCableLength;
    }

    public void setRealCableLength(String realCableLength) {
        this.realCableLength = realCableLength;
    }

    public String getChargePileCode() {
        return chargePileCode;
    }

    public void setChargePileCode(String chargePileCode) {
        this.chargePileCode = chargePileCode;
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

    public String getFeeDesc() {
        return feeDesc;
    }

    public void setFeeDesc(String feeDesc) {
        this.feeDesc = feeDesc;
    }

    public BigDecimal getPredictIntallFee() {
        return predictIntallFee;
    }

    public void setPredictIntallFee(BigDecimal predictIntallFee) {
        this.predictIntallFee = predictIntallFee;
    }

    public BigDecimal getRealInstallFee() {
        return realInstallFee;
    }

    public void setRealInstallFee(BigDecimal realInstallFee) {
        this.realInstallFee = realInstallFee;
    }

    public String getProcessDesc() {
        return processDesc;
    }

    public void setProcessDesc(String processDesc) {
        this.processDesc = processDesc;
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