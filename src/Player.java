
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
	
	public String get_player_name()
	{
		
	return this.player_name;
	}
	
	public void set_points_this_turn(int points)
	{
		this.points_this_turn = points;
	}
	
	
	public void set_points_this_round(int points)
	{
		set_points_this_turn(points);
		this.points_this_round_of_play = (this.points_this_round_of_play + points);
	}
	
	/////////////////////////////////////////////////Added new////////////////////////////
	public int set_points_this_round(int points, int round, Player p)
	{		
		p.pointsPerRound[round] = points;
		
	return p.pointsPerRound[round];
	}
	
	public int get_points_this_round()
	{
		
	return this.points_this_round_of_play;
	}
	///////////////////////////////Added this///////////////
	public int get_points_this_round(int round, Player p)
	{
		int points = 0;
		points = p.pointsPerRound[round];
		
	return points;
	}
	
	public int get_points_this_turn()
	{
		
	return this.points_this_turn;
	}
	

}
