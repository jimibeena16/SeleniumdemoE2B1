package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentDemo {

    @Test
    public void reportDemo() {

        // Create Reporter
       ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/ExtentReport.html");


        // Create ExtentReports Object
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);

        // Create Test in Report
        ExtentTest test = extent.createTest("Google Test");

        try {

            String actual = "Google";
            String expected = "Google";

            Assert.assertEquals(actual, expected);

            test.pass("Title Verification Passed");

        } catch (Exception e) {

            test.fail("Test Failed");
        }

        // Write report
        extent.flush();
    }
}