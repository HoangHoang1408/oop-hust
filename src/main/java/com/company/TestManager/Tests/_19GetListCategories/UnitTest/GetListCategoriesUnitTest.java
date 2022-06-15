package com.company.TestManager.Tests._19GetListCategories.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._19GetListCategories.GetListCategoriesResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class GetListCategoriesUnitTest extends UnitTest {
    public GetListCategoriesUnitTest(Test test) {super(test, "With correct params format, the response code and message strings shall be not null as well as non-empty ");
    }
    public void test() throws IOException {
        //        create request object
        GetListCategoriesResponse res = this.sendGetRequest(GetListCategoriesResponse.class);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertInstanceOf(res.message, String.class);
    }
}

