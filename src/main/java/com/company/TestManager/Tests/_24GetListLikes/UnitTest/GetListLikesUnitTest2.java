package com.company.TestManager.Tests._24GetListLikes.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Tests._24GetListLikes.GetListLikesResponse;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Test;

import java.io.IOException;

public class GetListLikesUnitTest2 extends UnitTest {
    public GetListLikesUnitTest2(Test test){
        super(test, "Not Loggined, code should be 1004, data should be null");
    }
    @Override
    public void test() throws IOException{
        String accessToken="asfpdsfopdsofpdsfpodsifpdsofpdofpsodfpsod";
        GetListLikesResponse res= Connection.sendGetRequest(fullURLString, this.params, GetListLikesResponse.class, accessToken);
        this.assertion.assertEquals(res, null);
        this.assertion.assertEquals(res.code, 1004);
    }
}
