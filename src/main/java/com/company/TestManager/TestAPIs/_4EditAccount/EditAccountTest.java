package com.company.TestManager.TestAPIs._4EditAccount;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._4EditAccount.UnitTests.*;
import com.company.utils.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditAccountTest extends Test {
    public EditAccountTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    public static HashMap<String, String> generateDefaultParams() {
        String email = Util.randomAlphabetOrNumberString(8, 0) + "@gmail.com";
        String password = Util.randomAlphabetOrNumberString(6, 4);
        String name = Util.randomAlphabetString(6);
        String phone = Util.randomNumberString(10);
        String address = Util.randomAlphabetOrNumberString(6, 6);
        return new HashMap<>(Map.of(
                "email", email,
                "password", password,
                "re_pass", password,
                "name", name,
                "phone", phone,
                "address", address
        ));
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new EditAccountUnitTest1(this), new EditAccountUnitTest2(this), new EditAccountUnitTest3(this), new EditAccountUnitTest4(this),
                new EditAccountUnitTest5(this), new EditAccountUnitTest6(this), new EditAccountUnitTest7(this), new EditAccountUnitTest8(this),
                new EditAccountUnitTest9(this), new EditAccountUnitTest10(this), new EditAccountUnitTest11(this), new EditAccountUnitTest12(this),
                new EditAccountUnitTest13(this), new EditAccountUnitTest14(this), new EditAccountUnitTest15(this)));
    }
}
