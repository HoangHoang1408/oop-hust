package com.company.Tests.Logout.UnitTests;

import com.company.Tests.Logout.LogoutResponse;
import com.company.Tests.Test;
import com.company.Tests.UnitTest;
import com.company.utils.ConnectionUtil;

import java.io.IOException;

public class LogoutUnitTest2 extends UnitTest {
    public LogoutUnitTest2(Test test) {
        super(test, "Can not log out with wrong access token");
    }

    @Override
    public void test() throws IOException {
        String accessToken = "djsldfgdfdsfsdgdfwrong214fgjksldfgjsdaNiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5cdgjdfgdklzfg"; //wrong access token
        LogoutResponse res = ConnectionUtil.sendPostRequest(this.fullURLString, this.params, LogoutResponse.class, accessToken);
        this.assertionManager.assertEquals(res.code, 1004);
        this.assertionManager.assertEquals(res.data, null);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertBoolean(res.message.length() > 0);
    }
}
