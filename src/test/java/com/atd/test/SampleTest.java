package com.atd.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class SampleTest {
    private AppiumDriverLocalService service;
    public AppiumDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        service = new AppiumServiceBuilder().withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                .usingAnyFreePort().build();
        service.start();

        if (service == null || !service.isRunning()) {
            throw new RuntimeException("An appium server node is not started!");
        }

        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options()
                .setDeviceName("Android Emulator")
                .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                .setApp(System.getProperty("user.dir") + "/VodQA.apk");

        driver = new AndroidDriver(service.getUrl(), uiAutomator2Options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void login() {
        wait.until(ExpectedConditions.
                elementToBeClickable(AppiumBy.accessibilityId("login"))).click();
    }

    @Test
    public void horizontalSwipingTest() {
        login();
        wait.until(presenceOfElementLocated(AppiumBy.accessibilityId("slider1")));
        driver.findElement(AppiumBy.accessibilityId("slider1")).click();
        wait.until(presenceOfElementLocated(AppiumBy.accessibilityId("slider")));
        WebElement slider = driver.findElement(AppiumBy.accessibilityId("slider"));

        Point source = slider.getLocation();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(), source.x + 400, source.y));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(singletonList(sequence));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }


}
