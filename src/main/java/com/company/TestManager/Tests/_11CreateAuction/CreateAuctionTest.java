package com.company.TestManager.Tests._11CreateAuction;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.UnitTest.*;


import java.util.List;

public class CreateAuctionTest extends Test {
    public CreateAuctionTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of( new CreateAuctionUnitTest1(this), new CreateAuctionUnitTest2(this),new CreateAuctionUnitTest3(this),
                                       new CreateAuctionUnitTest4(this), new CreateAuctionUnitTest5(this),new CreateAuctionUnitTest6(this),
                                       new CreateAuctionUnitTest7(this), new CreateAuctionUnitTest8(this),new CreateAuctionUnitTest9(this),
                                       new CreateAuctionUnitTest10(this), new CreateAuctionUnitTest11(this)));
    }
}
