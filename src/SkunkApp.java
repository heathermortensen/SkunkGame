import java.util.ArrayList;

public class SkunkApp 
{
             
	int numberofPlayers;
	
	int roundOfPlay = 1;
	
	//See min 51:27
	private int numPlayers;
	private Player active_player;
	private int player_number = 0;
              
	int[] pointsPerRound = new int[5];
	
     public int getNumberofPlayer()
     {
    	 return numberofPlayers; 
     }
 
     
     public void setNumberOfPlayers(int num)
     {
   	 
    	this.numberofPlayers = num;
    	
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
			
		
			controller = playerTurn(UI, controller, players);
			
			
	}


	public SkunkController playerTurn(SkunkUI UI, SkunkController controller, ArrayList<Player> players) 
	{
		int number = players.size();
		
		
		//players turn starts here....
		for (int m = 0; m < (number); m++)
		{
		System.out.println("player index =" + m);
			
		Player p = new Player(players.get(m));
		
		players.get(p.player_index); // player_number i = 0
		
		//set active player 
		this.active_player = p;
		
		//this active player_number = 1 for output
		player_number = p.player_index + 1; 
		
		Dice myDice = new Dice();

		UI.printStartPlayerTurn(p.get_player_name(), player_number, roundOfPlay);
		
		int roll_of_dice;
		
			
			//Player's first roll
			 controller = playersFirstRoll(UI, controller, p, myDice);
			
			//Player takes all following rolls...
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
						
						//1. set total points
						System.out.println("m = " + m + " p.get_points_this_round_of_play(m) = " + p.get_points_this_round_of_play(m));
						int get_points = p.get_points_this_round_of_play(m);
						
						p.set_points_this_turn((p.get_points_this_turn() + roll_of_dice));
						
						// Add the points to the previous point total.
						
						// Set points in the array
						//2. set array to total points. This is the value of the 2nd,3rd,4th.. roll.
						
						int points_nth_roll = 0;  //change here!!!!!!!!!!!!!!!!
						points_nth_roll = p.get_points_this_round_of_play(m);
						controller.list.set(player_number, p).set_points_this_round(points_nth_roll, roundOfPlay, p);
						
						//p.set_points_this_round(p.get_points_this_turn(), roundOfPlay, p);
						System.out.println("\\\\\\\\\\\\\\\\[roundOfPlay] = " + roundOfPlay);
						System.out.println("\\\\\\\\\\\\\\\\pointsPerRound[roundOfPlay]=" + pointsPerRound[roundOfPlay]);
						
						//
						UI.printRollPoints(p.rolls_this_turn, roll_of_dice);
							
						UI.print("Total points this turn = " + p.get_points_this_turn());
						
					}//end if
				
			}//end while
					
					
			
			//print scorecard here..........
					
			printScorecard(UI, players);
			
			pauseGame();
			
			roundOfPlay++;
			
	}//end for loop - each player has had 1 turn.
	
		
	return controller;
	}


	public void printScorecard(SkunkUI UI, ArrayList<Player> players) {
		
		UI.printRoundOfPlay( roundOfPlay);
		
		for (int l = 0; l < players.size(); l++) 
		{
			Player q = players.get(l);
			players.get(q.player_index); // player_number i = 0
			
			//set active player 
			this.active_player = q;
			
			//this active player_number = 1 for output
			player_number = q.player_index + 1;
										
					 
			System.out.println("\nPLAYER: " + q.get_player_name() );
			//System.out.print("Round  = ");
					
			        for(int k = 1; k < (roundOfPlay + 1); k++)
			        {			
						System.out.print("" + k + "   ");
						
			        }
			        
					UI.print("\nPoints = " );
			        
			        int pointOutput = 0;
			        
			        for(int j = 1; j < (roundOfPlay + 1); j++)
			        {
			        	UI.print("\nq.get_points_this_round()" + q.get_points_this_round_of_play(j));
			        	UI.print("\nq.get_points_this_turn()" + q.get_points_this_turn());
			        	UI.print("\nq.get_points_this_round(j)" + q.get_points_this_round_of_play(j));
			        	UI.print("(roundOfPlay)= " + roundOfPlay);
			        	UI.print("q.get_points_this_round(roundOfPlay)= " + q.get_points_this_round_of_play(roundOfPlay) + "   ");
			        	UI.print("q.get_points_this_round(roundOfPlay)= " + q.get_points_this_round_of_play(roundOfPlay) + "   ");
			        }
			        
			        UI.printLine();
			        
			        
		}
	}


	public SkunkController playersFirstRoll(SkunkUI UI, SkunkController controller, Player p, Dice myDice) 
	{
		int roll_of_dice = 0;
		
		//Player takes the first roll of the dice in his turn.		
		roll_of_dice = myDice.roll_dice(p);
		
		//set total points
		p.set_points_this_turn(roll_of_dice);
		
		//set array to total points. This is the value of the first roll.
		int get_points_first_roll = 0;
		get_points_first_roll = p.get_points_this_turn();
		controller.list.set(player_number, p).set_points_this_round(roll_of_dice, roundOfPlay, p);
		controller = p.set_array(controller,player_number,UI,roll_of_dice,roundOfPlay);
		
		System.out.println("FIRST ROLL () : pointsPerRound[roundOfPlay]= round of play=" + roundOfPlay + " "+ controller.list.get(player_number).get_points_this_turn());
		
		UI.printRollPoints(p.rolls_this_turn, roll_of_dice);
	
	return controller;
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
