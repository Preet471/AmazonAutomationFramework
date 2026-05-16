package apiTests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAPITest {

    @Test
    public void createUserTest() {

        String requestBody = "{\n" +
                "    \"name\": \"Preetham\",\n" +
                "    \"job\": \"QA Engineer\"\n" +
                "}";

        Response response =

                given()
                .header("x-api-key", "free_user_3DnXnmYC0aL9kLacVVjnBPohe5P")
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .post("https://reqres.in/api/users");

        System.out.println(response.getStatusCode());

        System.out.println(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 201);

        String name = response.jsonPath().getString("name");

        System.out.println(name);

        Assert.assertEquals(name, "Preetham");
    }
}