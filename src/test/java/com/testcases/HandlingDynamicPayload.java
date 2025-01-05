package com.testcases;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HandlingDynamicPayload {


    @DataProvider(name="books")
    public Object[][] getData(){
        //2d array. object[2][3] . 2 rows ,3 columns
        return new Object[][]{{"java","acbd","1236","James"},{"python","efdg2s","7690","Jacob"},{"c#","hksdf","6754","Geet"}};
    }

    @Test(dataProvider = "books")
    public void addBook(String author,String name,String isbn,String aisle){
        RestAssured.baseURI="http://216.10.245.166";
       Response response= given().log().all().header("content-type","application/json").body(getPayload(author,name,isbn,aisle)).when()
                .post("/Library/Addbook.php");
        System.out.println("response "+response.getBody().asString());

    }

    public String getPayload(String author,String name,String isbn, String aisle){
        return "{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"isbn\": \""+isbn+"\",\n" +
                "  \"aisle\": \""+aisle+"\",\n" +
                "  \"author\": \""+author+"\"\n" +
                "}";
    }
}
