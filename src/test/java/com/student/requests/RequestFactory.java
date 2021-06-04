package com.student.requests;

import com.student.pojo.StudentClass;
import com.student.tests.TestBase;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class RequestFactory extends TestBase {

    RestClient restClient = new RestClient();

    @Step("Fetching all students info from db")
    public Response getAllStudents(){
        Response response = restClient.doGetRequest("/list");
        return response;
    }

    @Step("Creating a new student")
    public Response createStudent(String url, String firstName, String lastName, String email, String programme, List<String> courses){

        StudentClass body = new StudentClass();
        body.setFirstName(firstName);
        body.setLastName(lastName);
        body.setEmail(email);
        body.setProgramme(programme);
        body.setCourses(courses);

        return restClient.doPostRequest(url, body);

    }
}
