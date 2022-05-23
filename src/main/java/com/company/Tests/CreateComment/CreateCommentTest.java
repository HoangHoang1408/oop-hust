package com.company.Tests.CreateComment;

import com.company.BaseURL;
import com.company.Tests.CreateComment.UnitTests.CreateCommentUnitTest1;
import com.company.Tests.Test;

import java.util.List;

public class CreateCommentTest extends Test {
    public CreateCommentTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new CreateCommentUnitTest1(this)));
    }
}
