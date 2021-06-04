package com.student.tests;


import com.github.javafaker.Faker;
import com.github.javafaker.ProgrammingLanguage;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;
import com.student.tags.Regression;
import com.student.tags.Smoke;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;

public class CrudTest extends TestBase {

    RequestFactory requests = new RequestFactory();

    @Category(Smoke.class)
    @DisplayName("This test gets all students")
    @Test
    public void getAllStudents() {
        requests.getAllStudents()
                .then()
                .spec(SpecificationFactory.genericResponseSpec())
                .statusCode(200);

    }

    @Category(Regression.class)
    @DisplayName("This test creates a student")
    @Test
    public void createStudent() {

        Faker faker = new Faker();
        String firstName= faker.name().firstName();
        String lastName= faker.name().lastName();
        String email= faker.internet().emailAddress();
        String programme = "Computer Science";

        List<String> courses = new ArrayList<String>();
        courses.add(faker.programmingLanguage().name());
        courses.add(faker.programmingLanguage().name());

        requests.createStudent("", firstName, lastName, email, programme, courses)
                .then()
                .spec(SpecificationFactory.genericResponseSpec())
                .statusCode(201);
    }

}
