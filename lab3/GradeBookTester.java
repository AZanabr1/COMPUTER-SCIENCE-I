import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTester {

	private GradeBook g1;
	private GradeBook g2;

	@Before
	public void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);

		g1.addScore(67.0);
		g1.addScore(79.0);
		g2.addScore(89.0);
		g2.addScore(50.0);

	}

	@After
	public void tearDown() throws Exception {
		g1 = null;
		g2 = null;

	}

	@Test
	public void testGradeBook() {
	}

	@Test
	public void testGetScoreSize() {
		assertEquals(2, g1.getScoreSize());
		assertEquals(2, g2.getScoreSize());
	}

	@Test
	public void testAddScore() {
		assertEquals("67.0 79.0 ", g1.toString());
		assertEquals("89.0 50.0 ", g2.toString());
		assertEquals(2, g1.getScoreSize());
		assertEquals(2, g2.getScoreSize());
	}

	@Test
	public void testSum() {
		assertEquals(146.0, g1.sum(), 0.0001);
		assertEquals(139.0, g2.sum(), 0.0001);
	}

	@Test
	public void testMinimum() {
		assertEquals(67.0, g1.minimum(), 0.0001);
		assertEquals(50.0, g2.minimum(), 0.0001);
	}

	@Test
	public void testFinalScore() {
		assertEquals(79.0, g1.finalScore(), 0.001);
		assertEquals(89.0, g2.finalScore(), 0.001);
	}

	@Test
	public void testToString() {
		assertEquals("67.0 79.0 ", g1.toString());
		assertEquals("89.0 50.0 ", g2.toString());
	}

}
