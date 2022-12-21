package org.selenium.practice.base.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected Wait<WebDriver> shortWait;
    protected Wait<WebDriver> longWait;
    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        shortWait=new WebDriverWait(driver, Duration.ofSeconds(5));
        longWait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void load(String endPoint)
    {
        driver.get("https://askomdch.com"+endPoint);
    }


}
