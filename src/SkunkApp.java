import java.util.ArrayList;

public class SkunkApp 
{
             
	int numberOfPlayers;
	int roundOfPlay = 0;
	
	private Player active_player;
	private int player_number = 0;
              

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
		
		
//Here, check if any players (in the arraylist) have points greater than 100.	
//for (int i = 0; i < number; i++)	
//{
	//check point totals
		
		//System.out.println(" Prior to anybody taking any turns  ");
		//UI.printRoundOfPlay(this, controller.list);
	
//}
		
		
	//Players take a first turn.
			
			//Increment this.roundOfPlay prior to each player taking a turn.
			this.roundOfPlay++;
			controller.list = playerTurns(this, UI, controller, controller.list, roundOfPlay);
			
			
			//Test Output - test list #2 after playerTurns()
			//UI.debugPrintPlayersAndPointsWithinTheList(controller);
			

			//print scorecard here..........
			
			System.out.println("");
			UI.printScorecard(controller.list, this, controller);
//}	
			
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
}
