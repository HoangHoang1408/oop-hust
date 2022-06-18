package com.company.TestManager.Tests._12EditAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.Tests._12EditAuction.EditAuctionResponse;
import com.company.TestManager.Tests._12EditAuction.EditAuctionTest;
import com.company.TestManager.UnitTest;
import com.company.utils.ConnectionUtil;
import com.company.utils.Util;

import java.io.IOException;

public class EditAuctionUnitTest1 extends UnitTest {
    public EditAuctionUnitTest1(Test test) {
        super(test,
                "With correct params, response code should be 1000 and data should not be null ");
    }

    @Override
    public void test() throws IOException {
        this.params = EditAuctionTest.generateDefaultParams();
        CreateAuctionResponse res = ConnectionUtil.sendPostRequest("https://auctions-app-2.herokuapp.com/api/auctions/create", this.params, CreateAuctionResponse.class, this.getAccessToken());
        this.params.put("title_ni", "Túi sách đã được chỉnh sửa của" + Util.randomAlphabetString(5));


        EditAuctionResponse resEdit = ConnectionUtil.sendPostRequest(this.fullURLString + "/" + res.data.auction_id, this.params, EditAuctionResponse.class, this.getAccessToken());

        this.assertionManager.assertNotEquals(resEdit, null);
        this.assertionManager.assertEquals(resEdit.code, 1000);
        this.assertionManager.assertBoolean(resEdit.message.length() > 0);
        this.assertionManager.assertNotEquals(resEdit.data, null);


    }
}
