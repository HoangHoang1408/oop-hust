package com.company.TestManager.Tests._2Login.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._2Login.LoginResponse;
import com.company.TestManager.UnitTest;

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
        this.assertion.assertInstanceOf(res.message, String.class);
        this.assertion.assertEquals(res.code, 1002);
        this.assertion.assertEquals(res.data, null);

        this.params.clear();

        this.params.put("email", "thanh12345345@gmail.com");
        this.params.put("password", "123dg456");
        res = this.sendPostRequest(LoginResponse.class);

        this.assertion.assertInstanceOf(res.message, String.class);
        this.assertion.assertEquals(res.code, 1002);
        this.assertion.assertEquals(res.data, null);

    }
}
