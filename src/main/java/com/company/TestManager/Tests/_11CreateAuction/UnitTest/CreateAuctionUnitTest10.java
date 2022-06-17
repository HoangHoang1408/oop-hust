package com.company.TestManager.Tests._11CreateAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateAuctionUnitTest10 extends UnitTest {
    public CreateAuctionUnitTest10(Test test) {
        super(test, "field 'title_ni' has not been entered, Server will return code 1001");
    }

    @Override
    public void test() throws IOException {
        this.params = this.generateDefaultParams();
        this.params.put("title_ni", "");

        CreateAuctionResponse res = sendPostRequestWithAccessToken(CreateAuctionResponse.class);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.data, null);

    }
}
