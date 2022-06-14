package com.company.TestManager.Tests._1SignUp;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._1SignUp.UnitTests.SignUpUnitTest1;
import com.company.TestManager.Tests._1SignUp.UnitTests.SignUpUnitTest2;
import com.company.TestManager.Tests._1SignUp.UnitTests.SignUpUnitTest3;
import com.company.TestManager.Tests._1SignUp.UnitTests.SignUpUnitTest4;

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
                new SignUpUnitTest4(this)
        ));
    }


}
