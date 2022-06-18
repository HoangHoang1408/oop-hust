package com.company.TestManager.Tests._5Search;

import com.company.TestManager.BaseResponse;

import java.util.ArrayList;

public class SearchResponse extends BaseResponse {
    public ArrayList<Data> data;

    public static class Data {
        public String id;
        public String name;
        public String key;
    }
}
