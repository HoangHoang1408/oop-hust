package com.company.TestManager.Tests._1SignUp.UnitTests;

import com.company.TestManager.Objects.User;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._1SignUp.SignUpResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class SignUpUnitTest1 extends UnitTest {
    public SignUpUnitTest1(Test test) {
        super(test, "With correct params format, the response code should be 1000 and message strings shall be not null as well as non-empty");
    }

    @Override
    public void test() throws IOException {
        //        create request object
        this.params = this.generateDefaultParams();

        SignUpResponse res = this.sendPostRequest(SignUpResponse.class);
        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertBoolean(res.message.length() > 0);


        User user = res.data;
        this.assertionManager.assertNotEquals(user, null);
        this.assertionManager.assertEquals(user.name, this.params.get("name"));
        this.assertionManager.assertEquals(user.role, "2");
        this.assertionManager.assertBoolean(user.avatar.length() > 0);
        this.assertionManager.assertEquals(user.address, this.params.get("address"));
        this.assertionManager.assertEquals(user.email, this.params.get("email"));
        this.assertionManager.assertEquals(user.phone, this.params.get("phone"));
    }
}
