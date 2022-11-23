import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/";


        Response response = given().
                            when().
                            header("Content-Type", "application/json").
                            body("{\n" +
                            "    \"email\": \"eve.holt@reqres.in\",\n" +
                            "    \"password\": \"pistol\"\n" +
                            "}").
                             post("/api/register");

        String res = response.getBody().asString();
        System.out.println("status code: " + response.getStatusCode());
        System.out.println(res);
    }
}
