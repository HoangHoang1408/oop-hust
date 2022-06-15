package com.company.TestManager.Tests._1SignUp;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._1SignUp.UnitTests.*;

import java.util.List;

public class SignUpTest extends Test {
    public SignUpTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(
                new SignUpUnitTest1(this),
                new SignUpUnitTest2(this),
                new SignUpUnitTest3(this),
                new SignUpUnitTest4(this),
                new SignUpUnitTest5(this),
                new SignUpUnitTest6(this),
                new SignUpUnitTest7(this),
                new SignUpUnitTest8(this),
                new SignUpUnitTest9(this),
                new SignUpUnitTest10(this),
                new SignUpUnitTest11(this),
                new SignUpUnitTest12(this)
        ));
    }


}
