package apiTests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class FirstAPITest {

	@Test
	public void getUsersTest() {

	    Response response =

	            given()
	            .header("x-api-key", "free_user_3DnXnmYC0aL9kLacVVjnBPohe5P")

	            .when()
	            .get("https://reqres.in/api/users?page=2");

	    System.out.println(response.getStatusCode());

	    System.out.println(response.getBody().asString());

	    Assert.assertEquals(response.getStatusCode(), 200);

	    String firstName = response.jsonPath().getString("data[0].first_name");

	    System.out.println(firstName);

	    Assert.assertEquals(firstName, "Michael");
	}}