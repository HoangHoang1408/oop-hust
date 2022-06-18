package com.company.TestManager.Tests._2Login.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._2Login.LoginResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class LoginUnitTest5 extends UnitTest {
    public LoginUnitTest5(Test test) {
        super(test, "Can not log in with more than 255 characters in password or empty password");
    }

    @Override
    protected void test() throws IOException {
        this.params.put("email", "hoang1482002@gmail.com");
        this.params.put("password", Util.randomAlphabetOrNumberString(200, 60));
        LoginResponse res = this.sendPostRequest(LoginResponse.class);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);

        this.params.clear();
        this.params.put("email", "hoang1482002@gmail.com");
        this.params.put("password", "");
        res = this.sendPostRequest(LoginResponse.class);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);
    }
}
