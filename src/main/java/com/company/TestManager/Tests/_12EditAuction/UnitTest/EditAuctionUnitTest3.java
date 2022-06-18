package com.company.TestManager.Tests._12EditAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._12EditAuction.EditAuctionResponse;
import com.company.TestManager.Tests._12EditAuction.EditAuctionTest;
import com.company.TestManager.UnitTest;
import com.company.utils.ConnectionUtil;

import java.io.IOException;

public class EditAuctionUnitTest3 extends UnitTest {
    public EditAuctionUnitTest3(Test test) {
        super(test,
                "Non-editable (Approved auctions cannot be edited),  response code should be 1005 and data should be null ");
    }

    @Override
    public void test() throws IOException {
        this.params = EditAuctionTest.generateDefaultParams();

        EditAuctionResponse res = ConnectionUtil.sendPostRequest(this.fullURLString + "/1", this.params, EditAuctionResponse.class, this.getAccessToken());

        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1005);
        this.assertionManager.assertEquals(res.data, null);


    }
}
