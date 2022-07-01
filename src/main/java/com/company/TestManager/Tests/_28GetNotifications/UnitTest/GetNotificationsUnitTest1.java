package com.company.TestManager.Tests._28GetNotifications.UnitTest;

import com.company.TestManager.Tests._28GetNotifications.GetNotificationsResponse;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Test;

import java.io.IOException;

public class GetNotificationsUnitTest1 extends UnitTest {
    public GetNotificationsUnitTest1(Test test){
        super(test,"Notification list of rejected auctions, code should be 1000");
    }
    @Override
    public void test() throws IOException{
        this.params.put("index","1");
        this.params.put("count","1");
        GetNotificationsResponse res= this.sendGetRequestWithAccessToken(GetNotificationsResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertNotEquals(res.data,null);
    }
}
