package com.company.TestManager.Tests._27ReadNews.UnitTest;

import com.company.TestManager.Tests._27ReadNews.ReadNewsResponse;
import com.company.TestManager.Tests._27ReadNews.ReadNewsTest;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Test;
import com.company.utils.ConnectionUtil;

import java.io.IOException;

public class ReadNewsUnitTest1 extends UnitTest {
    public ReadNewsUnitTest1(Test test){
        super(test,"Read the notice from the version auction");
    }
    @Override
    public void test() throws IOException{
        ReadNewsResponse res= ConnectionUtil.sendGetRequest(this.fullURLString+"/1",this.params,ReadNewsResponse.class,getAccessToken());
        this.assertionManager.assertNotEquals(res,null);
        this.assertionManager.assertEquals(res.data.is_read,"1");
    }
}
