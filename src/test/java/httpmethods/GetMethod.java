package httpmethods;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class GetMethod {


    @Test
    public void getResponseBody(){
        given().queryParam("CUSTOMER_ID",68195)
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No",1)
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
    }
}
