package driver;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager extends MobileDriverManager {

    @Override
    protected void createDriver() {
        System.out.println("Initializing Android Driver");
        URL url;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AppiumDriver(url, getAndroidCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4_API_30");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        return capabilities;
    }
}
