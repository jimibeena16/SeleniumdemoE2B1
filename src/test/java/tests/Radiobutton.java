package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radiobutton {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();

		 driver.get("https://demoqa.com/radio-button");
		 Thread.sleep(3000);
		 
		WebElement yesRadio = driver.findElement(By.xpath("//input[@id='yesRadio']"));
		yesRadio.click();
			
		System.out.println(yesRadio.isSelected());

	//WebElement radio = driver.findElement(By.id("yesRadio"));
	//radio.click();
		//System.out.println(radio.isSelected());
		
		driver.quit();

	}

}