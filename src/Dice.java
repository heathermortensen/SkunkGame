
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
	
	public int roll_dice(Player p)
	{
		int sum = 0;
		
		int roll_1 = die_1.roll();
		int roll_2 = die_2.roll();
		
		sum = roll_1 + roll_2;
		
		System.out.println("" + die_1.showDie(roll_1));
		
		System.out.println("");
		
		System.out.println("" + die_2.showDie(roll_2));
		
		int skunkCount = checkIfSkunk(roll_1,roll_2);
		
		//player rolls at least one 1.
		
		if (skunkCount > 0)
		{
			sum = 0;
			p.set_points_this_turn(0);
			this.skunkEndsTurn = true;
		}
		
		//player rolls two 1's.
		
		if (skunkCount == 2)
		{
			sum = 0;
			p.set_points_this_turn(0);
			
			//void all points accumulated by player
			p.set_points_this_round(0);
			
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
}
