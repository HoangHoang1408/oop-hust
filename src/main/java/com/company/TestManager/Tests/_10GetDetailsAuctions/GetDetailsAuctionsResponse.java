package com.company.TestManager.Tests._10GetDetailsAuctions;

import com.company.TestManager.BaseResponse;

import java.util.ArrayList;

public class GetDetailsAuctionsResponse extends BaseResponse {
    public Data data;
    public static class Data {
        public Auctions auctions;
        public Category category;
        public Items items;
        public Selling_user selling_user;
        public Buying_user buying_user;
        public String max_bid;
        public String like;

    }
    public static class Auctions {
        public String auction_id;
        public String title;
        public String start_date;
        public String end_date;
        public String statusId;
        public String status;


    }
    public static class Category {
        public String name;
        public String image;
        public String type;
    }
    public static class Items {
        public String items_id;
        public String name;
        public String buying_user_id;
        public String brand;
        public String series;
        public String description;
        public String starting_price;
        public String mainImage;
        public ArrayList<String> images;

    }
    public static class Selling_user {
        public String selling_user_id;
        public String selling_user_name;
        public String selling_user_avatar;

    }
    public static class Buying_user {
        public String buying_user_id;
        public String buying_user_name;
        public String buying_user_phone;
        public String buying_user_address;

    }

}
