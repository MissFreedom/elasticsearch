package com.test.elasticsearch.model;

import com.test.elasticsearch.utils.Constant;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * author: JinBingBing
 * description:
 * time: 2017/1/16 10:42.
 */
@Document(indexName = Constant.Index.FUNDS_BUSINESS,type = Constant.Type.BILL_TRANSFER_GUARANTEE)
public class BillTransferGuaranteeDO implements Serializable,Cloneable{

    @Id
    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String id;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String billNumber;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String channelId;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String channelAccount;

    @Field(type = FieldType.String,index= FieldIndex.not_analyzed,store = true)
    private String transferType;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String fromUserId;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String fromAccountId;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String toUserId;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String toAccountId;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String toThirdUserId;//收款用户;借款消费

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String toThirdAccountId;//收款账户;借款消费:(被借方=fromUserId;借款消费方=toUserId;)

    /**
     * 多个收款账户用|隔开，最多支持10个收款账户
     * 格式：id,userId,accountId,amount|id2,userId2,accountId2,amount2
     */
    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String toBatchJsonId;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String batchId;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String businessNumber;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String businessBody;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String appId;

    @Field(type = FieldType.Date,index = FieldIndex.not_analyzed,store = true)
    private Date businessDate;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String businessDesc;

    @Field(type = FieldType.Double,index = FieldIndex.not_analyzed,store = true)
    private BigDecimal amount;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String sign;

    @Field(type = FieldType.Date,index = FieldIndex.not_analyzed,store = true)
    private Date invalidDate;

    @Field(type = FieldType.Date,index = FieldIndex.not_analyzed,store = true)
    private Date createDate;

    @Field(type = FieldType.Date,index = FieldIndex.not_analyzed,store = true)
    private Date updateDate;

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String description;

    @Field(type = FieldType.Integer,index = FieldIndex.not_analyzed,store = true)
    private Byte version;

    @Field(type = FieldType.Integer,index = FieldIndex.not_analyzed,store = true)
    private Integer isdeleted;

    @Field(type = FieldType.Date,index = FieldIndex.not_analyzed,store = true)
    private Date endDate;

    @Field(type = FieldType.String,index = FieldIndex.not_analyzed,store = true)
    private String billStatus;

    @Field(type = FieldType.String,index = FieldIndex.not_analyzed,store = true)
    private String isEcardPay;//是否支付e卡支付，NO不支持，YES 支持

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String ecardAccountId;//收入e卡账户ID

    @Field(type = FieldType.String,index = FieldIndex.not_analyzed,store = true)
    private String virtualGoods;//是否虚拟商品，默认NO不是，YES 是



    public String getVirtualGoods() {
        return virtualGoods;
    }

    public void setVirtualGoods(String virtualGoods) {
        this.virtualGoods = virtualGoods;
    }

    public String getIsEcardPay() {
        return isEcardPay;
    }

    public void setIsEcardPay(String isEcardPay) {
        this.isEcardPay = isEcardPay;
    }

    public String getEcardAccountId() {
        return ecardAccountId;
    }

    public void setEcardAccountId(String ecardAccountId) {
        this.ecardAccountId = ecardAccountId;
    }

    public BillTransferGuaranteeDO() {
    }

    public BillTransferGuaranteeDO(String id, String channelAccount) {
        this.id = id;
        this.channelAccount = channelAccount;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getToBatchJsonId() {
        return toBatchJsonId;
    }

    public void setToBatchJsonId(String toBatchJsonId) {
        this.toBatchJsonId = toBatchJsonId;
    }

    public String getToThirdUserId() {
        return toThirdUserId;
    }

    public void setToThirdUserId(String toThirdUserId) {
        this.toThirdUserId = toThirdUserId;
    }

    public String getToThirdAccountId() {
        return toThirdAccountId;
    }

    public void setToThirdAccountId(String toThirdAccountId) {
        this.toThirdAccountId = toThirdAccountId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber == null ? null : billNumber.trim();
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelAccount() {
        return channelAccount;
    }

    public void setChannelAccount(String channelAccount) {
        this.channelAccount = channelAccount;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId == null ? null : fromUserId.trim();
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId == null ? null : fromAccountId.trim();
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId == null ? null : toUserId.trim();
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(String toAccountId) {
        this.toAccountId = toAccountId == null ? null : toAccountId.trim();
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber == null ? null : businessNumber.trim();
    }

    public String getBusinessBody() {
        return businessBody;
    }

    public void setBusinessBody(String businessBody) {
        this.businessBody = businessBody == null ? null : businessBody.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Date getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }

    public String getBusinessDesc() {
        return businessDesc;
    }

    public void setBusinessDesc(String businessDesc) {
        this.businessDesc = businessDesc == null ? null : businessDesc.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

//    public BillTransferGuaranteeDO clone() {
//        BillTransferGuaranteeDO billTransferGuarantee = null;
//        try {
//            billTransferGuarantee = (BillTransferGuaranteeDO) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return billTransferGuarantee;
//    }

    @Override
    public String toString() {
        return "BillTransferGuaranteeDO{" +
                "id='" + id + '\'' +
                ", billNumber='" + billNumber + '\'' +
                ", channelId=" + channelId +
                ", channelAccount='" + channelAccount + '\'' +
                ", transferType=" + transferType +
                ", fromUserId='" + fromUserId + '\'' +
                ", fromAccountId='" + fromAccountId + '\'' +
                ", toUserId='" + toUserId + '\'' +
                ", toAccountId='" + toAccountId + '\'' +
                ", toThirdUserId='" + toThirdUserId + '\'' +
                ", toThirdAccountId='" + toThirdAccountId + '\'' +
                ", toBatchJsonId='" + toBatchJsonId + '\'' +
                ", batchId='" + batchId + '\'' +
                ", businessNumber='" + businessNumber + '\'' +
                ", businessBody='" + businessBody + '\'' +
                ", appId='" + appId + '\'' +
                ", businessDate=" + businessDate +
                ", businessDesc='" + businessDesc + '\'' +
                ", amount=" + amount +
                ", sign='" + sign + '\'' +
                ", invalidDate=" + invalidDate +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", description='" + description + '\'' +
                ", version=" + version +
                ", isdeleted=" + isdeleted +
                ", endDate=" + endDate +
                ", billStatus=" + billStatus +
                '}';
    }

}