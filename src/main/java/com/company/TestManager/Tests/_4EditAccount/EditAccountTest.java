package com.company.TestManager.Tests._4EditAccount;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._4EditAccount.UnitTests.*;

import java.util.List;

public class EditAccountTest extends Test {
    public EditAccountTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new EditAccountUnitTest1(this), new EditAccountUnitTest2(this), new EditAccountUnitTest3(this), new EditAccountUnitTest4(this),
                new EditAccountUnitTest5(this), new EditAccountUnitTest6(this), new EditAccountUnitTest7(this), new EditAccountUnitTest8(this),
                new EditAccountUnitTest9(this), new EditAccountUnitTest10(this), new EditAccountUnitTest11(this), new EditAccountUnitTest12(this),
                new EditAccountUnitTest13(this), new EditAccountUnitTest14(this), new EditAccountUnitTest15(this)));
    }
}
