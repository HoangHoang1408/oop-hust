package com.company.TestManager.Tests._12EditAuction.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.Tests._12EditAuction.EditAuctionResponse;
import com.company.TestManager.Tests._12EditAuction.EditAuctionTest;
import com.company.TestManager.UnitTest;
import com.company.constants.Constant;
import com.company.utils.Util;

import java.io.IOException;

public class EditAuctionUnitTest4 extends UnitTest {
    public EditAuctionUnitTest4(Test test) {
        super(test,
                "No editing permission (Auctions not created by the user),response code should be 1006 and data should be null ");
    }

    @Override
    public void test() throws IOException {
        this.params = EditAuctionTest.generateDefaultParams();
        CreateAuctionResponse res = Connection.sendPostRequest(this.baseURLString + "/" + Constant.CREATE_AUCTION, this.params, CreateAuctionResponse.class, this.getAccessToken());
        this.params.put("title_ni", "Túi sách đã được chỉnh sửa của" + Util.randomAlphabetString(5));


        EditAuctionResponse resEdit = Connection.sendPostRequest(this.fullURLString + "/" + Util.randomNumberString(1, 54, 58), this.params, EditAuctionResponse.class, this.getAccessToken());

        this.assertion.assertNotEquals(resEdit, null);
        this.assertion.assertEquals(resEdit.code, 1006);
        this.assertion.assertEquals(resEdit.data, null);


    }
}
