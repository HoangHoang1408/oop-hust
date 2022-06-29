package com.company.TestManager.Tests._25TotalLikesOfAuction.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._25TotalLikesOfAuction.TotalLikesOfAuctionResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class TotalLikesOfAuctionUnitTest1 extends UnitTest {
    public TotalLikesOfAuctionUnitTest1(Test test) {
        super(test, " Response code should be 1000 and data should not be null");
    }

    @Override
    public void test() throws IOException {
        TotalLikesOfAuctionResponse res = Connection.sendGetRequest(this.fullURLString + "/1", this.params, TotalLikesOfAuctionResponse.class, getAccessToken());
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertNotEquals(res.data, null);
    }
}
