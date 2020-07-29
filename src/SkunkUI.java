import java.util.ArrayList;
import java.util.Scanner;

public class SkunkUI 
{
	public void welcomeToSkunk()
	{
		

		System.out.println("Bug #1. Scorecard outputs the players most recent roll of the dice, not the total points from ALL rolls of the dice.");
		System.out.println("Bug #2. Inconsistent and incorrect indexing/roundOfPlay. Make a couple changes there.");
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
//			Player q = players.get(l);
//			players.get(q.player_index); // player_number i = 0
//			
//			//set active player 
//			app.active_player = q;
//			
//			//this active player_number = 1 for output
//			player_number = q.player_index + 1;
										
					 
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
	public void printPlayersAndPointsWithinTheList(SkunkController controller) 
	{
		System.out.println("");
		System.out.println("1.) print all players created inside list ----------------");
		controller.printAllPlayersAndPointsInsideList(1);
		System.out.println("-------------------------------------------------------");
		System.out.println("");
	}
	
}
