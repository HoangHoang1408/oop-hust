package com.company.TestManager.TestAPIs._4EditAccount.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class EditAccountUnitTest4 extends UnitTest {
    public EditAccountUnitTest4(Test test) {
        super(test, "Can edit account with correct access token");
    }

    @Override
    public void test() throws IOException {
        //        create request object
        this.params.put("email", "Cubee@gmail.com");
        this.params.put("password", "12345678");
        this.params.put("re_pass", "12345678");
        this.params.put("name", "thanh");
        this.params.put("phone", "0826518516");

        EditAccountResponse res = this.sendPostRequestWithAccessToken(EditAccountResponse.class);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertInstanceOf(res.message, String.class);

    }
}

