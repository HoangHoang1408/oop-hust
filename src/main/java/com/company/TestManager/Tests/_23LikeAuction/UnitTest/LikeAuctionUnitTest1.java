package com.company.TestManager.Tests._23LikeAuction.UnitTest;

import com.company.TestManager.Tests._23LikeAuction.LikeAuctionResponse;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Test;
import com.company.utils.ConnectionUtil;

import java.io.IOException;

public class LikeAuctionUnitTest1 extends UnitTest {
    public LikeAuctionUnitTest1(Test test){
        super(test,"Loggined, response code should be 1000, data should not be null and Did you like the auction?");
    }
    @Override
    public void test() throws IOException{
        LikeAuctionResponse res = ConnectionUtil.sendPostRequest(this.fullURLString+"/5", this.params, LikeAuctionResponse.class, getAccessToken());
        this.assertionManager.assertNotEquals(res,null);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertNotEquals(res.message, null);
        this.assertionManager.assertNotEquals(res.data, null);
    }
}
