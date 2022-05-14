package com.company.Tests.Logout.UnitTests;

import com.company.Tests.Logout.LogoutResponse;
import com.company.Tests.Test;
import com.company.Tests.UnitTest;

import java.io.IOException;

public class LogoutUnitTest1 extends UnitTest {
    public LogoutUnitTest1(Test test) {
        super(test, "Can log out with correct access token");
    }

    @Override
    public void startUnitTest() throws IOException {
        LogoutResponse res = this.sendPostRequestWithAccessToken(LogoutResponse.class);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertNotEquals(res.message, "");
        this.assertionManager.assertEquals(res.data, null);
        this.assertionManager.judge();
    }
}
