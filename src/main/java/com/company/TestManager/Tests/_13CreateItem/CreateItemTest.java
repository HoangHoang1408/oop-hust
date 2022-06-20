package com.company.TestManager.Tests._13CreateItem;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._13CreateItem.UnitTest.*;
import com.company.utils.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateItemTest extends Test {
    public CreateItemTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }


    public static HashMap<String, String> generateDefaultParams() {

        String name = Util.randomAlphabetString(10);
        String starting_price = Util.randomNumberString(7);
        String brand_id = Util.randomNumberString(1, 1, 8);
        String description = "chieu cao: " + Util.randomNumberString(2) + "cm, " + "chieu rong: " + Util.randomNumberString(2) + "cm, " + "chieu dai: " + Util.randomNumberString(2) + "cm" ;
        String series = Util.randomNumberString(1, 100000000, 999999999);
        return new HashMap<>(Map.of(
                "name", name,
                "starting_price", starting_price,
                "brand_id", brand_id,
                "description",description,
                "series", series

        ));
    }
    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new CreateItemUnitTest1(this),
                new CreateItemUnitTest2(this),
                new CreateItemUnitTest3(this),
                new CreateItemUnitTest4(this),
                new CreateItemUnitTest5(this),
                new CreateItemUnitTest6(this),
                new CreateItemUnitTest7(this),
                new CreateItemUnitTest8(this),
                new CreateItemUnitTest9(this),
                new CreateItemUnitTest10(this)));
    }
}
