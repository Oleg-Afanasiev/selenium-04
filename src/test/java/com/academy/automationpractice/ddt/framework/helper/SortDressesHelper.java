package com.academy.automationpractice.ddt.framework.helper;

import com.academy.automationpractice.ddt.framework.page.HomePage;
import com.academy.automationpractice.ddt.framework.page.WomenPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SortDressesHelper {
    private WebDriver driver;

    public SortDressesHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void sortProductBy(String sortBy) {
        new HomePage( driver ).clickWomenPageLink().clickToList().sortProductBy( sortBy );

    }

    public void verifySort(String sortBy) {
        WomenPage womenPage = new HomePage( driver ).clickWomenPageLink().clickToList().sortProductBy( sortBy );
        List<String> actualPrises =
                womenPage
                        .listProduct();
        List<String> expectedPrices = new ArrayList<>(actualPrises);
        expectedPrices.sort(String::compareTo);
        Assert.assertEquals(actualPrises, expectedPrices);
    }
}
