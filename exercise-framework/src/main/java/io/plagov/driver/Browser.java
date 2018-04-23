package io.plagov.driver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    protected static WebDriver driver;

    @BeforeClass
    public static void driverSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void cleanCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}

