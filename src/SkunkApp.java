import java.util.ArrayList;
import java.util.Scanner;

public class SkunkApp 
{
             
	int numberOfPlayers;
	int roundOfPlay = 0;
	
	private Player active_player;
	private int player_number = 0;
	
	private Player winner;
              

     public int getNumberOfPlayers()
     {
    	 return numberOfPlayers; 
     }
     
     public int getRoundOfPlay()
     {
    	 return roundOfPlay; 
     }
 
     public void setNumberOfPlayers(int num)
     {
   	 
    	this.numberOfPlayers = num;
    	
     }
     
     public void setRoundOfPlay(int m)
     {
   	 
    	this.roundOfPlay = m;
    	
     }

	public void playGame() 
	{
		
		//This controller class is responsible for setting data inside the player array to keep player score after each round of play.
		//Each player object holds an array called int[] pointsPerRound = new int[5];
		
		SkunkUI UI = new SkunkUI();

		SkunkController controller = new SkunkController();
		
		UI.welcomeToSkunk();
		
		//Must enter number of PLAYERS >= 2.
		int number = UI.getNumPlayersFromUser();
		
		setNumberOfPlayers(number);

		//Player names are now stored in the list of players.
	
		controller.list = controller.createPlayers(getNumberOfPlayers());
		
		//Start the first round of play. 
		for (Player e: controller.list)
			e.initializeArray();
		
		//Play 5 rounds of Skunk
		for (int round = 1; round < 6; round++)
		{
		
				//Here, check if any players (in the arraylist) have points greater than 100.
			//Does anyone have 100 or more points??? --> They win.
			//REFRACTOR THIS. PULL OUT INTO its own method.
		
			doesAnyPayerHave100PointsYet(UI, controller, number, round);
				
				
			//Players take a first turn.
					
					//Increment this.roundOfPlay prior to each player taking a turn.
					this.roundOfPlay++;
					controller.list = playerTurns(this, UI, controller, controller.list, roundOfPlay);
					
					
					//Test Output - test list #2 after playerTurns()
					//UI.debugPrintPlayersAndPointsWithinTheList(controller);
					
		
					//print scorecard here..........
					
					System.out.println("");
					UI.printScorecard(controller.list, this, controller);
					
					this.longPauseGame();
					
				//Determine who is winning after this round of play
					
					
					
					//Who currently has the most points??? They are currently winning.
					
					String winning = currentlyWinning(controller);
					
					int wins = indexOfPlayerCurrentlyWinningTheGame(controller);
					
					if (wins == 44)
					{
						UI.print("\nNo player is currently winning.");
					}
					else
					{
						UI.printCurrentlyWinning(winning, this.roundOfPlay, controller.list.get(wins));
					}
		} //end of for loop that establishes 5 rounds of the game	
		
		//who is the winner after 5 rounds? Who has the most points?
		
		//Player winner = new Player(hasMaxPoints(controller.list));
		//System.out.println("winner is " + winner.get_player_name());
		
		//Exit the game?
		exitGame(UI.getUserInputToExitGame());
		
		
			
}

	public void doesAnyPayerHave100PointsYet(SkunkUI UI, SkunkController controller, int number, int round) 
	{
		ArrayList<Player> hasMoreThan99Points = new ArrayList<Player>();
		
		for (int i = 0; i < number; i++)	
		{
				//check point totals
				for (Player f: controller.list)
				{
					if (f.get_total_game_points() > 99)
					{
						hasMoreThan99Points.add(f);
					}
				}		
		}
		
		if (hasMoreThan99Points.size() == 0)
		{
			//There is no winner, yet. Keep playing rounds of the game.
		}
		else if (hasMoreThan99Points.size() == 1)
		{
			//player f is the winner
			//System.out.println("\n" + hasMoreThan99Points.get(0).get_player_name() + " wins the game!!!");
			UI.printCurrentlyWinning(hasMoreThan99Points.get(0).get_player_name(), round, hasMoreThan99Points.get(0) );
			
			//Winner declared. Call function to exit the game HERE.
			exitGame(UI.getUserInputToExitGame());
			
		}
		else // (hasMoreThan99Points.size() > 1)
		{
			//Check who has more points and declare that player the winner
			String winner = currentlyWinning(controller);
			int indexOfWinnerInsideList = 0;
			indexOfWinnerInsideList = indexOfPlayerCurrentlyWinningTheGame(controller);
					
			UI.printCurrentlyWinning(winner, round, hasMoreThan99Points.get(indexOfWinnerInsideList));
			
			//Winner declared. Call function to exit the game HERE.
			exitGame(UI.getUserInputToExitGame());
			
			//if the two (or more) players tie on points, then the winner is the player with the smallest index./////////
			//////////////////////////////////////
		}
	}


	public ArrayList<Player> playerTurns(SkunkApp app, SkunkUI UI, SkunkController controller, ArrayList<Player> players, int roundOfPlay) 
	{
		int numberOfPlayers = this.getNumberOfPlayers();
		
		//Each players turn starts here. m is the player's index inside the arrayList.
		//This loop runs once for each player so they can each take a turn 
		//m is the index of the player  inside the list.
		//Player number = player index + 1
		
		for (int m = 0; m < numberOfPlayers; m++)
		{
			
			Player p = new Player(players.get(m)); //players.get(0) players.get(1) on 2nd turn
		
			players.get(p.player_index); 
		
			this.active_player = p;
		
			player_number = p.player_index + 1; 
		
			Dice myDice = new Dice();
			
			///////////////////  Player rolls for the first time in their turn  //////////////////////

			UI.printStartPlayerTurn(p.get_player_name(), player_number, getRoundOfPlay());  
		
			//dont need to send in roundOfPlay here. It can be obtained from other parameters - app.roundOfPlay
			controller = p.playersFirstRoll(app, UI, controller, p, myDice, roundOfPlay);  
			
			//////////////////    Player makes all additional rolls in this turn    //////////////////
			
			controller = p.playersAllAdditionalRolls(UI, controller, m, p, myDice, roundOfPlay);
					
			
		}//end for (int m = 0; m < number; m++) - each player has had one turn
		
	
	return players;
	}
	
    public Boolean rollAgain()
    {
   	 	Boolean b = true;
   	 	
   	 	return b;
    }
    
	public void longPauseGame() 
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public String currentlyWinning(SkunkController controller)
    {
    	Player p = null;
    	String name = "";
    	
    	//which player has the most points?
    	for (Player q: controller.list)
		{
			//p = 0, 1, 2, 3
    		Boolean [] winning = new Boolean[this.numberOfPlayers];
			
			for (int m = 0; m < this.numberOfPlayers; m++)
			{
				p = controller.list.get(m);
				
				if (q.get_player_index() != p.get_player_index())
				{
					if (q.get_total_game_points() > p.get_total_game_points())
					{
						winning[p.get_player_index()] = true;
						//System.out.println("q.get_total_game_points() = "+q.get_total_game_points() + " > " + p.get_total_game_points()+" =p.get_total_game_points() ");
					}
					else
					{
						winning[p.get_player_index()] = false;
					}
				
				}
				else
				{
					winning[q.get_player_index()] = true;
				}
			}//end for loop
			
			//System.out.println("\n");
			
			int countWins = 0;
			
			for (int i = 0; i < this.numberOfPlayers; i++)
			{	
				//System.out.println("winning[" + i + "]" + winning[i]);
				//System.out.println("countWins i=" + i + "=" + countWins + " for " + q.get_player_name());
				
				if (winning[i].equals(true))
				{
					countWins++;
				}
	
				if (countWins == this.numberOfPlayers)
				{
					
				name = q.get_player_name();
				return name;
				}
				else
				{
				
				name = "No one";	
				}
			}
		}
	return name; 	
    }
    
    public int indexOfPlayerCurrentlyWinningTheGame(SkunkController controller)
    {
    	Player p = null;
    	int indexOfWinner = 44;
    	
    	//which player has the most points?
    	for (Player q: controller.list)
		{
			//p = 0, 1, 2, 3
    		Boolean [] winning = new Boolean[this.numberOfPlayers];
			
			for (int m = 0; m < this.numberOfPlayers; m++)
			{
				p = controller.list.get(m);
				
				if (q.get_player_index() != p.get_player_index())
				{
					if (q.get_total_game_points() > p.get_total_game_points())
					{
						winning[p.get_player_index()] = true;
						//System.out.println("q.get_total_game_points() = "+q.get_total_game_points() + " > " + p.get_total_game_points()+" =p.get_total_game_points() ");
					}
					else //if q.get_total_game_points() < p.get_total_game_points()
					{
						winning[p.get_player_index()] = false;
						
					}
				
				}
				else // (q.get_player_index() == p.get_player_index())
				{
					//Each player will have 1 win = true (when its compared with itself)
					winning[q.get_player_index()] = true;
				}
			}//end for loop
			
			//System.out.println("\n");
			
			int countWins = 0;
			
			for (int i = 0; i < this.numberOfPlayers; i++)
			{	
				//System.out.println("winning[" + i + "]" + winning[i]);
				//System.out.println("countWins i=" + i + "=" + countWins + " for " + q.get_player_name());
				
				//Count the number of wins for a particular player
				if (winning[i].equals(true))
				{
					countWins++;
				}
				
				//If this player's # of wins = the # of players in the game, this player is the winner of the game.
				if (countWins == this.numberOfPlayers)
				{		
					indexOfWinner = q.player_index;
				
					//This will always execute for one player.????Maybe not
				//return indexOfWinner;
				}
				
			}//end for loop
		}// end for (Player q: controller.list)
    	
    //System.out.println("\nSkunkApp's indexOfPlayerCurrentlyWinningTheGame() returns indexOfWinner = " + indexOfWinner);
	return indexOfWinner; 
    }
    
    public void exitGame(String userInput)
	{
		String exitTheGame = userInput;
		
		
		if ((exitTheGame == "Y")||(exitTheGame == "y")||(exitTheGame == "Yes")||(exitTheGame == "yes")||(exitTheGame == "YES"))
		{
			System.exit(0);
		}
		else if ((exitTheGame == "N")||(exitTheGame == "n")||(exitTheGame == "No")||(exitTheGame == "no")||(exitTheGame == "NO"))
		{
			//Do whatever here
		}
	}

   
    
}

