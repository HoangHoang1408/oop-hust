package com.company.Tests.SignUp.UnitTests;

import com.company.Tests.SignUp.SignUpResponse;
import com.company.Tests.Test;
import com.company.Tests.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class SignUpUnitTest2 extends UnitTest {

    public SignUpUnitTest2(Test test) {
        super(test, "Can not sign up with duplicate email addresses");
    }

    @Override
    public void startUnitTest() throws IOException {
        String email = Util.randomAlphabetString(8) + "@gmail.com";
        String password = "1231231234";
        String name = Util.randomAlphabetString(6);
        String phone = Util.randomNumberString(10);

        this.params.put("email", email);
        this.params.put("password", password);
        this.params.put("re_pass", password);
        this.params.put("name", name);
        this.params.put("phone", phone);

        this.sendPostRequest(SignUpResponse.class);
        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);

        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.data, null);
        this.assertionManager.judge();
    }
}
