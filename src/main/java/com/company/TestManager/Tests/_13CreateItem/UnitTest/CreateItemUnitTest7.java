package com.company.TestManager.Tests._13CreateItem.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.Tests._13CreateItem.CreateItemResponse;
import com.company.TestManager.Tests._13CreateItem.CreateItemTest;
import com.company.TestManager.UnitTest;
import com.company.constants.Constant;
import com.company.utils.Util;

import java.io.IOException;

public class CreateItemUnitTest7 extends UnitTest {
    public CreateItemUnitTest7(Test test) {
        super(test, "if a non-numeric input is entered in the starting_price field, the response code will be 1001 and the data should be null");
    }

    @Override
    public void test() throws IOException {
        this.params = CreateAuctionTest.generateDefaultParams();
        CreateAuctionResponse resAuction = Connection.sendPostRequest(this.baseURLString + "/" + Constant.CREATE_AUCTION, this.params, CreateAuctionResponse.class, CreateItemTest.accessToken);

        this.params = CreateItemTest.generateDefaultParams();
        this.params.put("starting_price", Util.randomAlphabetString(5));
        CreateItemResponse res = Connection.sendPostRequest(this.fullURLString + "/" + resAuction.data.auction_id, this.params, CreateItemResponse.class, CreateItemTest.accessToken);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);


    }
}
