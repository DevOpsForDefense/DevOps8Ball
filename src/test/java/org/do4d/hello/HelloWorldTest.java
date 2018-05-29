package org.do4d.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class HelloWorldTest {

	@Test
	void testHelloWorld() {
		HelloWorld hw = new HelloWorld();
		assertNotNull(hw);
	}

	@Test
	void testSayHello() {
		
		String[] in = {null, "", " ", "Tony Stark", "  Bob  "};
		String[] ex = {"Hello World!", "Hello World!", "Hello World!", "Hello Tony Stark!", "Hello Bob!"};
		
		HelloWorld hw = new HelloWorld();
		
		for(int i=0; i<in.length; i++) {
			assertEquals(ex[i], hw.sayHello(in[i]));
		}
		
	}

}
