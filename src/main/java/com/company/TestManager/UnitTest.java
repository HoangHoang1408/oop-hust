package com.company.TestManager;

import java.io.IOException;
import java.util.HashMap;


// abstract class của các test (các class unit test khác phải kế thừa class này)
public abstract class UnitTest {
    protected String expectation;
    protected HashMap<String, String> params;
    protected String fullURLString;
    protected String baseURLString;
    protected Assertion assertion;

    public UnitTest(Test test, String expectation) {
        this.params = new HashMap<>();
        this.fullURLString = test.getFullURLString();
        this.baseURLString = test.getBaseUrlString();
        this.expectation = expectation;
        this.assertion = new Assertion(expectation);
    }


    //    có thể được gọi ở class con để lấy đc accesstoken
    protected String getAccessToken() {
        return Connection.getAccessToken(this.baseURLString);
    }

    //    thường đc gọi ở class con để gửi post request (ko kèm access token)
    protected <T> T sendPostRequest(Class<T> cl) throws IOException {
        return Connection.sendPostRequest(this.fullURLString, this.params, cl, null);
    }


    //    thường đc gọi ở class con để gửi post request (có kèm access token)
    public <T> T sendPostRequestWithAccessToken(Class<T> cl) throws IOException {
        String accessToken = this.getAccessToken();
        return Connection.sendPostRequest(this.fullURLString, this.params, cl, accessToken);
    }

    //    thường đc gọi ở class con để gửi get request (ko kèm access token)
    protected <T> T sendGetRequest(Class<T> cl) throws IOException {
        return Connection.sendGetRequest(this.fullURLString, this.params, cl, null);
    }

    //    thường đc gọi ở class con để gửi get request (có kèm access token)
    protected <T> T sendGetRequestWithAccessToken(Class<T> cl) throws IOException {
        String accessToken = this.getAccessToken();
        return Connection.sendGetRequest(this.fullURLString, this.params, cl, accessToken);
    }

    //    hàm bắt buộc phải ghi đè ở lớp con
    protected abstract void test() throws IOException;

    public boolean judge(int i) {
        return this.assertion.judge(i);
    }

    public void forceFail() {
        this.assertion.forceFail();
    }

    public String getExpectation() {
        return this.expectation;
    }
}
