package com.atd.test.wordpress.test;

import com.atd.test.wordpress.pages.LoginPage;
import com.atd.test.wordpress.util.BaseTest;
import org.testng.annotations.Test;

public class CreateUser extends BaseTest {
    @Test
    public void createUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.createAccount().createUser();
    }
}
