package com.company.TestManager.Tests._5Search.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._5Search.SearchResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SearchUnitTest6 extends UnitTest {
    public SearchUnitTest6(Test test) {
        super(test, "Can not search for auctions with wrong starting price (type = 1)");
    }

    @Override
    protected void test() throws IOException {
        this.params.put("type", "1");
        this.params.put("key", "40395");
        SearchResponse res = this.sendGetRequest(SearchResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 9998);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertEquals(res.data, null);

        this.params.put("key", "lksf98ds");
        res = this.sendGetRequest(SearchResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 9998);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertEquals(res.data, null);
    }
}
