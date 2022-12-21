package org.selenium.test;

import org.selenium.practice.pages.CartPage;
import org.selenium.practice.pages.CheckOutPage;
import org.selenium.practice.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest{

@Test
public void addToCartFromStorePage()
{
    StorePage storePage=new StorePage(getDriver()).load();
    storePage.itemAddToCart();
    CartPage cartPage= storePage.viewItemToCart();
    Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");
    CheckOutPage checkOutPage=cartPage.clickOnProceedToCheckOut();
}


}
