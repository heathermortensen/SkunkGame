import java.util.ArrayList;
import java.util.List;


//THIS FILE RUNS THE CODE!!!!!!!!!!!!!!!!!!!!!!!
public class SkunkController
{
	int numPlayers = 0;
	int kitty = 0;
	
	Boolean wantsToQuit;
	Boolean oneOrMoreRoll;
	
	ArrayList<Player> list = new ArrayList<Player>();
	
	SkunkUI ui = new SkunkUI();
	
	public ArrayList<Player> createPlayers(int numberOfPlayers)
	{
		//SkunkUI ui = 
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
	
//	public void playerTotals(int round)
//	{
//		for (Player i: list) 
//		{
//			//call skunk ui here
//			ui.printPointsThisTurn(i);
//		    
//		}
//		
//		//need to make this set all the rounds and point totals and stuff here//////////////////////////
//		//////////////////////////////////////////////////////////////////////////////////
//		
//	}
	
	public static void main(String[] args) 
	{
		SkunkApp app = new SkunkApp();
		
		app.playGame();
	}

}
