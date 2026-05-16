package apiTests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PathParamTest {

    @Test
    public void pathParameterTest() {

        Response response =

                given()
                .header("x-api-key", "free_user_3DnXnmYC0aL9kLacVVjnBPohe5P")
                .pathParam("id", 2)

                .when()
                .get("https://reqres.in/api/users/{id}");

        System.out.println(response.getStatusCode());

        System.out.println(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200);

        String firstName = response.jsonPath().getString("data.first_name");

        System.out.println(firstName);

        Assert.assertEquals(firstName, "Janet");
    }
}