import static org.junit.Assert.*;

import org.junit.Test;

public class DieTest {

	@Test
	public void testDie() {
		Die die = new Die();
		die.setValue(0);
		assertEquals(0, die.getValue());
		 
	}

	@Test
	public void testGetValue() {
		Die die = new Die();
		die.getValue();
		assertEquals(0, die.getValue());
	}

	@Test
	public void testSetValue() {
		Die die = new Die();
		die.setValue(0);
		assertEquals(0, die.getValue());
	}

	@Test
	public void testRoll() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowDie() {
		fail("Not yet implemented");
	}

}
