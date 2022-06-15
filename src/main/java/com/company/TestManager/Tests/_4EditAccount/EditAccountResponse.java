package com.company.TestManager.Tests._4EditAccount;
import com.company.TestManager.BaseResponse;

public class EditAccountResponse extends BaseResponse{
    public Data data;

    public static class Data {
        public String name;
        public String email;
        public String phone;
        public String address;
        public String avatar;
        public String role;
    }

}
