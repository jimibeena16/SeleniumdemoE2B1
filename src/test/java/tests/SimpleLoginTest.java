package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleLoginTest {

@Test
public void googleTitleTest() {

String actual = "Google";
String expected = "Google";

Assert.assertEquals(actual, expected);
}
}
