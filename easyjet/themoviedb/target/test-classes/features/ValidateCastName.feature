Feature: Check actor on The movie DB
		I want to go themovieDB website 
		and verify the actor is present in specific episodes only
		
Background:
	Given I navigate to the movie DB
	And I am on the home page
	And I search for "Game of thrones" TV show
	And I click on "Game of thrones"

Scenario: The actor is not in season 6 episode 1
	Given I click on the season 6
	When I click on full cast and crew for episode 1
	Then the actor "Nell Tiger Free" is not present in season regular
	And the actor "Nell Tiger Free" is not present in guest stars

Scenario: The actor is in season 5 episode 1 as main cast member but not as a guest actor
	Given I click on the season 5
	When I click on full cast and crew for episode 1
	Then the actor "Nell Tiger Free" is present in season regular
	And the actor "Nell Tiger Free" is not present in guest stars

Scenario: The actor is in season 5 episode 2 as main cast member and as a guest actor
	Given I click on the season 5
	And I select episode 2
	When I click on full cast and crew for episode 2
	Then the actor "Nell Tiger Free" is present in season regular
	And the actor "Nell Tiger Free" is present in guest stars