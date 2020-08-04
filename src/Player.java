
public class Player 
{
	String player_name = "";
	int player_index;
	int points_this_round_of_play = 0;
	int cummulative_points_this_turn = 0;
	int total_points = 0;
	int rolls_this_turn = 0;
	
	Boolean isCurrentlyWinning = false;
	Boolean is_winner = false;
	
	Dice dice = new Dice();
	
	int[] pointsPerRound = new int[5];
	
	Player(String name, int index)
	{
		this.player_name = name;
		this.player_index = index;
	
	}
	
	Player(Player p)
	{
		this.player_name = p.player_name;
		this.player_index = p.player_index;
		
		this.points_this_round_of_play = p.points_this_round_of_play;
		this.cummulative_points_this_turn = p.cummulative_points_this_turn;
		this.total_points = p.total_points;
		this.rolls_this_turn = p.rolls_this_turn;
		
		//this.isCurrentlyWinning = p.isCurrentlyWinning;
		this.is_winner = p.is_winner;
		
		Dice dice = new Dice();
		
		int[] pointsPerRound = new int[5];
		for (int i = 0; i<5; i++)
		{
			this.pointsPerRound[i] = p.pointsPerRound[i];
		}
	}
	
//////////////////////////////Getters/////////////////////////////////////////////
	
	public String get_player_name()
	{
		
	return this.player_name;
	}
	
	public int get_player_index()
	{
		
	return this.player_index;
	}
	
	public int get_points_this_round_of_play(int round)
	{
		int index = round - 1;
		
	return this.pointsPerRound[index];
	}
	
	public Boolean get_is_winner()
	{
		
	return this.is_winner;
	}
	
	public int get_total_game_points()
	{
		int point_total = 0;
		
		for (int i = 0; i < 5; i++)
		{
			point_total = point_total + this.pointsPerRound[i];
		}
		
	return point_total;
	}
	
	public int get_total_points_this_turn()
	{
		
	return this.cummulative_points_this_turn;
	}
	
	public int get_rolls_this_turn()
	{
		
	return this.rolls_this_turn;
	}
	
	//////////////////////////////Setters////////////////////////////////////////////////////
	public Player equals(Player p)
	{
		//Player newPlayer = new Player(p);
		this.player_name = p.player_name;
		this.player_index = p.player_index;
		
		this.points_this_round_of_play = p.points_this_round_of_play;
		this.cummulative_points_this_turn = p.cummulative_points_this_turn;
		this.total_points = p.total_points;
		this.rolls_this_turn = p.rolls_this_turn;
		
		Dice dice = new Dice();
		
		int[] pointsPerRound = new int[5];
		
		for (int i = 0; i<5; i++)
		{
			this.pointsPerRound[i] = p.pointsPerRound[i];
		}
	return this;	
	}
	
	public void initializeArray()
	{
		for (int i = 0; i < 5; i++)
		{
			this.pointsPerRound[i] = 0;
		}
		
	}
	public void setRollsThisTurn(int i)
	{
		this.rolls_this_turn = i;		
	}
	//////////////////////////BROKEN/////////////////////////////////////////////////
	public void setDataInTotalPointsArray(int round, int points)
	{
//		System.out.println("Player class, setDataInTotalPointsArray(int round, int points) method, round=" + round );
		int index = round;
		index = index - 1;
		this.pointsPerRound[index] = points;
//		System.out.println("round =" + round );
//		System.out.println("index =" + index );
//		System.out.println("this.pointsPerRound[" + index+ "] =" + points );
	}
		
	public Player set_points_first_roll_first_turn(int points, int round)
	{
		
//		System.out.println("        Player class:     set_points_first_roll_first_turn(int points, int round");
		
		int index = round-1;
			
//		System.out.println("///////////set_points_first_roll_first_turn = " + points + ", index = " + index);
		
		this.cummulative_points_this_turn =  points;
	
		
		this.pointsPerRound[index] =  points;
		 
//		System.out.println("////////////this.pointsPerRound[" + index + "] =  points = "+ this.pointsPerRound[index]);
		System.out.println("");
		
	return this;
	}
	
	public void set_points_this_turn(int points, int round)
	{
		int index = round -1;
		
//		System.out.println("---Player class -----------set_points_this_turn(int points, int round)");
//		System.out.println("--------------------------- points = " + points + " index = " + index);
//		System.out.println("points currently stored after first roll = " + this.pointsPerRound[index]);
//		
		if (points !=0)
		{
			this.cummulative_points_this_turn =  this.cummulative_points_this_turn + points;
			this.pointsPerRound[index] = get_total_points_this_turn();
		}
		else 
		{
			this.pointsPerRound[index] = 0;
		}
//		System.out.println("set_points_this_turn(points,round) = this.cummulative_points_this_turn  + points = " + this.cummulative_points_this_turn + "+" + points + " = " + this.cummulative_points_this_turn + " , round = " + round);
//		System.out.println("this.pointsPerRound[index] =" + this.pointsPerRound[index]);
//		System.out.println("---------------------------------------------------------------");
	}
	
	
	public SkunkController set_array(SkunkController controller, int player_number, SkunkUI UI, int roll_of_dice, int roundOfPlay)
	{
		int roll = this.get_total_points_this_turn();
		controller.list.set(player_number, this).set_points_this_turn(roll_of_dice, roundOfPlay);
		
		//System.out.println("FIRST ROLL () : pointsPerRound[roundOfPlay]=" + controller.list.get(player_number).get_points_this_turn());
		
		//UI.printRollPoints(this.rolls_this_turn, roll_of_dice);
		
	return controller;
	}

	public Player set_points_ALL_rounds_to_zero() 
	{
		for (int i =0; i<5; i++)
		{
			this.pointsPerRound[i] = 0;
		}
	return this;	
	}
	///////////////////////////////////////////WORKS PERFECTLY//////////////////////////////////////////////
	public SkunkController playersFirstRoll(SkunkApp app, SkunkUI UI, SkunkController controller, Player p, Dice myDice, int roundOfPlay) 
	{
		int roll_of_dice = 0;
		
		//If this is the first player in the round, then increment the roundOfPlay
//		if (p.get_player_index()==0)
//		{
//			controller.incrementRoundOfPlay(app);
//		}
		
		//Player takes the first roll of the dice in his turn. roll_of_dice contains the sum of the two die.
		setRollsThisTurn(1);
		roll_of_dice = myDice.roll_dice(p,roundOfPlay,UI, controller);
		
		
		//set total current points into the array inside the Player inside the arraylist.
//		System.out.println("///Players 1st Roll():   roundOfPlay =" + roundOfPlay);
		p = set_points_first_roll_first_turn(roll_of_dice, roundOfPlay);
		
		int playerIndex = p.get_player_index();
		Player p2 = new Player(p);
		p2 = controller.list.get(playerIndex);
		
		///////////////////////////////////////
		//  problem here
		//////////////////////////////
		//index = roundOfPlay - 1;
//		System.out.println("p2 = controller.list.get(index);, index=" + playerIndex);
		p2.setDataInTotalPointsArray(roundOfPlay, p.pointsPerRound[roundOfPlay-1]);
		controller.list.set(playerIndex, p2);
		
		//Move this to class SkunkUI.java
		//Output
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("                    QUICK    SCORECARD     ROUND " + roundOfPlay);
		System.out.println("------------------------------------------------------------------------------------------");
		
			//for (Player q : controller.list)
			for (int k = 0; k < p.get_player_index(); k++)
			{   
				Player h = new Player(controller.list.get(k));
			    System.out.print("\n" + h.get_player_name() + ":  ");
			    System.out.println("Points this round  = "+ controller.list.get(h.get_player_index()).pointsPerRound[roundOfPlay-1]);
			    System.out.println("-----------------------------------------------------------------------------");
			}
			
			System.out.println("\n");
			
			UI.print(p.player_name + ": ");
			UI.printRollPoints(p.rolls_this_turn, roll_of_dice);
	
	return controller;
	}
	
	private Player set_points_2nd_thru_nth_roll_first_turn(int roll_of_dice, int roundOfPlay) 
	{
		int index = roundOfPlay -1;
		
//		System.out.println("\n  Player class, ");
//		System.out.println("\n/////////////  set_points_2nd_thru_nth_roll_first_turn(int roll_of_dice, int roundOfPlay");
//		System.out.println("///////////////////////////////////////////////////////////////////////////////");

		if (roll_of_dice ==0)
		{
//			System.out.println("///////if (roll_of_dice ==0)////////");
			
			this.cummulative_points_this_turn =  roll_of_dice;
			
//			System.out.println("this.cummulative_points_this_turn = roll_of_dice" + this.cummulative_points_this_turn);
//			System.out.println("this.cummulative_points_this_turn = " + this.cummulative_points_this_turn);
			
			this.pointsPerRound[index] =  this.cummulative_points_this_turn;
			
//			System.out.println(" where [index] = " + index + " and round = " + roundOfPlay);
//			System.out.println("this.pointsPerRound[index] = " + pointsPerRound[index]);
		}
		else
		{
//			System.out.println("///////if (roll_of_dice !=0)////////");
//			System.out.println("");
//			System.out.println("1.)");
//			System.out.println("this.cummulative_points_this_turn =  roll_of_dice + this.cummulative_points_this_turn  = "+ roll_of_dice + "+" + this.cummulative_points_this_turn + " = " + (roll_of_dice + this.cummulative_points_this_turn));
			
			this.cummulative_points_this_turn =   roll_of_dice + this.cummulative_points_this_turn;
			
//			System.out.println("this.cummulative_points_this_turn =" + this.cummulative_points_this_turn);
//			System.out.println(" where [index] = " + index + " and round = " + roundOfPlay);
//			System.out.println("2.)");
//			System.out.println("this.pointsPerRound[index] =  this.cummulative_points_this_turn = ");
//			System.out.println("                                   = "+ this.cummulative_points_this_turn);
			
			this.pointsPerRound[index] =  this.cummulative_points_this_turn;
			
//			System.out.println("this.pointsPerRound["+index+"] =" + this.pointsPerRound[index]);
		}

		
//		System.out.println("\n///////   Final output   ////////");
//		System.out.println("////////////////////////////////////////////////////////////////////////////////////////");
//		System.out.println(" this.pointsPerRound[index] =  " + this.pointsPerRound[index]);
//		System.out.println("////////////////////////////////////////////////////////////////////////////////////////");
//		System.out.println("");
//		
		
	return this;
	}
	////////////////////////////////////////////////////////////////////////////////////////
	
	public SkunkController playersAllAdditionalRolls(SkunkUI UI, SkunkController controller, int m, Player p, Dice myDice, int roundOfPlay) 
	{
		int roll_of_dice = 0;
		String again = "Y";
		
			while ((again.equals("Y") || again.equals("y")) && myDice.getSkunkEndsTurn() == false)
			{
				//Does the player want to roll again???
				
				again = UI.promptAndReturn("\nWant to roll again, " + p.get_player_name() + "? 'Y' = Yes 'N' = No");
				
				if ((again.equals("Y") || again.equals("y")))
				{
					
					
					// Roll again
					
					//increase the number of rolls inside patron
					p.rolls_this_turn ++;
					
					
					roll_of_dice = myDice.roll_dice(p, roundOfPlay, UI, controller);
					
			
					
					//1. set total points - Add the points to the previous point total.
					
					p = set_points_2nd_thru_nth_roll_first_turn(roll_of_dice, roundOfPlay);
					
					
					//CONTROLLER WRITES < VIEW READS
					
					
					//2. Set points in the arraylist
					
					int index = p.get_player_index();
					Player p2 = new Player(p);
					p2 = controller.list.get(index);
					
				
					
					p2.setDataInTotalPointsArray(roundOfPlay, p.get_points_this_round_of_play(roundOfPlay));
					
					controller.list.set(index, p2);
					
					UI.print(p.player_name + ":  ");
					
					UI.printRollPoints(p.rolls_this_turn, roll_of_dice);
						
					UI.print("Total points this turn = " + p.cummulative_points_this_turn);
					
					UI.printLine();
					
				}//end if ((again.equals("Y") || again.equals("y")))
			
		}//end while ((again.equals("Y") || again.equals("y")) && myDice.getSkunkEndsTurn() == false)
				
		shortPauseGame();
	
		return controller;
	}
	
	public Boolean set_is_winner()
	{
		this.is_winner = true;
		
	return this.get_is_winner();
	}


	public void shortPauseGame() 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}
