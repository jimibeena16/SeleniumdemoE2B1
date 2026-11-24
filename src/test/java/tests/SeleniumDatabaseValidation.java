package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDatabaseValidation {

    public static void main(String[] args) {

    //    WebDriver driver = null;
        Connection con = null;

        try {

            //--------------------------
            // Launch Browser
            //--------------------------

          //  WebDriverManager.chromedriver().setup();
        	WebDriver driver = new ChromeDriver();
          
            driver.manage().window().maximize();

            //--------------------------
            // Open Application
            //--------------------------

            driver.get("https://example.com/register");

            String username = "Jimi";
            String email = "jimi@test.com";

            //--------------------------
            // Enter User Details
            //--------------------------

            driver.findElement(By.id("username"))
                  .sendKeys(username);

            driver.findElement(By.id("email"))
                  .sendKeys(email);

            //--------------------------
            // Click Submit
            //--------------------------

            driver.findElement(By.id("submitBtn"))
                  .click();

            //--------------------------
            // Wait for DB update
            //--------------------------

            Thread.sleep(3000);

            //--------------------------
            // DB Connection
            //--------------------------

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "password");

            //--------------------------
            // Execute Query
            //--------------------------

            Statement stmt = con.createStatement();

            String query =
                    "SELECT username,email " +
                    "FROM users " +
                    "WHERE username='Jimi'";

            ResultSet rs = stmt.executeQuery(query);

            //--------------------------
            // Validate Data
            //--------------------------

            if(rs.next()) {

                String dbUsername =
                        rs.getString("username");

                String dbEmail =
                        rs.getString("email");

                if(username.equals(dbUsername)
                        && email.equals(dbEmail)) {

                    System.out.println(
                            "PASS : UI data matches DB data");
                }
                else {

                    System.out.println(
                            "FAIL : Data mismatch");
                }
            }
            else {

                System.out.println(
                        "FAIL : Record not found in database");
            }

        }
        catch(Exception e) {

            e.printStackTrace();
        }
        finally {

            try {

                if(con != null) {
                    con.close();
                }

               // if(driver != null) {
                //    driver.quit();
               // }

            } catch(Exception e) {

                e.printStackTrace();
            }
        }
        
    }
}
