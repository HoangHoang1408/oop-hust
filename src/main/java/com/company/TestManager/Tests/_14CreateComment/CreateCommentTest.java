package com.company.TestManager.Tests._14CreateComment;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._14CreateComment.UnitTests.CreateCommentUnitTest1;
import com.company.TestManager.Tests._14CreateComment.UnitTests.CreateCommentUnitTest2;
import com.company.TestManager.Tests._14CreateComment.UnitTests.CreateCommentUnitTest3;
import com.company.TestManager.Tests._14CreateComment.UnitTests.CreateCommentUnitTest4;

import java.util.List;

public class CreateCommentTest extends Test {
    public CreateCommentTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new CreateCommentUnitTest1(this),new CreateCommentUnitTest2(this), new CreateCommentUnitTest3(this), new CreateCommentUnitTest4(this)));
    }
}
