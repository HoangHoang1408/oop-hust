package com.company.TestManager.TestAPIs._29ReadNotifications;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._29ReadNotifications.UnitTest.ReadNotificationsUnitTest1;

import java.util.List;

public class ReadNotificationsTest extends Test {
    public ReadNotificationsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new ReadNotificationsUnitTest1(this)));

    }
}
