package org.selenium.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.practice.base.pom.BasePage;

public class StorePage extends BasePage {

    private final By searchFld=By.cssSelector("#woocommerce-product-search-field-0");
    private final By searchBtn=By.cssSelector("button[value='Search']");
    private final By searchItemName=By.cssSelector(".woocommerce-products-header__title");
    private final By addToCart=By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    private final By viewCart=By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }
    public StorePage searchItemFld(String txt)
    {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(txt);
       return this;
    }
    public StorePage searchBtnClick()
    {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn)).click();;
        return this;
    }

    public StorePage load()
    {
        load("/store");
      return this;
    }


    public void search(String txt)
    {

        searchItemFld(txt)
                .searchBtnClick();
    }

    public String setSearchItemName()
    {
        return  longWait.until(ExpectedConditions.visibilityOf(driver.findElement(searchItemName))).getText();

    }

    public void itemAddToCart()
    {
        longWait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();

    }
    public CartPage viewItemToCart()
    {
        longWait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
        return new CartPage(driver);
    }


}
