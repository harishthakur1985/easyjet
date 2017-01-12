package com.themoviedb.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.themoviedb.pom.EpisodeFragment;
import com.themoviedb.pom.HomePage;
import com.themoviedb.pom.SeasonFragment;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TheMovieDBStepDefs {

    private static final String THE_MOVIE_DB_URL = "https://www.themoviedb.org";
	private WebDriver driver;
    private HomePage homePage;
	private SeasonFragment seasonFragment;
	private EpisodeFragment episodeFragment;
    
    public TheMovieDBStepDefs(){
    	this.driver = BrowserDriver.driver;
    	homePage = PageFactory.initElements(driver, HomePage.class);
    	seasonFragment = PageFactory.initElements(driver, SeasonFragment.class);
    	episodeFragment = PageFactory.initElements(driver, EpisodeFragment.class);
    }
      
	@Given("^I navigate to the movie DB$")
	public void i_navigate_to_compare_the_market(){
		driver.get(THE_MOVIE_DB_URL);
	}
	
	@Given("^I am on the home page$")
	public void i_am_on_the_home_page(){
		homePage.checkTitle();
	}
	
	@Given("^I search for \"([^\"]*)\" TV show$")
	public void i_search_for_TV_show(String seriesName){
		homePage.searchMovie(seriesName);
	}

	@Given("^I click on \"([^\"]*)\"$")
	public void i_click_on_Game_of_thrones(String seriesName){
		homePage.selectMovie();
	}

	@Given("^I click on the season (\\d+)$")
	public void i_click_on_the_season(int season){
		assertTrue("season is not selected",seasonFragment.selectSeason(String.valueOf(season)));
	}
	
	@When("^I am on season (\\d+) page$")
	public void i_am_on_season_page(int season){
	    assertTrue("This is not season "+season+" page",seasonFragment.validateSeasonPage(("SEASON "+season).toUpperCase()));
	}

	@When("^I click on full cast and crew for episode (\\d+)$")
	public void i_click_on_full_cast_and_crew_for_episode(int episode){
		assertTrue("season is not selected",episodeFragment.clickFullCastCrew(String.valueOf(episode)));
	}

	@Then("^the actor \"([^\"]*)\" is (present|not present) in season regular$")
	public void the_actor_is_not_present_in_season_regular(String actor, String isPresent){
		episodeFragment.clickShowMore();
		if("present".equals(isPresent))
			assertTrue("Actor is not present",episodeFragment.checkActorPresentInRegular(actor));
		else
			assertFalse("Actor is present",episodeFragment.checkActorPresentInRegular(actor));
	}

	@Then("^the actor \"([^\"]*)\" is (present|not present) in guest stars$")
	public void the_actor_is_not_present_in_guest_stars(String actor, String isPresent){
		if("present".equals(isPresent))
			assertTrue("Actor is not present",episodeFragment.checkActorPresentInGuest(actor));
		else
			assertFalse("Actor is present",episodeFragment.checkActorPresentInGuest(actor));
	}
	
	@Given("^I select episode (\\d+)$")
	public void i_select_episode(int episode){
		episodeFragment.selectEpisode();
	}
	
	@Then("^the number of episodes are (\\d+)$")
	public void the_number_of_episodes_are(int numberOfEpisode){
		assertEquals(String.valueOf(numberOfEpisode), episodeFragment.getActualEpisodes());
	}
}
