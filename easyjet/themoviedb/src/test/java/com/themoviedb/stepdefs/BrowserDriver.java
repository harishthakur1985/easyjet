package com.themoviedb.stepdefs;
import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class BrowserDriver{
    public static WebDriver driver;

    @Before
    public void openBrowser(){
    	 driver = new FirefoxDriver();
//    	 To run the test in Chrome browser uncomment the below lines and comment the above one
//    	 System.setProperty("webdriver.chrome.driver", "<YOUR_CHROME_PATH>/easyjet/chromedriver_win32/chromedriver.exe");
//    	 driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
    } 
    
    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
       
        if(scenario.isFailed()) {
        	try {
        		scenario.write("Current Page URL is " + driver.getCurrentUrl());
        		byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        		scenario.embed(screenshot, "image/png");
        	}
        	catch (WebDriverException somePlatformsDontSupportScreenshots) {
        		System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        	}
        }
        driver.quit(); 
    }
    
}