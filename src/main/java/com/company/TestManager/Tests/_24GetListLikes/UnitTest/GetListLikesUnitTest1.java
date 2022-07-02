package com.company.TestManager.Tests._24GetListLikes.UnitTest;

import com.company.TestManager.Tests._24GetListLikes.GetListLikesResponse;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Test;

import java.io.IOException;

public class GetListLikesUnitTest1 extends UnitTest {
    public GetListLikesUnitTest1(Test test){
        super(test,"Loggined, code should be 1000, data should be not null");
    }
    @Override
    public void test() throws IOException{
        this.params.put("index","1");
        this.params.put("count","1");
        GetListLikesResponse res=this.sendGetRequestWithAccessToken(GetListLikesResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertNotEquals(res.data, null);

    }
}
