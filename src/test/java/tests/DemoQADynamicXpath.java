package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQADynamicXpath {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        // 1. Basic XPath
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Jimi");

        // 2. Multiple Attributes
        WebElement fullName = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Full Name']"));

        System.out.println("Multiple Attributes: " + fullName.getAttribute("id"));

        // 3. Contains
        WebElement contains = driver.findElement(By.xpath("//input[contains(@id,'user')]"));

        System.out.println("Contains XPath: "+ contains.getAttribute("id"));

        // 4. Starts-With
        WebElement startsWith = driver.findElement(By.xpath("//input[starts-with(@id,'user')]"));

        System.out.println("Starts-With XPath: " + startsWith.getAttribute("id"));

        // 5. Parent
        WebElement parent = driver.findElement(By.xpath("//label[text()='Full Name']/parent::div"));

        System.out.println("Parent Tag: "+ parent.getTagName());

        // 6. Following
        WebElement following = driver.findElement(By.xpath("//label[text()='Full Name']/following::input[1]"));

        following.clear();
        following.sendKeys("Following XPath");

        // 7. Ancestor
        WebElement ancestor = driver.findElement(By.xpath("//input[@id='userName']/ancestor::div[1]"));

        System.out.println("Ancestor Tag: " + ancestor.getTagName());

        // 8. Index
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("jimi@test.com");

        Thread.sleep(2000);

        driver.get("https://demoqa.com/buttons");

        // 9. Text()
        WebElement clickMe = driver.findElement(By.xpath("//button[text()='Click Me']"));

        System.out.println("Text XPath: " + clickMe.getText());

        // 10. Contains Text()
        driver.findElement(By.xpath("//button[contains(text(),'Click')]")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}