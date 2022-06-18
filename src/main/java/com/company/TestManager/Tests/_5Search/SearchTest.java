package com.company.TestManager.Tests._5Search;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.Tests._5Search.UnitTests.*;
import com.company.constants.Constant;
import com.company.utils.ConnectionUtil;
import com.company.utils.Util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchTest extends Test {
    public SearchTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(
                new SearchUnitTest1(this),
                new SearchUnitTest2(this),
                new SearchUnitTest3(this),
                new SearchUnitTest4(this),
                new SearchUnitTest5(this),
                new SearchUnitTest6(this),
                new SearchUnitTest7(this),
                new SearchUnitTest8(this)
        ));
    }

    @Override
    public void beforeAll() throws IOException {
        HashMap<String, String> tempParams = new HashMap<>(Map.of(
                "category_id", TempParams.category_id,
                "start_date", TempParams.start_date,
                "end_date", TempParams.end_date,
                "title_ni", TempParams.title_ni
        ));
        System.out.println(this.baseURLString + "/" + Constant.CREATE_AUCTION);
        ConnectionUtil.sendPostRequest(this.baseURLString + "/" + Constant.CREATE_AUCTION, tempParams, CreateAuctionResponse.class, ConnectionUtil.getAccessToken());
    }

    public static class TempParams {
        public static String category_id = Util.randomNumberString(1, 1, 7);
        public static String start_date = "2023-06-20 11:03:38";
        public static String end_date = "2023-06-21 11:03:38";
        public static String title_ni = "Test item" + Util.randomAlphabetString(20);
    }
}
