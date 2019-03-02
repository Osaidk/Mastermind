package assignment2;

class GameMain {

	public static void main(String [] args) {
		Game Player;
		if (args.length!=0)
			Player = new Game(args[0].equals("1"));
		else Player = new Game(false);
		Player.runGame();
		}
	}
