package com.company.TestManager.Tests._12EditAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._12EditAuction.EditAuctionResponse;
import com.company.TestManager.Tests._12EditAuction.EditAuctionTest;
import com.company.TestManager.UnitTest;
import com.company.utils.ConnectionUtil;
import com.company.utils.Util;

import java.io.IOException;

public class EditAuctionUnitTest11 extends UnitTest  {
    public EditAuctionUnitTest11(Test test){super(test,
            "if the end time is earlier than the start time, the response code will be 1001 and the data should be null");}
    @Override
    public void test() throws IOException{
        this.params = EditAuctionTest.generateDefaultParams();
        this.params.put("end_date", "2023-06-19 11:03:38");

        EditAuctionResponse res = ConnectionUtil.sendPostRequest(this.fullURLString +"/" + Util.randomNumberString(1, 60 ,77), this.params, EditAuctionResponse.class, this.getAccessToken());

        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);


    }
}
