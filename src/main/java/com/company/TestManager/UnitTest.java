package com.company.TestManager;

import com.company.TestManager.Tests._2Login.LoginResponse;
import com.company.constants.Constant;
import com.company.utils.ConnectionUtil;

import java.io.IOException;
import java.util.HashMap;


// abstract class của các test (các class unit test khác phải kế thừa class này)
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

    //    có thể được gọi ở class con để lấy đc accesstoken
    protected String getAccessToken() throws IOException {
        HashMap<String, String> tempParams = new HashMap<>();
        tempParams.put("email", "hoang1482002@gmail.com");
        tempParams.put("password", "12345678");
        LoginResponse res = ConnectionUtil.sendPostRequest(this.test.baseURL.getBaseURL() + "/" + Constant.LOG_IN, tempParams, LoginResponse.class, null);
        return res.data.access_token;
    }

    //    thường đc gọi ở class con để gửi post request (ko kèm access token)
    protected <T> T sendPostRequest(Class<T> cl) throws IOException {
        return ConnectionUtil.sendPostRequest(this.fullURLString, this.params, cl, null);
    }


    //    thường đc gọi ở class con để gửi post request (có kèm access token)
    protected <T> T sendPostRequestWithAccessToken(Class<T> cl) throws IOException {
        String accessToken = this.getAccessToken();
        return ConnectionUtil.sendPostRequest(this.fullURLString, this.params, cl, accessToken);
    }

    //    thường đc gọi ở class con để gửi get request (ko kèm access token)
    protected <T> T sendGetRequest(Class<T> cl) throws IOException {
        return ConnectionUtil.sendGetRequest(this.fullURLString, this.params, cl, null);
    }

    //    thường đc gọi ở class con để gửi get request (có kèm access token)
    protected <T> T sendGetRequestWithAccessToken(Class<T> cl) throws IOException {
        String accessToken = this.getAccessToken();
        return ConnectionUtil.sendGetRequest(this.fullURLString, this.params, cl, accessToken);
    }

    //    hàm bắt buộc phải ghi đè ở lớp con
    public void test() throws IOException {
    }

    public boolean startUnitTest() throws IOException {
        this.test();
        return this.assertionManager.judge();
    }

    public String getExpectation() {
        return this.expectation;
    }
}
