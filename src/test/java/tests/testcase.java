//package tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import base.BaseTest;
//
//import java.util.List;
//
//public class testcase extends BaseTest {
//
//    // COMMON SEARCH
//    public void search(String product) {
//        driver.findElement(By.id("twotabsearchtextbox")).clear();
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
//        driver.findElement(By.id("nav-search-submit-button")).click();
//    }
//
//    // TC1
//    @Test
//    public void TC1_verifySearchBox() {
//        test = extent.createTest("TC1_verifySearchBox");
//
//        Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed());
//    }
//
//    // TC2
//    @Test
//    public void TC2_searchProduct() {
//        test = extent.createTest("TC2_searchProduct");
//
//        search("iPhone");
//    }
//
//    // TC3
//    @Test
//    public void TC3_verifyTitle() {
//        test = extent.createTest("TC3_verifyTitle");
//
//        search("iPhone");
//        Assert.assertTrue(driver.getTitle().toLowerCase().contains("iphone"));
//    }
//
//    // TC4
//    @Test
//    public void TC4_verifyResultsDisplayed() {
//        test = extent.createTest("TC4_verifyResultsDisplayed");
//
//        search("iPhone");
//
//        List<WebElement> results =
//                driver.findElements(By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']"));
//
//        Assert.assertTrue(results.size() > 0);
//    }
//
//    // TC5
//    @Test
//    public void TC5_clickFirstProduct() {
//        test = extent.createTest("TC5_clickFirstProduct");
//
//        search("iPhone");
//        driver.findElements(By.cssSelector("h2 a")).get(0).click();
//    }
//
//    // TC6
//    @Test
//    public void TC6_addToCartButtonVisible() {
//        test = extent.createTest("TC6_addToCartButtonVisible");
//
//        search("iPhone");
//        driver.findElements(By.cssSelector("h2 a")).get(0).click();
//
//        Assert.assertTrue(driver.findElement(By.id("add-to-cart-button")).isDisplayed());
//    }
//
//    // TC7
//    @Test
//    public void TC7_addToCart() {
//        test = extent.createTest("TC7_addToCart");
//
//        search("iPhone");
//        driver.findElements(By.cssSelector("h2 a")).get(0).click();
//
//        driver.findElement(By.id("add-to-cart-button")).click();
//    }
//
//    // TC8
//    @Test
//    public void TC8_cartIconVisible() {
//        test = extent.createTest("TC8_cartIconVisible");
//
//        Assert.assertTrue(driver.findElement(By.id("nav-cart")).isDisplayed());
//    }
//
//    // TC9
//    @Test
//    public void TC9_openCart() {
//        test = extent.createTest("TC9_openCart");
//
//        driver.findElement(By.id("nav-cart")).click();
//    }
//
//    // TC10
//    @Test
//    public void TC10_emptySearch() {
//        test = extent.createTest("TC10_emptySearch");
//
//        driver.findElement(By.id("nav-search-submit-button")).click();
//    }
//
//    // TC11
//    @Test
//    public void TC11_invalidSearch() {
//        test = extent.createTest("TC11_invalidSearch");
//
//        search("@@@###");
//    }
//
//    // TC12
//    @Test
//    public void TC12_searchLaptop() {
//        test = extent.createTest("TC12_searchLaptop");
//
//        search("Laptop");
//    }
//
//    // TC13
//    @Test
//    public void TC13_pageTitleNotNull() {
//        test = extent.createTest("TC13_pageTitleNotNull");
//
//        search("iPhone");
//
//        Assert.assertNotNull(driver.getTitle());
//    }
//
//    // TC14
//    @Test
//    public void TC14_resultCountCheck() {
//        test = extent.createTest("TC14_resultCountCheck");
//
//        search("iPhone");
//
//        List<WebElement> results =
//                driver.findElements(By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']"));
//
//        Assert.assertTrue(results.size() > 5);
//    }
//
//    // TC15
//    @Test
//    public void TC15_firstResultDisplayed() {
//        test = extent.createTest("TC15_firstResultDisplayed");
//
//        search("iPhone");
//
//        Assert.assertTrue(driver.findElements(By.cssSelector("h2 a")).get(0).isDisplayed());
//    }
//
//    // TC16
//    @Test
//    public void TC16_refreshPage() {
//        test = extent.createTest("TC16_refreshPage");
//
//        driver.navigate().refresh();
//    }
//
//    // TC17
//    @Test
//    public void TC17_backNavigation() {
//        test = extent.createTest("TC17_backNavigation");
//
//        search("iPhone");
//
//        driver.navigate().back();
//    }
//
//    // TC18
//    @Test
//    public void TC18_forwardNavigation() {
//        test = extent.createTest("TC18_forwardNavigation");
//
//        search("iPhone");
//
//        driver.navigate().back();
//        driver.navigate().forward();
//    }
//
//    // TC19
//    @Test
//    public void TC19_urlCheck() {
//        test = extent.createTest("TC19_urlCheck");
//
//        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
//    }
//
//    // TC20
//    @Test
//    public void TC20_pageLoadCheck() {
//        test = extent.createTest("TC20_pageLoadCheck");
//
//        Assert.assertTrue(driver.getTitle().length() > 0);
//    }
//}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class testcase extends BaseTest {

    HomePage home;

    // TC1
    @Test
    public void TC1_verifySearchBox() {

        home = new HomePage(driver);

        Assert.assertTrue(home.isSearchBoxDisplayed());
    }

    // TC2
    @Test
    public void TC2_searchProduct() {

        home = new HomePage(driver);

        home.search("iPhone");
    }


 // TC4
    @Test
    public void TC4_resultsCheck() {

        test = extent.createTest("TC4_resultsCheck");

        home = new HomePage(driver);

        home.search("iPhone");

        Assert.assertTrue(
        driver.getCurrentUrl().contains("s?k=iPhone"));
    }
 // TC5
    @Test
    public void TC5_refreshPage() {

        driver.navigate().refresh();

        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
    }
}