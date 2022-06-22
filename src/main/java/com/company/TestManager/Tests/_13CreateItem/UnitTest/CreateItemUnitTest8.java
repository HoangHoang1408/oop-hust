package com.company.TestManager.Tests._13CreateItem.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.Tests._13CreateItem.CreateItemResponse;
import com.company.TestManager.Tests._13CreateItem.CreateItemTest;
import com.company.TestManager.UnitTest;
import com.company.constants.Constant;
import com.company.utils.ConnectionUtil;
import com.company.utils.Util;

import java.io.IOException;

public class CreateItemUnitTest8 extends UnitTest  {
    public CreateItemUnitTest8(Test test){super(test, "If more than 10 characters are entered in the series field, the response code will be 1001 and the data should be null");}

    @Override
    public void test() throws IOException {
        this.params = CreateAuctionTest.generateDefaultParams();
        CreateAuctionResponse resAuction = ConnectionUtil.sendPostRequest(this.baseURLString +"/"+ Constant.CREATE_AUCTION,this.params, CreateAuctionResponse.class, this.getAccessToken());

        this.params = CreateItemTest.generateDefaultParams();
        this.params.put("series", Util.randomNumberString(11));
        CreateItemResponse res = ConnectionUtil.sendPostRequest(this.fullURLString + "/" + resAuction.data.auction_id, this.params, CreateItemResponse.class, this.getAccessToken());

        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertEquals(res.data, null);





    }
}