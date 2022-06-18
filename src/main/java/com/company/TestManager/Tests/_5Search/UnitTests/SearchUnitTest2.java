package com.company.TestManager.Tests._5Search.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._5Search.SearchResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SearchUnitTest2 extends UnitTest {
    public SearchUnitTest2(Test test) {
        super(test, "Empty result when searching for auction names doesnt exist (type = 4)");
    }

    @Override
    protected void test() throws IOException {
        this.params.put("type", "4");
        this.params.put("key", "hflsjlfl");
        SearchResponse res = this.sendGetRequestWithAccessToken(SearchResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 9998);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertEquals(res.data, null);
    }
}
