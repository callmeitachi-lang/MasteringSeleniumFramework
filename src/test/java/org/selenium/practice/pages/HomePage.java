package org.selenium.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.practice.base.pom.BasePage;

public class HomePage extends BasePage {

    private By storeLinkClick= By.cssSelector("#menu-item-1227 > a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

public HomePage load()
{
 driver.get("https://askomdch.com");
 return this;
}
    public StorePage setStoreLinkClick()
    {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(storeLinkClick)).click();
        return new StorePage(driver);
    }


}
