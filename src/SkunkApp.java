import java.util.ArrayList;

public class SkunkApp 
{
             
	int numberOfPlayers;
	
	int roundOfPlay = 0;
	
	
	//private int numPlayers;
	private Player active_player;
	private int player_number = 0;
              
	//int[] pointsPerRound = new int[5];
	

    
     public int getNumberOfPlayers()
     {
    	 return numberOfPlayers; 
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

		//Player names are stored in players.
	
		controller.list = controller.createPlayers(getNumberOfPlayers());
		
		//Start the first round of play. 
		for (Player e: controller.list)
			e.initializeArray();
		
		
//Here, check if any players (in the arraylist) have points greater than 100.	
//for (int i = 0; i < number; i++)	
//{
	//check point totals
	
//}
		
		
	//Player #1 takes a turn.
			
	//player_number == number
		
			//Test Output - test list #1 before playerTurns()
			UI.printPlayersAndPointsWithinTheList(controller);
			
		
			controller.list = playerTurns(UI, controller, controller.list, roundOfPlay);
			
			//Test Output - test list #2 after playerTurns()
			UI.print("\noutput AFTER PlayerTurns, just before the scorecard executes....");
			UI.printPlayersAndPointsWithinTheList(controller);
			
			//Make a new, updated ArrayList from controller.list	 
			
//			ArrayList<Player> playersHadOneTurnEach = new ArrayList<Player>();
//			playersHadOneTurnEach = controller.list;

			//print scorecard here..........
			
			
//			System.out.println("");
//			System.out.println("this is what?" + this.getClass());
//			System.out.println("");
					
			UI.printScorecard(controller.list, this, controller);
//}	
			
}


	public ArrayList<Player> playerTurns(SkunkUI UI, SkunkController controller, ArrayList<Player> players, int roundOfPlay) 
	{
		int number = this.getNumberOfPlayers();
		
		
		//players turn starts here....m = the player index
		for (int m = 0; m < number; m++)
		{
			System.out.println("/////////////Start of turn, m = " + m);
			
			Player p = new Player(players.get(m)); //players.get(0) players.get(1) on 2nd turn
		
			players.get(p.player_index); 
			System.out.println("player index =" + p.player_index);
		
			//set active player 
			this.active_player = p;
		
			//this active player_number = 1 for output
			player_number = p.player_index + 1; 
		
			Dice myDice = new Dice();

			UI.printStartPlayerTurn(p.get_player_name(), player_number, m);  
		
			
			////////////////////////////////here///////////////////////////////
			
			//Player's first roll
			 p.playersFirstRoll(UI, controller, p, myDice, roundOfPlay);
			 
			 ///////////working perfectly thru here.///////////////////////////
			
			//Player takes all following rolls...
			p.playersAllAdditionalRolls(UI, controller, m, p, myDice, roundOfPlay);
					
			
	}//end for (int m = 0; m < number; m++) - each player has had one turn
		
		
		
	
		
	return players;
	}







	
    public Boolean rollAgain()
    {
   	 	Boolean b = true;
   	 	
   	 	return b;
    }
}
