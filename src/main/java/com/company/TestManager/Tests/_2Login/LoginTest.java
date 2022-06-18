package com.company.TestManager.Tests._2Login;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._2Login.UnitTests.*;

import java.util.List;

// class kế thừa class test với mục đích thêm các unit test
public class LoginTest extends Test {
    public LoginTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
//    phương thức cần phải ghi đè từ phương thức của class cha
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(
                new LoginUnitTest1(this),
                new LoginUnitTest2(this),
                new LoginUnitTest3(this),
                new LoginUnitTest4(this),
                new LoginUnitTest5(this)
        ));
    }
}
