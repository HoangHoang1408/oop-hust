package com.company.constants;

import java.util.HashMap;

public class Constant {
    public static final String DEFAULT_BASE_URL = "https://auctions-app-2.herokuapp.com/api";
    public static final String SIGN_UP = "signup";
    public static final String LOG_IN = "login";
    public static final String LOG_OUT = "logout";
    public static final String GET_LIST_AUCTIONS = "auctions";
    public static HashMap<Integer, String> paths = new HashMap<>();
    public static HashMap<Integer, String> testNames = new HashMap<>();

    static {
        paths.put(1, Constant.SIGN_UP);
        paths.put(2, Constant.LOG_IN);
        paths.put(3, Constant.LOG_OUT);
        paths.put(4, Constant.GET_LIST_AUCTIONS);
    }

    static {
        testNames.put(1, "Sign up");
        testNames.put(2, "Log in");
        testNames.put(3, "Log out");
        testNames.put(4, "Get list auctions");
    }
}