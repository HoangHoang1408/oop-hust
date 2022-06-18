package com.company.TestManager.Tests._12EditAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._12EditAuction.EditAuctionResponse;
import com.company.TestManager.Tests._12EditAuction.EditAuctionTest;
import com.company.TestManager.UnitTest;
import com.company.utils.ConnectionUtil;

import java.io.IOException;

public class EditAuctionUnitTest2 extends UnitTest {
    public EditAuctionUnitTest2(Test test) {
        super(test,
                "If you are not logged in, the server will return code 1004");
    }

    @Override
    public void test() throws IOException {
        this.params = EditAuctionTest.generateDefaultParams();

        EditAuctionResponse res = ConnectionUtil.sendPostRequest(this.fullURLString + "/1", this.params, EditAuctionResponse.class, null);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1004);
        this.assertionManager.assertEquals(res.data, null);


    }
}
