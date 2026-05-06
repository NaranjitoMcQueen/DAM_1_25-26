package arguments.exemple;

public class TestArguments {

	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println("arg0: " + args[0]);
		} else {
			System.out.println("Sense arguments");
		}
		if (args.length > 1) {
			System.out.println("arg1: " + args[1]);
		}
		if (args.length > 2) {
			System.out.println("arg2: " + args[2]);
		}
		if (args.length > 3) {
			System.out.println("arg3: " + args[3]);
		}
	}
}
