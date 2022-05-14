package com.company.Tests.GetListAuctions;

import com.company.BaseURL;
import com.company.Tests.GetListAuctions.UnitTests.GetListAuctionsUnitTest1;
import com.company.Tests.Test;

import java.util.List;

public class GetListAuctionsTest extends Test {

    public GetListAuctionsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetListAuctionsUnitTest1(this)));
    }
}
