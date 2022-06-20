package com.company.TestManager.Tests._5Search.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._5Search.SearchResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SearchUnitTest7 extends UnitTest {
    public SearchUnitTest7(Test test) {
        super(test, "Empty result when searching for auctions with wrong starting time (type = 2)");
    }

    @Override
    protected void test() throws IOException {
        this.params.put("type", "2");
        this.params.put("key", "5555-06-07 11:03:00");
        SearchResponse res = this.sendGetRequest(SearchResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 9998);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertEquals(res.data, null);

        this.params.put("key", "wrong format");
        res = this.sendGetRequest(SearchResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 9998);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertEquals(res.data, null);
    }
}
