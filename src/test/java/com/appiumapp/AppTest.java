package com.appiumapp;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
// import org.testng.annotations.Test;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    
    public AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException{
        String appiumServerUrl = "http://127.0.0.1:4723";

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiautomator2");
        dc.setCapability("appium:app", System.getProperty("user.dir") + "/apps/globills.apk");

        // dc.setCapability("platformName", "Android");

        driver = new AndroidDriver(new URL(appiumServerUrl), dc);
    }

    @Test
    // public void shouldAnswerWithTrue()
    public void test()
    {
        // assertTrue( true );
        driver.findElement(AppiumBy.accessibilityId("\t\r\n" + //
                        "Choose your country")).click();
    }


    @AfterTest
    public void close(){
        if (driver != null) {
            driver.quit();
        }
    }
}
