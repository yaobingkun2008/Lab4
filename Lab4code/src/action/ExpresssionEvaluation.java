package action;

import java.util.Scanner;

public class ExpresssionEvaluation {
	private static final char COM_MARK = '!';
	private static final String INPUT_PROMPT = ">";
	private static final String END_COM = "###";
	
	public static void main(final String[] args)
	{
		final Expression expression = Expression.instance();
		final SimplifyCommand simplifyCommand = SimplifyCommand.instance();
		final DerivationCommand derivationCommand = DerivationCommand.instance();
		System.out.print(INPUT_PROMPT);
		String line;
		final Scanner reader = new Scanner(System.in);
		line = reader.nextLine();
		while(!line.equals(END_COM)){
			try{
				if (line.charAt(0) == COM_MARK) {
					if (line.substring(1, 4).equals("d/d")) {
						derivationCommand.input(line);
						derivationCommand.execute();
						expression.printDer();
					}
					else if (line.substring(1,9).equals("simplify")) {
						simplifyCommand.input(line);
						simplifyCommand.execute();
						expression.printSim();
					}
				}
				else{
					expression.input(line);
					expression.printOri();
				}
			}catch (Exception e) {
				System.out.println("Error! "+e.getMessage());
			}
			System.out.print(INPUT_PROMPT);
			line = reader.nextLine();
		}
		reader.close();
	}
}
