package com.company.TestManager.Tests._30GetSlider.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._30GetSlider.GetSliderResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class GetSliderUnitTest extends UnitTest {
    public GetSliderUnitTest(Test test){super(test, "the response code and message strings shall be not null as well as non-empty");

    }

    public void test() throws IOException{
        GetSliderResponse res = sendGetRequest(GetSliderResponse.class);

        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertNotEquals(res.data, null);

    }
}
