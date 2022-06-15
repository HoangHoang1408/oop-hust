package com.company.TestManager.Tests._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._1SignUp.SignUpResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class SignUpUnitTest12 extends UnitTest {
    public SignUpUnitTest12(Test test) {
        super(test, "Can not sign up when password and re_pass are not matched");
    }

    @Override
    protected void test() throws IOException {
        this.params = this.generateDefaultParams();
        this.params.put("password", Util.randomAlphabetOrNumberString(10, 10));
        this.params.put("re_pass", Util.randomAlphabetOrNumberString(10, 10));

        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);
        this.assertionManager.assertBoolean(res.message.length() > 0);
    }
}
