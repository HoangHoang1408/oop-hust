package com.company.TestManager.Tests._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._1SignUp.SignUpResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class SignUpUnitTest3 extends UnitTest {
    public SignUpUnitTest3(Test test) {
        super(test, "Can not sign up with more than 255 characters in name");
    }


    @Override
    protected void test() throws IOException {
        String password = "1231231234";
        String phone = Util.randomNumberString(10);

        this.params.put("email", Util.randomAlphabetString(10) + "@gmail.com");
        this.params.put("password", password);
        this.params.put("re_pass", password);
        this.params.put("name", Util.randomAlphabetString(260));
        this.params.put("phone", phone);

        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);
        this.assertionManager.assertBoolean(res.message.length() > 0);
    }
}
