package com.testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class StaticPayload {

    @Test
    public void staticPayloadFromJsonFile() throws IOException {
        // content of the file to string :  content of the file can convert into Byte -->Byt data to String.
         String payload= new String(Files.readAllBytes(Paths.get("C:\\Users\\grees\\git\\Projects\\api_restassured\\src\\test\\java\\com\\json\\addBook.json")));
        RestAssured.baseURI="http://216.10.245.166";
        Response response= given().log().all().header("content-type","application/json").body(payload).when()
                .post("/Library/Addbook.php").then().log().all().extract().response();
        System.out.println("response "+response.getBody().asString());
    }
}
