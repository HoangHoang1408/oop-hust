package com.company.Tests.Login.UnitTests;

import com.company.Tests.Login.LoginResponse;
import com.company.Tests.Test;
import com.company.Tests.UnitTest;

import java.io.IOException;

public class LoginUnitTest2 extends UnitTest {

    public LoginUnitTest2(Test test) {
        super(test, "With wrong email or password, response code should be 1002 and data should be null");
    }

    @Override
    public void test() throws IOException {

        this.params.put("email", "thanh12345@gmail.com");
        this.params.put("password", "123456546");
        LoginResponse res = this.sendPostRequest(LoginResponse.class);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.code, 1002);
        this.assertionManager.assertEquals(res.data, null);

        this.params.clear();

        this.params.put("email", "thanh12345345@gmail.com");
        this.params.put("password", "123dg456");
        res = this.sendPostRequest(LoginResponse.class);

        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.code, 1002);
        this.assertionManager.assertEquals(res.data, null);

    }
}
