package com.test.elasticsearch.service;

import com.test.elasticsearch.model.BillTransferGuaranteeDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
            while (true) {
                BillTransferGuaranteeDO billTransferGuaranteeDO = new BillTransferGuaranteeDO();
                billTransferGuaranteeDO.setId(UUID.randomUUID().toString());
                billTransferGuaranteeDO.setToAccountId("toAccountId");
                billTransferGuaranteeDO.setBillStatus("billStatus");
                billTransferGuaranteeDO.setBusinessDate(new Date());
                billTransferGuaranteeDO.setAmount(new BigDecimal(10));
                billTransferGuaranteeDO.setBusinessNumber("businessNumber");
                billTransferGuaranteeDO.setChannelId("channelId");
                billTransferGuaranteeDO.setCreateDate(new Date());
                boolean b = billTransferGuaranteeService.addBillTransferGuarantee(billTransferGuaranteeDO);
                System.out.println(b);
            }
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
        try {
            BillTransferGuaranteeDO billTransferGuaranteeDO = new BillTransferGuaranteeDO();
            billTransferGuaranteeDO.setId("bbac2bbb-f928-49ab-af74-a363ea5c9db1");
            billTransferGuaranteeDO.setToAccountId("toAccountId");
            billTransferGuaranteeDO.setFromAccountId("fromAccountId");
            billTransferGuaranteeDO.setBillStatus("billStatus");
            billTransferGuaranteeDO.setBusinessDate(new Date());
            billTransferGuaranteeDO.setAmount(new BigDecimal(10));
            billTransferGuaranteeDO.setBusinessNumber("businessNumber");
            billTransferGuaranteeDO.setChannelId("channelId");
            billTransferGuaranteeDO.setCreateDate(new Date());
            boolean b = billTransferGuaranteeService.modifyBillTransferGuarantee(billTransferGuaranteeDO);
            System.out.println(b);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     *
     * Method: removeBillTransferGuarantee(String id)
     *
     */
    @Test
    public void testRemoveBillTransferGuarantee() throws Exception {
        billTransferGuaranteeService.removeBillTransferGuarantee("AVm1kV5y4myzPyRhG1O9");
    }

    /**
     *
     * Method: getBillTransferGuaranteeById(String id)
     *
     */
    @Test
    public void testGetBillTransferGuaranteeById() throws Exception {
        BillTransferGuaranteeDO bill = billTransferGuaranteeService.getBillTransferGuaranteeById("e376c535-5d23-4cab-ad26-c9ca2075de9c");
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
        BillTransferGuaranteeDO billTransferGuaranteeDO = new BillTransferGuaranteeDO();
//        billTransferGuaranteeDO.setChannelId("w");
//        billTransferGuaranteeDO.setToAccountId("toAccountId");
        billTransferGuaranteeDO.setBillStatus("billStatus");
        Pageable pageable = new PageRequest(0,10);
        Page<BillTransferGuaranteeDO> list = billTransferGuaranteeService.queryBillTransferGuaranteeByPage(billTransferGuaranteeDO,pageable);
        Iterator<BillTransferGuaranteeDO> iterator = list.iterator();
        System.out.println(list.getNumber());
        System.out.println(list.getSize());
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

} 
