package APIsteps;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import utils.APIConstants;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class GenTOken {


    public static String tokenn;



@Test
    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        RequestSpecification requestSpecification=given().header("Content-type","application/json").
                body("{\"email\": \"checking123@g.com\", \"password\": \"checking\"}");

       Response response=requestSpecification.when().post(APIConstants.GENERATE_TOKEN_URI);

     tokenn="Bearer "+ response.jsonPath().getString("token");
        System.out.println(tokenn);


    }




}
