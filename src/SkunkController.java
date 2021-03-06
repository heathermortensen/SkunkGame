import java.util.ArrayList;


public class SkunkController
{
	int numPlayers = 0;
	//What is the kitty?
	int kitty = 0;
	
	Boolean wantsToQuit;
	Boolean oneOrMoreRoll;
	
	//A list of players in the skunk game
	ArrayList<Player> list = new ArrayList<Player>();
	
	//Essentially, a 2D matix made up of all player.pointsPerRound[5] arrays
	//int[][] gameMatrix = new int[list.size()][5];
	
	SkunkUI ui = new SkunkUI();
	
	public ArrayList<Player> createPlayers(int numberOfPlayers)
	{ 
		String name;
		
		for (int i = 0; i < numberOfPlayers; i++)
		{
			ArrayList<Player> list = new ArrayList<Player>();
			
			name = ui.getPlayerNamesFromUser(numberOfPlayers, (i+1));
			
			Player p = new Player(name, i);
			
			this.list.add(p);			
		}
		
	return list;
	}
	
    public void incrementRoundOfPlay(SkunkApp app)
    {
   	 	app.roundOfPlay++;
    }
	
	public int get_points_Per_Round(int playerNum, int round)
	{
		
		 Player p = this.list.get(playerNum);
		 int points = p.get_points_this_round_of_play(round);
		// System.out.println("ARRAY POINTS: SkunkController.get_points_Per_Round = p.points_this_round_of_play = points" + points);
			
	return points;
	}
	
	
	public static void main(String[] args) 
	{
		SkunkApp app = new SkunkApp();
		
		app.playGame();
	}



}
