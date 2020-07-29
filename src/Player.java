
public class Player 
{
	String player_name = "";
	int player_index;
	int points_this_round_of_play = 0;
	int points_this_turn = 0;
	int total_points = 0;
	int rolls_this_turn = 1;
	
	Dice dice = new Dice();
	/////////////////////////////////////Added new/////////////////////
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
	}
	
//////////////////////////////Getters//////////////////////////////
	
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
		
	return this.pointsPerRound[round];
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
	
	public int get_points_this_turn()
	{
		
	return this.points_this_turn;
	}
	
	public int get_total_points()
	{
		
	return this.points_this_turn;
	}
	
	public int rolls_this_turn()
	{
		
	return this.rolls_this_turn;
	}
	
	//////////////////////////////Setters//////////////////////////////
	public void initializeArray()
	{
		for (int i = 0; i < 5; i++)
		{
			this.pointsPerRound[i] = 0;
		}
		
	}
	public void setDataInTotalPointsArray(int round, int points)
	{
		int index = round--;
		this.pointsPerRound[index] = points;
		
	}
	
	
	public Player set_points_first_roll_first_turn(int points, int round)
	{
		
		this.points_this_turn =  points;
		System.out.println("///////////set_points_first_roll_first_turn = " + points + ", round = " + round);
		
		this.pointsPerRound[round] =  points;
		// arraylist.set(0, 11);
		 
		System.out.println("////////////this.pointsPerRound[round] =  points = "+ this.pointsPerRound[round]);
		
	return this;
	}
	
	public void set_points_this_turn(int points, int round)
	{
		this.points_this_turn =  this.points_this_turn + points;
		
		System.out.println("set_points_this_turn = " + points + ", round = " + round);
		
		if (points !=0)
		{
		this.pointsPerRound[round] = this.get_points_this_turn();
		}
		else 
			this.pointsPerRound[round] = 0;
		
		System.out.println("BAD METHOD in player class!!!!!!!!!!!!! set_points_this_turn = this.get_points_this_turn() =" + this.get_points_this_turn());
	}
	
	
	public SkunkController set_array(SkunkController controller, int player_number, SkunkUI UI, int roll_of_dice, int roundOfPlay)
	{
		int roll = this.get_points_this_turn();
		controller.list.set(player_number, this).set_points_this_turn(roll_of_dice, roundOfPlay);
		
		//System.out.println("FIRST ROLL () : pointsPerRound[roundOfPlay]=" + controller.list.get(player_number).get_points_this_turn());
		
		//UI.printRollPoints(this.rolls_this_turn, roll_of_dice);
		
	return controller;
	}

	public void set_points_ALL_rounds_to_zero() 
	{
		for (int i =0; i<5; i++)
		{
			this.pointsPerRound[i] = 0;
		}
		
	}
	///////////////////////////////////////////WORKS PERFECTLY//////////////////////////////////////////////
	public SkunkController playersFirstRoll(SkunkUI UI, SkunkController controller, Player p, Dice myDice, int roundOfPlay) 
	{
		int roll_of_dice = 0;
		
		//Player takes the first roll of the dice in his turn. roll_of_dice contains the sum of the two die.
		roll_of_dice = myDice.roll_dice(p,(roundOfPlay));
		
		
		//set total current points into the array inside the Player inside the arraylist.
		p = set_points_first_roll_first_turn(roll_of_dice, roundOfPlay);
		
		int index = p.get_player_index();
		Player p2 = new Player(p);
		p2 = controller.list.get(index);
		p2.setDataInTotalPointsArray(roundOfPlay, roll_of_dice);
		controller.list.set(index, p2);
		

		//Output
		

		for (Player q : controller.list) 
		{   
		    System.out.print(""+q.get_player_name() + " " + q.get_player_index() + " ");
		    System.out.println("list.get(index).pointsPerRound[roundOfPlay] ="+ controller.list.get(q.get_player_index()).pointsPerRound[roundOfPlay]);
		}
		
		UI.printRollPoints(p.rolls_this_turn, roll_of_dice);
	
	return controller;
	}
	
	private Player set_points_2nd_thru_nth_roll_first_turn(int roll_of_dice, int roundOfPlay) 
	{
//		System.out.println("/////////////////////////// OK /////////////////////////////////////////////////////////");
//		System.out.println("///////////set_points_2nd_thru_nth_roll_first_turn(int roll_of_dice, int roundOfPlay) = ");
//		System.out.println("roll_of_dice + this.points_this_turn = "+ roll_of_dice + "+" + this.points_this_turn + " = " + (roll_of_dice + this.points_this_turn));
//		System.out.println("/////////////////////////// OK /////////////////////////////////////////////////////////");
//		System.out.println("");
		this.points_this_turn =  this.points_this_turn + roll_of_dice;
		
		this.pointsPerRound[roundOfPlay] =  this.pointsPerRound[roundOfPlay] + roll_of_dice;
//		System.out.println("/////////////////////////// OK /////////////////////////////////////////////////////////");
//		System.out.println(" this.pointsPerRound[roundOfPlay] = this.pointsPerRound[roundOfPlay] + roll_of_dice = " + this.pointsPerRound[roundOfPlay]);
//		System.out.println("////////////////////////////////////////////////////////////////////////////////////////");
//		System.out.println("");
		
		
		return this;
	}
	////////////////////////////////////////////////////////////////////////////////////////
	
	public void playersAllAdditionalRolls(SkunkUI UI, SkunkController controller, int m, Player p, Dice myDice, int roundOfPlay) 
	{
		int roll_of_dice = 0;
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
					
					//m=0 is the player index and the roundofplay
					roll_of_dice = myDice.roll_dice(p, roundOfPlay);
					
				//works perfect
					
					//1. set total points - Add the points to the previous point total.
					p = set_points_2nd_thru_nth_roll_first_turn(roll_of_dice, roundOfPlay);
					
					
					//CONTROLLER WRITES < VIEW READS
					
				 
					
					//2. Set points in the arraylist
					
					int index = p.get_player_index();
					Player p2 = new Player(p);
					p2 = controller.list.get(index);
					p2.setDataInTotalPointsArray(roundOfPlay, roll_of_dice);
					controller.list.set(index, p2);
					
					controller.list.get(m).set_points_this_turn(roll_of_dice, roundOfPlay);
					
					//p.set_points_this_round(p.get_points_this_turn(), roundOfPlay, p);
					System.out.println("\\\\\\\\\\Controller set \\\\\\p.[m] = " + (m));
					System.out.println("\\\\\\\\\\\\\\\\pointsPerRound[m]=" + p.get_points_this_round_of_play((m)));
					
					//
					UI.printRollPoints(p.rolls_this_turn, roll_of_dice);
						
					UI.print("Total points this turn = " + p.get_points_this_turn());
					
				}//end if ((again.equals("Y") || again.equals("y")))
			
		}//end while ((again.equals("Y") || again.equals("y")) && myDice.getSkunkEndsTurn() == false)
				
		pauseGame();
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

}
