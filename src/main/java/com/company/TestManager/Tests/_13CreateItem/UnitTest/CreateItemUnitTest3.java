package com.company.TestManager.Tests._13CreateItem.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._13CreateItem.CreateItemResponse;
import com.company.TestManager.Tests._13CreateItem.CreateItemTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateItemUnitTest3 extends UnitTest  {
    public CreateItemUnitTest3(Test test){super(test, "if the brand_id field is not set, response code 1001 and data must be null ");}

    @Override
    public void test() throws IOException {
        this.params = CreateItemTest.generateDefaultParams();
        this.params.put("brand_id","");
        CreateItemResponse res = Connection.sendPostRequest(this.fullURLString + "/" + CreateItemTest.auction_idForCreateItem, this.params, CreateItemResponse.class, CreateItemTest.accessToken);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);





    }
}
