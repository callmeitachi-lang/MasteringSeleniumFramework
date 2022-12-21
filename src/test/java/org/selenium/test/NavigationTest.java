package org.selenium.test;

import org.selenium.practice.pages.HomePage;
import org.selenium.practice.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest{

@Test
public void navigateFromToStoreUsingMainMenu()

{
    HomePage homepage=new HomePage(getDriver()).load();

    StorePage storePage=homepage.setStoreLinkClick();
    Assert.assertEquals(storePage.setSearchItemName(),"Store");
}


}
