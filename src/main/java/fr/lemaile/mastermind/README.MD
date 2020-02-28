# Mastermind

This project is a mastermind in java. It has no real purpose other than learning some things in Java for me.

Actual version is 1.3 

## Installation

JDK 1.11 is required.

This project use maven to be build.

To ensure you have correctly download the project, you may run "mvn clean install", and maven should be successfull.

mvn sonar:sonar \
  -Dsonar.projectKey=mastermind \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=fafb58396824116bc4b84c2a208050fde00b8bb4

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