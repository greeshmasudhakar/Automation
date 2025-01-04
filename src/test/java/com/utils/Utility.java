package com.utils;

import com.google.gson.Gson;
import com.model.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;
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
        JSONObject jsonObject=new JSONObject(response.getBody().asString());
        String place_id= jsonObject.getString("place_id");
        Response response2= given().baseUri("https://rahulshettyacademy.com").queryParam("key","qaclick123").
                queryParam("place_id",place_id).when().get(" /maps/api/place/get/json");
        System.out.println("get response "+response2.getBody().asString());
        PutRequestModel putPayload=new PutRequestModel();
        putPayload.setPlace_id(place_id);
        putPayload.setAddress("North America");
        putPayload.setKey("qaclick123");
        Response putResponse= given().log().all().baseUri("https://rahulshettyacademy.com").body(putPayload)
                .when().put("/maps/api/place/update/json");
        System.out.println("put response "+putResponse.getBody().asString());
        DeleteRequest deletepayload=new DeleteRequest();
        deletepayload.setPlace_id(place_id);
        Response delete=given().baseUri("https://rahulshettyacademy.com").body(deletepayload).queryParam("key","qaclick123").when().delete(" /maps/api/place/delete/json");
        System.out.println("delete response "+delete.getBody().asString());
        Gson gson=new Gson();
        return gson.fromJson(response.getBody().asString(),PostResponseModel.class);
    }
}
