package com.company.TestManager;

import com.company.constants.ANSI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


// abstract class của các test (các class unit test khác phải kế thừa class này)
public abstract class UnitTest {
    private final Test test;
    private final ArrayList<Assertion> assertions;
    protected String expectation;
    protected HashMap<String, String> params;
    protected String fullURLString;
    protected String baseURLString;
    protected Assertion assertion;
    protected Integer numOfRepetitions;
    protected Integer totalRepeatedUnitTestPassed;

    public UnitTest(Test test, String expectation, Integer numOfRepetitions) {
        this.test = test;
        this.params = new HashMap<>();
        this.fullURLString = test.getFullURLString();
        this.baseURLString = test.getBaseUrlString();
        this.expectation = expectation;
        this.assertion = new Assertion();
        this.numOfRepetitions = numOfRepetitions;
        this.assertions = new ArrayList<>();
        this.totalRepeatedUnitTestPassed = 0;
    }

    public UnitTest(Test test, String expectation) {
        this(test, expectation, 1);
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

    protected boolean executeTest(int id) throws IOException {
        for (int i = 0; i < numOfRepetitions; i++) {
            this.test.handledBeforeEach(id);
            this.test();
            this.test.handledAfterEach(id);
            this.totalRepeatedUnitTestPassed += this.assertion.judge() ? 1 : 0;
            this.assertions.add(this.assertion);
            this.assertion = new Assertion();
        }
        boolean passed = totalRepeatedUnitTestPassed.equals(this.numOfRepetitions);
        if (passed) notifyTestPassed(id);
        else notifyTestFailed(id);
        return passed;
    }

    public void forceFail() {
        this.assertion.forceFail();
    }

    private void notifyTestPassed(int i) {
        System.out.println(ANSI.GREEN + i + ") " + this.expectation + " => Passed!" + ANSI.RESET);
    }

    private void notifyTestFailed(int i) {
        System.out.println(ANSI.RED + i + ") " + this.expectation + " => Failed!" + ANSI.RESET);
        for (int j = 0; j < this.assertions.size(); j++) {
            System.out.println(ANSI.SINGLE_TAB + ANSI.YELLOW + "Repeated unit test " + (j + 1) + ":" + ANSI.RESET);
            this.assertions.get(j).printJudgement();
        }
    }

    public String getExpectation() {
        return this.expectation;
    }
}
