package org.selenium.test;

import org.selenium.practice.objects.BillingAddress;
import org.selenium.practice.pages.CartPage;
import org.selenium.practice.pages.CheckOutPage;
import org.selenium.practice.pages.HomePage;
import org.selenium.practice.pages.StorePage;
import org.selenium.practice.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyFirstTest extends BaseTest {

    @Test
    public void guestCheckoutDirectBankTransfer() throws InterruptedException, IOException {
        HomePage homepage=new HomePage(getDriver()).load();

        StorePage storePage=homepage.setStoreLinkClick();
        storePage.search("blue");
        Assert.assertEquals(storePage.setSearchItemName(),"Search results: “blue”");

       storePage.itemAddToCart();
      CartPage cartPage= storePage.viewItemToCart();
       Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");



       CheckOutPage checkOutPage=cartPage.clickOnProceedToCheckOut();
        BillingAddress billingAddress= JacksonUtils.deserializeJson("BillingAddress.json",BillingAddress.class);

        checkOutPage.setBillingAddress1(billingAddress);
        checkOutPage.placingOrder();
        Assert.assertEquals(checkOutPage.setGetNotice(),"Thank you. Your order has been received.");



    }


}
