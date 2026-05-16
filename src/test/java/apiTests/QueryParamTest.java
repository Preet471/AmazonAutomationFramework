package apiTests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class QueryParamTest {

    @Test
    public void queryParameterTest() {

        Response response =

                given()
                .header("x-api-key", "free_user_3DnXnmYC0aL9kLacVVjnBPohe5P")
                .queryParam("page", 2)

                .when()
                .get("https://reqres.in/api/users");

        System.out.println(response.getStatusCode());

        System.out.println(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200);

        int pageNumber = response.jsonPath().getInt("page");

        System.out.println(pageNumber);

        Assert.assertEquals(pageNumber, 2);
    }
}