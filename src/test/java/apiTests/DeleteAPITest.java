package apiTests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DeleteAPITest {

    @Test
    public void deleteUserTest() {

        Response response =

                given()
                .header("x-api-key", "free_user_3DnXnmYC0aL9kLacVVjnBPohe5P")

                .when()
                .delete("https://reqres.in/api/users/2");

        System.out.println(response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(), 204);

        System.out.println("User Deleted Successfully");
    }
}
