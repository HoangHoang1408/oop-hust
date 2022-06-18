package com.company.TestManager.Tests._5Search.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._5Search.SearchResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SearchUnitTest3 extends UnitTest {
    public SearchUnitTest3(Test test) {
        super(test, "Can search for existed auctions by starting time (type = 2)");
    }

    @Override
    protected void test() throws IOException {
        this.params.put("type", "2");
        this.params.put("key", "2022-06-07 11:03:00");
        SearchResponse res = this.sendGetRequestWithAccessToken(SearchResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertBoolean(res.data.size() > 0);
    }
}
