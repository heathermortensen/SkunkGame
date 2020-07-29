import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player player = new Player("yaz",1);
		player.get_player_name();
		assertEquals("yaz", player.get_player_name());
	}

	@Test
	public void testGet_player_name() {
		Player player = new Player("yaz",1);
		assertEquals("yaz", player.get_player_name());
	}

	@Test
	public void testSet_points_this_turn() {
		Player player = new Player("yaz",1);
		player.set_points_this_turn(10,0);
		assertEquals(10, player.get_points_this_turn());
		
	}

	@Test
	public void testGet_points_this_round() {
		Player player = new Player("yaz",1);
		player.get_points_this_turn();
		assertEquals(0, player.get_points_this_turn());
	}

}
