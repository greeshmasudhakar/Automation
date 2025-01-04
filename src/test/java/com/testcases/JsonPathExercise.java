package com.testcases;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JsonPathExercise {

    @Test
    public void jpathExercise() {
        String s = "{\n" +
                "  \"dashboard\":{\n" +
                "    \"purchaseAmount\":910,\n" +
                "    \"website\": \"greeshma.com\"\n" +
                "  },\n" +
                "  \"courses\":[\n" +
                "    {\n" +
                "      \"title\":\"selenium\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\":6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\":\"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\":4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\":\"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\":10\n" +
                "    }\n" +
                "    ]\n" +
                "}";

        JsonPath jpath = new JsonPath(s);
        int sum=0;
        List courses= jpath.get("courses");
        System.out.println("courses size : "+jpath.getInt("courses.size()"));
        System.out.println(jpath.get("dashboard.purchaseAmount").toString());
        System.out.println(jpath.get("courses[0].title").toString());
        for(int i=0;i<courses.size();i++){
            System.out.println(jpath.get("courses["+i+"].title").toString()+","+jpath.get("courses["+i+"].price").toString());
            if(jpath.get("courses["+i+"].title").toString().equals("RPA")){
                System.out.println(jpath.get("courses["+i+"].copies").toString());
            }
            int price = jpath.get("courses["+i+"].price");
            int noOfCopies= jpath.get("courses["+i+"].copies");
             sum =sum +(price*noOfCopies);
        }

        Assert.assertEquals(Integer.parseInt(jpath.get("dashboard.purchaseAmount").toString()),sum,"sums doesn't match");
        System.out.println("sum "+sum);
    }
}
