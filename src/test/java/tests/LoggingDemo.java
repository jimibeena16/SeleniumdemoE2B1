package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoggingDemo {

@Test
public void loginTest() {

Reporter.log("Browser Launched", true);

Reporter.log("Application Opened", true);

Reporter.log("User Logged In", true);

Reporter.log("Test Completed", true);
}
}
