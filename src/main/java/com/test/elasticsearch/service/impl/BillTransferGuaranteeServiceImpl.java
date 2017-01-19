package com.test.elasticsearch.service.impl;

import com.test.elasticsearch.model.BillTransferGuaranteeDO;
import com.test.elasticsearch.service.BillTransferGuaranteeService;
import com.test.elasticsearch.utils.Constant;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private Client clinet;

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
    public boolean addBillTransferGuarantee(BillTransferGuaranteeDO billTransferGuaranteeDO) throws Exception {
        try{
            IndexQuery indexQuery = new IndexQueryBuilder().withId(billTransferGuaranteeDO.getId()).withObject(billTransferGuaranteeDO).build();
            elasticsearchTemplate.index(indexQuery);
            return true;
        }catch (Exception e){
            logger.error("add BillTransferGuarantee error!",e);
            throw e;
        }
    }

    /**
     * 修改支付订单服务实现信息
     *
     * @param billTransferGuaranteeDO
     * @return
     * @throws Exception
     */
    public boolean modifyBillTransferGuarantee(BillTransferGuaranteeDO billTransferGuaranteeDO) throws Exception {
        try {
            Assert.notNull(billTransferGuaranteeDO.getAppId(),"订单Id不能为空");
            String bill = getBillTransferGuaranteeById(billTransferGuaranteeDO.getId());
            Assert.isTrue(StringUtils.hasText(bill),"订单不存在，无法修改");
            UpdateQuery updateQuery = new UpdateQuery();
            return addBillTransferGuarantee(billTransferGuaranteeDO);
        }catch (Exception e){
            logger.error("update BillTransferGuarantee error!",e);
            throw e;
        }
    }

    /**
     * 删除支付订单服务实现信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    public boolean removeBillTransferGuarantee(String id) throws Exception {
        try {
            elasticsearchTemplate.delete(BillTransferGuaranteeDO.class,id);
            return true;
        }catch (Exception e){
            logger.error("remove BillTransferGuarantee error!",e);
            throw e;
        }
    }

    /**
     * 根据id获取支付订单服务实现信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    public String getBillTransferGuaranteeById(String id) throws Exception {
        try {
            Assert.notNull(id,"支付订单Id不能为空");
            SearchRequestBuilder searchRequestBuilder = clinet.prepareSearch(Constant.Index.FUNDS_BUSINESS).setTypes(Constant.Type.BILL_TRANSFER_GUARANTEE)
                    .setSearchType(SearchType.DEFAULT).setExplain(true);
            QueryStringQueryBuilder queryBuilder = QueryBuilders.queryStringQuery(id);
            searchRequestBuilder.setQuery(queryBuilder);
            SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();
            SearchHits hits = searchResponse.getHits();
            if (0==hits.getTotalHits()){
                return null;
            }
            SearchHit hit = hits.getAt(0);
            return hit.getSourceAsString();
        }catch (Exception e){
            logger.error("get BillTransferGuarantee error!",e);
            throw e;
        }
    }

    /**
     * 获取所有支付订单服务实现信息
     *
     * @return
     * @throws Exception
     */
    public List<BillTransferGuaranteeDO> getBillTransferGuaranteeList() throws Exception {
        return null;
    }

    /**
     * 查询支付订单服务实现信息
     *
     * @param query
     * @return
     */
    public List<BillTransferGuaranteeDO> queryBillTransferGuarantee(BillTransferGuaranteeDO query) throws Exception {
        return null;
    }

}