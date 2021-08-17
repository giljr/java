package com.uninter.tic_tac_toe;

import java.util.Random;
import java.util.Scanner;

/**
 * <p>
 * It is responsible to the iteration player-1 VERSUS Player-2 (or computer) :)
 * </p>
 * 
 * @version 1.0_Aug_2021
 * @since 2021_08_01
 */
public class GameController {
	
	// The constants declarations
	/** Level 1 - No time constrained */
	private static final int NEWBIE = 1;
	/**Level 2 - Time constrained 2 seconds. */
	private static final int INTERMEDIATE = 2;
	/**Level 3 - Time constrained 3 seconds.  */
	private static final int ADVANCED = 3;
	/**Player 1 is always human */
	private static final String PLAYER_1 = "PLAYER_1";
	/**Player 2 might be human or machine */
	private static final String PLAYER_2 = "PLAYER_2";
	/** The name or the computer player */
	private static final String COMPUTER = "COMPUTER";
	/**
	 * <p>Represent the board itself; </p>
	 * <p>It is populated like this: -> { -1, -1, -1, -1,
	 * -1, -1, -1, -1, -1 }
	 * </p>
	 */
	Board board = new Board();
	
	/**
	 * <p>
	 * Object of type Scanner; used to gather the data from the console
	 * </p>
	 */
	Scanner sc = new Scanner(System.in);

	/************************************************************
	 * <p>
	 * This method asks Player 1 to Choose the mark to play with.
	 * </p>
	 * <p>while(): user must enter input 'X' or 'O'.</p>
	 * <p>
	 * It will set a marker for each Player objects.
	 * </p>
	 * 
	 * @param board    the board in which to play
	 * @param player_1 the first Player
	 * @param player_2 the second Player
	 * 
	 * 
	 * @author Gilberto_jr_(RU_3326662)
	 * @version 1.1_Aug_2021
	 * @since 2021_08_01
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
		System.out.println("PLAYER_1 uses '" + player_1.getMarker() + "' as marker.");
		System.out.println(player_2.getName() +" uses '" + player_2.getMarker() + "' as marker.");
	}

	/************************************************************
	 * <p>
	 * This method asks Player 1 to Choose the mark to play with.
	 * </p>
	 * <p>while(): user must enter input 'X' or 'O'.</p>
	 * <p>
	 * It will set a marker for each Player objects.
	 * </p>
	 * 
	 * @return boolean if the player wants to enter in the loop game
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
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
	 * <p> while(): user must enter input 'X' or 'O'.</p>
	 * <p>
	 * It will set a marker for each Player objects.
	 * </p>
	 * 
	 * @param player_2 the second Player
	 * 
	 * @return String The name of the player
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 ***********************************************************/
	public String whosTurn(Player player_2) {
		
		Random rand = new Random();
		int flip = (int) (rand.nextInt(2));

		if (flip == 0)
			return PLAYER_1;
		else
			return player_2.getName();
	}

	/************************************************************
	 * <p>
	 * This method asks Player 1 itf he/she wants to play again.
	 * </p>
	 * <p>while(): user must enter input 'Y' or 'N'.</p>
	 * <p>
	 * It waits for values (Y)es or (N)o.
	 * </p>
	 * 
	 * 
	 * @return boolean weather the play want to play again
	 * 
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
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
	 * This method asks for the player the next position (as a number 1 -9)
	 * </p>
	 * 
	 * @param position the position object from the caller method
	 * 
	 * @return integer the position for later use
	 * 
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 ***********************************************************/
	public int choosePosition(int position) {

		return position = (int) sc.nextInt();
	}
	
	/************************************************************
	 * <p>
	 * This method asks for the player wants to run the game against machine ()
	 * instead of humans
	 * </p>
	 * <p>
	 * It will set the attributes human and name.
	 * </p>
	 * 
	 * @param player Player 1, that always is human
	 * 
	 * @return boolean if the player wants to play against computer
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 ***********************************************************/
	public boolean AgainstComputer(Player player) {

		Character against = ' ';
		while (against != 'Y' && against != 'y' && against != 'N' && against != 'n') {
			against = sc.next().charAt(0);
			if (Character.toUpperCase(against) == 'Y') {
				player.setHuman(false);
				player.setName(COMPUTER);
				return true;
			} else if (Character.toUpperCase(against) == 'N') {
				player.setHuman(true);
				player.setName(PLAYER_2);
				return false;
			}
			System.err.println("ERROR: Enter 'Y' or 'N' Only :/");
		}
		return false;
	}
	
	/************************************************************
	 * <p>
	 * This method asks for the player what level to play with.
	 * </p>
	 * <p>
	 * Newbie (1) Intermediate (2) Advanced (3)
	 * </p>
	 * 
	 * @param player Player 1, that always is human
	 * 
	 * @return int the number of the level
	 * 
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.1_Aug_2021
	 * @since 2021_08_01
	 ***********************************************************/
	public int askLevel(Player player) {

		int level = -1;
		while (level != 1 || level != 2 || level != 3) {
			level = sc.nextInt();
			if (level == 1) {
				player.setLevel(1);
				return NEWBIE;

			} else if (level == 2) {
				player.setLevel(2);
				return INTERMEDIATE;
			} else if (level == 3)
				player.setLevel(1);
			return ADVANCED;
		}
		System.err.println("ERROR: Enter 'Y' or 'N' Only :/");
		return level;
	}

	/************************************************************
	 * <p>
	 * This method is for Testing The Class GameController()
	 * </p>
	 * 
	 * 
	 * @param args the arguments are empty
	 * 
	 * 
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 ***********************************************************/
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

		String whosTurn = computer.whosTurn(player_2);
		System.out.println("The first to play is: " + whosTurn);

		board.displayBoard(board);

		System.out.println("Please, Choose the position (Range 0-8):");
		int position = (int) 1;
		System.out.println("position = " + position);

		if (board.spaceCheck(board, position)) {
			board.placeMarker(board, player_1, position);
		} else {

			System.out.println("ERROR: Cell already in use! Choose another number!");
		}

		System.out.println("Please, Choose the Another position (Range 0-8):");
		position = (int) 1;
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
