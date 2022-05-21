package com.company.Tests.Logout;

import com.company.BaseURL;
import com.company.Tests.Logout.UnitTests.LogoutUnitTest1;
import com.company.Tests.Logout.UnitTests.LogoutUnitTest2;
import com.company.Tests.Test;

import java.util.List;

public class LogoutTest extends Test {
    public LogoutTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new LogoutUnitTest1(this), new LogoutUnitTest2(this)));
    }
}
