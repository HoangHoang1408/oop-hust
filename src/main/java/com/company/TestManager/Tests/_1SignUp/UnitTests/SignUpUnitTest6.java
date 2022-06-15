package com.company.TestManager.Tests._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._1SignUp.SignUpResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SignUpUnitTest6 extends UnitTest {

    public SignUpUnitTest6(Test test) {
        super(test, "Can not sign up with empty phone");
    }

    @Override
    protected void test() throws IOException {
        this.params = this.generateDefaultParams();
        this.params.put("phone", "");

        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);
        this.assertionManager.assertBoolean(res.message.length() > 0);
    }
}
