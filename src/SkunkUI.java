//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class SkunkUI 
{
	public void welcomeToSkunk()
	{
		System.out.println("TO DO:  ");
		System.out.println("Make the pause between players shorter and create a pause after selecting roll dice. This makes it less confusing.");
		System.out.println("Add loop for 5 rounds of game. But, not yet, it will take forever to run the progam.");
		System.out.println("Move Any remaining output into SkunkUI.java class.");
		System.out.println("Do I have time to add some tests?");
		System.out.println("Add MVC");
		System.out.println("Clean up Github README.md");
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
			System.out.println("   ___o              ____________");
			System.out.println("  / 0 |            _/      _____/");
			System.out.println(" (__   \\_______  /    _____/       ZERO");
			System.out.println("    |          \\/ _____/         POINTS");
			System.out.println("    |  _______  /                THIS");
			System.out.println("    / /      / /               ROUND");
			System.out.println("   JJJ      JJJ");
			System.out.println("-----------------------------------------");
			System.out.println("  Pew, You rolled a SKUNK!!!!    			 ");
			System.out.println("-----------------------------------------");
		}
		else
		{
			System.out.println("   ___o             ____________        ___o             ____________");
			System.out.println("  / 0 |           _/      _____//      / 0 |           _/      _____//");
			System.out.println(" (__   \\_______  //    _____//       (__   \\_______  //    _____// ");
			System.out.println("    |          \\/ _____//               |          \\/ _____//");
			System.out.println("    |  ______   \\//         YOU         |  ______   \\//");
			System.out.println("    // //    // //         LOOSE        // //    // //");
			System.out.println("    JJJ      JJJ         ALL POINTS!!!  JJJ      JJJ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("   Peewww, You rolled two SKUNKS!!!!  	 ");
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
		
		System.out.println("\n------------------------------------------------" );
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
			        
			        int pointOutput = 0;
			        
			        for(int j = 0; j < (app.roundOfPlay); j++)
			        {
			        	Player p = new Player(players.get(j));
			   
			        	this.print(" " + p.pointsPerRound[0/*k*/]);
			        	//pointOutput = pointOutput + q.get_points_this_round_of_play(j);
			        	
			        }
			        this.print("\n Total points = " + pointOutput);
			        
			        this.printLine();
		}
			  
		System.out.print("\n");
		System.out.print("\nBAD OUTPUT HERE>>>>  IT does not sum all the rolls. It breaks for #rolls > 1.");
		System.out.print("\nIt outputs the most recent roll, not the total of ALL rolls.");
			    
			        System.out.print("\n");
			        System.out.println("\n Output from method SkunkController.printAllPlayersAndPointsInsideList(int round)");
			        for (Player r : players) 
					{   
					    System.out.print("\n"+r.get_player_name() + " " + r.get_player_index() + " ");
					    System.out.println(" players.get(index).pointsPerRound[roundOfPlay] ="+ players.get(r.get_player_index()).pointsPerRound[app.roundOfPlay]);
					}
				   
			        
			        
		
	}

	
	//Count the number of dashes here and make it consistent when the player's name is added.
	public void printStartPlayerTurn(String nameOfPlayer, int numberOfPlayer, int roundOfPlay) 
	{
		System.out.println("\n----------------------------------------------------");
		System.out.println("-------- Player #" + (numberOfPlayer) + ".) " + nameOfPlayer + ", turn #" + roundOfPlay + " --------------");
		System.out.println("----------------------------------------------------");
	}
	
	public void printRollPoints(int roll_number, int value_of_dice) 
	{

		System.out.println("Roll #" + roll_number + ", points = " + value_of_dice );
		
	}
	
	public void printLine() 
	{
		System.out.println("\n------------------------------------------------" );

	}
	public void debugPrintPlayersAndPointsWithinTheList(SkunkController controller) 
	{
		System.out.println("");
		System.out.println("-----------    TEMPORARY SCORECARD     ----------------");
		controller.printAllPlayersAndPointsInsideList(1);
		System.out.println("-------------------------------------------------------");
		System.out.println("");
	}
	
}
