Feature: Check episodes on The Movie DB
		I want to go themovieDB website 
		and verify the number of episodes per season
		
Background:
	Given I navigate to the movie DB
	And I am on the home page
	And I search for "Breaking Bad" TV show
	And I click on "Breaking Bad"

Scenario Outline: For Breaking Bad confirm the episodes per season is correct
	Given I click on the season <season>
	When I am on season <season> page 
	Then the number of episodes are <episode>

Examples:
|season	|episode|
|5		|16		|
|4		|13		|
|3		|13		|
|2		|13		|
|1		|7		|