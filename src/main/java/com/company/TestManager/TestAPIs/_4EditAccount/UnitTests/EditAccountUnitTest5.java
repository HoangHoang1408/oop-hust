package com.company.TestManager.TestAPIs._4EditAccount.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class EditAccountUnitTest5 extends UnitTest {
    public EditAccountUnitTest5(Test test) {
        super(test, "wrong email format - Can not edit account with wrong access token ");
    }

    public void test() throws IOException {
        //        create request object
        this.params.put("email", "Cubee");
        this.params.put("password", "12345678");
        this.params.put("re_pass", "12345678");
        this.params.put("name", "thanh");
        this.params.put("address", Util.randomAlphabetString(20));
        this.params.put("phone", "0826528516");

        EditAccountResponse res = this.sendPostRequestWithAccessToken(EditAccountResponse.class);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertInstanceOf(res.message, String.class);
    }
}
