package tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownloadDemo {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/upload-download");

        // Click Download Button
        driver.findElement(By.id("downloadButton")).click();

        // Wait for download
        Thread.sleep(5000);

        // File location
        File file = new File(System.getProperty("user.home")+ "\\Downloads\\sampleFile.jpeg");

        if(file.exists()) {

            System.out.println("File downloaded successfully");

            System.out.println("File Name : " + file.getName());
            System.out.println("File Path : " + file.getAbsolutePath());
            System.out.println("File Size : " + file.length() + " bytes");

        } else {

            System.out.println("File download failed");
        }

        driver.quit();
    }
}

