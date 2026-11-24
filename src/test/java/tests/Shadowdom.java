package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.DriverFactory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class Shadowdom {

    public static void main(String[] args) {

    	//WebDriver driver = new ChromeDriver();
    	WebDriver driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		

        driver.get("https://practice.expandtesting.com/shadowdom");

        // Locate shadow host
        WebElement shadowHost = driver.findElement(By.id("shadow-host"));

        // Enter shadow root
        SearchContext shadowRoot =  shadowHost.getShadowRoot();

        // Locate paragraph inside shadow DOM
        WebElement message = shadowRoot.findElement(By.id("my-btn"));

        // Print text
        System.out.println(message.getText());

        driver.quit();
    }
}