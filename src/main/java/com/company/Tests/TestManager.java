package com.company.Tests;

import com.company.BaseURL;
import com.company.Tests.CreateComment.CreateCommentTest;
import com.company.Tests.GetListAuctions.GetListAuctionsTest;
import com.company.Tests.Login.LoginTest;
import com.company.Tests.Logout.LogoutTest;
import com.company.Tests.SignUp.SignUpTest;
import com.company.constants.Constant;

import java.io.IOException;

public class TestManager {

    public void startTest(String apiName, BaseURL baseUrl) {
        Test test = switch (apiName) {
            case Constant.SIGN_UP -> new SignUpTest(baseUrl, Constant.SIGN_UP);
            case Constant.LOG_IN -> new LoginTest(baseUrl, Constant.LOG_IN);
            case Constant.LOG_OUT -> new LogoutTest(baseUrl, Constant.LOG_OUT);
            case Constant.GET_LIST_AUCTIONS -> new GetListAuctionsTest(baseUrl, Constant.GET_LIST_AUCTIONS);
            case Constant.CREATE_COMMENT -> new CreateCommentTest(baseUrl, Constant.CREATE_COMMENT);
            default -> null;
        };
        if (test == null) return;
        try {
            test.startTest();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Somethings went wrong, try again later!");
        }
    }
}
