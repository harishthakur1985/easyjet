package com.themoviedb.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EpisodeFragment extends BaseFragment {

	private final By fullCastLink = By.cssSelector("a[href*='/cast']");
	private final By showMore = By.cssSelector("p.show_more a");
	private final By cast = By.cssSelector("ol.people.credits");
	private final By episode2 = By.cssSelector("a[episode='2']");
	private final By episodeCount = By.cssSelector("h3.episode_sort.space span:first-child:not(.glyphicons)");
		
	public EpisodeFragment(WebDriver driver){
		super(driver);
	}
 
	public boolean clickFullCastCrew(String episode){
		return clickOptionByHref(fullCastLink, episode);
	}
	
	public void clickShowMore(){
		clickElement(showMore);
	}
	
	public boolean checkActorPresentInRegular(String actor){
		return verifyActorPresent(cast,actor,"regular");
	}
	
	public boolean checkActorPresentInGuest(String actor){
		return verifyActorPresent(cast,actor,"guest");
	}
	
	public void selectEpisode() {
		clickElement(episode2);
	}
	
	public String getActualEpisodes() {
		return getText(episodeCount);
	}
}
