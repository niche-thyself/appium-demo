package com.atd.test.wordpress.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    AppiumDriver driver;
    LoginPageObjects  loginPageObjects;
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        loginPageObjects = new LoginPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver),loginPageObjects);
    }

    public RegistrationPage createAccount() {
        ((AndroidDriver) driver).hideKeyboard();
        loginPageObjects.createAccount.click();
        return new RegistrationPage(driver);
    }
}
