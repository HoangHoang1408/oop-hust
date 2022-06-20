package com.company.TestManager.Tests._12EditAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.Tests._12EditAuction.EditAuctionResponse;
import com.company.TestManager.Tests._12EditAuction.EditAuctionTest;
import com.company.TestManager.UnitTest;
import com.company.constants.Constant;
import com.company.utils.ConnectionUtil;
import com.company.utils.Util;

import java.io.IOException;

public class EditAuctionUnitTest13 extends UnitTest  {
    public EditAuctionUnitTest13(Test test){super(test,
            "if Title is already used, response code will be 1001 and data should be null ");}
    @Override
    public void test() throws IOException{
        this.params = EditAuctionTest.generateDefaultParams();
        CreateAuctionResponse res = ConnectionUtil.sendPostRequest(this.baseURLString + "/" + Constant.CREATE_AUCTION,this.params,CreateAuctionResponse.class, this.getAccessToken());


        EditAuctionResponse resEdit = ConnectionUtil.sendPostRequest(this.fullURLString + "/" + Util.randomNumberString(1, 60, 75), this.params, EditAuctionResponse.class, this.getAccessToken());

        this.assertionManager.assertNotEquals(resEdit, null);
        this.assertionManager.assertEquals(resEdit.code, 1001);
        this.assertionManager.assertEquals(resEdit.data, null);


    }
}
