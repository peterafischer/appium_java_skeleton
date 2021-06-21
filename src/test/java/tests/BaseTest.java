package tests;

import driver.DriverType;
import driver.MobileDriverFactory;
import driver.MobileDriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public AppiumDriver appiumDriver;
    public MobileDriverManager driverManager;

    @BeforeTest(alwaysRun = true)
    public void setup() {
        driverManager = MobileDriverFactory.getManager(DriverType.ANDROID);
        this.appiumDriver = driverManager.getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        driverManager.quitDriver();
    }
    }
