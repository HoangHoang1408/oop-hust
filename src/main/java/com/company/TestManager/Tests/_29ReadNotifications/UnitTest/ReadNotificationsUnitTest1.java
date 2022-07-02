package com.company.TestManager.Tests._29ReadNotifications.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._29ReadNotifications.ReadNotificationsResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class ReadNotificationsUnitTest1 extends UnitTest {
    public ReadNotificationsUnitTest1(Test test) {
        super(test, "Logined, Response code should be 1000, Notice from refuse the auction from admin side");
    }

    @Override
    public void test() throws IOException {
        ReadNotificationsResponse res = Connection.sendGetRequest(this.fullURLString + "/1", this.params, ReadNotificationsResponse.class, getAccessToken());

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.data.auction_id.length() > 0);
        this.assertion.assertTrue(Integer.parseInt(res.data.is_read) >= 0);
    }

}
