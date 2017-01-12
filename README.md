# easyjet
# The Movie DB

Getting Started
Open the project easyjet/themoviedb using eclipse.


Prerequisities
-Eclipse

-Mozilla firefox or Chrome browser

-Java JDK latest version


Installing
Please install the above softwares if not already installed.


Runnning the tests
-To run test open the "easyjet\themoviedb\src\test\java\com\themoviedb\executor\RunBddTest.java" file in eclipse 
 and right click to run jUnit test.

-Result report is generated on the following path
	path : easyjet\themoviedb\target\cucumber-html-report\cucumber-pretty\index.html

-The tests will run in Firefox mozilla by default to run in chrome browser change the following
	1) Open file "easyjet\themoviedb\src\test\java\com\themoviedb\stepdefs\BrowserDriver.java"
	2) Comment line number 21 using // and uncomment line number 23-24 by removing // in above file.
	3) Download the chrome driver and update the path at line number 23.
	3) And rerun the tests.
	
  
Tests
-Feature file is at "easyjet\themoviedb\src\test\resources\features\"

-Test1: Feature: Check actor is in the cast of Game of Thrones - ValidateCastName.feature	
-Test2: Feature: Check number of episodes in Breaking Bad - ValidateNumberOfEpisodes.feature
