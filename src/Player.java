
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
	
	
	
	public void set_points_this_turn(int points)
	{
		this.points_this_turn =  points;
	}
	
	public void set_points_this_round(int points)
	{
		this.points_this_turn = this.points_this_turn + points;
	}

	public void set_points_this_round(int points, int round, Player p)
	{		
		this.pointsPerRound[round] = this.pointsPerRound[round] + points;
		
	}
	
	public SkunkController set_array(SkunkController controller, int player_number, SkunkUI UI, int roll_of_dice, int roundOfPlay)
	{
		int roll = this.get_points_this_turn();
		controller.list.set(player_number, this).set_points_this_round(roll_of_dice, roundOfPlay, this);
		
		System.out.println("FIRST ROLL () : pointsPerRound[roundOfPlay]=" + controller.list.get(player_number).get_points_this_turn());
		
		UI.printRollPoints(this.rolls_this_turn, roll_of_dice);
		
	return controller;
	}


}
