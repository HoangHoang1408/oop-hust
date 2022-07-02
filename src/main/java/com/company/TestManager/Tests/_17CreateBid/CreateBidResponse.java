package com.company.TestManager.Tests._17CreateBid;

import com.company.TestManager.BaseResponse;
import com.company.TestManager.Objects.Bid;

import java.util.ArrayList;

public class CreateBidResponse extends BaseResponse {
    public Data data;

    public static class Data{
        ArrayList<Bid> bid;
        public String total;
    }
}
