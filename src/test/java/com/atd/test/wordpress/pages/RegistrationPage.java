package com.atd.test.wordpress.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;


public class RegistrationPage {
    private final AppiumDriver driver;
    RegistrationPageObjects registrationPageObjects;

    public RegistrationPage(AppiumDriver driver) {
        this.driver = driver;
        registrationPageObjects = new RegistrationPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver), registrationPageObjects);
    }

    public void createUser() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        registrationPageObjects.emailAddress.sendKeys("username" + randomInt + "@gmail.com");
        registrationPageObjects.userName.sendKeys("username" + randomInt);
        registrationPageObjects.passWord.sendKeys("username" + randomInt);
        registrationPageObjects.siteUrl.sendKeys("username" + randomInt);
        registrationPageObjects.createAccount.click();
        //org.wordpress.android:id/my_site_title_label -> Assert on this
    }
}
