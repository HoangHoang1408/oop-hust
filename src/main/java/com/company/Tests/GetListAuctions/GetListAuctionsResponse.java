package com.company.Tests.GetListAuctions;

import com.company.Objects.Auction;
import com.company.Tests.BaseResponse;

import java.util.ArrayList;

public class GetListAuctionsResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public ArrayList<Auction> auctions;
        public String total;
    }
}
