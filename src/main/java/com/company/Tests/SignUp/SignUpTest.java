package com.company.Tests.SignUp;

import com.company.BaseURL;
import com.company.Tests.SignUp.UnitTests.SignUpUnitTest1;
import com.company.Tests.SignUp.UnitTests.SignUpUnitTest2;
import com.company.Tests.Test;

import java.util.List;

public class SignUpTest extends Test {
    public SignUpTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new SignUpUnitTest1(this), new SignUpUnitTest2(this)));
    }


}
