package com.themoviedb.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeasonFragment extends BaseFragment {

		private final By seasonList = By.cssSelector(".season_list a[href*='tv']");
		private final By seasonHeader = By.cssSelector("#section_header h2 a");
		
		public SeasonFragment(WebDriver driver){
			super(driver);
		}
	    
	    public boolean selectSeason(String season){
	    	return clickOptionByText(seasonList, season);
	    }
	    
	    public boolean validateSeasonPage(String season){
	    	return isCorrectSeason(seasonHeader,season);
	    }
}
