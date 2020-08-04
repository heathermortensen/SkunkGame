# Overview
This repo houses a repeated dice rolling game called Skunk. It is programmed in Java.

## [Skunk aka Pig](https://en.wikipedia.org/wiki/Pig_(dice_game))

Skunk is a dice rolling game where each player can roll a pair of dice as many times as they like per round.

### How To Play Skunk

* The # of players must be > 1.
* The player with the most points after 5 rounds wins.
* Alternatively, a player can win by being the first to reach 100 points. 
* If players tie, the first player looses by default.
* If a player rolls a 1, they lose all points in that round.
* If a player rolls snake eyes, they lose all accumulated points in the game.

<img src="https://github.com/heathermortensen/SkunkGame/blob/master/images/Skunkdocumentation.png?raw=true" alt="Use case" style="zoom: 50%;" />

This scorecard shown here summarizes the example game above. Heather wins because she was first to reach 100 points.  A scorecard shows the cumulative points across all of a players turns rolling the dice.

<img src="https://github.com/heathermortensen/SkunkGame/blob/master/images/Scorecard.png?raw=true" alt="Skunk Scorecard" style="zoom: 200%;" />

### Sample Program Output

This shows the program output for 1 round of play in a game with 2 players. During a round of skunk, each player takes their turn.

Heather is the first player. 

She chooses to roll the dice 3 times and accumulates 20 total points, until she rolls a skunk in her third roll and looses all the points in her first turn.

Garth is the second player. 

He rolls only once and gets 9 points. Garth's point total means that he is winning the game at the end of round 1.

![](https://raw.githubusercontent.com/heathermortensen/SkunkGame/master/images/ScreenshotsOf1Turn.png)

### Use Case

Skunk game with 3 players where player 3 wins by having the most points at the end of turn 5.

![image-20200725115334810](https://raw.githubusercontent.com/heathermortensen/SkunkGame/master/images/use_case_1.png)



The data model might be imagined as a matrix with dimensions [number of players] x 5. We sum the points accumulated in every turn to give the total points for each player. The Scorecard outputs each players point totals.

![2D matrix](https://raw.githubusercontent.com/heathermortensen/SkunkGame/master/images/use_case_2.png)



### Data Model

While we might visualize the data as a matrix, the actual implementation uses 2 arrays. An Array list of Player objects contains all the players in the game. Each player object contains an array containing the points for each of 5 turns (or rounds). 

![Data model](https://raw.githubusercontent.com/heathermortensen/SkunkGame/master/images/use_case_3.png)





### Future Project Improvements

- [x] Make the pause between players shorter and create a pause after selecting "Yes" to option to roll the dice. 
- [x] Add loop around playerTurns for 5 rounds of game. But, not yet. Otherwise, it will take forever to run the program.
- [ ] Move Any remaining output into SkunkUI.java class. There's some scorecard outputs in the Player class and a Dice.java picture.
- [x] Make Scorecard output at the end of each round of turns.
- [ ] Do I have time to add some tests? Write some for the conditions that don't execute often.
- [ ] Add MVC
- [x] Clean up GitHub README.md
- [x] Update the program output inside the readme.
- [ ] Make class diagram for backend?
- [x] winner doesn't work. That function is messy - delete it.
- [x] format scorecard output for double and triple digits.
- [ ] Double skunk (snake eyes) isn't clearing all rounds of player's points?? It barley ever executes. Verify using tests.
- [x] Exit the game user input
- [x] Refractor the playGame() method in SkunkApp.java
- [ ] 		
  Input validation
  		
  