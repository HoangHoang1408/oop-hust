package com.company.TestManager.Tests._5Search;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._5Search.UnitTests.*;

import java.util.List;

public class SearchTest extends Test {
    public SearchTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(
                new SearchUnitTest1(this),
                new SearchUnitTest2(this),
                new SearchUnitTest3(this),
                new SearchUnitTest4(this),
                new SearchUnitTest5(this)
        ));

    }
}
