package com.themoviedb.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseFragment { 

		private final By searchBox = By.id("search_v4");
		private final By viewMore = By.cssSelector(".view_more a[href*='tv']");
		
		public HomePage(WebDriver driver){
			super(driver);
		}
		
		public void checkTitle(){
			checkTitle("The Movie Database (TMDb)");
		}
	    
	    public void searchMovie(String seriesName){
	    	setText(searchBox, seriesName);
	    	setKey(searchBox, Keys.RETURN);
	    }
	    
	    public void selectMovie(){
	    	clickElement(viewMore);
	    }

}
