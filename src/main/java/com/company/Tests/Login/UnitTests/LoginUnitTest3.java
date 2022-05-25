package com.company.Tests.Login.UnitTests;

import com.company.Tests.Login.LoginResponse;
import com.company.Tests.Test;
import com.company.Tests.UnitTest;

import java.io.IOException;

public class LoginUnitTest3 extends UnitTest {
    public LoginUnitTest3(Test test) {
        super(test, "With wrong email format, response code should be 1001 and data should be null");
    }

    @Override
    public void test() throws IOException {
        this.params.put("email", "thanh12345com");
        this.params.put("password", "12345654sdf6");

        LoginResponse res = this.sendPostRequest(LoginResponse.class);

        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);
    }
}
