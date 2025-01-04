package com.testcases;

import com.model.PostResponseModel;
import com.model.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.utils.Utility.getResponse;
import static com.utils.Utility.setRequestBody;

public class Testcase {


    @Test
    public void addPlace(){
        Request requestBody= setRequestBody(33.427362,-33.427362,50,"Greeshma","1234567890", List.of("shoe","shoeMaker"),"English-en","https://greeshma.com","29 side layout, cohen 09");
        PostResponseModel response =getResponse(requestBody);
        Assert.assertEquals(response.getScope(),"APP","Scope doesn't match with APP");
    }
}
