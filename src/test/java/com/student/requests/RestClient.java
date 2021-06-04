package com.student.requests;

import com.student.specs.SpecificationFactory;
import com.student.tests.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestClient extends TestBase {

    public Response doGetRequest(String endpoint){

        return given()
                .when()
                .get(endpoint);
    }

    public Response doPostRequest(String url, Object body){
        return given().
                contentType(ContentType.JSON)
                .spec(SpecificationFactory.logPayloadInfo())
                .when()
                .body(body)
                .post();
    }
}
