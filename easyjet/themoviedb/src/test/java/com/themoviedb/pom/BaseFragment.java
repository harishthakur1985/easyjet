package com.themoviedb.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseFragment extends WebPageHelper{
	
	protected static final int WAIT_TIME_OUT = 20;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BaseFragment(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	protected void checkTitle(String title){
		waitForJStoLoad();
    	wait = new WebDriverWait(driver, WAIT_TIME_OUT);
    	wait.until(ExpectedConditions.titleContains(title));
	}
	
	protected void clickElement(By elementBy) {
		wait = new WebDriverWait(driver, WAIT_TIME_OUT);
		wait.until(ExpectedConditions.elementToBeClickable(elementBy));
		WebElement element = driver.findElement(elementBy);
		try{
			new Actions(driver).moveToElement(element).perform();
			element.click();
		}
		catch (Exception e){
			clickLink(elementBy);
		}
	}

	protected void setText(By elementBy, String postCode) {
		wait = new WebDriverWait(driver, WAIT_TIME_OUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
		driver.findElement(elementBy).sendKeys(postCode);
	}
	
	protected void setKey(By elementBy, Keys key) {
		wait = new WebDriverWait(driver, WAIT_TIME_OUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
		driver.findElement(elementBy).sendKeys(key);
	}
    
	protected String getText(By elementBy) {
		wait = new WebDriverWait(driver, WAIT_TIME_OUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
		return driver.findElement(elementBy).getText();
	}
	
	protected boolean clickOptionByText(By elementBy, String option){
		boolean clicked = false;
		waitForJStoLoad();
		List<WebElement> elements = driver.findElements(elementBy);

		for(WebElement element: elements){
			if (element.getText().equals(option)){
				element.sendKeys(Keys.ENTER);
				clicked = true;
				return clicked;
			}
		}
		return clicked;		
	}
	
	protected boolean clickOptionByHref(By elementBy, String option){
		boolean clicked = false;
		waitForJStoLoad();
		List<WebElement> elements = driver.findElements(elementBy);

		for(WebElement element: elements){
			if (element.getAttribute("href").contains(option+"/")){
				element.sendKeys(Keys.ENTER);
				clicked = true;
				return clicked;
			}
		}
		return clicked;		
	}	

	protected boolean verifyActorPresent(By castElement, String actor, String castType) {
		boolean found = false;
		List<WebElement> elements = driver.findElements(castElement);
		if (castType.equals("regular")){
			return findActor(actor, elements.get(0));
		} else if(castType.equals("guest")){
			return findActor(actor, elements.get(1));
		}
		return found;
	}
	
	protected boolean isCorrectSeason(By seasonHeader, String season) {
		return getText(seasonHeader).toUpperCase().contains(season);
	}
	
	private boolean findActor(String actor, WebElement element) {
		boolean found = false;
		List<WebElement>actors =element.findElements(By.cssSelector("p a"));
		for(WebElement actualActor: actors){
			if (actor.equals(actualActor.getText())){
				found = true;
				return found;
			}
		}
		return found;
	}
}
