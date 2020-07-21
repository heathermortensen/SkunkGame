import java.util.ArrayList;

public class SkunkApp 
{
             
	int NumberofPlayer;
	
	int roundOfPlay = 1;
	
	//See min 51:27
	private int numPlayers;
	private Player active_player;
	private int player_number = 0;
              
	int[] pointsPerRound = new int[5];
	
     public int getNumberofPlayer()
     {
    	 return NumberofPlayer; 
     }
     
     public void setNumberOfPlayers(int num)
     {
    	 
    	this.NumberofPlayer = num;
     }

	public void playGame() 
	{
		
		SkunkUI UI = new SkunkUI();

		SkunkController controller = new SkunkController();
		
		UI.welcomeToSkunk();
		
		//Must enter number of PLAYERS >= 2.
		int number = UI.getNumPlayersFromUser();
		
		setNumberOfPlayers(number);

		//Player names are stored in players.
		ArrayList<Player> players = new ArrayList<Player>();	 
		
		players = controller.createPlayers(getNumberofPlayer());
		
		//Start the first round of play. 
		

//Here, check if any players (in the arraylist) have points greater than 100.	
//for (int i = 0; i < number; i++)	
//{
	//check point totals
	
//}
		
		
	//Player #1 takes a turn.
			
	//player_number == number
			
	for (int i = 0; i < number; i++)
	{
			//players turn starts here....
				
			Player p = new Player(players.get(i));
			
			players.get(p.player_index); // player_number i = 0
			
			//set active player 
			this.active_player = p;
			
			//this active player_number = 1 for output
			player_number = p.player_index + 1; 
			
			Dice myDice = new Dice();
		
			UI.printStartPlayerTurn(p.get_player_name(), player_number, roundOfPlay);
			
			int roll_of_dice = 0;
			
			//Player takes the first roll of the dice in his turn.		
			roll_of_dice = myDice.roll_dice(p);
			
			//set total points
			p.set_points_this_turn(roll_of_dice);
			
			//set total points into array. This is the value of the first roll.
			int get_points_first_roll = 0;
			get_points_first_roll = p.get_points_this_turn();
			pointsPerRound[roundOfPlay-1] = p.set_points_this_round(get_points_first_roll, roundOfPlay, p);
			
			UI.printRollPoints(p.rolls_this_turn, roll_of_dice);
					
			
		
			String again = "Y";
			
			while ((again.equals("Y") || again.equals("y")) && myDice.getSkunkEndsTurn() == false)
			{
				//Does the player want to roll again???
				
				again = UI.promptAndReturn("\nWant to roll again? 'Y' = Yes 'N' = No");
				
				if ((again.equals("Y") || again.equals("y")))
				{
					
					// Roll again
					
					//increase the number of rolls inside patron
					p.rolls_this_turn ++;
	
					roll_of_dice = myDice.roll_dice(p);
					
					//works perfect
					
					int get_points = p.get_points_this_turn();
					
					p.set_points_this_turn((p.get_points_this_turn() + roll_of_dice));
					
					
					// Add the points to the previous point total.
					
					// Set points in the array
					pointsPerRound[roundOfPlay] = p.set_points_this_round(p.get_points_this_turn(), roundOfPlay, p);
					
					//p.set_points_this_round(p.get_points_this_turn(), roundOfPlay, p);
					
					//change to ui method...
					UI.printRollPoints(p.rolls_this_turn, roll_of_dice);
						
					UI.print("Total points this turn = " + p.get_points_this_turn());
					
				}//end if
				
			}//end while
					
					
			
			//print scorecard here..........
					
			
			UI.printRoundOfPlay(roundOfPlay);
			
			for (int l = 0; l < players.size(); l++) 
			{
				Player q = players.get(l);
				players.get(q.player_index); // player_number i = 0
				
				//set active player 
				this.active_player = p;
				
				//this active player_number = 1 for output
				player_number = p.player_index + 1;
											
						 
				System.out.println("\nPLAYER: " + p.get_player_name() );
				//System.out.print("Round  = ");
						
//				        for(int k = 1; k < (roundOfPlay + 1); k++)
//				        {			
//							System.out.print("" + k + "   ");
//							
//				        }
				        
						UI.print("\nPoints = " );
				        
				        int pointOutput = 0;
				        
				        for(int j = 1; j < (roundOfPlay + 1); j++)
				        {
				        	
				        	UI.print(p.get_points_this_round(roundOfPlay, p) + "   ");
				        	
				        }
				        
				        UI.printLine();
				        
				        l++;
			}
			
			pauseGame();
						
		
		}//end for loop - each player has had 1 turn.
	
	
	
	roundOfPlay++;
			
	}

	public void pauseGame() 
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public Boolean rollAgain()
    {
   	 	Boolean b = true;
   	 	
   	 	return b;
    }
}
