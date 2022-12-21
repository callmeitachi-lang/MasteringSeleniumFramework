package org.selenium.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.practice.base.pom.BasePage;
import org.selenium.practice.objects.BillingAddress;

public class CheckOutPage extends BasePage {

    private By billingFirstName=By.cssSelector("#billing_first_name");
    private By billinglastName=By.cssSelector("#billing_last_name");
    private By billingAddress=By.cssSelector("#billing_address_1");
    private By billingCity=By.cssSelector("#billing_city");
    private By billingPostCode=By.cssSelector("#billing_postcode");
    private By billingPEmailId=By.cssSelector("#billing_email");
    private By PlacingOrder=By.cssSelector("#place_order");
    private By getNotice=By.cssSelector(".woocommerce-notice--success.woocommerce-thankyou-order-received");

    public CheckOutPage(WebDriver driver) {
   super(driver);
    }

    public CheckOutPage setBillingFirstName(String firstName)
    {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(billingFirstName)).clear();
        longWait.until(ExpectedConditions.visibilityOfElementLocated(billingFirstName)).sendKeys(firstName);

        return this;
    }
    public CheckOutPage setBillingLastName(String lastName)
    {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(billinglastName)).clear();
        longWait.until(ExpectedConditions.visibilityOfElementLocated(billinglastName)).sendKeys(lastName);
        return this;
    }
    public CheckOutPage setBillingAddress(String billingAddress)
    {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(this.billingAddress)).clear();
        longWait.until(ExpectedConditions.visibilityOfElementLocated(this.billingAddress)).sendKeys(billingAddress);
        return this;
    }
    public CheckOutPage setBillingCity(String billingCity)
    {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(this.billingCity)).clear();
        longWait.until(ExpectedConditions.visibilityOfElementLocated(this.billingCity)).sendKeys(billingCity);
        return this;
    }
    public CheckOutPage setBillingPostCode(String PostCode)
    {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(this.billingPostCode)).clear();
        longWait.until(ExpectedConditions.visibilityOfElementLocated(this.billingPostCode)).sendKeys(PostCode);
        return this;
    }
    public CheckOutPage setBillingPEmailId(String EmailId)
    {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(this.billingPEmailId)).clear();
        longWait.until(ExpectedConditions.visibilityOfElementLocated(this.billingPEmailId)).sendKeys(EmailId);
        return this;
    }

    public void setBillingAddress1(BillingAddress billingAddress)
    {
        setBillingFirstName(billingAddress.getFirstName())
                .setBillingLastName(billingAddress.getLastName())
                .setBillingAddress(billingAddress.getBillingAddress())
                .setBillingCity(billingAddress.getBillingCity())
                .setBillingPostCode(billingAddress.getBillingPostcode())
                .setBillingPEmailId(billingAddress.getBillingEmailID());
    }

    public void placingOrder()
    {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(this.PlacingOrder)).click();;
    }
    public String setGetNotice()
    {
        return longWait.until(ExpectedConditions.visibilityOfElementLocated(this.getNotice)).getText();
    }

}
