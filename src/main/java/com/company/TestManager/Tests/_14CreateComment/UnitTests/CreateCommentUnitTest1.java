package com.company.TestManager.Tests._14CreateComment.UnitTests;

import com.company.TestManager.Test;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Tests._14CreateComment.CreateCommentResponse;
import com.company.utils.ConnectionUtil;

import java.io.IOException;

public class CreateCommentUnitTest1 extends UnitTest {
    //    content
//            comment_last_id
    public CreateCommentUnitTest1(Test test) {
        super(test, "With correct params, response code should be 1000 and data should not be null and comment contains submitted comment ");
    }

    @Override
    public void test() throws IOException {
        String comment = "Hello from Hoang 9384578";
        this.params.put("content", comment);
        this.params.put("comment_last_id", "10");

        CreateCommentResponse res = ConnectionUtil.sendPostRequest(this.fullURLString + "/1", this.params, CreateCommentResponse.class, this.getAccessToken());

        this.assertionManager.assertNotEquals(res, null);
        this.assertionManager.assertEquals(res.code, 1000);
        this.assertionManager.assertBoolean(res.message.length() > 0);
        this.assertionManager.assertNotEquals(res.data, null);
        this.assertionManager.assertBoolean(Integer.parseInt(res.data.total) >= 1);
        this.assertionManager.assertBoolean(res.data.comments.size() >= 1);
        this.assertionManager.assertBoolean(res.data.comments.stream().map(cm -> cm.content).toList().contains(comment));
    }
}
