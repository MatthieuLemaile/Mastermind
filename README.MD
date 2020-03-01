# Mastermind

This project is a mastermind in java. It has no real purpose other than learning some things in Java for me.

Actual version is 1.4

## Installation

JDK 1.11 is required.

This project use gradle to be built, and Git for version control.

To ensure you have correctly download the project,
you may run `gradlew clean build`,
and gradle should be successful.

More about git :
https://rogerdudler.github.io/git-guide/index.fr.html
just, please, use `git pull --rebase` instead of just `git pull`.

Full gradle command line, with test and sonar :
``` shell script
gradlew clean build jacocoTestReport sonarqube
```

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

* java module (problem with java.awt imported from two modules.) ?
* Bug : closing sub window does not stop app, nor bring back menu.
* GitHub Publish ?
* Create interface between controller and UI.
* java FX (in place of swing/awt). Maybe wait for something more stable than jfx 11 (it has no packager).
* Add options. How many balls (not more than colors) ? 
* UComponentUtils should be a factory / builder, see which pattern is relevant
* Ask Marc : save highscores ? In this case we'll need file writing, Nio2. With times maybe ?
* i18n ?
* Add a rules option in main menu, with a part with some tips. (Like make a combination that can be same result as previous one, if no green nor orange in result => no more color, ... ?)
* BoardBody => JSplitPane + JScrollPane ?
* Option => calculator to compute how much attempts min you need.

## Release History

####1.4
* Moved Credit from in-game menu to a dedicated "à propos" part, accessible via an "À propos" option in main menu
* Fix bug for setting a different number of pin would crash if try to re-choose colors of the attempt.

####1.3
* Added a main menu
* Added an option panel to choose if the solution can reuse colors.

####1.2
* move solution in top of the game panel
* Fix bug, right in max attempts possible would lead to both loose and win.