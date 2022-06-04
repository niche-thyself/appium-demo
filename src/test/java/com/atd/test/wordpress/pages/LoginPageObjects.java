package com.atd.test.wordpress.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
    @AndroidFindBy(id = "org.wordpress.android:id/nux_create_account_button") public WebElement createAccount;
}
