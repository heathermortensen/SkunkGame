# Overview
This repo houses a repeated dice rolling game called Skunk. It is programmed in Java.

## [Skunk aka Pig](https://en.wikipedia.org/wiki/Pig_(dice_game))

Skunk is a dice rolling game where each player can roll a pair of dice as many times as they like per round.

### How To Play Skunk

* The # of players must be > 1.

* The player with the most points after 5 rounds wins.

* Alternatively, a player can win by being the first to reach 100 points.

* If a player rolls a 1, they lose all points in that round.

* If a player rolls snake eyes, they lose all accumulated points in the game.

<img src="https://github.com/heathermortensen/SkunkGame/blob/master/images/Skunkdocumentation.png?raw=true" alt="Use case" style="zoom: 50%;" />

 This scorecard shown here summarizes the example game above. Heather wins because she was first to reach 100 points.<img src="https://github.com/heathermortensen/SkunkGame/blob/master/images/Scorecard.png?raw=true" alt="Skunk Scorecard" style="zoom: 150%;" />

### Sample Program Output

This shows the program output for 1 round of play in a game with 2 players. Each player rolls the dice twice.

Heather is the first player. She rolls 9 points and chooses to roll a second time. In her second roll, she rolls a 1 (aka skunk) and looses all the points in her turn.

Garth is the second player. He initially rolls 10 points. In his second roll, he adds another 7 points. Garth has a total of 17 points and is leading the game.

![](https://raw.githubusercontent.com/heathermortensen/SkunkGame/master/images/ScreenshotsOf1Turn.png)

### Use Case

Skunk game with 3 players where player 3 wins by having the most points at the end of turn 5.

![image-20200725115334810](https://raw.githubusercontent.com/heathermortensen/SkunkGame/master/images/use_case_1.png)



The data model might be imagined as a matrix with dimensions [number of players] x 5. We sum the points accumulated in every turn to give the total points for each player.

![2D matrix](https://raw.githubusercontent.com/heathermortensen/SkunkGame/master/images/use_case_2.png)

### Data Model

While we might visualize the data as a matrix, the actual implementation uses 2 arrays. An Array list of Player objects contains all the players in the game. Each player object contains an array containing the points for each of 5 turns (or rounds). 

![Data model](https://raw.githubusercontent.com/heathermortensen/SkunkGame/master/images/use_case_3.png)