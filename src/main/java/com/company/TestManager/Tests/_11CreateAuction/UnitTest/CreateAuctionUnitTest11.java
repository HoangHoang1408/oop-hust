package com.company.TestManager.Tests._11CreateAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateAuctionUnitTest11 extends UnitTest {
    public CreateAuctionUnitTest11(Test test) {
        super(test, "Auction title is unique, Server will return code 1001");
    }

    @Override
    public void test() throws IOException {
        this.params.put("category_id", "5");
        this.params.put("start_date", "2023-06-20 11:03:38");
        this.params.put("end_date", "2023-06-30 11:03:38 ");
        this.params.put("title_ni", "bao lo LUOIVUITUOI");

        CreateAuctionResponse res = sendPostRequestWithAccessToken(CreateAuctionResponse.class);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.data, null);

    }
}
