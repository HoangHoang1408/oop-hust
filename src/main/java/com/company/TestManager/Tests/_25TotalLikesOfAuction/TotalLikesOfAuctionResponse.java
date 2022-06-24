package com.company.TestManager.Tests._25TotalLikesOfAuction;

import com.company.TestManager.BaseResponse;

public class TotalLikesOfAuctionResponse extends BaseResponse {
    public Data data;

    public static class Data{
        public String auction_id;
        public String total_liked;
    }
}
