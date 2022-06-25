package com.company.TestManager.Tests._23LikeAuction;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._23LikeAuction.UnitTest.LikeAuctionUnitTest1;

import java.util.List;

public class LikeAuctionTest extends Test {
    public LikeAuctionTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new LikeAuctionUnitTest1(this)));
    }
}
