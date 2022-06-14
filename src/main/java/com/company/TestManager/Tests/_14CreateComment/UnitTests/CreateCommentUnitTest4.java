package com.company.TestManager.Tests._14CreateComment.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._14CreateComment.CreateCommentResponse2;
import com.company.TestManager.UnitTest;
import com.company.utils.ConnectionUtil;

import java.io.IOException;

public class CreateCommentUnitTest4 extends UnitTest {
    public CreateCommentUnitTest4(Test test){
        super(test, "Not logged in, response code should be 1004 and data should be null and comment not contains submitted comment ");
    }

    @Override
    public void test() throws IOException {
        String comment = "Hello";
        this.params.put("content", comment);
        this.params.put("comment_last_id", "10");
        String accessToken = "djsldfgdfdsfsdgdfwrong214fgjksldfgjsdaNiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3fwpMeJf36POk6yJV_adQssw5cdgjdfgdklzfg";
        CreateCommentResponse2 res = ConnectionUtil.sendPostRequest(this.fullURLString+"/1", this.params, CreateCommentResponse2.class, accessToken);

        this.assertionManager.assertEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1004);
        this.assertionManager.assertEquals(res.data, null);
    }
}