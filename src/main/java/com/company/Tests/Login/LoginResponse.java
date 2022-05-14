package com.company.Tests.Login;

import com.company.Objects.User;
import com.company.Tests.BaseResponse;

public class LoginResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public String access_token;
        public String token_type;
        public String expires_in;
        public User user;
    }
}
