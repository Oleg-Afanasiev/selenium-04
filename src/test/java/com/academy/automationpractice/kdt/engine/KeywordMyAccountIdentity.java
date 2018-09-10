package com.academy.automationpractice.kdt.engine;

import com.academy.automationpractice.ddt.framework.page.AccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KeywordMyAccountIdentity {
    private WebDriver driver;

    public KeywordMyAccountIdentity(WebDriver driver) {
        this.driver = driver;
    }

    public void doAction(String action, String object, String value) {
        switch (action) {
            case "ASSERT":
                doAssert(object, value);
                break;

            case "CLICK":
                click(object, value);
                break;
        }
    }

    private void doAssert(String object, String value) {
        switch (object) {
            case "usernameLinkText":
                Assert.assertEquals(
                        new AccountPage(driver).getUserNameCapture(), value);
                break;
        }
    }

    private void click(String object, String value) {
        switch (object) {
            case "signOutButton":
                new AccountPage(driver).clickLogout();
                break;
        }
    }
}