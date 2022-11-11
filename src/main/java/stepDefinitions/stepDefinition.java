package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class stepDefinition {

    Response response;

    @Given("^I am on Reqres application$")
    public void ivenIAmOnReqresApplication() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @When("^I pass the (.*) for get api call$")
    public void iPassTheEndpoint(String endpoint) {
        response = given().
                when().
                header("content-type", "application/json").
                get(endpoint);
    }

    @Then("^I get the statuscode (.*)$")
    public void iGetTheStatusCode(int expectedStatuscode) {
        int actualStatuscode = response.getStatusCode();
        Assert.assertEquals(actualStatuscode, expectedStatuscode);

        // Write code here that turns the phrase above into concrete actions
        // throw new PendingException();
    }

    @When("^I pass the (.*) for post api call$")
    public void iPassTheEndpointForPostApiCall(String endpoint) {
        response = given().
                when().
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +"}").
                post(endpoint);
//        int actualStatuscode = response.getStatusCode();
//        Assert.assertEquals(actualStatuscode, 200);

    }

    @Then("^I get the statuscodes for create users (.*)$")
    public void iGetTheStatuscodesForCreateUsersStatuscode(int expectedStatuscode) {
        int actualStatuscode = response.getStatusCode();
        Assert.assertEquals(actualStatuscode, expectedStatuscode);
    }

//    @Then("^I get the statuscode (.*)$")
//    public void iGetTheStatuscodeStatuscode( int expectedStatuscode) {
//        int actualStatuscode = response.getStatusCode();
//        Assert.assertEquals(actualStatuscode, expectedStatuscode);
//    }
}