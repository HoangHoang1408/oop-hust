package com.company.TestManager.Tests._26GetNews.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._26GetNews.GetNewsResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class GetNewsUnitTest1 extends UnitTest {
    public GetNewsUnitTest1(Test test){super(test, "With correct params format, the response code and message strings shall be not null as well as non-empty");}

    @Override
    public void test() throws IOException{
        this.params.put("index","0");
        this.params.put("count", "10");
        GetNewsResponse res = this.sendGetRequestWithAccessToken(GetNewsResponse.class);
    }
}
