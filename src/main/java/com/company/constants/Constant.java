package com.company.constants;

import java.util.HashMap;

public class Constant {
    public static final String DEFAULT_BASE_URL = "https://auctions-app-2.herokuapp.com/api";
    public static final String BASE_URL_2 = "https://auctions-app3.herokuapp.com/api";
    public static final String SIGN_UP = "signup";
    public static final String LOG_IN = "login";
    public static final String LOG_OUT = "logout";
    public static final String EDIT_ACCOUNT = "edit";
    public static final String SEARCH = "search";
    public static final String GET_LIST_AUCTIONS = "auctions/listAuctions";
    public static final String GET_LIST_AUCTIONS_BY_STATUS = "auctions/listAuctionsByStatus";
    public static final String GET_LIST_AUCTIONS_BY_USER = "auctions/listAuctionsByUser";
    public static final String GET_LIST_AUCTIONS_BY_TYPE = "auctions/listAuctions";
    public static final String GET_DETAILS_AUCTIONS = "auctions/detail";
    public static final String CREATE_AUCTION = "auctions/create";
    public static final String EDIT_AUCTION = "auctions/edit";
    public static final String CREATE_ITEM = "items/create";
    public static final String CREATE_COMMENT = "comments/create";
    public static final String GET_LIST_COMMENTS = "comments";
    public static final String DELETE_COMMENT = "comments";
    public static final String CREATE_BID = "bids/create";
    public static final String GET_LIST_BIDS = "bids";
    public static final String GET_LIST_CATEGORIES = "categories";
    public static final String GET_LIST_BRANDS = "brands";
    public static final String ACCEPT_MAX_BID = "accept";
    public static final String CONTACT_US = "contactUs";
    public static final String LIKE_AUCTION = "updateLike";
    public static final String GET_LIST_LIKES = "likes";
    public static final String TOTAL_LIKES_OF_AUCTION = "totalLikes";
    public static final String GET_NEWS = "news";
    public static final String READ_NEWS = "news/read";
    public static final String GET_NOTIFICATIONS = "notifications";
    public static final String READ_NOTIFICATIONS = "notifications/read";
    public static final String GET_SLIDER = "slider";
    public static final HashMap<Integer, String> baseUrls = new HashMap<>();
    public static final HashMap<Integer, String> paths = new HashMap<>();
    public static final HashMap<Integer, String> testNames = new HashMap<>();

    static {
        baseUrls.put(1, DEFAULT_BASE_URL);
        baseUrls.put(2, BASE_URL_2);
    }

    static {
        paths.put(1, Constant.SIGN_UP);
        paths.put(2, Constant.LOG_IN);
        paths.put(3, Constant.LOG_OUT);
        paths.put(4, Constant.EDIT_ACCOUNT);
        paths.put(5, Constant.SEARCH);
        paths.put(6, Constant.GET_LIST_AUCTIONS);
        paths.put(7, Constant.GET_LIST_AUCTIONS_BY_STATUS);
        paths.put(8, Constant.GET_LIST_AUCTIONS_BY_USER);
        paths.put(9, Constant.GET_LIST_AUCTIONS_BY_TYPE);
        paths.put(10, Constant.GET_DETAILS_AUCTIONS);
        paths.put(11, Constant.CREATE_AUCTION);
        paths.put(12, Constant.EDIT_AUCTION);
        paths.put(13, Constant.CREATE_ITEM);
        paths.put(14, Constant.CREATE_COMMENT);
        paths.put(15, Constant.GET_LIST_COMMENTS);
        paths.put(16, Constant.DELETE_COMMENT);
        paths.put(17, Constant.CREATE_BID);
        paths.put(18, Constant.GET_LIST_BIDS);
        paths.put(19, Constant.GET_LIST_CATEGORIES);
        paths.put(20, Constant.GET_LIST_BRANDS);
        paths.put(21, Constant.ACCEPT_MAX_BID);
        paths.put(22, Constant.CONTACT_US);
        paths.put(23, Constant.LIKE_AUCTION);
        paths.put(24, Constant.GET_LIST_LIKES);
        paths.put(25, Constant.TOTAL_LIKES_OF_AUCTION);
        paths.put(26, Constant.GET_NEWS);
        paths.put(27, Constant.READ_NEWS);
        paths.put(28, Constant.GET_NOTIFICATIONS);
        paths.put(29, Constant.READ_NOTIFICATIONS);
        paths.put(30, Constant.GET_SLIDER);
    }

    static {
        testNames.put(1, "Sign up");
        testNames.put(2, "Log in");
        testNames.put(3, "Log out");
        testNames.put(4, "Edit account");
        testNames.put(5, "Search");
        testNames.put(6, "Get list auctions");
        testNames.put(7, "Get list auctions by status");
        testNames.put(8, "Get list auctions by user");
        testNames.put(9, "Get list auctions by type");
        testNames.put(10, "Get details auctions");
        testNames.put(11, "Create auction");
        testNames.put(12, "Edit auction");
        testNames.put(13, "Create item");
        testNames.put(14, "Create comment");
        testNames.put(15, "Get list comments");
        testNames.put(16, "Delete comment");
        testNames.put(17, "Create bid");
        testNames.put(18, "Get list bids");
        testNames.put(19, "Get list categories");
        testNames.put(20, "Get list brands");
        testNames.put(21, "Accept max bid");
        testNames.put(22, "Contact us");
        testNames.put(23, "Like auction");
        testNames.put(24, "Get list likes");
        testNames.put(25, "Total likes of auction");
        testNames.put(26, "Get news");
        testNames.put(27, "Read news");
        testNames.put(28, "Get notifications");
        testNames.put(29, "Read notification");
        testNames.put(30, "Get slider");
    }
}