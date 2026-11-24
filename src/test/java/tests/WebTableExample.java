package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.w3schools.com/html/html_tables.asp");

        // Table locator
        WebElement table = driver.findElement(By.id("customers"));

        // =========================
        // Row Count
        // =========================

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        System.out.println("Total Rows = " + rows.size());

        // =========================
        // Column Count
        // =========================

        List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));

        System.out.println("Total Columns = " + columns.size());

        // =========================
        // Specific Cell
        // Row 2 Column 1
        // =========================

        String value = driver.findElement(
                By.xpath("//table[@id='customers']/tbody/tr[2]/td[1]"))
                .getText();

        System.out.println("Row 2 Col 1 = " + value);

        // =========================
        // Print Entire Table
        // =========================

        System.out.println("\n=== TABLE DATA ===");

        for (int i = 1; i < rows.size(); i++) {

            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t");
            }

            System.out.println();
        }

        driver.quit();
    }
}
