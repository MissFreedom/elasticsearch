package com.test.elasticsearch.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.elasticsearch.model.BillTransferGuaranteeDO;
import com.test.elasticsearch.model.ElasticsearchBaseDO;
import com.test.elasticsearch.service.BillTransferGuaranteeService;
import com.test.elasticsearch.utils.Constant;
import org.elasticsearch.index.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * author: JinBingBing
 * description: 支付订单服务实现
 * time: 2017/1/16 10:51.
 */
@Service
public class BillTransferGuaranteeServiceImpl implements BillTransferGuaranteeService {

    private static final Logger logger = LoggerFactory.getLogger(BillTransferGuaranteeServiceImpl.class);

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

//    @PostConstruct
//    public void init(){
//        if (!elasticsearchTemplate.indexExists("funds_business")){
//            elasticsearchTemplate.createIndex("funds_business");
//        }
//        elasticsearchTemplate.putMapping(BillTransferGuaranteeDO.class);
//    }

    /**
     * 添加支付订单服务实现信息
     *
     * @param billTransferGuaranteeDO
     * @return
     * @throws Exception
     */
    @Override
    public boolean addBillTransferGuarantee(BillTransferGuaranteeDO billTransferGuaranteeDO) throws Exception {
        IndexQuery indexQuery = new IndexQueryBuilder().withId(billTransferGuaranteeDO.getId()).withObject((ElasticsearchBaseDO)billTransferGuaranteeDO).build();
        String id = elasticsearchTemplate.index(indexQuery);
        if (org.apache.commons.lang.StringUtils.isNotBlank(id)) {
            return true;
        }
        return false;
    }

    /**
     * 修改支付订单服务实现信息
     *
     * @param billTransferGuaranteeDO
     * @return
     * @throws Exception
     */
    @Override
    public boolean modifyBillTransferGuarantee(BillTransferGuaranteeDO billTransferGuaranteeDO) throws Exception {
        BillTransferGuaranteeDO bill = getBillTransferGuaranteeById(billTransferGuaranteeDO.getId());
        if (null == bill){
            return false;
        }
        return addBillTransferGuarantee(billTransferGuaranteeDO);
    }

    /**
     * 删除支付订单服务实现信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public void removeBillTransferGuarantee(String id) throws Exception {
        elasticsearchTemplate.delete(BillTransferGuaranteeDO.class,id);
    }

    /**
     * 根据id获取支付订单服务实现信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public BillTransferGuaranteeDO getBillTransferGuaranteeById(String id) throws Exception {
        BoolQueryBuilder filterBuilder = QueryBuilders.boolQuery();
        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("id",id);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withIndices(Constant.Index.FUNDS_BUSINESS).withTypes(Constant.Type.BILL_TRANSFER_GUARANTEE)
                .withFilter(filterBuilder.must(termsQueryBuilder)).build();
        List<Map> billTransferGuaranteeDO = elasticsearchTemplate.queryForList(searchQuery,Map.class);
        if (ObjectUtils.isEmpty(billTransferGuaranteeDO)){
            return null;
        }
        Map s = billTransferGuaranteeDO.get(0);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(s);
        BillTransferGuaranteeDO billTransferGuarantee = JSONObject.toJavaObject(jsonObject,BillTransferGuaranteeDO.class);
        return billTransferGuarantee;

    }

    /**
     * 支付订单查询
     * @param query
     * @param pageable
     * @return
     */
    public Page<BillTransferGuaranteeDO> queryBillTransferGuaranteeByPage(BillTransferGuaranteeDO query, Pageable pageable) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        if (null != query.getId()&&"" != query.getId()){
            WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("id","*"+query.getId()+"*");
            queryBuilder.must(wildcardQueryBuilder);
        }
        if (null != query.getChannelId()&&"" != query.getChannelId()){
            TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("channelId",query.getChannelId());
            queryBuilder.must(termsQueryBuilder);
        }
        if (null != query.getFromUserId()&&"" != query.getFromUserId()){
            TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("fromUserId",query.getFromUserId());
            queryBuilder.must(termsQueryBuilder);
        }
        if (null != query.getToUserId()&&"" != query.getToUserId()){
            TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("toUserId",query.getToUserId());
            queryBuilder.must(termsQueryBuilder);
        }
        if (null != query.getBillStatus() && "" != query.getBillStatus()){
            TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("billStatus",query.getBillStatus());
            queryBuilder.must(termsQueryBuilder);
        }
        if (null != query.getBusinessNumber() && "" != query.getBusinessNumber()){
            TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("businessNumber",query.getBusinessNumber());
            queryBuilder.must(termsQueryBuilder);
        }
        if (null != query.getTransferType() && "" != query.getTransferType()){
            TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("transferType",query.getTransferType());
            queryBuilder.must(termsQueryBuilder);
        }
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withIndices(Constant.Index.FUNDS_BUSINESS).withTypes(Constant.Type.BILL_TRANSFER_GUARANTEE)
                .withQuery(queryBuilder).withPageable(pageable).build();
        Page<BillTransferGuaranteeDO> billTransferGuaranteeDOs = elasticsearchTemplate.queryForPage(searchQuery,BillTransferGuaranteeDO.class);
        return billTransferGuaranteeDOs;
    }

}