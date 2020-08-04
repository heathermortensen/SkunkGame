
public class Dice 
{
	private Die die_1 = new Die();
	private Die die_2 = new Die();
	private boolean skunkEndsTurn = false;
	
	Dice()
	{
		
		die_1.setValue(0); 
		die_2.setValue(0); 
	}
	
	public boolean getSkunkEndsTurn()
	{
		return this.skunkEndsTurn;
	}
	
	public int roll_dice(Player p, int round, SkunkUI ui, SkunkController controller)
	{
		int sum = 0;
		int index = round -1;
		
		int roll_1 = die_1.roll();
		int roll_2 = die_2.roll();
		
		sum = roll_1 + roll_2;
		
		shortPauseGame();
		
		System.out.println("" + die_1.showDie(roll_1));
		
		System.out.println("");
		
		System.out.println("" + die_2.showDie(roll_2));
		
		int skunkCount = checkIfSkunk(roll_1,roll_2);
		
		//player rolls at least one 1.
		
		if (skunkCount == 1)
		{
			sum = 0;
			p.set_points_this_turn(0, round);
			//p.set_points_this_turn(0, index);
			p.cummulative_points_this_turn =0;
			//p.pointsPerRound[round] =  0;
			p.pointsPerRound[index] =  0;
			ui.printSkunk(1);
			this.skunkEndsTurn = true;
			
		    
		}
		
		//player rolls two 1's.
		
		if (skunkCount == 2)
		{
			sum = 0;
			controller.list.get(p.get_player_index()).cummulative_points_this_turn = 0;
			//p.cummulative_points_this_turn = 0;
			controller.list.get(p.get_player_index()).set_points_this_turn(0, round);
			//p.set_points_this_turn(0, round);
			//p.pointsPerRound[index] =  0;
			controller.list.get(p.get_player_index()).pointsPerRound[index] = 0;
			
			//TEST THIS!!!//////////////////////////////////////////////This might be failing. Barley ever executes.
			//void all points accumulated by player
		
			while (index >= 0)
			{
				controller.list.get(p.get_player_index()).pointsPerRound[index] = 0;
				//p.pointsPerRound[index] =  0;
				
				//Debug
				System.out.println("index = " + index + " & " + p.player_name + "'s points for round " + (index+1) + " = " + p.pointsPerRound[index]);
				index--;
			}
			
			ui.printSkunk(2);
			
			this.skunkEndsTurn = true;
		}
		
		return sum;
	}
	
	public int checkIfSkunk(int rollOfDie1, int rollOfDie2)
	{
		//this value counts the number of skunks rolled by the dice
		int skunkCount = 0;
		
		if (rollOfDie1 == 1)
		{
			skunkCount ++;
		}
		if (rollOfDie2 == 1)
		{
			skunkCount ++;
		}
		
		return skunkCount;
		
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
