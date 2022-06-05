package com.atd.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class SampleTest {
    public AppiumDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options()
                .setDeviceName("Android Emulator")
                .setAutomationName("UIAutomator2")
                .setApp(System.getProperty("user.dir") + "/VodQA.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), uiAutomator2Options);
    }

    @Test
    public void SampleTest() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ((AndroidDriver)driver).setLocation(new Location(27.1767, 78.0081, 400));
        Location location = ((AndroidDriver)driver).location();
        System.out.println(location);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
