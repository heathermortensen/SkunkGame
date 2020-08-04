//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class SkunkUI 
{
	public void welcomeToSkunk()
	{
		System.out.println("");
		System.out.println("Backend UML");
		System.out.println("Winner must be declared for player points < 100 and tie game");
		System.out.println("Double skunk isn't clearing all rounds of points - Test this");
		System.out.println("Missing a Dice.java test class. Needed for snake eyes test");
		System.out.println("Input validation.");
		System.out.println("");
		System.out.println(" _______                _");
		System.out.println("/  ___| |              | |");  
		System.out.println("\\ `--.| | ___   _ _ __ | | __");
		System.out.println(" `--. \\ |/ / | | | '_ \\| |/ /");
		System.out.println("/\\__/ /   <| |_| | | | |   <");
		System.out.println("\\____/|_|\\_/\\__,_|_| |_|_|\\_\\");
	}
	
	public int getNumPlayersFromUser()
	{
		
		int numPlayers = 0;
		
		//Make sure that there are at least 2 players.
		while (numPlayers < 2)
		{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
	
			
			System.out.print("\n Please enter the # of Players >>");
			
			//Get input from user.
			numPlayers = scan.nextInt();
			
			//in.close();
			
			//display game error message			
			if (numPlayers < 2)
			{
				System.out.print("\n You MUST have at least 2 players in order to play Skunk!");
			}
		}
				
		
	return numPlayers;
	}
	
	public  String getPlayerNamesFromUser(int num_Players, int count)
	{
		String player_name = "";
		@SuppressWarnings("resource")
		Scanner scan2 = new Scanner(System.in);
		
		System.out.print("\n Please enter the name of Player #" + count + ">>");
		
		//Get input from user.
		player_name = scan2.nextLine();
		
	
	return player_name;
	}
	
	public String promptAndReturn(String question)
	{
		String result = "";
		@SuppressWarnings("resource")
		Scanner scan3 = new Scanner(System.in);
		
		System.out.print(question + " >>");
		result =  scan3.nextLine();	
		
	return result;
	}
	
	public void print(String output)
	{
		System.out.print(output);
	}
	
	public void printSkunk(int i)
	{
		if (i == 1)
		{
			System.out.println("--------------------------------------------------------------");
			System.out.println("   ___o              ____________");
			System.out.println("  / 0 |            _/      _____/");
			System.out.println(" (__   \\_______  /    _____/       ZERO");
			System.out.println("    |          \\/ _____/         POINTS");
			System.out.println("    |  _______  /                THIS");
			System.out.println("    / /      / /               ROUND");
			System.out.println("   JJJ      JJJ");
			System.out.println("");
			System.out.println("  Pew, You rolled a SKUNK!!!!    Your turn is over.			 ");
			System.out.println("--------------------------------------------------------------");
		}
		else
		{
			System.out.println("--------------------------------------------------------------------");
			System.out.println("   ___o             ____________        ___o             ____________");
			System.out.println("  / 0 |           _/      _____//      / 0 |           _/      _____//");
			System.out.println(" (__   \\_______  //    _____//       (__   \\_______  //    _____// ");
			System.out.println("    |          \\/ _____//               |          \\/ _____//");
			System.out.println("    |  ______   \\//         YOU         |  ______   \\//");
			System.out.println("    // //    // //         LOOSE ALL     // //    // //");
			System.out.println("    JJJ      JJJ         GAME POINTS!!!  JJJ      JJJ");
			System.out.println("");
			System.out.println("   Peewww, You rolled two SKUNKS!!!!  	 Your turn is over.");
			System.out.println("--------------------------------------------------------------------");
			
		}
	}
	
//	public void debugPrintRoundOfPlay(SkunkApp app, ArrayList<Player> q)
//	{
//		System.out.println("SkunkApp app roundOfPlay instance variable = " + app.roundOfPlay);
//		
//		for (Player p : q)
//		{
//			System.out.println("//////////////////////////////////////////////////////////////////////////////////");
//			System.out.println("\nPlayer " + p.get_player_name() + "  Player index = " + p.get_player_index() + "Player Number = ?");
//			System.out.println("-------------------------Rolls, Turn-----------------------------------------------------");
//			System.out.println("Player rolls this turn" + p.rolls_this_turn + "  p.points_this_turn = " + p.cummulative_points_this_turn);
//			System.out.println("----------------------------Round--------------------------------------------------");
//			System.out.println("p.get_points_this_round_of_play(app.roundOfPlay) = " + p.get_points_this_round_of_play(app.roundOfPlay));
//			System.out.println("----------------------------total points--------------------------------------------------");
//			System.out.println("Total Game points p.get_total_game_points() = " + p.get_total_game_points() );
//			System.out.println("//////////////////////////////////////////////////////////////////////////////////");
//		}
//	}
	
	public void printPointsThisRound(String output)
	{
		System.out.println(output);
	}
	
	public void printRoundOfPlay(int round)
	{
		String roundOfPlay = "i";
		
		//Note: round should not equal 0, it should equal 1 for each player this turn...
		if (round ==0)
			roundOfPlay = "_ _ _ _ _    Note: round should not equal 0, it should equal 1 for each player this turn...Thats why it prints the 2nd roll for player #2, because it increments each new player turn.";
		else if (round == 1)
				roundOfPlay = "S _ _ _ _ ";
		else if (round == 2)
			roundOfPlay = "S K _ _ _ ";
		else if (round == 3)
			roundOfPlay = "S K U _ _ ";
		else if (round == 4)
			roundOfPlay = "S K U N _ ";
		else if (round == 5)
			roundOfPlay = "S K U N K ";
		else
			roundOfPlay = "System error line 88, File SkunkUI.java";
		
		System.out.println("------------------------------------------------" );
		System.out.println("|    ROUND OF PLAY = " + roundOfPlay +    "                |");	
		System.out.println("------------------------------------------------" );
		
		
	}
	
	public void printScorecard(ArrayList<Player> players, SkunkApp app, SkunkController controller) 
	{
		System.out.println("///////////////////////////////////////////////////");
		System.out.println("//////////  SKUNK SCORECARD  //////////////////////");
		System.out.println("///////////////////////////////////////////////////");
		printRoundOfPlay(app.roundOfPlay);
		
		for (Player q: players)
		{										
					 
			System.out.println("\nPLAYER: " + q.get_player_name() );
			System.out.print("Round  = ");
					
			        for(int k = 1; k < (app.roundOfPlay + 1); k++)
			        {			
						System.out.print("" + k + "   ");
						
			        }
			        
					this.print("\nPoints = " );
			        
			        
			        for(int j = 0; j < (app.roundOfPlay); j++)
			        {
			        	//System.out.print("" + q.pointsPerRound[j]);
			        	System.out.print("" + players.get(q.get_player_index()).pointsPerRound[j] );
			        	
			        	if (players.get(q.get_player_index()).pointsPerRound[j] < 10)
			        	{
			        		System.out.print("   ");
			        	}
			        	else if ( (9 < players.get(q.get_player_index() ).pointsPerRound[j]) && (( players.get(q.get_player_index() ).pointsPerRound[j]) < 100) )
			        	{
			        		System.out.print("  ");
			        	}
			        	else
			        	{
			        		System.out.print(" ");
			        	}
			        }
			        
			        this.print("\n Total points = " + q.get_total_game_points());
			        
			        this.printLine();
		}
			    
		System.out.println("///////////////////////////////////////////////////");
		System.out.println("///////////////////////////////////////////////////");			        
			        	
	}

	
	//Count the number of dashes here and make it consistent when the player's name is added.
	public void printStartPlayerTurn(String nameOfPlayer, int numberOfPlayer, int roundOfPlay) 
	{
		System.out.println("\n----------------------------------------------------");
		System.out.println("-------- Player #" + (numberOfPlayer) + ".) " + nameOfPlayer + ", turn #" + roundOfPlay + " --------------");
		System.out.println("----------------------------------------------------");
		System.out.println("\n  rolling dice...");
	}
	
	public void printRollPoints(int roll_number, int value_of_dice) 
	{

		System.out.println(" " + "Roll #" + roll_number + ", points = " + value_of_dice );
		
	}
	
	public void printLine() 
	{
		System.out.println("\n------------------------------------------------" );

	}
	public void debugPrintPlayersAndPointsWithinTheList(SkunkController controller) 
	{
		System.out.println("");
		System.out.println("-----------    TEMPORARY SCORECARD     ----------------");
		
		printAllPlayersAndPointsInsideList(1, controller.list);
		
		System.out.println("-------------------------------------------------------");
		System.out.println("");
	}
	
	public void printAllPlayersAndPointsInsideList(int round, ArrayList<Player> list)
	{
		 
			for (Player q : list) 
			{   
			    System.out.print(""+q.get_player_name() + " " + q.get_player_index() + " ");
			    System.out.println("list.get(index).pointsPerRound[roundOfPlay] ="+ list.get(q.get_player_index()).pointsPerRound[round]);
			}

	}

	public void printCurrentlyWinning(String winning, int round, Player p) 
	{	
		if (round == 5) 
		{
			System.out.println("\n ***************** "+ p.player_name + " WINS the game !!!!   **************************** ");
			System.out.println("\n ****************         Winner, winner! Chicken dinner!!!! ********************** ");
			
			if (p.get_total_game_points() > 99)
			{
				System.out.println("\n ***************** "+ p.player_name + " WINS the game !!!!   **************************** ");
				System.out.println("\n ******* Winner double chicken dinner! You got more that 100 points!!! ******* ");
			}
		}
		else
		{
			// Print the name of whomever is currently winning at the end of each round.
			System.out.println("\n" + winning + " is currently winning.");
			
			if (p.get_total_game_points() > 99)
			{
				System.out.println("\n ***************** "+ p.player_name + " WINS the game !!!!   **************************** ");
				System.out.println("\n ******* Winner double chicken dinner! You got more that 100 points!!! ******* ");
			}
		}
		
	}
	
	public String getUserInputToExitGame()
	{
		String exitTheGame = "";
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n Exit the game? Y/n >>");
		
		//Get input from user.
		exitTheGame = scan.nextLine();
		
	return exitTheGame;
	}
	
}
