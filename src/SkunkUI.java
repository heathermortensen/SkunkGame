import java.util.ArrayList;
import java.util.Scanner;

public class SkunkUI 
{
	public void welcomeToSkunk()
	{
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
			numPlayers = scan.nextInt();;
			
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
		
		
		if (round == 1)
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
	
}
