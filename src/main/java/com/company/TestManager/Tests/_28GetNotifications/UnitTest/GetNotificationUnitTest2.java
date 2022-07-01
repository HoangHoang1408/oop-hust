package com.company.TestManager.Tests._28GetNotifications.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Tests._28GetNotifications.GetNotificationsResponse;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Test;

import java.io.IOException;

public class GetNotificationUnitTest2 extends UnitTest {
    public GetNotificationUnitTest2(Test test){
        super(test,"Not Loggined, code should be 1004, data should be null");
    }
    @Override
    public void test() throws IOException{
        String accessToken="fskdfnsdjflksdfjlskdfklksdfjlsdklfsdklfksl";
        GetNotificationsResponse res= Connection.sendGetRequest(fullURLString, this.params, GetNotificationsResponse.class, accessToken);
        this.assertion.assertEquals(res, null);
        this.assertion.assertEquals(res.code, 1004);
    }
}
