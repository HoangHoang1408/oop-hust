package com.company.TestManager.Tests._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._1SignUp.SignUpResponse;
import com.company.TestManager.Tests._1SignUp.SignUpTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SignUpUnitTest2 extends UnitTest {

    public SignUpUnitTest2(Test test) {
        super(test, "Can not sign up with duplicated emails");
    }

    @Override
    public void test() throws IOException {
        this.params = SignUpTest.generateDefaultParams();

        this.sendPostRequest(SignUpResponse.class);
        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);

        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.data, null);
    }
}
