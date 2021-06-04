package com.student.tests;

import com.student.util.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {

    public static PropertyReader properties;

    @BeforeClass
    public static void init(){
        properties= PropertyReader.getInstance();

        RestAssured.baseURI = properties.getProperty("baseUrl");
        RestAssured.port = Integer.parseInt(properties.getProperty("port"));

    }
}
