import static org.junit.Assert.*;

import org.junit.Test;

public class SkunkUITest {

	@Test
	public void testGetNumPlayersFromUser() {
		SkunkUI si = new SkunkUI();
		si.getNumPlayersFromUser();
		assertEquals(1,si.getNumPlayersFromUser());
	}

	@Test
	public void testGetPlayerNamesFromUser() {
		SkunkUI si = new SkunkUI();
		si.getPlayerNamesFromUser(1, 1);
		assertEquals(1,si.getPlayerNamesFromUser(1,1 ));
	}

	@Test
	public void testPromptAndReturn() {
		SkunkUI si = new SkunkUI();
		si.promptAndReturn(null);
		assertEquals(null,si.promptAndReturn(null));
	}

	@Test
	public void testPrint() {
		SkunkUI si = new SkunkUI();
		si.print(null);
		//assertEquals(null, si.print(null));
	}

}
