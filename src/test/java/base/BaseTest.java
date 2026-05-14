//package base;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class BaseTest {
//
//    public WebDriver driver;
//
//    public static ExtentReports extent;
//    public static ExtentTest test;
//
//    // ================= SETUP =================
//    @BeforeMethod
//    public void setup() {
//
//        if (extent == null) {
//            extent = ReportManager.getReport();
//        }
//
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.amazon.in/");
//    }
//
//    // ================= RESULT HANDLER =================
//    @AfterMethod
//    public void tearDown(ITestResult result) {
//
//        if (result.getStatus() == ITestResult.SUCCESS) {
//
//            test.pass("Test Passed ✔");
//        }
//
//        else if (result.getStatus() == ITestResult.FAILURE) {
//
//            // 🔥 TAKE SCREENSHOT ON FAILURE
//            String path = ScreenshotUtil.takeScreenshot(driver, result.getName());
//
//            test.fail("Test Failed ❌");
//            test.fail(result.getThrowable());
//
//            try {
//                test.addScreenCaptureFromPath(path);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        else if (result.getStatus() == ITestResult.SKIP) {
//            test.skip("Test Skipped ⏭");
//        }
//
//        driver.quit();
//    }
//
//    // ================= FINAL REPORT =================
//    @AfterSuite
//    public void endReport() {
//        extent.flush();
//    }
//}
//
//
//
package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public WebDriver driver;

    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeMethod
    public void setup() {

        if (extent == null) {
            extent = ReportManager.getReport();
        }

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.in/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed ✔");
        } 
        else if (result.getStatus() == ITestResult.FAILURE) {

            String path = ScreenshotUtil.takeScreenshot(driver, result.getName());

            test.fail("Test Failed ❌");
            test.fail(result.getThrowable());

            try {
                test.addScreenCaptureFromPath(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped ⏭");
        }

        driver.quit();
    }

    @AfterSuite
    public void endReport() {
        extent.flush();
    }
}