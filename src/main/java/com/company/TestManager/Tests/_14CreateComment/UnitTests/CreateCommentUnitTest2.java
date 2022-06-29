package com.company.TestManager.Tests._14CreateComment.UnitTests;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._14CreateComment.CreateCommentResponse2;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateCommentUnitTest2 extends UnitTest {
    public CreateCommentUnitTest2(Test test) {
        super(test, "With correct params, response code should be 1000 and data should not be null and comment contains submitted comment ");
    }

    @Override
    public void test() throws IOException {
        String comment = "Hello Tung";
        this.params.put("content", comment);
        this.params.put("comment_last_id", "10");

        CreateCommentResponse2 res = Connection.sendPostRequest(this.fullURLString + "/1", this.params, CreateCommentResponse2.class, this.getAccessToken());

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertInstanceOf(res.message, String.class);
        this.assertion.assertNotEquals(res.data, null);
        this.assertion.assertTrue(Integer.parseInt(res.data.total) >= 1);


    }
}
