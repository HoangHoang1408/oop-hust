package com.company.TestManager.Tests._26GetNews.UnitTest;

import com.company.TestManager.Tests._26GetNews.GetNewsResponse;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Test;
import com.company.TestManager.Connection;

import java.io.IOException;

public class GetNewsUnitTest1 extends UnitTest {
    public GetNewsUnitTest1(Test test){
        super(test, "With correct params, response code should be 1000 and data should not be null ");
    }
    @Override
    public void test() throws IOException{
        this.params.put("index","0");
        this.params.put("count","1");
        GetNewsResponse res= Connection.sendGetRequest(this.fullURLString,this.params,GetNewsResponse.class,getAccessToken());
        this.assertion.assertNotEquals(res,null);
        this.assertion.assertEquals(res.code,1000);
        this.assertion.assertNotEquals(res.data,null);

    }
}
