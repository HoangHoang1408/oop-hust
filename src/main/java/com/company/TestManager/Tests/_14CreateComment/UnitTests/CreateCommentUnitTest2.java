package com.company.TestManager.Tests._14CreateComment.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._14CreateComment.CreateCommentResponse2;
import com.company.TestManager.UnitTest;
import com.company.utils.ConnectionUtil;

import java.io.IOException;

public class CreateCommentUnitTest2 extends UnitTest {
    public CreateCommentUnitTest2(Test test) {
        super(test, "With correct params, response code should be 1000 and data should not be null and comment contains submitted comment ");
    }
    @Override
    public void test() throws IOException {
        String comment = "Hello";
        this.params.put("content", comment);
        this.params.put("comment_last_id", "10");

        CreateCommentResponse2 res = ConnectionUtil.sendPostRequest(this.fullURLString + "/1", this.params, CreateCommentResponse2.class, this.getAccessToken());

        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertNotEquals(res.data, null);
        this.assertionManager.assertBoolean(Integer.parseInt(res.data.total) >= 1);
        this.assertionManager.assertBoolean(res.data.content.length() >= 1);
        this.assertionManager.assertInstanceOf(res.data.auction_id, String.class);
        this.assertionManager.assertInstanceOf(res.data.user_id, String.class);
        this.assertionManager.assertInstanceOf(res.data.content, String.class);
        this.assertionManager.assertInstanceOf(res.data.update_at, String.class);
        this.assertionManager.assertInstanceOf(res.data.total, String.class);

    }
}
