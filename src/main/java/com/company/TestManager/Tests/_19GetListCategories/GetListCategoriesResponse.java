package com.company.TestManager.Tests._19GetListCategories;

import com.company.TestManager.BaseResponse;

import java.util.ArrayList;


public class GetListCategoriesResponse extends BaseResponse {
    public ArrayList<Category> data;


    public static class Category{
        public String category_id;
        public String name;
        public String image;
        public String type;
    }
}

