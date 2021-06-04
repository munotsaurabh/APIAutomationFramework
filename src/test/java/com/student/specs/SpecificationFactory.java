package com.student.specs;

import com.student.tests.TestBase;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.internal.ResponseSpecificationImpl;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class SpecificationFactory extends TestBase {

    public static synchronized ResponseSpecification genericResponseSpec() {

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        ResponseSpecification responseSpecification;

        responseSpecBuilder.expectHeader("Content-Type", "application/json;charset=UTF-8");
        responseSpecBuilder.expectHeader("Transfer-Encoding", "chunked");
        responseSpecBuilder.expectResponseTime(lessThan(5l), TimeUnit.SECONDS);

        responseSpecification = responseSpecBuilder.build();

        return responseSpecification;

    }

    public static synchronized RequestSpecification logPayloadInfo() {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        RequestSpecification requestSpecification;

        requestSpecBuilder.addFilter(new AllureRestAssured());
        requestSpecification = requestSpecBuilder.build();

        return requestSpecification;

    }

}

