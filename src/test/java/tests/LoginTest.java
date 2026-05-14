package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void start()
    {
        setup();
    }

    @Test
    public void amazonTitleTest()
    {
        String title = driver.getTitle();

        System.out.println(title);
    }

    @AfterMethod
    public void end()
    {
        closeBrowser();
    }

	private void closeBrowser() {
		// TODO Auto-generated method stub
		
	}
}