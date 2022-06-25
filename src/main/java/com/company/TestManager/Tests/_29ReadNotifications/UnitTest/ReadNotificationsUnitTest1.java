package com.company.TestManager.Tests._29ReadNotifications.UnitTest;

import com.company.TestManager.Tests._29ReadNotifications.ReadNotificationsResponse;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Test;
import com.company.utils.ConnectionUtil;

import java.io.IOException;

public class ReadNotificationsUnitTest1 extends UnitTest {
    public ReadNotificationsUnitTest1(Test test){
        super(test,"Logined, Notice from refuse the auction from admin side");
    }
    @Override
    public void test() throws IOException{
        ReadNotificationsResponse res = ConnectionUtil.sendGetRequest(this.fullURLString+"/1",this.params,ReadNotificationsResponse.class,getAccessToken());
        this.assertionManager.assertNotEquals(res,null);
        this.assertionManager.assertNotEquals(res.data,null);
        this.assertionManager.assertEquals(res.data.is_read,"1");
    }

}
