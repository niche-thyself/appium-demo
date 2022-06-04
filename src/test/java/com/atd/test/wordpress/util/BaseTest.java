package com.atd.test.wordpress.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options()
                .setDeviceName("Android Emulator")
                .setAutomationName("UIAutomator2")
                .setApp("/Users/saikrisv/Documents/git/VodQaAdvancedAppium/apps/wordpress.apk")
                .setAppActivity("org.wordpress.android.ui.WPLaunchActivity")
                .setAppPackage("org.wordpress.android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), uiAutomator2Options);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
