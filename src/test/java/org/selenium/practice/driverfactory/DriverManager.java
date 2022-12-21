package org.selenium.practice.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverManager {
    private WebDriver driver;
    Properties prop;
    public WebDriver intalizeDriver(String browser)
    {
        //To run in mvn cmd
        //browser=System.getProperty("BROWSER");
       // WebDriverManager.chromeDriver().setup();
        System.out.println("The Browser value is :"+browser);

        if (browser.equalsIgnoreCase("chrome")) {
             driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else {
            System.out.println("Check the browser value"+browser);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public Properties init_properties(Properties prop)
    {
       prop=new Properties();

        FileInputStream io= null;
        try {
            io = new FileInputStream("./src/main/resources/Config.properties");
            prop.load(io);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
         catch (IOException e) {
            throw new RuntimeException(e);
        }
       return prop;
    }

}
