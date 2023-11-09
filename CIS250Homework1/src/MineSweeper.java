import java.util.Random;
/**
 * minesweeper class provides the data
 * and methods for a minesweeper game
 *
 * Level 1 - data & methods to implement 
 *           Mines, Clues, Tiles, basic Board characters,
 *           and opening/marking tiles
 *           Level 1 DONE
 *           
 * Level 2 - Additional data & methods to support game status
 *           and extended Board characters
 * 
 * minesweeper.java
 * spring 2004
 *
 */
public class MineSweeper {

	/** mine and clue values, 9 - mine, 0-8 clue values
	 * 
	 */
	public int[][] mines;

	/** tile values 0 - open, 1 - closed,
	 * 2 - question, 3 - mine
	 * Mine as in flag.
	 */
	public int[][] tiles;

	/** Level 2 - game status win, lose, play
	 * 
	 */
	private String status;

	/** default constructor
	 * 	board size 9 x 9
	 *  create mines and tile arrays
	 *  place mines
	 *  calculate clues
	 *  (*)set game status to play
	 *  All of these are set up by initGame.
	 *  DONE
	 */
	public MineSweeper() {
		initGame(9, 9);
	}

	/** alternate constructor
	 *  use specifies board size
	 *  create mines and tile arrays
	 *  place mines
	 *  calculate clues
	 *  (*)set game status to play
	 * @param newRows number of rows for grid
	 * @param newCols number of columns for grid
	 * All of these are set up by initGame.
	 * DONE
	 */
	public MineSweeper(int newRows, int newCols) {
		initGame(newRows, newCols);
	}

	/** Level 2 - game status
	 * @return "play", "win", or "lose"
	 * DONE
	 */
	public String getStatus() {
		return status;
	}

	/** number of rows for board
	 * @return number of rows
	 * DONE
	 */
	public int getRows() {
		return mines.length;
	}

	/** number of columns for board
	 * @return number of columns
	 * DONE
	 */
	public int getCols() {
		return mines[0].length;
	}

	/** value of the mines array at r,c
	 * -1 is returned if invalid r,c
	 * @param r row index
	 * @param c column index
	 * @return value of mines array, -1 if invalid
	 * DONE
	 */
	public int getMines(int r, int c) {
		if (validIndex(r, c)) {
			return mines[r][c];
		} else {
			return -1;
		}
	}

	/** value of the tiles array at r,c
	 * -1 is returned if invalid r,c<br>
	 * @param r row index
	 * @param c column index
	 * @return value of tiles array, -1 if invalid
	 * DONE
	 */
	public int getTiles(int r, int c) {
		if (validIndex(r, c)) { //If the tiles are valid
			return tiles[r][c];
		} else {
			return -1;
		}
	}

	/** mark tile - open tile, close tile, 
	 *  flag tile as mine, set tile as question mark, close tile
	 * 
	 * Level 1 - Requirements
	 * - invalid r,c values must be ignored
	 * - a tile that is opened must stay open
	 * - a tile that is marked as a flag (ie. tile[][] value 3) can not be opened
	 * 
	 * 
	 * Level 2 - Requirements
	 * - tile values can only change when game status is "play"
	 * - game status must be updated after a tile is opened
	 * 
	 * @param r row index
	 * @param c column index
	 * @param t 0 - open, 1 - close, 2 - question, 3 - mine
	 * DONE
	 */
	public void markTile(int r, int c, int t) {
		if (validIndex(r, c) && status.equals("play")) {
			if (t == 0) { //If attempting to open tile
				if (tiles[r][c] == 3 || tiles[r][c] == 2) { //If tile is marked as flag or a question mark
					//Do nothing
				}
				else {
					tiles[r][c] = 0; //Open the tile.
					if (mines[r][c] == 9) { //If that tile was a mine
						status = "lose";
						mines[r][c] = 10; //To differentiate the mine that ends the game from other mines
					}
				}
			}
			if (t == 2) { //If attempting to question tile
				if (tiles[r][c] == 0) { //If tile is opened already
					//Do nothing
				}
				else {
					tiles[r][c] = 2; //Question tile
				}
			}
			if (t == 3) { //If attempting to mark tile as mine
				if (tiles[r][c] == 0) { //If tile is opened already
					//Do nothing
				}
				else {
					tiles[r][c] = 3; //Mark tile as mine
					if (gameWon()) { //checks if game is won (All mines must be marked)
						status = "win";
					}
				}
			}
		}
	}

	/** mines array as String
	 * @return mines array as a String
	 * DONE
	 */
	public String toStringMines() {
		String result = "\n";

		for (int r = 0; r < mines.length; r++) {
			for (int c = 0; c < mines[r].length; c++)
				result = result + mines[r][c];

			result += "\n";
		}

		return result;
	}

	/** tiles array as String
		 * @return mines array as a String
		 * DONE
		 */
	public String toStringTiles() {
		String result = "\n";

		for (int r = 0; r < mines.length; r++) {
			for (int c = 0; c < mines[r].length; c++)
				result = result + tiles[r][c];

			result += "\n";
		}

		return result;
	}

	/** game board array as String
	 * @return game board as String
	 */
	public String toStringBoard() { //Doesn't print when a game is lost. Find out why. 
		String result = "";
		
		System.out.print("  ");
		for (int i = 0; i < tiles.length; ++i) { //Prints the X coordinates
			System.out.print(i);
		}
		System.out.println();

		for (int r = 0; r < tiles.length; r++) {
			result += r + " "; //Prints the y coordinates
			for (int c = 0; c < tiles[r].length; c++) {
				result += this.getBoard(r, c);
			}
			//System.out.println(result + "\n");
			result += "\n"; //advance to next line
		}

		return result;
	}

	/** getBoard - determines current game board character for r,c position 
	 *  using the value of the mines[][] and tiles[][] array
	 *  Note:  Level 2 values are returned when
	 *         game is over (ie. status is "win" or "lose")
	 * 
	 * Level 1 values
	 * '1'-'8'  opened tile showing clue value
	 * ' '      opened tile blank
	 * 'X'      tile closed
	 * '?'      tile closed marked with ?
	 * 'F'      tile closed marked with flag
	 * '*'      mine
	 * 
	 * Level 2 values
	 * '-'      if game lost, mine that was incorrectly flagged
	 * '!'      if game lost, mine that ended game
	 * 'F'      if game won, all mines returned with F
	 * 
	 * @return char representing game board at r,c
	 * 
	 */
	public char getBoard(int r, int c) {
		
		char charValue = ' ';
		
		if (validIndex(r, c)) {
			if (status.equals("play")) {
				if (tiles[r][c] == 1) { //If the tile is closed
					charValue = 'X';
				}
				else if (tiles[r][c] == 2) { //If the tile is Questioned
					charValue = '?';
				}
				else if (tiles[r][c] == 3) { //If the tile is marked with flag
					charValue = 'F';
				}
				else { //Return clue value (0 - 8, Mine)
					charValue = tileCharValue(r, c, charValue);
				}
			}
			else if (status.equals("win")) { //All mines marked with flags.
				if (mines[r][c] == 9) {
					charValue = 'F';
				}
				else if (tiles[r][c] == 1) { //Closed tile
					charValue = 'X';
				}
				else {
					charValue = tileCharValue(r, c, charValue);
				}
			}
			else if (status.equals("lose")) { //Prints the 0 - 8 values, -, !, and F.
				if (tiles[r][c] == 3 && mines[r][c] != 9) { //If flagged and is NOT a mine
					charValue = '-';
				}
				if (mines[r][c] == 10) { //Mine that ended the game
					charValue = '!';
				}
				if (mines[r][c] == 9) { //Any other mine
					charValue = '*';
				}
				else if (tiles[r][c] == 1) { //Closed tile
					charValue = 'X';
				}
				else { //Return clue value (0 - 8, Mine)
					charValue = tileCharValue(r, c, charValue);
				}
				//System.out.println("Char value: " + charValue);
			}
		}
		
		return charValue; //this line must be modified
	}

	/** create mines & tiles array
	 * place mines
	 * update clues
	 * @param newRows number of rows for grid
	 * @param newCols number of columns for grid
	 * DONE
	 */
	private void initGame(int newRows, int newCols) {
		//allocate space for mines and tiles array
		if ((newRows >= 1) && (newCols >= 1)) {
			mines = new int[newRows][newCols];
			tiles = new int[newRows][newCols];

			//init tiles array
			resetTiles();

			//place mines
			placeMines();

			//update clues
			calculateClues();

			//set game status
			status = "play";
		}
	}

	/** Sets all tiles to 1 - closed
	 * DONE
	 */
	private void resetTiles() {
		for (int i = 0; i < tiles.length; ++i) {
			for (int j = 0; j < tiles[0].length; ++j) {
				tiles[i][j] = 1;
			}
		}
		for (int i = 0; i < mines.length; ++i) {
			for (int j = 0; j < mines[0].length; ++j) {
				mines[i][j] = 0;
			}
		}
	}

	/** places mines randomly on grid
	 * integer value 9 represents a mine
	 * number of mines = (1 + number of columns * number rows) / 10
	 * minimum number of mines = 1
	 * DONE
	 */
	private void placeMines() {
		int mineNum = getMineNum(mines);
		
		Random randGen = new Random();
		for (int i = 0; i < mineNum; ++i) {
			int randRow = randGen.nextInt(mines.length);
			int randCol = randGen.nextInt(mines[0].length);
			mines[randRow][randCol] = 9;
		}

	}

	/** calculates clue values and updates
	 * clue values in mines array
	 * integer value 9 represents a mine
	 * clue values will be 0 ... 8
	 * DONE
	 */
	private void calculateClues() {
		for (int i = 0; i < mines.length; i++) { //Isn't incrementing the tiles around it? 
			for (int j = 0; j < mines[0].length; j++) {
				if (mines[i][j] == 9) {
					for (int m = i - 1; m <= i + 1; m++) {
						for (int n = j + 1; n >= j - 1; n--) {
							if (validIndex(m, n)) { //If valid square
								if (mines[m][n] == 9) { //If square has a mine
									//Do nothing
								}
								else {
									mines[m][n] += 1; //Increment the square
								}
							}
						}
					}
				}
			}
		}
	}

	/** determines if x,y is valid position
	 * @param x row index
	 * @param y column index
	 * @return true if valid position on board,
	 * false if not valid board position
	 * DONE
	 */
	private boolean validIndex(int x, int y) {
		boolean isXTrue = false;
		boolean isYTrue = false;
		boolean isTrue = false;
		for (int i = 0; i < tiles.length; i++) {
			if (i == x) {
				isXTrue = true;
			}
			for (int j = 0; j < tiles[0].length; j++) {
				if (j == y) {
					isYTrue = true;
				}
			}
			if (isXTrue && isYTrue) {
				isTrue = true;
			}
		}

		return isTrue;
	}

	/** Level 2 - game won status
	 * @return true if game won
	 * false if game not won
	 * DONE
	 */
	private boolean gameWon() {
		boolean isGameWon = false;
		int mineCount = 0;
		int mineNum = getMineNum(mines);
		
		for (int i = 0; i < mines.length; i++) {
			for (int j = 0; j < mines[0].length; j++) {
				if (mines[i][j] == 9 && tiles[i][j] == 3) { //If mine exists and is flagged
					++mineCount;
				}
			}
		}
		if (mineCount == mineNum) {
			isGameWon = true;
		}
		
		return isGameWon; 
	}
	
	private char tileCharValue(int r, int c, char value) { //Code is super long, so placing into separate method		
		if (mines[r][c] == 0) {
			value = ' ';
		}
		else if (mines[r][c] == 1) {
			value = '1';
		}
		else if (mines[r][c] == 2) {
			value = '2';
		}
		else if (mines[r][c] == 3) {
			value = '3';
		}
		else if (mines[r][c] == 4) {
			value = '4';
		}
		else if (mines[r][c] == 5) {
			value = '5';
		}
		else if (mines[r][c] == 6) {
			value = '6';
		}
		else if (mines[r][c] == 7) {
			value = '7';
		}
		else if (mines[r][c] == 8) {
			value = '8';
		}
		else if (mines[r][c] == 9) {
			value = '*';
		}
		
		return value;
		
	}
	private int getMineNum(int[][] mines) { //mineNum is used in multiple locations, so I made it accessible throughout the program.
		int mineNum = (1 + (mines[0].length * mines.length)) / 10;
		if (mineNum == 0) {
			mineNum = 1; //Minimum number
		}
		return mineNum;
	}
	
}