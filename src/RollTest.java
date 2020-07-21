import static org.junit.Assert.*;

import org.junit.Test;

public class RollTest {

	@Test
	public void testRoll() {
		Roll roll = new Roll();
				
	}

	@Test
	public void testRollDie() {
		
	}

	@Test
	public void testGetLastTotal() {
		Roll roll = new Roll();
		roll.getLastTotal();
		assertEquals(1, roll.getLastTotal());
	}

}
