package driver;

import io.appium.java_client.AppiumDriver;

public abstract class MobileDriverManager {

    protected AppiumDriver appiumDriver;

    protected abstract void createDriver();

    public void quitDriver() {
        if (null != appiumDriver) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }

    public AppiumDriver getDriver() {
        if (null == appiumDriver) {
            createDriver();
        }
        return appiumDriver;
    }
}
