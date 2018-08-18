package org.do4d.eightball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Magic8BallTest {

	@Test
	void testStandardUsage() {
		Magic8Ball b = new StandardMagic8Ball();
		
		b.ask("Will this test pass?");
		b.shake();
		String answer = b.look();
		assertNotNull(answer);
		
	}

	@Test
	void testForgotToShake() {
		Magic8Ball b = new StandardMagic8Ball();
		String answer = b.look();
		b.ask("Do I have to shake this thing?");
		assertEquals(answer, b.look());
	}

	@Test
	void testShakingIsGenerallyRandom() {
		Magic8Ball b = new StandardMagic8Ball();
		int numChanged = 0;
		int numSame = 0;
		
		String last = b.look();
		for(int i=0; i<100; i++) {
			b.shake();
			String answer = b.look();
			if (last.equals(answer)) {
				numSame++;
			} else {
				numChanged++;
			}
		}
		assertTrue(numChanged > numSame);
	}

}
