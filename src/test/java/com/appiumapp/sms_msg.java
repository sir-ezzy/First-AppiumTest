package com.appiumapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class sms_msg {
     private AndroidDriver driver;
     private static String APPIUM_ServerUrl =  "http://127.0.0.1:4723";
     private static String PHONE_NUMBER = "555-123-4567";
     private static String MESSAGE_TEXT = "Hello, this is a test message!"; 

    @BeforeTest
    public void setup() throws MalformedURLException{
        // String appiumServerUrl = "http://127.0.0.1:4723";

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiautomator2");
        dc.setCapability("appium:appPackage", "com.google.android.apps.messaging");
        dc.setCapability("appium:appActivity", ".ui.ConversationListActivity");

        driver = new AndroidDriver(new URL(APPIUM_ServerUrl), dc);
    }

    @Test
    // public void shouldAnswerWithTrue()
    public void sendMessage()
    {
      driver.sendSMS(PHONE_NUMBER, MESSAGE_TEXT);
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }  

    @AfterTest
    public void close(){
        if (driver != null) {
            driver.quit();
        }
    }
}
