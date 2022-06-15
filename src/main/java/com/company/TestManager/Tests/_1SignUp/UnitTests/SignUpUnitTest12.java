package com.company.TestManager.Tests._1SignUp.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SignUpUnitTest12 extends UnitTest {
    public SignUpUnitTest12(Test test, String expectation) {
        super(test, "Can not sign up when password and re_pass are not matched");
    }

    @Override
    protected void test() throws IOException {
        String password = "k34jl23j";
        String re_pass = "3404knre4";
        
    }
}
