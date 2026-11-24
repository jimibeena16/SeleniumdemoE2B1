package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/upload-download");

        // Locate File Upload element
        WebElement upload = driver.findElement(By.id("uploadFile"));

        // Upload file
       // upload.sendKeys("C:\\Users\\Student\\Downloads\\test.txt");
        String filepath = System.getProperty("user.dir")+ "\\test-data\\sample.txt";
        upload.sendKeys(filepath);

        // Verify uploaded file path
        String uploadedFile = driver.findElement(By.id("uploadedFilePath")).getText();

        System.out.println("Uploaded File Path: " + uploadedFile);

        // Validation
        if(uploadedFile.contains("sample.txt")) {
            System.out.println("File uploaded successfully");
        } else {
            System.out.println("File upload failed");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
