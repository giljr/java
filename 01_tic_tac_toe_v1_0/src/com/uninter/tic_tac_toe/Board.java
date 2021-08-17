package com.uninter.tic_tac_toe;

public class Board {

	private int[] table = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
	
	/**
	 * <p>This method the instructions to the players.</p>
	 * <p>It shows the table mapped to each cell.</p>
	 * <p>The numbering is zero-initiated.</p>
	 * 
	 * @param      	board  the board in which to play
	 * 
	 * @return 		void
	 * 
	 * @apiNote 	%I% gets incremented each time you edit and delget a file
				    %G% is the date mm/dd/yy
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
	 */
	public void displayMappedBoard(Board board) {
		for (int i = 0; i < board.table.length; i++) {
			System.out.print("|");
			System.out.print(i);
			if (i == 2)
				System.out.println("| ");
			if (i == 5)
				System.out.println("| ");
		}
		System.out.println("|");
		System.out.println();
	}
	
	/**
	 * <p>This method clears the board.</p>
	 * <p>It will set a marker for each Player objects. </p>
	 * 
	 * @param 		board  the board in which to play
	 * 
	 * @return 		void
	 * 
	 * @apiNote     while(): mark  '0'->  0,
	 *                   mark  '1'->  1 and
	 *                   empty ' '->'-1';
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
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
	 * 
	 * @param       board  the board in which to play
     *
	 * @return 		void
	 * 
	 * @apiNote 	while(): user must enter input 'X' or 'O'.
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
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
	 * <p>This method asks Player 1 to Choose the mark to play with.</p>
	 * <p>It will set a marker for each Player objects. </p>
	 * 
	 * @param       board  the board in which to play
	 * @param 		player_1 the first Player
	 * @param 		player_2 the second Player
	 * 
	 * @return 		void
	 * 
	 * @apiNote 	while(): user must enter input 'X' or 'O'.
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
	 */
	public void placeMarker(Board board, Player player, int position) {
		
		if(spaceCheck(board, position)) {

			board.table[position] = (char) player.getMarker();	
			
		} else
			System.err.println("UNAVAILABLE NUMBER! NEXT PLAYER :/");	
	}
	
	/**
	 * <p>This method checks who win.</p>
	 * <p>It checks 3 row, 2 columns and 2 diagonals. </p>
	 * 
	 * @param       board  the board in which to play
	 * @param 		player the Player from where to get the mark
	 * 
	 * @return 		boolean if the player is the winner or not :/
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
	 */
	public boolean winCheck(Board board, Player player) {
		// Win TIC_TAC_TOE?
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
	 * 
	 * @param 		board  the board in which to play
	 * @param 		position the number to store at board's table
	 * 
	 * @return 		boolean if the space is available
	 * 
	 * @apiNote 	while(): user must enter input 'X' or 'O'.
	 * 
	 * @see         clearBoard(Board) 
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
	 */
	public boolean spaceCheck(Board board, int position) {
		
		return (board.table[position] == -1);
	}
	
	/**
	 * <p>This method asks Player 1 to Choose the mark to play with.</p>
	 * <p>It will set a marker for each Player objects. </p>
	 * 
	 * @param 		board  the board in which to play
	 * 
	 * @return 		boolean if the board is full
	 * 
	 * @apiNote while(): user must enter input 'X' or 'O'.
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
	 */
	public boolean fullBoardCheck(Board board) {
		for (int i = 0; i < board.table.length; i++) {
			if (spaceCheck(board, i))
				return false;
		}
		return true;
	}
	
	/* Debug - Testing Purpose - Object: Board.java */
	public static void main(String[] args) {
		Player player_1 = new Player();
		Player player_2 = new Player();
		Board board = new Board();

		player_1.setMarker('X');
		player_2.setMarker('O');

		board.displayMappedBoard(board);

		Boolean full = board.fullBoardCheck(board);
		System.out.println("Board full?" + full + "\n");

		board.placeMarker(board, player_1, 8);
		board.displayBoard(board);
		board.placeMarker(board, player_2, 3);
		board.displayBoard(board);
		board.placeMarker(board, player_1, 2);
		board.displayBoard(board);
		board.placeMarker(board, player_2, 0);
		board.displayBoard(board);
		board.placeMarker(board, player_1, 1);
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
