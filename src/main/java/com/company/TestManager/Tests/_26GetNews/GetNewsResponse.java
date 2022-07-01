package com.company.TestManager.Tests._26GetNews;

import com.company.TestManager.BaseResponse;

import java.util.ArrayList;

public class GetNewsResponse extends BaseResponse {
    public Data data;

    public static class Data{
       public ArrayList<News> news;
       public String total;
    }
    public static class News{
        public String user_id;
        public String title;
        public String content;
        public String created_at;
        public String updated_at;

    }
}
