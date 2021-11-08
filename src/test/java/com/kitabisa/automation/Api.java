package com.kitabisa.automation;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class Api {

  final static String url = "https://reqres.in/";

  @Test
  public void verifyGetListUsersResponse200AndEmailFound() {
    Response response = given().baseUri(url)
        .basePath("api")
        .queryParam("page", 2)
        .header("accept", "application/json")
        .contentType(ContentType.JSON)
        .log().all()
        .get("users");
    response.getBody().prettyPrint();

    //assert status code
    int statusCode = response.getStatusCode();
    Assert.assertEquals(200, statusCode);

    //assert email (not sure with the task)
    //check email inside list
    List<String> data = response.path("data");
    List<String> emails = new ArrayList<>();
    for (int i = 0; i < data.size(); i++) {
      String path = String.format("data[%d].email", i);
      emails.add(response.path(path));
    }
    Assert.assertTrue(emails.contains("lindsay.ferguson@reqres.in"));
  }

  @Test
  public void verifyCreateUserResponse201AndDataCreated() {
    String body = "{\n"
        + "    \"name\": \"Tri\",\n"
        + "    \"job\": \"QA\"\n"
        + "}";

    Response response = given().baseUri(url)
        .basePath("api")
        .header("accept", "application/json")
        .contentType(ContentType.JSON)
        .log().all()
        .body(body)
        .post("users");
    response.getBody().prettyPrint();

    //assert status code
    //create user success now have response code 201 (need update question)
    int statusCode = response.getStatusCode();
    Assert.assertEquals(201, statusCode);

    System.out.println("id : " + response.path("id"));
    System.out.println("name : " + response.path("name"));
    System.out.println("job : " + response.path("job"));
  }

}
