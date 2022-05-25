package com.company.TestManager.Tests._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Tests._1SignUp.SignUpResponse;
import com.company.utils.Util;

import java.io.IOException;

public class SignUpUnitTest1 extends UnitTest {
    public SignUpUnitTest1(Test test) {
        super(test, "With correct params format, the response code and message strings shall be not null as well as non-empty");
    }

    @Override
    public void test() throws IOException {
        //        create request object
        this.params.put("email", Util.randomAlphabetString(8) + "@gmail.com");
        this.params.put("password", "12345678");
        this.params.put("re_pass", "12345678");
        this.params.put("name", "hoang");
        this.params.put("phone", "0932198999");

        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);

        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertInstanceOf(res.message, String.class);
    }
}
