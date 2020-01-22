# Battle Ship Game

[Battleship](https://en.wikipedia.org/wiki/Battleship_(game)) is a strategy type guessing game for two players. It is played on ruled grids (paper or myBoard) on which each player's fleet of ships (including battleships) are marked. The locations of the fleets are concealed from the other player. Players alternate turns calling "shots" at the other player's ships, and the objective of the game is to destroy the opposing player's fleet.

## Implementation and Assumption

This Project is providing a implementation where combination of human player and computer bot can play the game among themselves. Follwong are some assumptions in the implementation.

- Players can join before the start of the game.
- Computer bot player is playing the move randomly. There is no intelligence to it.
- Player have ability to add ships on the board.
- There can be multiple player playing the game in a round robin fashion.
- Player can have more advance type of Weopons if required. Current implementation have only one i.e Missile
- Weopon is thrown at position and it can destroy more area than that position. Currently implemented to destroy only position where it is thrown.


### Prerequisites

One need to have Java 8 installed on the their system. It can be checked on console by command.

```
java -version
```

### Building

[Gradle](https://gradle.org/) is used as a build tool for the project. 
Jar from the project can be created by running following command from root directory of the project

```
Linux / Mac OS: 	./gradlew clean build jar
Windows: 			./gradlew.bat clean build jar
```
This will generate jar file at path ./build/libs/document-search.jar

## Running the Application

Following command run the game console

```
java -jar ./build/libs/coding.jar
```
Alternatively directly through gradle, application can be run as

```
./gradlew run
```

A sample output with myBoard initialization looks as below. This is debug information and it is enabled by default. It can be disabled by passing first command line argument as `nodebug`

```
Placing ship CARRIER at C2 C6
Placing ship BATTLESHIP at H3 H6
Placing ship CRUISER at B0 D0
Placing ship SUBMARINE at D3 F3
Placing ship DESTROYER at A5 A6
  0 1 2 3 4 5 6 7 8 9
A - - - - - S S - - -
B S - - - - - - - - -
C S - S S S S S - - -
D S - - S - - - - - -
E - - - S - - - - - -
F - - - S - - - - - -
G - - - - - - - - - -
H - - - S S S S - - -
I - - - - - - - - - -
J - - - - - - - - - -

Placing ship CARRIER at A2 A6
Placing ship BATTLESHIP at G6 G9
Placing ship CRUISER at G2 G4
Placing ship SUBMARINE at J7 J9
Placing ship DESTROYER at G0 G1
  0 1 2 3 4 5 6 7 8 9
A - - S S S S S - - -
B - - - - - - - - - -
C - - - - - - - - - -
D - - - - - - - - - -
E - - - - - - - - - -
F - - - - - - - - - -
G S S S S S - S S S S
H - - - - - - - - - -
I - - - - - - - - - -
J - - - - - - - S S S
```

Once User puts a input on console, It shows the updates table and the bot player makes it move and both the boards are printed namely current user and other user board respectively as below. Symbols used are explained here.

`S` shows the position of the ship.  
`X` shows the hit position.  
`-` shows empty position for opponent player and current player board.  
`*` shoes the unexplored position for the opponents player board.  


Computer Bot plays the chance automatically and both the boards are shown from Computer Bot's perspective.

```
F8
Player HumanPlayer@63947c6b Played Position { F8 }
It's a miss.
  0 1 2 3 4 5 6 7 8 9
A - - - - - S S - - -
B S - - - - - - - - -
C S - S S S S S - - -
D S - - S - - - - - -
E - - - S - - - - - -
F - - - S - - - - - -
G - - - - - - - - - -
H - - - S S S S - - -
I - - - - - - - - - -
J - - - - - - - - - -

  0 1 2 3 4 5 6 7 8 9
A * * * * * * * * * *
B * * * * * * * * * *
C * * * * * * * * * *
D * * * * * * * * * *
E * * * * * * * * * *
F * * * * * * * * - *
G * * * * * * * * * *
H * * * * * * * * * *
I * * * * * * * * * *
J * * * * * * * * * *

Player BotPlayer@70dea4e Played Position { E8 }
It's a miss.
  0 1 2 3 4 5 6 7 8 9
A - - S S S S S - - -
B - - - - - - - - - -
C - - - - - - - - - -
D - - - - - - - - - -
E - - - - - - - - - -
F - - - - - - - - - -
G S S S S S - S S S S
H - - - - - - - - - -
I - - - - - - - - - -
J - - - - - - - S S S

  0 1 2 3 4 5 6 7 8 9
A * * * * * * * * * *
B * * * * * * * * * *
C * * * * * * * * * *
D * * * * * * * * * *
E * * * * * * * * - *
F * * * * * * * * * *
G * * * * * * * * * *
H * * * * * * * * * *
I * * * * * * * * * *
J * * * * * * * * * *

```

Game goes on till on of the plyeres all ships are destroyed.

## Bot Mode
Alternatively It can be ran as bot mode where both players are bot with follwing commands

```
java -jar ./build/libs/coding.jar debug runBots
```
OR

```
./gradlew run --args='debug runBots'
```

## Testing

Currently test case are added for happy flow and it do not cover all the negative paths

Following command can be used to run the test

```
./gradlew test
```

Following command will generate the code coverage report

```
./gradlew jacocoTestReport
```

Current code coverage is 89%. Jacoco is used to get the coverage report as below.


![Coverage](https://i.ibb.co/MGkzQzc/Screenshot-2019-11-11-at-3-37-57-PM.png)

## Built With

* [Gradle](https://gradle.org/) - Java project build tool

## Authors

* **Jitendra Kushwaha** - *jitendra.theta@gmail.com* 



