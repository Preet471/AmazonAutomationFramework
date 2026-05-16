package apiTests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutAPITest {

    @Test
    public void updateUserTest() {

        String requestBody = "{\n" +
                "   \"name\":\"Preetham Updated\",\n" +
                "   \"job\":\"Senior QA Engineer\"\n" +
                "}";

        Response response =

                given()
                .header("x-api-key", "free_user_3DnXnmYC0aL9kLacVVjnBPohe5P")
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .put("https://reqres.in/api/users/2");

        System.out.println(response.getStatusCode());

        System.out.println(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200);

        String updatedJob = response.jsonPath().getString("job");

        System.out.println(updatedJob);

        Assert.assertEquals(updatedJob, "Senior QA Engineer");
    }
}