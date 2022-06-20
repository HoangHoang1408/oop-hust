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

public class CreateItemUnitTest2 extends UnitTest  {
    public CreateItemUnitTest2(Test test){super(test, "If you are not logged in, the server will return code 1004");}

    @Override
    public void test() throws IOException {
        this.params = CreateAuctionTest.generateDefaultParams();
        CreateAuctionResponse resAuction = ConnectionUtil.sendPostRequest(this.baseURLString +"/"+ Constant.CREATE_AUCTION,this.params, CreateAuctionResponse.class, this.getAccessToken());

        this.params = CreateItemTest.generateDefaultParams();
        CreateItemResponse res = ConnectionUtil.sendPostRequest(this.fullURLString + "/" + resAuction.data.auction_id, this.params, CreateItemResponse.class, null);

        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1004);
        this.assertionManager.assertEquals(res.data, null);





    }
}
