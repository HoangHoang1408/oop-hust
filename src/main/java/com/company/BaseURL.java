package com.company;

import com.company.constants.Constant;

public class BaseURL {
    private String baseURL;

    public BaseURL() {
        this.baseURL = Constant.DEFAULT_BASE_URL;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
}
