package com.themoviedb.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebPageHelper {
	
	private WebDriver driver;
	
	public WebPageHelper(WebDriver driver){
		this.driver = driver;
	}

	protected boolean waitForJStoLoad() {

	    WebDriverWait wait = new WebDriverWait(driver, 5000);

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        try {
	        	return ((Long)executeJavaScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	        	return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	    	  return executeJavaScript("return document.readyState")
	            .toString().equals("complete");
	      }
	    };

	  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
	
	protected String getBorderHexValue(By element) {
		String rgb[] = driver.findElement(element).getCssValue("color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))","").split(",");
		String hex = String.format("#%s%s%s", toBrowserHexValue(Integer.parseInt(rgb[0])), toBrowserHexValue(Integer.parseInt(rgb[1])), toBrowserHexValue(Integer.parseInt(rgb[2])));
		return hex;
	}
	
	protected void clickLink(By element) {
		WebElement link = driver.findElement(element);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",link);
	}

	private static String toBrowserHexValue(int number) {
	        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
	        while (builder.length() < 2) {
	            builder.append("0");
	        }
	        return builder.toString().toUpperCase();
	}
	
	private Object executeJavaScript(String string) {
        //Creating the JavascriptExecutor interface object by Type casting		
        JavascriptExecutor js = (JavascriptExecutor)driver;	
        return js.executeScript(string, 5000);
	}

}
