package com.company.Tests;

import com.company.Tests.Login.LoginResponse;
import com.company.constants.Constant;
import com.company.utils.ConnectionUtil;

import java.io.IOException;
import java.util.HashMap;

public abstract class UnitTest {
    protected final Test test;
    protected String expectation;
    protected HashMap<String, String> params;
    protected String fullURLString;
    protected AssertionManager assertionManager;

    public UnitTest(Test test, String expectation) {
        this.params = new HashMap<>();
        this.test = test;
        this.fullURLString = this.test.getFullURLString();
        this.expectation = expectation;
        this.assertionManager = new AssertionManager(expectation);
    }

    private String getAccessToken() throws IOException {
        HashMap<String, String> tempParams = new HashMap<>();
        tempParams.put("email", "hoang1482002@gmail.com");
        tempParams.put("password", "12345678");
        LoginResponse res = ConnectionUtil.sendPostRequest(this.test.baseURL.getBaseURL() + "/" + Constant.LOG_IN, tempParams, LoginResponse.class, null);
        return res.data.access_token;
    }

    protected <T> T sendPostRequest(Class<T> cl) throws IOException {
        return ConnectionUtil.sendPostRequest(this.fullURLString, this.params, cl, null);
    }

    protected <T> T sendPostRequestWithAccessToken(Class<T> cl) throws IOException {
        String accessToken = this.getAccessToken();
        return ConnectionUtil.sendPostRequest(this.fullURLString, this.params, cl, accessToken);
    }

    protected <T> T sendGetRequest(Class<T> cl) throws IOException {
        return ConnectionUtil.sendGetRequest(this.fullURLString, this.params, cl, null);
    }

    protected <T> T sendGetRequestWithAccessToken(Class<T> cl) throws IOException {
        String accessToken = this.getAccessToken();
        return ConnectionUtil.sendGetRequest(this.fullURLString, this.params, cl, accessToken);
    }

    public void startUnitTest() throws IOException {
    }

    public String getExpectation() {
        return this.expectation;
    }
}
