package com.company.TestManager.Tests._12EditAuction;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._12EditAuction.UnitTest.*;
import com.company.utils.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditAuctionTest extends Test {
    public EditAuctionTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }
    public static HashMap<String, String> generateDefaultParams() {

        String category_id = Util.randomNumberString(1, 1, 7);
        String start_date = "2023-06-20 11:03:38";
        String end_date = "2023-06-21 11:03:38";
        String title_ni = "Tui xach " + Util.randomAlphabetString(20);
        return new HashMap<>(Map.of(
                "category_id", category_id,
                "start_date", start_date,
                "end_date", end_date,
                "title_ni", title_ni

        ));
    }
    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new EditAuctionUnitTest1(this), new EditAuctionUnitTest2(this),new EditAuctionUnitTest3(this),
                new EditAuctionUnitTest4(this),new EditAuctionUnitTest5(this), new EditAuctionUnitTest6(this),new EditAuctionUnitTest7(this),
                new EditAuctionUnitTest8(this), new EditAuctionUnitTest9(this),new EditAuctionUnitTest10(this),new EditAuctionUnitTest11(this),
                new EditAuctionUnitTest12(this),new EditAuctionUnitTest13(this)));
    }


}
