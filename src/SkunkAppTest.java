import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SkunkAppTest {

	@Test
	public void testGetNumberofPlayer() {
		SkunkApp sk = new SkunkApp();
		sk.getNumberOfPlayers();
		assertEquals(0, sk.getNumberOfPlayers());
	}

	@Test
	public void testSetNumberOfPlayers() {
		SkunkApp sk = new SkunkApp();
		sk.setNumberOfPlayers(2);
		assertEquals(2, sk.getNumberOfPlayers());
	}

//	@Test
//	public void testPlayGame() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testRollAgain() {
		SkunkApp sk = new SkunkApp();
		sk.rollAgain();
		assertEquals(true, sk.rollAgain());
	}
	
	@Test
	public void testDoesAnyPlayerHave100PointsYet() {
		
		SkunkApp sk = new SkunkApp();
		
		//Current round is round 3.
		sk.roundOfPlay = 3;
		
		//Create two players with identical point totals
		Player player1 = new Player("Rambo", 0);
		Player player2 = new Player("Lionel", 1);
		
		//Each player has 50 points in round 1, and 40 points in round 2.
		player1.setDataInTotalPointsArray(1, 50);
		player2.setDataInTotalPointsArray(1, 50);
		player1.setDataInTotalPointsArray(2, 40);
		player2.setDataInTotalPointsArray(2, 40);
		
		SkunkController controller = new SkunkController();
		SkunkUI UI = new SkunkUI();
		ArrayList<Player> hasMoreThan99Points = new ArrayList<Player>();
		
		
		//set each player into the app's player list
		controller.list.add(player1);
		controller.list.add(player2);
		
		//test player number - fails
		//assertEquals(2, sk.getNumberOfPlayers());
		
		//test that player has a point total of 90
		assertEquals(90, player1.get_total_game_points());
		
		//This should be returned by the following method Test. It is an empty list.
		ArrayList<Player> tiedPlayers = new ArrayList<Player>();
		
		//Test this method - ArrayList<Player> hasMoreThan99Points should be empty.
		assertEquals(tiedPlayers, findTiedPlayers(UI, hasMoreThan99Points, 44, 90));
		
		//Test this method
		equals(doesAnyPlayerHave100PointsYet(UI, controller, 2, 3));
		
		//Add 10 points into round = 3, index = 2 so that both players have 100 points.
		
	
		
	}

	private Object doesAnyPlayerHave100PointsYet(SkunkUI uI, SkunkController controller, int i, int j) {
	{
			ArrayList<Player> hasMoreThan99Points = new ArrayList<Player>();
			
			for (int i1 = 0; i1 < 2; i1++)	
			{
					//check point totals
					for (Player f: controller.list)
					{
						if (f.get_total_game_points() > 99)
						{
							hasMoreThan99Points.add(f);
						}
					}		
			}
			
			if (hasMoreThan99Points.size() == 0)
			{
				//There is no winner, yet. Keep playing rounds of the game.
			}
			else if (hasMoreThan99Points.size() == 1)
			{
				//player f is the winner
				//System.out.println("\n" + hasMoreThan99Points.get(0).get_player_name() + " wins the game!!!");
				uI.printCurrentlyWinning(hasMoreThan99Points.get(0).get_player_name(), 3, hasMoreThan99Points.get(0) );
				
				//Winner declared. Call function to exit the game HERE.
				exitGame(uI.getUserInputToExitGame());
				
			}
			else if (hasMoreThan99Points.size() > 1)
			{
				
					//Check who has more points and declare that player the winner
					String winner = currentlyWinning(controller);
					int indexOfWinnerInsideList = 0;
					//indexOfWinnerInsideList = indexOfPlayerCurrentlyWinningTheGame(controller);
					
				if (indexOfWinnerInsideList != 44)
				{
					//point total of the winner
					int winningPointTotal = hasMoreThan99Points.get(indexOfWinnerInsideList).get_total_game_points();
					
					uI.printCurrentlyWinning(winner, 3, hasMoreThan99Points.get(indexOfWinnerInsideList));
					
					//Winner declared. Call function to exit the game HERE.
					exitGame(uI.getUserInputToExitGame());
				}
				
				else //returns "no player is currently winning"
				{			
					//if 2 (or more) players tie on points, then the winner is the player with the smallest index./////////
					ArrayList<Player> tied = new ArrayList<Player>();
					
					//point total of the winner
					int winningPointTotal = hasMoreThan99Points.get(indexOfWinnerInsideList).get_total_game_points();
					
					
					tied = (ArrayList<Player>) findTiedPlayers(uI, hasMoreThan99Points, 0, 90);
					//declare the winner to be the last player in the list
					int size = tied.size();
					int index = size -1;
					Player tiedPlayerWithLargestIndex = new Player(tied.get(index));
					
					uI.printCurrentlyWinning(tiedPlayerWithLargestIndex.get_player_name(), 3, tiedPlayerWithLargestIndex);
					
					//Winner declared. Call function to exit the game HERE.
					exitGame(uI.getUserInputToExitGame());
				 }
				
			}
	}
		return null;
	}

    private String currentlyWinning(SkunkController controller) 
     {
        	Player p = null;
        	String name = "";
        	
        	//which player has the most points?
        	for (Player q: controller.list)
    		{
    			//p = 0, 1, 2, 3
        		Boolean [] winning = new Boolean[2];
    			
    			for (int m = 0; m < 2; m++)
    			{
    				p = controller.list.get(m);
    				
    				if (q.get_player_index() != p.get_player_index())
    				{
    					if (q.get_total_game_points() > p.get_total_game_points())
    					{
    						winning[p.get_player_index()] = true;
    						//System.out.println("q.get_total_game_points() = "+q.get_total_game_points() + " > " + p.get_total_game_points()+" =p.get_total_game_points() ");
    					}
    					else
    					{
    						winning[p.get_player_index()] = false;
    					}
    				
    				}
    				else
    				{
    					winning[q.get_player_index()] = true;
    				}
    			}//end for loop
    			
    			//System.out.println("\n");
    			
    			int countWins = 0;
    			
    			for (int i = 0; i < 2; i++)
    			{	
    				//System.out.println("winning[" + i + "]" + winning[i]);
    				//System.out.println("countWins i=" + i + "=" + countWins + " for " + q.get_player_name());
    				
    				if (winning[i].equals(true))
    				{
    					countWins++;
    				}
    	
    				if (countWins == 2)
    				{
    					
    				name = q.get_player_name();
    				return name;
    				}
    				else
    				{
    				
    				name = "No one";	
    				}
    			}
    		}
    	return name; 	
        }

	public void exitGame(String userInput)
	{
		String exitTheGame = userInput;
		
		
		if ((exitTheGame == "Y")||(exitTheGame == "y")||(exitTheGame == "Yes")||(exitTheGame == "yes")||(exitTheGame == "YES"))
		{
			System.exit(0);
		}
		else if ((exitTheGame == "N")||(exitTheGame == "n")||(exitTheGame == "No")||(exitTheGame == "no")||(exitTheGame == "NO"))
		{
			//Do whatever here
		}
	}

	private Object findTiedPlayers(SkunkUI uI, ArrayList<Player> hasMoreThan99Points, int i, int j) {
	{
			ArrayList<Player> tiedPlayers = new ArrayList<Player>();
			SkunkUI UI = new SkunkUI();

			int indexOfWinnerInsideList = 0;
			int winningPointTotal = 90;
			
			
			for (Player u : hasMoreThan99Points)
			{
				
				if ( winningPointTotal == (hasMoreThan99Points.get(indexOfWinnerInsideList ).get_total_game_points()) )
				{
					UI.print("\n player tie! ");
					tiedPlayers.add(u);
				}
			}
	return tiedPlayers;
	}

	}
}
