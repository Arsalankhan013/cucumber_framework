package APIsteps;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;

import static io.restassured.RestAssured.given;

public class GenerateToken {


    public static String token;




    @Given("a JWT is generated")
    public void a_jwt_is_generated() {

        RequestSpecification request=given().header("Content-Type","application/json").body(
                "{\"email\": \"checking123@g.com\", \"password\": \"checking\"}");


        Response response=request.when().post(APIConstants.GENERATE_TOKEN_URI);
token="Bearer "+ response.jsonPath().getString("token");

    }
}
