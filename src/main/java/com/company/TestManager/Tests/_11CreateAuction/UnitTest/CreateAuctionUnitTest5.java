package com.company.TestManager.Tests._11CreateAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateAuctionUnitTest5 extends UnitTest {
    public CreateAuctionUnitTest5(Test test) {
        super(test, "Data format of field 'start_date' incorrect, Server will return code 1001");
    }

    @Override
    public void test() throws IOException {
        this.params = this.generateDefaultParams();
        this.params.put("start_date", "2023_6_12");


        CreateAuctionResponse res = sendPostRequestWithAccessToken(CreateAuctionResponse.class);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.data, null);

    }
}
