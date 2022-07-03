package com.company.TestManager.TestAPIs._12EditAuction.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.TestAPIs._12EditAuction.EditAuctionResponse;
import com.company.TestManager.TestAPIs._12EditAuction.EditAuctionTest;
import com.company.TestManager.UnitTest;
import com.company.constants.EndpointConstants;
import com.company.utils.Util;

import java.io.IOException;

public class EditAuctionUnitTest13 extends UnitTest {
    public EditAuctionUnitTest13(Test test) {
        super(test,
                "if Title is already used, response code will be 1001 and data should be null ");
    }

    @Override
    public void test() throws IOException {
        this.params = EditAuctionTest.generateDefaultParams();
        CreateAuctionResponse res = Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.CREATE_AUCTION, this.params, CreateAuctionResponse.class, this.getAccessToken());


        EditAuctionResponse resEdit = Connection.sendPostRequest(this.fullURLString + "/" + Util.randomNumberString(1, 60, 75), this.params, EditAuctionResponse.class, this.getAccessToken());

        this.assertion.assertNotEquals(resEdit, null);
        this.assertion.assertEquals(resEdit.code, 1001);
        this.assertion.assertEquals(resEdit.data, null);


    }
}
