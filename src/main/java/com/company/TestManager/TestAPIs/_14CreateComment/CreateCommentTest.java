package com.company.TestManager.TestAPIs._14CreateComment;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._14CreateComment.UnitTests.CreateCommentUnitTest1;
import com.company.TestManager.TestAPIs._14CreateComment.UnitTests.CreateCommentUnitTest2;
import com.company.TestManager.TestAPIs._14CreateComment.UnitTests.CreateCommentUnitTest3;
import com.company.TestManager.TestAPIs._14CreateComment.UnitTests.CreateCommentUnitTest4;
import com.company.utils.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateCommentTest extends Test {
    public CreateCommentTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new CreateCommentUnitTest1(this),new CreateCommentUnitTest2(this), new CreateCommentUnitTest3(this), new CreateCommentUnitTest4(this)));
    }
    public static HashMap<String, String> generateDefaultParams() {

        String content= Util.randomAlphabetString(201);
        String comment_last_id="10";
        return new HashMap<>(Map.of(
                "content", content ,
                "comment_last_id", comment_last_id

        ));
    }
}
