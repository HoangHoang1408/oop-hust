package com.company.TestManager.Tests._6GetListAuctions;

import com.company.TestManager.BaseResponse;
import com.company.TestManager.Objects.Auction;

import java.util.ArrayList;

public class GetListAuctionsResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public ArrayList<Auction> auctions;
        public Integer total;
    }
}
