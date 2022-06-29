package com.company.TestManager.Tests._30GetSlider.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._30GetSlider.GetSliderResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class GetSliderUnitTest extends UnitTest {
    public GetSliderUnitTest(Test test) {
        super(test, "the response code and message strings shall be not null as well as non-empty");

    }

    public void test() throws IOException {
        GetSliderResponse res = sendGetRequest(GetSliderResponse.class);

        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertInstanceOf(res.message, String.class);
        this.assertion.assertNotEquals(res.data, null);

    }
}
