import static org.junit.Assert.*;

import org.junit.Test;

public class SkunkControllerTest {

	@Test
	public void testCreatePlayers() {
		SkunkController sc = new SkunkController();
		sc.createPlayers(1);
		assertEquals(1, sc.createPlayers(1));
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
