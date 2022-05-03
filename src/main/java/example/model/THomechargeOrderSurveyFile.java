package example.model;

import lombok.Data;

import java.util.Date;

/**
 *
 * create by qsm
 * t_homecharge_order_survey_file
 */
@Data
public class THomechargeOrderSurveyFile {
    /**
     * 主键
     */
    private Long id;

    /**
     * 家充工单勘测记录ID
     */
    private Long homechargeOrderSurveyRecordId;

    /**
     * 家充工单ID(t_homecharge_order表的id)
     */
    private Long homechargeOrderId;

    /**
     * 家充工单号
     */
    private String orderNo;

    /**
     * 附件名称
     */
    private String fileName;

    /**
     * 附件OSS path
     */
    private String fileOssPath;

    /**
     * 类型：1：施工方案图片， 2:车位以及布线环境,3：安装以及售后服务协议,4：勘测报告,5:增项项目照片
     */
    private Byte type;

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

    public Long getHomechargeOrderSurveyRecordId() {
        return homechargeOrderSurveyRecordId;
    }

    public void setHomechargeOrderSurveyRecordId(Long homechargeOrderSurveyRecordId) {
        this.homechargeOrderSurveyRecordId = homechargeOrderSurveyRecordId;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileOssPath() {
        return fileOssPath;
    }

    public void setFileOssPath(String fileOssPath) {
        this.fileOssPath = fileOssPath;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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