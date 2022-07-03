package com.company.TestManager.TestAPIs._15GetListComments;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._15GetListComments.UnitTest.GetListCommentUnitTest1;

import java.util.List;

public class GetListCommentsTest extends Test {
    public GetListCommentsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetListCommentUnitTest1(this)));
    }
}
