package assignment2;
import java.util.*;


public class Game {
	boolean Test_mode=false;
	Scanner keyboard;
	String code;
	String input;
	boolean result=false;
	boolean win=false;
	int tries;
	ArrayList <String> History = new ArrayList<String>();

	
	public Game (boolean state) {
		this.Test_mode=state;
	    keyboard = new Scanner(System.in);
	}
	
	public void Welcome_Msg() {
		System.out.println("Welcome to Mastermind.");
	}
	
	public String Start_Game() {
		System.out.println("Do you want to play a new game? (Y/N):");
		String input = keyboard.nextLine();
		return input;
	}
	
	public void runGame() {
		Welcome_Msg();
		input = Start_Game();
        Input user_input= new Input();
    	Code Validity;
		while (user_input.check_continuity(input)) {
			tries=GameConfiguration.guessNumber;
			History.clear();
			win=false;
			code = SecretCodeGenerator.getInstance().getNewSecretCode();
			Validity = new Code(code);
			if (Test_mode == true)
				System.out.println("Secret code:"+ " " + code);
			while (tries > 0 && win==false) {
				while (!result) {
					System.out.println();
					System.out.println("You have"+" " +tries+ " "+"guess(es) left.");
					System.out.println("Enter guess:");
					input = keyboard.nextLine();
					result=user_input.check_input(input);
					if (input.equals("HISTORY")) {
						for (int i=0; i < History.size(); i++) {
							Validity.check_code(History.get(i));
						}
					}
					else if (result == false) {
						System.out.println("INVALID_GUESS");
					}
					
				}
				result = false;
				History.add(input);
				Validity.check_code(input);
				if (Validity.check_win()) {
					System.out.println("You win!");
					win =true;
					}
				tries--;
				}
			if (win == false) {
				System.out.println("You lose! The pattern was "+code);

			}
			input = Start_Game();
		}
	}
}

