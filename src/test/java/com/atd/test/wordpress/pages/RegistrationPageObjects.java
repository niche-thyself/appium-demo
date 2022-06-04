package com.atd.test.wordpress.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class RegistrationPageObjects {
    @AndroidFindBy(id = "org.wordpress.android:id/email_address") public WebElement emailAddress;
    @AndroidFindBy(id = "org.wordpress.android:id/username") public WebElement userName;
    @AndroidFindBy(id = "org.wordpress.android:id/password") public WebElement passWord;
    @AndroidFindBy(id = "org.wordpress.android:id/site_url") public WebElement siteUrl;
    @AndroidFindBy(id = "org.wordpress.android:id/signup_button") public WebElement createAccount;


}