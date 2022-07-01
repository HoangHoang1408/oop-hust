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

public class CreateItemUnitTest4 extends UnitTest  {
    public CreateItemUnitTest4(Test test){super(test, "if the name field is not set, response code 1001 and data must be null ");}

    @Override
    public void test() throws IOException {
        this.params = CreateAuctionTest.generateDefaultParams();
        CreateAuctionResponse resAuction = Connection.sendPostRequest(this.baseURLString +"/"+ Constant.CREATE_AUCTION,this.params, CreateAuctionResponse.class, CreateItemTest.accessToken);

        this.params = CreateItemTest.generateDefaultParams();
        this.params.put("name","");
        CreateItemResponse res = Connection.sendPostRequest(this.fullURLString + "/" + resAuction.data.auction_id, this.params, CreateItemResponse.class, CreateItemTest.accessToken);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);





    }
}
