package com.company.TestManager.Tests._18GetListBids;

import com.company.TestManager.BaseResponse;

import java.util.ArrayList;

public class GetListBidsResponse extends BaseResponse {
    public Data data;

    public static class  Data{
        public ArrayList<Bids> bids;
        public String total;
    }
    public static class Bids{
        public String user_name;
        public String user_avatar;
        public String price;
        public String updated_at;
    }
}
