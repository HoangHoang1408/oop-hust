package com.company.TestManager.TestAPIs._27ReadNews;

import com.company.TestManager.Objects.BaseResponse;

public class ReadNewsResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public String new_id;
        public String is_read;
    }
}
