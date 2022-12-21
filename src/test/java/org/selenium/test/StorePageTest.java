package org.selenium.test;

import org.selenium.practice.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StorePageTest extends BaseTest{
@Test
    public void searchProductMatched()
    {
        StorePage storePage=new StorePage(getDriver()).load();
        storePage.search("blue");
        Assert.assertEquals(storePage.setSearchItemName(),"Search results: “blue”");


    }
}
