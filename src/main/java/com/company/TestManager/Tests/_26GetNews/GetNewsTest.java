package com.company.TestManager.Tests._26GetNews;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._26GetNews.UnitTest.GetNewsUnitTest1;

import java.util.List;

public class GetNewsTest extends Test {
    public GetNewsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetNewsUnitTest1(this)));
    }

}
