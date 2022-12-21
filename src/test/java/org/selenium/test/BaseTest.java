package org.selenium.test;

import org.openqa.selenium.WebDriver;
import org.selenium.practice.driverfactory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {

    Properties prop;
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);

    }

    public WebDriver getDriver() {
        return this.driver.get();
    }


    // @Parameters("browser")
    @BeforeMethod
    public void startMethod() {
        DriverManager driverManager = new DriverManager();
        prop = driverManager.init_properties(prop);

        setDriver(new DriverManager().intalizeDriver(prop.getProperty("browser")));
        //setDriver(new DriverManager().intalizeDriver(browser));
        System.out.println("The running Thread is ::" + Thread.currentThread().getId()
                + " the running driver is  " + getDriver());
    }


    @AfterMethod
    public void tearDown() {

        getDriver().quit();
        System.out.println("The running Thread is ::" + Thread.currentThread().getId()
                + " the running driver is  " + getDriver());
    }

}
