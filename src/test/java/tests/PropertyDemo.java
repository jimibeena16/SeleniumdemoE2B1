package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.PropertyReader;

public class PropertyDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(PropertyReader.get("url"));
    }

    @Test
    public void loginAndVerifyProduct() {

        // Login
        driver.findElement(By.id("user-name"))
              .sendKeys(PropertyReader.get("username"));

        driver.findElement(By.id("password"))
              .sendKeys(PropertyReader.get("password"));

        driver.findElement(By.id("login-button")).click();

        // Read product from properties file
        String productName = PropertyReader.get("product");

        // Verify product exists
        String actualProduct = driver.findElement(
                By.xpath("//div[text()='" + productName + "']"))
                .getText();

        Assert.assertEquals(actualProduct, productName);

        System.out.println("Product Verified: " + actualProduct);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}