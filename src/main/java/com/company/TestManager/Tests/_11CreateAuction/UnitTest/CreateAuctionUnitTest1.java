package com.company.TestManager.Tests._11CreateAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class CreateAuctionUnitTest1 extends UnitTest {
    public CreateAuctionUnitTest1(Test test) {
        super(test, "With correct params, response code should be 1000 and data should not be null ");
    }

    @Override
    public void test() throws IOException {
        this.params.put("category_id", "5");
        this.params.put("start_date", "2023-06-18 11:03:38");
        this.params.put("end_date", "2023-06-20 11:03:38");
        this.params.put("title_ni", "Tui xach "+Util.randomAlphabetString(20));

        CreateAuctionResponse res = sendPostRequestWithAccessToken(CreateAuctionResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertNotEquals(res.data, null);


}



}
