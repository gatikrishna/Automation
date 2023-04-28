package utility;

import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utility {

    public static RequestSpecification getRequestSpec() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("authorization", GlobalProperty.getProperty("token"));
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(GlobalProperty.getProperty("Env-Url"))
                .addHeaders(headers)
                .log(LogDetail.ALL)
                .build();
        return requestSpecification;
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }

}
