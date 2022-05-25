package com.company.Tests.Login;

import com.company.Objects.User;
import com.company.Tests.BaseResponse;


// class với mục đích để GSON chuyển dữ liệu server gửi về từ dạng json về object
public class LoginResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public String access_token;
        public String token_type;
        public String expires_in;
        public User user;
    }
}
