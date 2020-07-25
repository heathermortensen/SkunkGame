# Overview
This repo houses a repeated dice rolling game called Skunk. It is coded in Java.

## [Skunk aka Pig](https://en.wikipedia.org/wiki/Pig_(dice_game))

Skunk is a dice rolling game where each player can roll a pair of dice as many times as they like per round.

### How To Play Skunk

* The # of players must be > 1.

* The player with the most points after 5 rounds wins.

* Alternatively, a player can win by being the first to reach 100 points.

* If a player rolls a 1, they lose all points in that round.

* If a player rolls snake eyes, they lose all accumulated points in the game.

<img src="https://github.com/heathermortensen/SkunkGame/blob/master/images/Scorecard.png?raw=true" alt="Skunk Scorecard" style="zoom: 30%;" />

The scorecard above summarizes the game below. Heather wins the game because she was first to reach 100 points.

<img src="https://github.com/heathermortensen/SkunkGame/blob/master/images/Skunkdocumentation.png?raw=true" alt="Use case" style="zoom: 50%;" />

### 

### Use Case

Skunk game with 3 players where player 3 wins by having the most points at the end of round 5.

![image-20200725115334810](C:\Users\Bob Ross\Desktop\workspace\SkunkGame\images\use_case_1.png)



The data model can be thought of as a 2-dimensional array, or matrix with dimensions [number of players] x 5.

![2D matrix](C:\Users\Bob Ross\Desktop\workspace\SkunkGame\images\use_case_2.png)

### Data Model

While we might visualize the data inside of a 2D array, or matrix, the data is actually stored inside of the following two arrays.

![Data model](C:\Users\Bob Ross\Desktop\workspace\SkunkGame\images\use_case_3.png)