//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class HomePage {
//
//    WebDriver driver;
//
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    By searchBox = By.id("twotabsearchtextbox");
//    By searchBtn = By.id("nav-search-submit-button");
//
//    public void search(String product) {
//        driver.findElement(searchBox).sendKeys(product);
//        driver.findElement(searchBtn).click();
//    }
//}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.id("twotabsearchtextbox");
    By searchBtn = By.id("nav-search-submit-button");

    public void search(String product) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchBtn).click();
    }

    public boolean isSearchBoxDisplayed() {
        return driver.findElement(searchBox).isDisplayed();
    }
}