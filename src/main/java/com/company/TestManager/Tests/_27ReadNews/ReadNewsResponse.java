package com.company.TestManager.Tests._27ReadNews;

import com.company.TestManager.BaseResponse;

public class ReadNewsResponse extends BaseResponse {
    public Data data;
    public static class Data{
        public String auction_id;
        public String is_read;
    }
}
