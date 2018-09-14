package com.academy.automationpractice.bdd.stepdefs;

import com.academy.automationpractice.ddt.framework.TestManager;
import com.academy.automationpractice.ddt.framework.page.AccountPage;
import com.academy.automationpractice.ddt.framework.page.HomePage;
import com.academy.automationpractice.ddt.framework.page.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class StepDefinitions {

    private TestManager manager;

    @Before
    public void setUp() throws IOException {
        manager = new TestManager();
        manager.init("chrome");
    }

    @Given("^I am on home page$")
    public void goToHomePage() {
        manager.goTo().home();
    }

    @Then("^I click on signIn link$")
    public void clickSignInLink() {
        new HomePage(manager.getDriver())
                .clickSignIn();
    }

    @When("^I fill login '(.*?)'$")
    public void fillLogin(String login) {
        // Write code here that turns the phrase above into concrete actions
        new LoginPage(manager.getDriver())
                .inputEmail(login);
    }

    @And("^I fill password '(.*?)'$")
    public void fillPassword(String password) {
        new LoginPage(manager.getDriver())
                .inputPassword(password);
    }

    @And("^click signIn button$")
    public void i_click_on_the_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        new LoginPage(manager.getDriver())
                .clickSignIn(true);
    }

    @Then("^I should see '(.*?)' link$")
    public void i_should_see_the_button(String userName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(
                new AccountPage(manager.getDriver()).getUserNameCapture(),
                userName);
    }

    @Then("^I should make logout$")
    public void i_should_see_the_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        new AccountPage(manager.getDriver())
                .clickLogout();
    }

    @Given("^Я нахожусь на домашней странице$")
    public void goToHomePage2() {
        System.out.println("***Я нахожусь на домашней странице***");
        manager.goTo().home();
    }

    @Then("^Я нажимаю ссылку signIn$")
    public void clickSignInLink2() {
        new HomePage(manager.getDriver())
                .clickSignIn();
    }

    @When("^Ввожу логин '(.*?)'$")
    public void fillLogin2(String login) {
        // Write code here that turns the phrase above into concrete actions
        new LoginPage(manager.getDriver())
                .inputEmail(login);
    }

    @And("^Ввожу пароль '(.*?)'$")
    public void fillPassword2(String password) {
        new LoginPage(manager.getDriver())
                .inputPassword(password);
    }

    @And("^нажимаю отправить$")
    public void i_click_on_the_button2() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        new LoginPage(manager.getDriver())
                .clickSignIn(false);
    }

    @Then("^должен увидеть сообщение об ошибке '(.*?)'$")
    public void i_should_see_the_button2(String msg) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(
                new LoginPage(manager.getDriver()).getErrorMessage(),
                msg);
    }

    @After
    public void tearDown(){
        manager.stop();
    }
}
