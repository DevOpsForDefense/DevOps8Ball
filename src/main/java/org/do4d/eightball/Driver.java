package org.do4d.eightball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

	public static void main(String[] args) throws IOException {
		Magic8Ball m8b = new StandardMagic8Ball();
		
		String question = "";
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (!question.equals("q") || !question.equals("Q")) {
			System.out.println("What is your question?  [enter q to quit]");
			question = in.readLine().trim();
			System.out.println("DEBUG:  you asked - " + question  );
			m8b.ask(question);
			m8b.shake();
			System.out.println(m8b.look());
		}

	}

}
