package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

    public static void main(String[] args) {

      // WebDriver driver = DriverFactory.getDriver();
    	WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/frames");

        // Switch to the first frame using frame ID
        driver.switchTo().frame("frame1");

        // Get text present inside the frame
        String text = driver.findElement(By.id("sampleHeading")).getText();

        System.out.println("Text inside frame: " + text);

        // Come out of the frame and return to main page
        driver.switchTo().defaultContent();

        driver.quit();
    }
}
