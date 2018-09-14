package com.academy.automationpractice.ddt.framework.helper;

import com.academy.automationpractice.ddt.framework.page.AccountPage;
import org.openqa.selenium.WebDriver;

import static com.academy.util.MatcherAssertExt.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class VerifyHelper {
    private WebDriver driver;

    public VerifyHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void userIsLoggedIn(String userNameExpected) {
        String userNameActual = new AccountPage(driver).getUserNameCapture();
        assertThat(userNameActual, equalTo(userNameExpected));
    }
}
