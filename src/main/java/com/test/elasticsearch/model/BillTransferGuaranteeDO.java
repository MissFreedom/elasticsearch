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
public class BillTransferGuaranteeDO extends ElasticsearchBaseDO implements Serializable,Cloneable{

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String channelId;

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

    /**
     * 多个收款账户用|隔开，最多支持10个收款账户
     * 格式：id,userId,accountId,amount|id2,userId2,accountId2,amount2
     */

    @Field(type = FieldType.String,analyzer = "standard",searchAnalyzer = "standard",store = true)
    private String businessNumber;

    @Field(type = FieldType.Date,index = FieldIndex.not_analyzed,store = true)
    private Date businessDate;

    @Field(type = FieldType.Double,index = FieldIndex.not_analyzed,store = true)
    private BigDecimal amount;

    @Field(type = FieldType.Date,index = FieldIndex.not_analyzed,store = true)
    private Date createDate;

    @Field(type = FieldType.Date,index = FieldIndex.not_analyzed,store = true)
    private Date updateDate;

    @Field(type = FieldType.Date,index = FieldIndex.not_analyzed,store = true)
    private Date endDate;

    @Field(type = FieldType.String,index = FieldIndex.not_analyzed,store = true)
    private String billStatus;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
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
        this.fromUserId = fromUserId;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(String toAccountId) {
        this.toAccountId = toAccountId;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public Date getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    @Override
    public String toString() {
        return  "id='" + this.getId() + '\'' +
                ", channelId=" + channelId +
                ", transferType=" + transferType +
                ", fromUserId='" + fromUserId + '\'' +
                ", fromAccountId='" + fromAccountId + '\'' +
                ", toUserId='" + toUserId + '\'' +
                ", toAccountId='" + toAccountId + '\'' +
                ", businessNumber='" + businessNumber + '\'' +
                ", businessDate=" + businessDate +
                ", amount=" + amount +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", endDate=" + endDate +
                ", billStatus=" + billStatus ;
    }

}