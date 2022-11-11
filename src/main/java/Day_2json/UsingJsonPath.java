package Day_2json;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsingJsonPath {
    public static void main(String[] args)
    {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given().
                            when().
                            header("Content-Type", "application/json").
                            get("api/users?page=2").andReturn();

        String res1 = response.getBody().asString();

       String firstname = JsonPath.read(res1,"$.data[1].first_name");
        System.out.println(firstname);

    }
}
