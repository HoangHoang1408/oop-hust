package com.company.TestManager.Tests._15GetListComments.UnitTest;

import com.company.TestManager.Tests._15GetListComments.GetListCommentResponse;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Test;
import com.company.utils.ConnectionUtil;

import java.io.IOException;

public class GetListCommentUnitTest1 extends UnitTest {
    public GetListCommentUnitTest1(Test test){
        super(test,"Logged in, the auction's comment book");
    }
    @Override
    public void test() throws IOException{
        this.params.put("index","1");
        this.params.put("count","1");
        GetListCommentResponse res= ConnectionUtil.sendGetRequest(this.fullURLString+ "/1",this.params, GetListCommentResponse.class, getAccessToken());
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertNotEquals(res.data, null);
    }
}
