package com.company.TestManager.Tests._12EditAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._12EditAuction.EditAuctionResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.ConnectionUtil;
import com.company.utils.Util;

import java.io.IOException;

public class EditAuctionUnitTest10 extends UnitTest  {
    public EditAuctionUnitTest10(Test test){super(test,
            "if the data format of the end_date field is incorrect, response code 1001 and data must be null");}
    @Override
    public void test() throws IOException{
        this.params = this.generateDefaultParams();
        this.params.put("end_date", "2023_12_221");

        EditAuctionResponse res = ConnectionUtil.sendPostRequest(this.fullURLString +"/" + Util.randomNumberString(1, 60 ,77), this.params, EditAuctionResponse.class, this.getAccessToken());

        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);


    }
}
