package com.company.TestManager.Tests._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._1SignUp.SignUpResponse;
import com.company.TestManager.Tests._1SignUp.SignUpTest;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class SignUpUnitTest9 extends UnitTest {
    public SignUpUnitTest9(Test test) {
        super(test, "Can not sign up with more than 255 character in email or empty email");
    }

    @Override
    protected void test() throws IOException {
        this.params = SignUpTest.generateDefaultParams();
        this.params.put("email", Util.randomAlphabetOrNumberString(200, 56) + "gmail.com");

        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);
        this.assertionManager.assertBoolean(res.message.length() > 0);

        this.params.put("email", "");
        res = this.sendPostRequest(SignUpResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);
        this.assertionManager.assertBoolean(res.message.length() > 0);
    }
}
