package com.company.TestManager.Tests._12EditAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.Tests._12EditAuction.EditAuctionResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.ConnectionUtil;
import com.company.utils.Util;

import java.io.IOException;

public class EditAuctionUnitTest4 extends UnitTest  {
    public EditAuctionUnitTest4(Test test){super(test,
            "No editing permission (Auctions not created by the user),response code should be 1006 and data should be null ");}
    @Override
    public void test() throws IOException{
        this.params = this.generateDefaultParams();
        CreateAuctionResponse res = ConnectionUtil.sendPostRequest("https://auctions-app-2.herokuapp.com/api/auctions/create" ,this.params,CreateAuctionResponse.class, this.getAccessToken());
        this.params.put("title_ni","Túi sách đã được chỉnh sửa của" + Util.randomAlphabetString(5));


        EditAuctionResponse resEdit = ConnectionUtil.sendPostRequest(this.fullURLString + "/" + Util.randomNumberString(2, 1, 9), this.params, EditAuctionResponse.class, this.getAccessToken());

        this.assertionManager.assertNotEquals(resEdit, null);
        this.assertionManager.assertEquals(resEdit.code, 1006);
        this.assertionManager.assertEquals(resEdit.data, null);


    }
}
