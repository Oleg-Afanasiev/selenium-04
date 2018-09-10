package com.academy.automationpractice.ddt.framework;

import com.academy.automationpractice.ddt.framework.helper.*;
import com.academy.util.PropertyManager;
import com.google.common.io.Files;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class TestManager {
    protected static final Logger LOG = LogManager.getLogger(TestManager.class);
    protected static final Logger LOG_BROWSER = LogManager.getLogger("BROWSER");

    private static int DEFAULT_WAIT = 30;
    protected WebDriver driver;

    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private AccountHelper accountHelper;
    private VerifyHelper verifyHelper;
    private AddressHelper addressHelper;

    public void init(String browser) throws IOException {

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", PropertyManager.getProperty("chrome.driver"));
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", PropertyManager.getProperty("firefox.driver"));
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        //        driver.manage().window().maximize();
        navigationHelper = new NavigationHelper(driver, PropertyManager.getProperty("automation.baseurl"));
        sessionHelper = new SessionHelper(driver, PropertyManager.getProperty("automation.username"), PropertyManager.getProperty("automation.password"));
        accountHelper = new AccountHelper(driver);
        addressHelper = new AddressHelper(driver);
        verifyHelper = new VerifyHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper session() {
        return sessionHelper;
    }

    public AccountHelper account() {
        return accountHelper;
    }

    public VerifyHelper verify() {
        return verifyHelper;
    }

    public AddressHelper address() {
        return addressHelper;
    }
}
