package com.company.TestManager.Tests._5Search.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._5Search.SearchResponse;
import com.company.TestManager.Tests._5Search.SearchTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SearchUnitTest1 extends UnitTest {
    public SearchUnitTest1(Test test) {
        super(test, "Can search for existed auctions by name (type = 4)");
    }

    @Override
    protected void test() throws IOException {
        this.params.put("type", "4");
        this.params.put("key", SearchTest.testAuctionData.title);
        SearchResponse res = this.sendGetRequest(SearchResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertNotEquals(res.data, null);
        this.assertionManager.assertBoolean(res.data.size() > 0);
    }
}
