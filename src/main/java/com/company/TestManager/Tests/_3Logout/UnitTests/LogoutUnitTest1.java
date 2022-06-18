package com.company.TestManager.Tests._3Logout.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._3Logout.LogoutResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class LogoutUnitTest1 extends UnitTest {
    public LogoutUnitTest1(Test test) {
        super(test, "Can log out with correct access token");
    }

    @Override
    public void test() throws IOException {
        LogoutResponse res = this.sendPostRequestWithAccessToken(LogoutResponse.class);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertEquals(res.data, null);
    }
}
