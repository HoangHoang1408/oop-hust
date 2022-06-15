package com.company.TestManager.Tests._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._1SignUp.SignUpResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class SignUpUnitTest10 extends UnitTest {
    public SignUpUnitTest10(Test test) {
        super(test, "Can not sign up with more than 255 characters in password and repass or empty password");
    }

    @Override
    protected void test() throws IOException {
        String password = Util.randomAlphabetString(260);

        this.params.put("email", Util.randomAlphabetString(10) + "@gmail.com");
        this.params.put("password", password);
        this.params.put("re_pass", password);
        this.params.put("name", Util.randomAlphabetString(10));
        this.params.put("address", Util.randomAlphabetString(260));
        this.params.put("phone", Util.randomNumberString(10));

        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);
        this.assertionManager.assertBoolean(res.message.length() > 0);

        this.params.put("password", null);
        this.params.put("re_pass", null);
        res = this.sendPostRequest(SignUpResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);
        this.assertionManager.assertBoolean(res.message.length() > 0);
    }
}