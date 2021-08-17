package com.uninter.tic_tac_toe;

/**
 * <p>
 * Takes care about all the operation inside the BOARD :)
 * 
 * @author 	Gilberto_jr_(RU_3326662)
 * @version 1.0_Aug_2021
 * @since 2021_08_01
 * </p>
 */

public class Board {
 /**	
  * <p>Represent the states of the board;</p>
  * <p> -1 means empty, 1 for 'X', 0 for 'O' example -> { -1, -1, -1, -1, -1, -1, -1, -1, -1 }</p>
 */
	private int[] table = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
	
	/**
	 * <p>This method shows the instruction to the players.</p>
	 * <p>It shows the table mapped to each cell.</p>
	 * <p>The numbering is one-initiated.</p>
	 * 
	 * @param board  the board in which to play
	 * 
	 * 
	 * @author Gilberto_jr_(RU_3326662)
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public void displayMappedBoard(Board board) {
		
		for (int i = 1; i < board.table.length + 1; i++) {
			System.out.print("|");
			System.out.print(i);
			if (i == 3)
				System.out.println("| ");
			if (i == 6)
				System.out.println("| ");
		}
		System.out.println("|");
		System.out.println();
	}
	
	/**
	 * <p>This method clears the board.</p>
	 * <p>It will set a marker for each Player objects. </p>
	 * 	<p> * while(): mark  '0'->  0,
	 *                   mark  '1'->  1 and
	 *                   empty ' '->'-1';</p>
	 * 
	 * @param board  the board in which to play
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public void clearBoard(Board board) {

		for (int i = 0; i < board.table.length; i++) {
			System.out.print("|");
			System.out.print(" ");
			if (i == 2)
				System.out.println("| ");
			if (i == 5)
				System.out.println("| ");
		}
		System.out.println("|");
		System.out.println();
		board.table = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
	}
	
	/**
	 * <p>This method displays the board.</p>
	 * <p>It use the ASCII Table for characters.</p>
	 * <p>'X' -> 88 in ASCII; 'O' -> 79 in ASCII.</p>
	 * 
	 * @param board  the board in which to play
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public void displayBoard(Board board) {

		for (int i = 0; i < board.table.length; i++) {
			System.out.print('|');
			if (board.table[i] == 88)
				System.out.print('X');
			if (board.table[i] == 79)
				System.out.print('O');
			if (board.table[i] == -1)
				System.out.print(" ");
			if (i == 2)
				System.out.println('|');
			if (i == 5)
				System.out.println('|');
		}
		System.out.println('|');
		System.out.println();
	}
	
	/**
	 * <p>This method asks PLAYER - 1 to Choose the position of the marker (0-9).</p>
	 * <p>If the player chose an unavailable position, the next player is called.  </p>
	 * <p> If player chose unavailable position, it
	 *              is penalized, and the next player is called :/</p>
	 * @param board  the board in which to play
	 * @param player the first Player
	 * @param position an integer to place the marker
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public void placeMarker(Board board, Player player, int position) {
		
		if(spaceCheck(board, position-1)) {

			board.table[position -1] = (char) player.getMarker();	
			
		} else
			System.err.println("UNAVAILABLE POSITION! NEXT PLAYER :/");	
	}
	
	/**
	 * <p>This method checks who win.</p>
	 * <p>It checks 3 row, 2 columns and 2 diagonals for the same marker.</p>
	 * 
	 * @param board  the board in which to play
	 * @param 		player the Player from where to get the mark
	 * 
	 * @return boolean if the player is the winner or not :/
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public boolean winCheck(Board board, Player player) {
		
		// What does it means to Win TIC_TAC_TOE?
		
		// Check ALL ROWS
		if (table[0] == player.getMarker() && (table[1] == player.getMarker()) && table[2] == player.getMarker())
			return true;
		if (table[3] == player.getMarker() && (table[4] == player.getMarker()) && table[5] == player.getMarker())
			return true;
		if (table[6] == player.getMarker() && (table[7] == player.getMarker()) && table[8] == player.getMarker())
			return true;
		
		// Check ALL COMUNS// Check ALL COMUNS
		if (table[0] == player.getMarker() && (table[3] == player.getMarker()) && table[6] == player.getMarker())
			return true;
		if (table[1] == player.getMarker() && (table[4] == player.getMarker()) && table[7] == player.getMarker())
			return true;
		if (table[2] == player.getMarker() && (table[5] == player.getMarker()) && table[8] == player.getMarker())
			return true;
		
		// Check 2 DIAGONALS
		if (table[0] == player.getMarker() && (table[4] == player.getMarker()) && table[8] == player.getMarker())
			return true;
		if (table[2] == player.getMarker() && (table[4] == player.getMarker()) && table[6] == player.getMarker())
			return true;

		else
			return false;
	}
	
	/**
	 * <p>This method checks if the cell is free to store value.</p>
	 * <p>The value -1 means empty cell </p>
	 * <p>while(): user must enter input 'X' or 'O'.</p>
	 * 
	 * @param board  the board in which to play
	 * @param position the number to store at board's table
	 * 
	 * @return boolean if the space is available
	 * 
	 * 
	 * @see clearBoard(Board) 
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public boolean spaceCheck(Board board, int position) {
		
		return (board.table[position] == -1);
	}
	
	/**
	 * <p>This method checks if the board is full.</p>
	 * <p>if it is full, and nobody wins, then TIE GAME is return. </p>
	 * 
	 * @param board  the board in which to play
	 * 
	 * @return boolean if the board is full
	 * 
	 * @see spaceCheck(board, int)
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public boolean fullBoardCheck(Board board) {
		
		for (int i = 0; i < board.table.length; i++) {
			if (spaceCheck(board, i))
				return false;
		}
		return true;
	}
	
	/************************************************************
	 * <p>
	 * This method is for Testing The Class Board()
	 * </p>
	 * 
	 * @param args 	the arguments are empty
	 * 
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 ***********************************************************/
	public static void main(String[] args) {
		
		Player player_1 = new Player();
		Player player_2 = new Player();
		Board board = new Board();

		player_1.setMarker('X');
		player_2.setMarker('O');

		board.displayMappedBoard(board);

		Boolean full = board.fullBoardCheck(board);
		System.out.println("Board full?" + full + "\n");

		board.placeMarker(board, player_1, 9);
		board.displayBoard(board);
		board.placeMarker(board, player_2, 8);
		board.displayBoard(board);
		board.placeMarker(board, player_1, 3);
		board.displayBoard(board);
		board.placeMarker(board, player_2, 1);
		board.displayBoard(board);
		board.placeMarker(board, player_1, 2);
		board.displayBoard(board);
		board.placeMarker(board, player_2, 4);
		board.displayBoard(board);
		board.placeMarker(board, player_1, 5);
		board.displayBoard(board);
		board.placeMarker(board, player_2, 6);
		board.displayBoard(board);
		board.placeMarker(board, player_1, 7);
		board.displayBoard(board);

		full = board.fullBoardCheck(board);
		System.out.println("Board full?" + full + "\n");

		System.out.println("cleaning The Board...");
		board.clearBoard(board);

		full = board.fullBoardCheck(board);
		System.out.println("Board full?" + full + "\n");
	}
}
