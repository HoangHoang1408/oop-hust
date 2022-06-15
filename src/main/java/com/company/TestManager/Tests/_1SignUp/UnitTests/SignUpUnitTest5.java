package com.company.TestManager.Tests._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._1SignUp.SignUpResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class SignUpUnitTest5 extends UnitTest {
    public SignUpUnitTest5(Test test) {
        super(test, "Can not sign up with more than 60 characters in phone");
    }

    @Override
    protected void test() throws IOException {
        this.params = this.generateDefaultParams();
        this.params.put("phone", Util.randomNumberString(61));

        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);
        this.assertionManager.assertBoolean(res.message.length() > 0);
    }
}
