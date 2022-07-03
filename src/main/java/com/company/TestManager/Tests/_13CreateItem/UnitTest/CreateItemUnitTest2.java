package com.company.TestManager.Tests._13CreateItem.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._13CreateItem.CreateItemResponse;
import com.company.TestManager.Tests._13CreateItem.CreateItemTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateItemUnitTest2 extends UnitTest  {
    public CreateItemUnitTest2(Test test){super(test, "If you are not logged in, the server will return code 1004");}

    @Override
    public void test() throws IOException {

        this.params = CreateItemTest.generateDefaultParams();
        CreateItemResponse res = Connection.sendPostRequest(this.fullURLString + "/" + CreateItemTest.auction_idForCreateItem, this.params, CreateItemResponse.class, null);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1004);
        this.assertion.assertEquals(res.data, null);





    }
}
