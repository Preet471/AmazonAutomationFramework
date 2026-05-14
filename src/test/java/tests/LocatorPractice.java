package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class LocatorPractice extends BaseTest {
	@DataProvider(name="searchData")
	public Object[][] getData()
	{
	    return new Object[][]
	    {
	        {"iPhone"},
	        {"Samsung"},
	        {"Laptop"}
	    };
	}
	@Test(dataProvider="searchData")
	public void amazonSearchTest(String product)
	{
	    setup();

	    driver.findElement(By.id("twotabsearchtextbox"))
	          .sendKeys(product);

	    driver.findElement(By.id("nav-search-submit-button"))
	          .click();

	    closeBrowser();
	}
	private void closeBrowser() {
		// TODO Auto-generated method stub
		
	}
}
