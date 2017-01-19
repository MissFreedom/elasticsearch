package com.test.elasticsearch.service;

import com.test.elasticsearch.model.BillTransferGuaranteeDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/** 
* BillTransferGuaranteeServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>һ�� 16, 2017</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring-elasticsearch.xml"})
public class BillTransferGuaranteeServiceImplTest { 

    @Resource
    private BillTransferGuaranteeService billTransferGuaranteeService;

    /**
     *
     * Method: addBillTransferGuarantee(BillTransferGuaranteeDO billTransferGuaranteeDO)
     *
     */
    @Test
    public void testAddBillTransferGuarantee() throws Exception {
        try {
            BillTransferGuaranteeDO billTransferGuaranteeDO = new BillTransferGuaranteeDO();
            billTransferGuaranteeDO.setId("2972ce3a-48b5-4ed4-8334-892c95a64181");
            billTransferGuaranteeDO.setVersion(new Byte("1"));
            billTransferGuaranteeDO.setToAccountId("toAccountId");
            billTransferGuaranteeDO.setAppId("appId");
            billTransferGuaranteeDO.setBatchId("batchId");
            billTransferGuaranteeDO.setBillNumber("billNumber");
            billTransferGuaranteeDO.setBillStatus("billStatus");
            billTransferGuaranteeDO.setBusinessBody("businessBody");
            billTransferGuaranteeDO.setBusinessDate(new Date());
            billTransferGuaranteeDO.setBusinessDesc("businessDesc");
            billTransferGuaranteeDO.setChannelAccount("channelAccount");
            billTransferGuaranteeDO.setAmount(new BigDecimal(10));
            billTransferGuaranteeDO.setBusinessNumber("businessNumber");
            billTransferGuaranteeDO.setChannelId("channelId");
            billTransferGuaranteeDO.setCreateDate(new Date());
            boolean b = billTransferGuaranteeService.addBillTransferGuarantee(billTransferGuaranteeDO);
            System.out.println(b);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     *
     * Method: modifyBillTransferGuarantee(BillTransferGuaranteeDO billTransferGuaranteeDO)
     *
     */
    @Test
    public void testModifyBillTransferGuarantee() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: removeBillTransferGuarantee(String id)
     *
     */
    @Test
    public void testRemoveBillTransferGuarantee() throws Exception {
        billTransferGuaranteeService.removeBillTransferGuarantee("2972ce3a-48b5-4ed4-8334-892c95a64181");
    }

    /**
     *
     * Method: getBillTransferGuaranteeById(String id)
     *
     */
    @Test
    public void testGetBillTransferGuaranteeById() throws Exception {
        String bill = billTransferGuaranteeService.getBillTransferGuaranteeById("billnumber");
        System.out.println(bill);
    }

    /**
     *
     * Method: getBillTransferGuaranteeList()
     *
     */
    @Test
    public void testGetBillTransferGuaranteeList() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: queryBillTransferGuarantee(BillTransferGuaranteeDO query)
     *
     */
    @Test
    public void testQueryBillTransferGuarantee() throws Exception {
//TODO: Test goes here...
    }

} 
