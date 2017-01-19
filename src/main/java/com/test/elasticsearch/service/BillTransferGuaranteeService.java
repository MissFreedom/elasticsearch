package com.test.elasticsearch.service;

import com.test.elasticsearch.model.BillTransferGuaranteeDO;

import java.util.List;

/**
 * author: JinBingBing
 * description: 支付订单服务
 * time: 2017/1/16 10:49.
 */

public interface BillTransferGuaranteeService {

    /**
     * 添加支付订单服务信息
     *
     * @param billTransferGuaranteeDO
     * @return
     * @throws Exception
     */
    boolean addBillTransferGuarantee(BillTransferGuaranteeDO billTransferGuaranteeDO) throws Exception;

    /**
     * 修改支付订单服务信息
     *
     * @param billTransferGuaranteeDO
     * @return
     * @throws Exception
     */
    boolean modifyBillTransferGuarantee(BillTransferGuaranteeDO billTransferGuaranteeDO) throws Exception;

    /**
     * 删除支付订单服务信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean removeBillTransferGuarantee(String id) throws Exception;

    /**
     * 根据id获取支付订单服务信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    String getBillTransferGuaranteeById(String id) throws Exception;

    /**
     * 查询支付订单服务信息
     *
     * @param query
     * @return
     */
    List<BillTransferGuaranteeDO> queryBillTransferGuarantee(BillTransferGuaranteeDO query) throws Exception;

}
