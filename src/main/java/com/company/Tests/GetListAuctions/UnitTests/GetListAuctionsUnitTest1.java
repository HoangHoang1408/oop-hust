package com.company.Tests.GetListAuctions.UnitTests;

import com.company.Tests.GetListAuctions.GetListAuctionsResponse;
import com.company.Tests.Test;
import com.company.Tests.UnitTest;

import java.io.IOException;

public class GetListAuctionsUnitTest1 extends UnitTest {
    public GetListAuctionsUnitTest1(Test test) {
        super(test, "With correct params, response code should be 1000, data should not be null and number of auctions should be smaller or equal to count");
    }

    @Override
    public void startUnitTest() throws IOException {
        String index = "1";
        String count = "5";
        this.params.put("index", "1");
        this.params.put("count", "5");
        GetListAuctionsResponse res = this.sendGetRequestWithAccessToken(GetListAuctionsResponse.class);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertBoolean(res.data.auctions.size() <= Integer.parseInt(count));
        this.assertionManager.judge();
    }
}
