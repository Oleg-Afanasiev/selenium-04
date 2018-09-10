package com.academy.automationpractice.ddt.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortDressesPage extends BasePage {
    @FindBy(linkText = "Women")
    private WebElement lincWomen;
    @FindBy(linkText = "selectProductSortBy")
    private WebElement lincselectProductSortBy;

    public SortDressesPage(WebDriver driver) {
        super( driver );

    }


    public SortDressesPage clicktoWomen() {
        clicktoWomen();
        return this;
    }

    public SortDressesPage clicktoselectProductSortBy() {
        clicktoselectProductSortBy();
        return this;
    }
}