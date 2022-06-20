package com.company.TestManager.Tests._13CreateItem.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.Tests._13CreateItem.CreateItemResponse;
import com.company.TestManager.Tests._13CreateItem.CreateItemTest;
import com.company.TestManager.UnitTest;
import com.company.constants.Constant;
import com.company.utils.ConnectionUtil;

import java.io.IOException;

public class CreateItemUnitTest1 extends UnitTest  {
    public CreateItemUnitTest1(Test test){super(test, "With correct params, response code should be 1000 and data should not be null ");}

    @Override
    public void test() throws IOException {
        this.params = CreateAuctionTest.generateDefaultParams();
        CreateAuctionResponse resAuction = ConnectionUtil.sendPostRequest(this.baseURLString +"/"+ Constant.CREATE_AUCTION,this.params, CreateAuctionResponse.class, this.getAccessToken());

        this.params = CreateItemTest.generateDefaultParams();
        CreateItemResponse res = ConnectionUtil.sendPostRequest(this.fullURLString + "/" + resAuction.data.auction_id, this.params, CreateItemResponse.class, this.getAccessToken());

        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertNotEquals(res.data.name, null);
        this.assertionManager.assertNotEquals(res.data.auction_id, null);
        this.assertionManager.assertNotEquals(res.data.brand_id, null);
        this.assertionManager.assertNotEquals(res.data.description, null);





    }
}
