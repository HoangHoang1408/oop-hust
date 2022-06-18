package com.company.TestManager.Tests._30GetSlider;

import com.company.TestManager.BaseResponse;


import java.util.ArrayList;


public class GetSliderResponse extends BaseResponse {
    public ArrayList<Data> data;


    public static class Data{
        public String slider_id;
        public String image;
        public String type;
        public String created_at;
        public String updated_at;

    }
}
