import java.util.Scanner;

public class MineSweeperGame {

	
	public static void playerActions(MineSweeper game, char userChar, Scanner scnr) {	
		do {
			//System.out.println(game.toStringMines()); For testing
			System.out.println(game.toStringBoard());
			System.out.println("\n" + "Type coordinates in \"x y\" format to pick a square. ");
			int y = scnr.nextInt();
			int x = scnr.nextInt();
			System.out.println("X: " + y);
			System.out.println("Y: " + x);
			
			System.out.println("Type 'O' to open");
			System.out.println("Type 'F' to flag a square");
			System.out.println("Type '?' to question a square for suspicion");
			userChar = scnr.next().charAt(0);
			
			if (userChar == 'O') {
				game.markTile(x, y, 0);
			}
			else if (userChar == 'F') {
				game.markTile(x, y, 3);
			}
			else if (userChar == '?') {
				game.markTile(x, y, 2);
			}
			else {
				System.out.println("Invalid input. Please try again.");
				userChar = scnr.next().charAt(0);
			}
		} while (game.getStatus() == "play"); //Checks if game is still playing at the end of each loop.
	} 
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		char userChar = ' ';
		
		while (userChar != 'q') {
			System.out.println("Welcome to minesweeper! Please type the size of your board in \"x y\" format.");
			int xSize = scnr.nextInt();
			int ySize = scnr.nextInt();
			MineSweeper game = new MineSweeper(xSize, ySize);
		
			playerActions(game, userChar, scnr); //Only exits once game is over.
			
			if (game.getStatus() == "win") {
				System.out.println(game.toStringBoard()); //Prints winning board
				System.out.println("You won!");
				System.out.println("Type anything to play another game, and type q to quit: ");
				userChar = scnr.next().charAt(0);
			}
			else if (game.getStatus() == "lose") {
				System.out.println(game.toStringBoard());
				System.out.println("You lost!");
				System.out.println("Type anything to play another game, and type q to quit: ");
				userChar = scnr.next().charAt(0);
			}
		}
			/*TODO: The game works! 
			 * Moriarty: Use constants for the variables and numbers to make code more readable.
			 */
	}
}
/* After this, create a text based user interface to allow the user to play a game of minesweeper.  
 * This should be implemented using your Minesweeper class and a class MinesweeperGame.java which houses a main.
 * Your user interface should be text based and operate via the console.
   Your user interface should allow the user to pick a square to reveal or to flag a square.
   The user should identify what square they want to reveal or flag by typing (x,y) coordinates.   
   Alter your minesweeper class that represents the board via text to show the user the x,y coordinates of the various squares on the board.
	Your code should display the state of the game board to the user after each move the user makes.
	When the game is over the user should have the opportunity to play another game from scratch or quit the application.
*/