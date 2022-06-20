package com.company.TestManager.Tests._10GetDetailsAuctions.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._10GetDetailsAuctions.GetDetailsAuctionsResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.ConnectionUtil;

import java.io.IOException;

public class GetDetailsAuctionsUnitTest1 extends UnitTest {
    public GetDetailsAuctionsUnitTest1(Test test) {
        super(test, "With correct params, response code should be 1000 and data should not be null ");
    }
    @Override
    public void test() throws IOException {
        GetDetailsAuctionsResponse res = ConnectionUtil.sendGetRequest(this.fullURLString + "/1", this.params, GetDetailsAuctionsResponse.class, this.getAccessToken());

        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertNotEquals(res.data, null);
        this.assertionManager.assertNotEquals(res.data.auctions, null);
        this.assertionManager.assertNotEquals(res.data.category, null);
        this.assertionManager.assertNotEquals(res.data.items, null);
        this.assertionManager.assertNotEquals(res.data.selling_user, null);


    }
}
