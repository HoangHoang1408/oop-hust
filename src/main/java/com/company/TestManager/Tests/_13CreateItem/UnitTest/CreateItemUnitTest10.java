package com.company.TestManager.Tests._13CreateItem.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.Tests._13CreateItem.CreateItemResponse;
import com.company.TestManager.Tests._13CreateItem.CreateItemTest;
import com.company.TestManager.UnitTest;
import com.company.constants.Constant;

import java.io.IOException;

public class CreateItemUnitTest10 extends UnitTest {
    public CreateItemUnitTest10(Test test) {
        super(test, "if the description field is not set, response code 1001 and data must be null ");
    }

    @Override
    public void test() throws IOException {
        this.params = CreateAuctionTest.generateDefaultParams();
        CreateAuctionResponse resAuction = Connection.sendPostRequest(this.baseURLString + "/" + Constant.CREATE_AUCTION, this.params, CreateAuctionResponse.class, this.getAccessToken());

        this.params = CreateItemTest.generateDefaultParams();
        this.params.put("description", "");
        CreateItemResponse res = Connection.sendPostRequest(this.fullURLString + "/" + resAuction.data.auction_id, this.params, CreateItemResponse.class, this.getAccessToken());

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);


    }
}
