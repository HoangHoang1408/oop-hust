package com.company.TestManager.TestAPIs._17CreateBid;

import com.company.BaseURL;
import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._17CreateBid.UnitTest.*;
import com.company.TestManager.TestAPIs._18GetListBids.GetListBidsResponse;
import com.company.TestManager.TestAPIs._2Login.LoginResponse;
import com.company.constants.EndpointConstants;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateBidTest extends Test {
    public static String max_Bid;
    public static String accessToken;

    public CreateBidTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    public static HashMap<String, String> generateDefaultParams() {
        String price = CreateBidTest.max_Bid;
        int priceInt = Integer.parseInt(price) + 1;
        price = String.valueOf(priceInt);
        return new HashMap<>(Map.of(
                "price", price,
                "bid_last_id", "10"
        ));
    }

    @Override
    protected void beforeAll() throws IOException {
        HashMap<String, String> tempParams = new HashMap<>();
        tempParams.put("email", "Cube@gmail.com");
        tempParams.put("password", "12345678");
        LoginResponse res = Connection.sendPostRequest(EndpointConstants.DEFAULT_BASE_URL + "/" + EndpointConstants.LOG_IN, tempParams, LoginResponse.class, null);
        CreateBidTest.accessToken = res.data.access_token;
        tempParams.clear();
        tempParams.put("index", "0");
        tempParams.put("count", "1");
        GetListBidsResponse res1 = Connection.sendGetRequest(this.baseURLString + "/" + EndpointConstants.GET_LIST_BIDS + "/12", tempParams, GetListBidsResponse.class, null);
        for (GetListBidsResponse.Bids s : res1.data.bids) {
            CreateBidTest.max_Bid = s.price;
        }
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new CreateBidUnitTest1(this),
                new CreateBidUnitTest2(this),
                new CreateBidUnitTest3(this),
                new CreateBidUnitTest4(this),
                new CreateBidUnitTest5(this)));
    }
}
