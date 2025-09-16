package com;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AirplaneTest {
     public AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException{
        String appiumServerUrl = "http://127.0.0.1:4723";

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiautomator2");
        dc.setCapability("appium:appPackage", "com.android.settings");
        dc.setCapability("appium:appActivity", ".Settings");

        driver = new AndroidDriver(new URL(appiumServerUrl), dc);
    }

    @Test
    // public void shouldAnswerWithTrue()
    public void test()
    {
      driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Network & internet\")")).click();
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.settings:id/switchWidget")));
      String AirplaneMode = element.getAttribute("checked");
      if (AirplaneMode.equals("false")) {
        element.click();
      } else {
        System.out.println("Airplane mode is already turned ON");
      }
      Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Airplane mode is on\")"))).isDisplayed());
    }  


    @Test
    // public void shouldAnswerWithTrue()
    public void test2()
    {
      driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Network & internet\")")).click();
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.settings:id/switchWidget")));
      String AirplaneMode = element.getAttribute("checked");
      if (AirplaneMode.equals("true")) {
        element.click();
      } else {
        System.out.println("Airplane mode is already turned OFF");
      }
    //   Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Airplane mode is on\")"))).isDisplayed());
    }  

    @AfterTest
    public void close(){
        if (driver != null) {
            driver.quit();
        }
    }
}


// mvn "-Dtest=AirplaneTest" test
//  mvn clean test "-DsuiteXmlFile=testng.xml"
// mvn "-Dtest=AirplaneTest#methodName" test