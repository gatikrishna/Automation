package stepdefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import utility.GlobalProperty;
import utility.Utility;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class CommonStepDef {

    private Response response = null;


    @Given("User login to the application using {string} and {string}")
    public void user_login_to_the_application_using_and(String username, String password) throws Throwable {
        RestAssured.baseURI = GlobalProperty.getProperty("Token-Url");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Accept", "application/json");

        Map<String, String> body = new HashMap<String, String>();
        body.put("grant_type", GlobalProperty.getProperty("grant_type"));
        body.put("client_id", GlobalProperty.getProperty("client_id"));
        body.put("client_secret", GlobalProperty.getProperty("client_secret"));
        body.put("username", username);
        body.put("password", password);

        Response response = given().headers(headers).formParams(body).when().post();
        JsonPath jsonpath = new JsonPath(response.asString());
        GlobalProperty.setProperty("token", "Bearer " + jsonpath.getString("access_token"));

    }


    @When("User {string} details of {string}")
    public void user_something_details_of_something(String method, String endpoint) {
        String endPoint = method + "_" + endpoint;
        response = (Response) given(Utility.getRequestSpec()).when().get(GlobalProperty.getProperty(endPoint))
                .then()
                .spec(Utility.getResponseSpec());

    }

    @Then("Verify status code as {string}")
    public void verify_status_code_as_something(String statusCode) throws Throwable {
        Assert.assertEquals("Status code matches", response.getStatusCode(), Integer.parseInt(statusCode));
    }
}
