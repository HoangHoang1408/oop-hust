package com.company.TestManager.Tests._12EditAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._12EditAuction.EditAuctionResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.ConnectionUtil;
import com.company.utils.Util;

import java.io.IOException;

public class EditAuctionUnitTest8 extends UnitTest  {
    public EditAuctionUnitTest8(Test test){super(test,
        "if time starts before current time, response code will be 1001 and data should be null");}
    @Override
    public void test() throws IOException{
        this.params = this.generateDefaultParams();
        this.params.put("start_date", "2021-06-12 00:00:00");

        EditAuctionResponse res = ConnectionUtil.sendPostRequest(this.fullURLString +"/" + Util.randomNumberString(1, 60 ,77), this.params, EditAuctionResponse.class, this.getAccessToken());

        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);


    }
}
