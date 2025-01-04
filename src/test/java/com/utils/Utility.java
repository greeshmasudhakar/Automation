package com.utils;

import com.google.gson.Gson;
import com.model.Location;
import com.model.PostResponseModel;
import com.model.Request;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Utility {


    public static Request setRequestBody(double lat,double lng,int accuracy,String name,String phoneNumber,List<String> types,String language,String website,String address){
        Location location=new Location();
        location.setLat(lat);
        location.setLng(lng);
        Request payload =new Request();
        payload.setAccuracy(accuracy);
        payload.setName(name);
        payload.setLocation(location);
        payload.setPhone_number(phoneNumber);
        payload.setTypes(types);
        payload.setLanguage(language);
        payload.setWebsite(website);
        payload.setAddress(address);
        return payload;
    }

    public static PostResponseModel getResponse(Request requestBody){
        Response response= given().log().all().baseUri("https://rahulshettyacademy.com").queryParam("key","qaclick123").header("content-type","application/json")
                .body(requestBody).when().post(" /maps/api/place/add/json");
        System.out.println("response1:"+response.getBody().asString());
        Gson gson=new Gson();
        return gson.fromJson(response.getBody().asString(),PostResponseModel.class);
    }
}
