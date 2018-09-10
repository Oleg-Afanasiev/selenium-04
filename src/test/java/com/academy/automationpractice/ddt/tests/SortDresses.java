package com.academy.automationpractice.ddt.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortDresses extends BaseTest {
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test(dataProvider = "sortBy")
    public void sortPriceToLowerFirstTest(String sortBy) throws Exception{
        manager.goTo().home();
        manager.goTo().womenPage();
        manager.dress().sortProductBy(sortBy);
        manager.dress().verifySort(sortBy);

    }

    @DataProvider(name="sortBy")
    private Object[]sortBy(){
        return new Object[]
                { "Product Name: A to Z"};
    }



}