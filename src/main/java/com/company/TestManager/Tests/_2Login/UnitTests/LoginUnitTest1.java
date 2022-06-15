package com.company.TestManager.Tests._2Login.UnitTests;

import com.company.TestManager.Objects.User;
import com.company.TestManager.Test;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Tests._2Login.LoginResponse;

import java.io.IOException;

public class LoginUnitTest1 extends UnitTest {
    //  constructor cần phải thêm expectation
    public LoginUnitTest1(Test test) {
        super(test, "With correct email and password, response code should be 1000 and data should not be null and data contains not null fields");
    }

    @Override
    public void test() throws IOException {
//        truyền các params để gọi request đến server
        String tempEmail = "thanh12345@gmail.com";
        this.params.put("email", tempEmail);
        this.params.put("password", "12345678");

//        gửi request và truyền vào class của object cần trả về
        LoginResponse res = this.sendPostRequest(LoginResponse.class);

//        đưa ra các giả định
        this.assertionManager.assertNotEquals(res, null);
        if (res == null) return;

        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertInstanceOf(res.message, String.class);

        LoginResponse.Data data = res.data;
        this.assertionManager.assertNotEquals(data, null);
        if (data == null) return;
        this.assertionManager.assertInstanceOf(data.access_token, String.class);
        this.assertionManager.assertBoolean(data.access_token.length() > 0);
        this.assertionManager.assertInstanceOf(data.token_type, String.class);
        this.assertionManager.assertBoolean(data.token_type.length() > 0);
        this.assertionManager.assertInstanceOf(data.expires_in, String.class);
        this.assertionManager.assertBoolean(data.expires_in.length() > 0);

        User user = res.data.user;
        this.assertionManager.assertNotEquals(user, null);
        this.assertionManager.assertInstanceOf(user.name, String.class);
        this.assertionManager.assertInstanceOf(user.role, String.class);
        this.assertionManager.assertInstanceOf(user.avatar, String.class);
        this.assertionManager.assertEquals(user.email, tempEmail);
        this.assertionManager.assertInstanceOf(user.phone, String.class);

    }
}
