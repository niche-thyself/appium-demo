package com.atd.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AppiumDriver driver;
    DesiredCapabilities caps;
    public WebDriverWait wait;

    @BeforeClass public void setUp() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
        caps.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir") + "/VodQA.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @AfterClass public void tearDown() {
        driver.quit();
    }

    public void waitForElement(AppiumDriver driver, WebElement id){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions
                .elementToBeClickable(id));
    }
}
