package org.selenium.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.practice.base.pom.BasePage;

public class CartPage  extends BasePage {

    private final By productName=By.xpath("//a[normalize-space()='Blue Shoes']");
    private final By proceedToCheckout=By.cssSelector(".checkout-button.button.alt.wc-forward");

    public CartPage(WebDriver driver) {
    super(driver);
    }

    public String getProductName()
    {
        return driver.findElement(productName).getText();
    }

    public CheckOutPage clickOnProceedToCheckOut()
    {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckout)).click();
        return new CheckOutPage(driver);
    }



}
