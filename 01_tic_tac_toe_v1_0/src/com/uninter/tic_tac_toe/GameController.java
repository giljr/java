package com.uninter.tic_tac_toe;

import java.util.Scanner;

public class GameController {

	Board board = new Board();

	Scanner sc = new Scanner(System.in);

	/************************************************************
	 * <p>
	 * This method asks Player 1 to Choose the mark to play with.
	 * </p>
	 * <p>
	 * It will set a marker for each Player objects.
	 * </p>
	 * 
	 * @param board    the board in which to play
	 * @param player_1 the first Player
	 * @param player_2 the second Player
	 * 
	 * @return void
	 * 
	 * @apiNote while(): user must enter input 'X' or 'O'.
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
	 ***********************************************************/
	public void playerInput(Board board, Player player_1, Player player_2) {
		char marker = ' ';
		while (marker != 'X' && marker != 'x' && marker != 'O' && marker != 'o') {
			marker = sc.next().charAt(0);
			if (Character.toUpperCase(marker) == 'X') {
				player_1.setMarker('X');
				player_2.setMarker('O');
			} else if (Character.toUpperCase(marker) == 'O') {
				player_1.setMarker('O');
				player_2.setMarker('X');

			} else
				System.out.println("Error: Please Enter 'X' or 'O':/");

		}
		System.out.println("Player 1 uses '" + player_1.getMarker() + "' as marker.");
		System.out.println("Player 2 uses '" + player_2.getMarker() + "' as marker.");
	}

	/************************************************************
	 * <p>
	 * This method asks Player 1 to Choose the mark to play with.
	 * </p>
	 * <p>
	 * It will set a marker for each Player objects.
	 * </p>
	 * 
	 * @param board    the board in which to play
	 * @param player_1 the first Player
	 * @param player_2 the second Player
	 * 
	 * @return void
	 * 
	 * @apiNote while(): user must enter input 'X' or 'O'.
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
	 ***********************************************************/
	public boolean playGame() {

		Character response = ' ';
		while (response != 'Y' && response != 'y' && response != 'N' && response != 'n') {
			response = sc.next().charAt(0);
			if (Character.toUpperCase(response) == 'Y') {
				return true;

			} else if (Character.toUpperCase(response) == 'N') {
				return false;
			}
			System.err.println("ERROR: Enter 'Y' or 'N' Only :/");
		}

		return false;
	}

	/************************************************************
	 * <p>
	 * This method asks Player 1 to Choose the mark to play with.
	 * </p>
	 * <p>
	 * It will set a marker for each Player objects.
	 * </p>
	 * 
	 * @param board    the board in which to play
	 * @param player_1 the first Player
	 * @param player_2 the second Player
	 * 
	 * @return void
	 * 
	 * @apiNote while(): user must enter input 'X' or 'O'.
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
	 ***********************************************************/
	public String whosTurn() {

		int flip = (int) (Math.random() + 0.4);

		if (flip == 0)
			return "Player_1";
		else
			return "Player_2";
	}

	/************************************************************
	 * <p>
	 * This method asks Player 1 to Choose the mark to play with.
	 * </p>
	 * <p>
	 * It will set a marker for each Player objects.
	 * </p>
	 * 
	 * @param board    the board in which to play
	 * @param player_1 the first Player
	 * @param player_2 the second Player
	 * 
	 * @return void
	 * 
	 * @apiNote while(): user must enter input 'X' or 'O'.
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
	 ***********************************************************/
	public boolean replay() {
		Character replay = ' ';
		while (replay != 'Y' && replay != 'y' && replay != 'N' && replay != 'n') {
			replay = sc.next().charAt(0);
			if (Character.toUpperCase(replay) == 'Y') {
				return true;

			} else if (Character.toUpperCase(replay) == 'N') {
				return false;
			}
		}

		return false;
	}

	/************************************************************
	 * <p>
	 * This method asks for the player the next INTEGER (as a number 0 -8)
	 * </p>
	 * <p>
	 * It will set a marker for each Player objects.
	 * </p>
	 * 
	 * @param int the position object from the caller method
	 * 
	 * @return int the position for later use
	 * 
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
	 ***********************************************************/
	public int choosePosition(int position) {

		return position = (int) sc.nextInt();

	}

	// Testing The Class GameController()
	public static void main(String[] args) {
		System.out.println("Inside GameController()!");
		GameController computer = new GameController();
		Player player_1 = new Player();
		Player player_2 = new Player();
		Board board = new Board();

		System.out.println("Player_1, choose your mark ('X' or ''O): ");
		computer.playerInput(board, player_1, player_2);

		System.out.println("Are you ready?");
		boolean gameOn = computer.playGame();
		System.out.println("The Game is on: " + gameOn);

		String whosTurn = computer.whosTurn();
		System.out.println("The first to play is: " + whosTurn);

		board.displayBoard(board);

		System.out.println("Please, Choose the position (Range 0-8):");
		int position = (int) 0;
		System.out.println("position = " + position);

		if (board.spaceCheck(board, position)) {
			board.placeMarker(board, player_1, position);
		} else {

			System.out.println("ERROR: Cell already in use! Choose another number!");
		}

		System.out.println("Please, Choose the Another position (Range 0-8):");
		position = (int) 0;
		System.out.println("position = " + position);
		// Place the Marker
		System.out.println("board.space_check(board, position) = " + board.spaceCheck(board, position));

		if (board.spaceCheck(board, position)) {
			board.placeMarker(board, player_1, position);
		} else {

			System.out.println("ERROR: Cell already in use! Choose another number!");
		}
	}
}
