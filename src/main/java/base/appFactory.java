package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.configFileReader;

import java.net.MalformedURLException;
import java.net.URL;

public class appFactory {
    public static AppiumDriver driver;
    public static utilities.configFileReader configFileReader;

    @Test
    public static void initializer() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        configFileReader = new configFileReader();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, configFileReader.getautomationName());
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, configFileReader.getplatformName());
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, configFileReader.getplatformVersion());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, configFileReader.getdeviceName());
        cap.setCapability("newCommandTimeout", 100000);
        cap.setCapability(MobileCapabilityType.APP, configFileReader.getappPath());
        //cap.setCapability("appPackage", configFileReader.getappPackage());
        //cap.setCapability("appActivity", configFileReader.getappActivity());
        driver = new AndroidDriver(new URL(configFileReader.getappiumServerURL()),cap);
        appDriver.setDriver(driver);

    }


    public static void quitDriver() {
        if (null != driver) {
            driver.quit();
        }
    }
}

