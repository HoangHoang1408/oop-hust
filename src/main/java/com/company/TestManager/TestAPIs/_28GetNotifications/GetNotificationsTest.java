package com.company.TestManager.TestAPIs._28GetNotifications;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._28GetNotifications.UnitTest.GetNotificationUnitTest2;
import com.company.TestManager.TestAPIs._28GetNotifications.UnitTest.GetNotificationsUnitTest1;

import java.util.List;

public class GetNotificationsTest extends Test {
    public GetNotificationsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetNotificationsUnitTest1(this),new GetNotificationUnitTest2(this)));
    }
}
