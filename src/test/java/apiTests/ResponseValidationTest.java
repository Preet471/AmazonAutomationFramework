package apiTests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResponseValidationTest {

    @Test
    public void validateResponseTest() {

        Response response =

                given()
                .header("x-api-key", "free_user_3DnXnmYC0aL9kLacVVjnBPohe5P")

                .when()
                .get("https://reqres.in/api/users?page=2");

        // STATUS CODE
        Assert.assertEquals(response.getStatusCode(), 200);

        // RESPONSE TIME
        long time = response.getTime();

        System.out.println("Response Time: " + time);

        Assert.assertTrue(time < 5000);

        // HEADER VALIDATION
        String contentType = response.getHeader("Content-Type");

        System.out.println(contentType);

        Assert.assertTrue(contentType.contains("application/json"));

        // JSON DATA VALIDATION
        String lastname = response.jsonPath().getString("data[1].last_name");

        System.out.println(lastname);

        Assert.assertEquals(lastname, "Ferguson");
    }
}