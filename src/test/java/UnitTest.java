import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UnitTest
{
    @Test
    public void getCall()
    {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given().
                when().
                header("Content-Type", "application/json").
                get("api/users?page=2").andReturn();
        int StatusCode = response.getStatusCode();
        Assert.assertEquals(StatusCode,200);
    }
    @Test()
    public void postCall()
    {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given().
                when().
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}").
                post("/api/register");
        int StatusCode = response.getStatusCode();
        Assert.assertEquals(StatusCode,200);
    }

}
