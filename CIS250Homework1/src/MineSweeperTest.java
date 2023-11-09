/*
 * 
 * MinesweeperTest.java
 *
 */
public class MineSweeperTest {

	public static void main(String[] args) {
        
        //create new minesweeper instance 2 rows by 5 columns
		MineSweeper game = new MineSweeper(4, 4);
		
		System.out.println("Status: " + game.getStatus());
		System.out.println("Rows: " + game.getRows());
		System.out.println("Columns: " + game.getCols());
		System.out.println("Mine array value at (1, 1): " + game.getMines(1, 1));
		System.out.println("Tiles array value at (1, 1): " + game.getTiles(1, 1));
		System.out.println("Board character at (1, 1): " + game.getBoard(1, 1));

        //display mines
        System.out.println( game.toStringMines() );
        
		//display tiles
		System.out.println( game.toStringTiles() );
		    
		//display board
		System.out.println( game.toStringBoard() );
			
		//mark tile at 0,0 as Open
		game.markTile(1,1,0);
		
		//mark tile at 0,1 as Question
		game.markTile(0,1,2);
				
		//mark tile at 0,0 as Mine
		game.markTile(0,2,3);
		game.markTile(1, 3, 0);
		game.markTile(3, 1, 2);
		game.markTile(1, 0, 3);
		  
        //display tiles 
		System.out.println( game.toStringTiles() );
	   
		//display board
		System.out.println( game.toStringBoard() );
		
		System.exit(0);
     }

}//minesweeperTest

/* Demonstrate that your class works by using the following test cases outlined in the specification document.  
 *  Modify the minesweeperTest.java program to demonstrate each of the methods in your minesweeper.java class.
 */