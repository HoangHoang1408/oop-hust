package com.company.TestManager.Tests._11CreateAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateAuctionUnitTest7 extends UnitTest {
    public CreateAuctionUnitTest7(Test test) {
        super(test, "field 'end_date' has not been entered, Server will return code 1001");
    }

    @Override
    public void test() throws IOException {
        this.params = CreateAuctionTest.generateDefaultParams();
        this.params.put("end_date", "");

        CreateAuctionResponse res = sendPostRequestWithAccessToken(CreateAuctionResponse.class);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.data, null);

    }
}
