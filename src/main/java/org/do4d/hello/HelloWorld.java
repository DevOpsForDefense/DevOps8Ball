package org.do4d.hello;

/**
 * This hello world application is used to exercise a proof-of-concept 
 * Continuous Delivery pipeline for the DevOps for Defense meetup.
 * 
 * @author JD Black
 *
 */
public class HelloWorld {

	/**
	 * Default constructor.
	 */
	public HelloWorld() {
		// default constructor
	}

	/**
	 * Performs the task of saying hello.
	 * 
	 * @param name the name to greet
	 * @return the greeting string
	 */
	public String sayHello(String name) {
		if ((name == null) || (name.trim().isEmpty())) {
			return "Hello World!";
		}
		return "Hello " + name.trim() + "!";
	}

	/**
	 * The application runner.  Reads a name from the arguments and provides a greeting using
	 * the HelloWorld class.
	 * 
	 * @param args the name to greet
	 */
	public static void main(String[] args) {
		HelloWorld hw = new HelloWorld();
		String name = null;
		if (args.length > 0) {
			for (String arg : args) {
				name = name + arg + " ";
			}
			name = name.trim();
		}
		System.out.println(hw.sayHello(name));
	}
}
