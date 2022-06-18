package com.company.TestManager.Tests._12EditAuction;

import com.company.TestManager.BaseResponse;

public class EditAuctionResponse extends BaseResponse   {
    public Data data;

    public static class Data{
        public String category_id;
        public String start_date;
        public String end_date;
        public String title_ni;
    }
}
