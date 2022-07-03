package com.company.TestManager.TestAPIs._29ReadNotifications;

import com.company.TestManager.Objects.BaseResponse;

public class ReadNotificationsResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public String auction_id;
        public String is_read;
    }
}
