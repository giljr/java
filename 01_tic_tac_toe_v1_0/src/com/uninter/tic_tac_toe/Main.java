package com.uninter.tic_tac_toe;

/**
 * <p>
 * TIC-TAC-TOE GAME!
 * </p>
 * 
 * <p>
 * Welcome!
 * </p>
 * 
 * Instructions:
 * 
 * (1) In the beginning, the Map for the board will be presented to you; 
 * (2) The System asks the PLAYER - 1 to choose the marker ('X' or 'O'); 
 * (3) A random number is generate to choose who's playing first; 
 * (4) The System asks, for the first player, if he/she is ready; 
 * (5) Then the System enter in a inner * loop giving the turn for each player; 
 * (6) The System checks for TIE GAME or WIN GAME at each turn; 
 * (7) If there is a Win, the system asks if you want to re-start the game; 
 * (8) If positive, the inner loop repeats; otherwise it says
 * "goodbye!" by ending the outer loop.
 * 
 * Note 
 * 1 - The Player must be care about the number to entering.
 * 	   If he/she use an UNVAILABLE POSITION then the game 
 *     goes on and the faulty player lost its turn. So, 
 *     play with play with care and focus :)
 * 
 * 2 - Examples of 3 board's states:
 * 
 * |X|O|X|
 * |O|O|X|   -> TIE GAME! NOBODY WINS
 * |O|X|O|
 * 
 * 
 * |X|O|X|
 * |O|X|O|   -> PLAYER_1 ('X' MARK) HAS WON!
 * | | |X|
 * 
 * |O|O|X|
 * |X|O|X|   -> PLAYER_2 ('O' MARK) HAS WON!
 * |O|X|O|
 * 
 * 
 * @author: Gilberto Jr.(j3) RU 332662
 * @version: 1.0
 * @date: Aug / 2021
 */

public class Main {

	private static Player player_1 = new Player();
	private static Player player_2 = new Player();

	private static Board board = new Board();
	protected static boolean gameOn;
	private static int position;

	public static void main(String[] args) {
		GameController computer = new GameController();

		System.out.println("Welcome to the TIC_TAC_TOE Game!!\n");
		System.out.println("Instructions:");
		System.out.println("Here is how the board is mapped:");
		board.displayMappedBoard(board);
;
		while (true) {
			// Set everything up (Board, Who's first, Choose Maker X or O)
			computer = new GameController();
			System.out.println("Player_1, choose your mark ('X' or ''O): ");
			computer.playerInput(board, player_1, player_2);

			System.out.println("\nFlipping a coin...\n");

			String whosTurn = computer.whosTurn();
			System.out.println("The first to play is: " + whosTurn);

			// gameOn = true;
			System.out.println("Are you ready?");
			gameOn = computer.playGame();
			System.out.println("The Game is on: " + gameOn);

			// Playing The Game Now!
			while (gameOn) {
				// Player_1 Turn
				if (whosTurn == "Player_1") {
					System.out.println("Player_1 Turn!");
					
					// Show the board
					board.displayBoard(board);

					// Choose a position
					System.out.print("\nPlease, Choose the position (Range 0-8): ");
					position = computer.choosePosition(position);

					// Place the Marker if the cell is empty
					board.placeMarker(board, player_1, position);

					// Check if this player won?
					if (board.winCheck(board, player_1)) {
						board.displayBoard(board);
						System.out.println("Player_1 Has Won!");
						System.out.println(" Congratulation!!");
						gameOn = false;
					} else if (board.fullBoardCheck(board)) {
						board.displayBoard(board);
						System.out.println("TIE GAME!");
						System.out.println("Ooops!!!");
						gameOn = false;
					} else
						whosTurn = "Player_2";
					// Player_2 Turn
				} else if (whosTurn == "Player_2") {
					System.out.println("Player_2 Turn!");
					
					// Show the board
					board.displayBoard(board);

					// Choose a position
					System.out.print("\nPlease, Choose the position (Range 0-8): ");
					position = computer.choosePosition(position);

					// Place the Marker if the cell is empty
					board.placeMarker(board, player_2, position);

					// Check if this player won?
					if (board.winCheck(board, player_2)) {
						board.displayBoard(board);
						System.out.println("Player_2 Has Won!");
						System.out.println(" Congratulation!!");
						gameOn = false;
					} else if (board.fullBoardCheck(board)) {
						board.displayBoard(board);
						System.out.println("TIE GAME!");
						System.out.println("Ooops!!!");
						gameOn = false;
					} else
						whosTurn = "Player_1";
				}
			}
			
			System.out.println("\nLet Us Play Again? 'Y' or 'N'?");
			
			// Restarting The Game.
			if (gameOn = computer.replay()) {
				board.clearBoard(board);
				System.out.println("gameOn = " + gameOn);
				gameOn = true;
			} else {
				// Breaking The Outer While Loop
				System.out.println("Bye o/");
				break;
			}
		}
	}
}
