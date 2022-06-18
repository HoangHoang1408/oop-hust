package com.company.TestManager.Tests._5Search.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._5Search.SearchResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SearchUnitTest5 extends UnitTest {
    public SearchUnitTest5(Test test) {
        super(test, "Can search for auctions with correct starting price (type = 1)");
    }

    @Override
    protected void test() throws IOException {
        this.params.put("type", "1");
        this.params.put("key", "90");
        SearchResponse res = this.sendGetRequest(SearchResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertBoolean(res.data.size() > 0);
    }
}
