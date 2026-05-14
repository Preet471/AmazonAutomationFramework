package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;

public class testcase_3 extends BaseTest {

    @DataProvider(name = "searchData")
    public Object[][] getData() {
        return new Object[][] {
            { "iPhone" }
            
        };
    }

    // This method will handle the search action so we can reuse it
    public void performSearch(String product) {
        // Locate search box and enter product name
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);

        // Locate search button and click
        driver.findElement(By.id("nav-search-submit-button")).click();

        // Wait for results to load
        try {
            Thread.sleep(3000); // Wait for 3 seconds (replace with explicit wait later)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "searchData")
    public void amazonSearchTest(String product) {
        setup(); // Launch browser and open Amazon

        performSearch(product); // Reuse the search action

        // Optional: Add some basic validation, like checking if results loaded (you can extend later)

        closeBrowser(); // Close browser after test
    }

    private void closeBrowser() {
		// TODO Auto-generated method stub
		
	}

	@Test(dataProvider = "searchData")
    public void amazonSearchTitleValidation(String product) {
        setup(); // Launch browser and open Amazon

        performSearch(product); // Reuse the search action

        // Validate that the search results page title includes the product name
        String title = driver.getTitle();
        Assert.assertTrue(title.toLowerCase().contains(product.toLowerCase()), 
            "Search results page title does not contain the product name!");

        closeBrowser(); // Close browser after test
    }

    // You can add more test cases by creating new @Test methods here, each with a different validation.
}