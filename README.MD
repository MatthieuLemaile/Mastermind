# Mastermind

This project is a mastermind in java. It has no real purpose other than learning some things in Java for me.

Actual version is 1.4

## Installation

JDK 1.11 is required.

This project use gradle to be built, and Git for version control.

To ensure you have correctly download the project,
you may run `gradle clean build`,
and gradle should be successful.

####Sonar
Run sonar docker with docker run -d -p 9000:9000 sonarqube
In your sonar (localhost:9000) log in with admin/admin,
create a project following instructions,
and update build.gradle with your project key.
you can then run sonarqube with :
```shell script
gradle build jacocoTestReport sonarqube
``` 


## Authors

Marc Lemaile
Matthieu Lemaile

## Miscellaneous

With the proper algorithm, 6 balls/8colors could be resolved in under 6 attempts.

## Things to add

* java module (problem with java.awt imported from two modules.)
* java FX (in place of swing/awt). Maybe wait for something more stable than jfx 11 (it has no packager).
* Add options. How many balls (not more than colors) ? how many colors (not more than max available) ? how many attempts ? Maybe helpfull calc to compute how much attempts min you need.
* Move Credit from in-game menu to a dedicated "credit" part, accessible via an "à propos" option in main menu
* Add a rules option in main menu, with a part with some tips. (Like make a combination that can be same result as previous one, if no green nor orange in result => no more color, ... ?)
* Ask Marc : save highscore ? In this case we'll need file writing, Nio2. With times maybe ?
* What configuration is needed for sonarqube server to pick up jacoco result ?

## Release History

####1.4

####1.3
* Added a main menu
* Added an option panel to choose if the solution can reuse colors.

####1.2
* move solution in top of the game panel
* Fix bug, right in max attempts possible would lead to both loose and win.