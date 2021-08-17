package com.uninter.tic_tac_toe;

/**
 * <p>
 * TIC-TAC-TOE GAME(V1)- UNINTER PROJECT - Course: Computer Engineer (AUG/2021)
 * </p>
 * 
 * <p>
 * Welcome!
 * </p>
 * 
 * <blockquote>
 * <p>Instructions:</p>
 * 
 * <p>
 * (1) In the beginning, the Map for the board will be presented to the players;
 * </p>
 * <p>
 * (2) The System asks the PLAYER - 1 to choose the marker LEVEL;
 * </p>
 * <p>
 * (3) The System asks the PLAYER - 1 if the system will run in AUTOPLAY or not;
 * </p>
 * if accepted, then PLAYER-2 turns the "COMPUTER"; otherwise, "PLAYER_2";
 * <p>
 * (4) The System asks the PLAYER - 1 to choose the marker ('X' or 'O');
 * </p>
 * <p>
 * (5) The System flip a coin to see who's first to play;\n
 *     A random number is generate to choose who's playing first;
 * </p>
 * <p>
 * (6) The System asks, for the first player, if he/she is ready;
 * </p>
 * <p>
 * (7) Then the System enter in a inner loop giving the turn for each player;
 * </p>
 * <p>
 * (8) The System checks for TIE GAME or WIN GAME at each turn;
 * </p>
 * <p>
 * (9) If there isn't a Win and No TIe, the system asks the next player to run;
 *     If there is a win , the system asks if he/she wants to re-start the game;
 * </p>
 * <p>
 * (10) If positive, the inner loop repeats; otherwise it says
 * </p>
 * <p>"GOODBYE!" and exit by ending the outer loop. The Game is Over!
 * </p>
 * 
 *
 * 
 * Note 1 - The Player must be care about the number to entering. If he/she use
 * 			an UNAVAILABLE POSITION then the game goes on and the faulty player lost its
 * 			turn. So, play with play with care and focus :)
 * 
 * Note 2 - JavaDoc are implemented; please see documentation at the HTML pages at
 * 			directory \tic_tac_toe\doc at the source file :)
 * 
 * 3 - Examples of 3 board's states:
 * 
 * <p>|X|O|X|</p>
 * <p>|O|O|X| -> TIE GAME! NOBODY WINS!</p>
 * <p>|O|X|O|</p>
 * 
 * 
 * <p>|X|O|X|</p>
 * <p>|O|X|O| -> PLAYER_1 ('X' MARK) HAS WON!</p>
 * <p>|' '|' '|X|</p>
 * 
 * <p>|O|O|X|</p>
 * <p>|X|O|X| -> PLAYER_2 ('O' MARK) HAS WON!</p>
 * <p>|O|X|O|</p>
 * 
 * <p>|O|O|X|</p>
 * <p>|X|O|X| -> COMPUTER ('O' MARK) HAS WON!</p>
 * <p>|O|X|O|</p>
 * </blockquote>
 * 
 * @author Gilberto_jr_(RU_3326662)
 * @version 1.1_(Aug_2021)
 * @since 2021_08_01
 */

public class Main {

	private static Player PLAYER_1 = new Player();
	private static Player PLAYER_2 = new Player();
	private static TickBoard tboard = new TickBoard();

	private static Board board = new Board();
	protected static boolean gameOn;
	private static int position;

	public static void main(String[] args) {
		GameController computer = new GameController();

		// Welcome message
		System.out.println("Welcome to the TIC_TAC_TOE Game!!\n");

		// Passing Instructions how to reference each board's cell
		System.out.println("Instructions:");
		System.out.println("Here is how the board is mapped:");
		board.displayMappedBoard(board);

		// Asks for LEVEL
		System.out.println("WHAT LEVEL? Newbie (1) Intermediate (2) Advanced (3)");
		int level = computer.askLevel(PLAYER_1);
		System.out.println("You are running the Game at  Level " + level + " Fine!\n");

		// Asks autoplay or not...if yes, PLAYER_2 turn to computer
		System.out.println("Do you want to PLAY AGAINST COMPUTER?");
		computer.AgainstComputer(PLAYER_2);
		System.out.println("You are going to Play with a " + PLAYER_2.getName() + "! Let's Get it on!!!\n");

		// Outer Loop of the Game - breaks at GameController()'s method replay()
		while (true) {
			// Set everything up (Board, Who's first, Choose Maker X or O)
			computer = new GameController();
			System.out.println("PLAYER_1, choose your mark ('X' or ''O): ");
			computer.playerInput(board, PLAYER_1, PLAYER_2);

			System.out.println("\nFlipping a coin...\n");

			String whosTurn = computer.whosTurn(PLAYER_2);
			System.out.println("The first to play is: " + whosTurn);

			// gameOn = true;
			System.out.println("Are you ready?");
			gameOn = computer.playGame();
			System.out.println("The Game is on: " + gameOn);

			// Playing The Game Now! The Inner Loop of the Game. Board session
			// initialization.
			while (gameOn) {
				// PLAYER_1 Turn
				if (whosTurn == "PLAYER_1") {
					// Show the board
					board.displayBoard(board);

					// Who's turn
					System.out.println("PLAYER_1 Turn!");

					// Choose a position
					System.out.print("\nPlease, Choose the position (Range 1-9): ");
					position = computer.choosePosition(position);

					// Place the Marker if the cell is empty
					board.placeMarker(board, PLAYER_1, position);

					// Check if this player won?
					if (board.winCheck(board, PLAYER_1)) {
						board.displayBoard(board);
						System.out.println("PLAYER_1 HAS WON!");
						System.out.println(" Congratulation!!");
						gameOn = false;
					} else if (board.fullBoardCheck(board)) {
						board.displayBoard(board);
						System.out.println("TIE GAME! NOBODY WINS!");
						System.out.println("Ooops!!!");
						gameOn = false;
					} else
						whosTurn = PLAYER_2.getName();
					
				// PLAYER_2 Turn
				} else if (whosTurn == PLAYER_2.getName()) {
					// Show the board
					board.displayBoard(board);

					// Who's turn
					System.out.println(PLAYER_2.getName() + " Turn!");

					if (PLAYER_2.isHuman()) {
						// Choose a position
						System.out.print("\nPlease, Choose the position (Range 1-9): ");
						position = computer.choosePosition(position);

						// Place the Marker if the cell is empty
						board.placeMarker(board, PLAYER_2, position);
					} else {
                        // Inverting the level -> 4-1 = 3; 4-2 = 2, 4-1 = 3
						// The higher the level, the shorter the time :)
						position = tboard.getPosition(4 - PLAYER_2.getLevel());

						// Place the Marker if the cell is empty
						board.placeMarker(board, PLAYER_2, position);
					}
					
					// Check if this player won?
					if (board.winCheck(board, PLAYER_2)) {
						board.displayBoard(board);
						System.out.println(PLAYER_2.getName() + " HAS WON!");
						System.out.println(" Congratulation!!");
						gameOn = false;
					} else if (board.fullBoardCheck(board)) {
						board.displayBoard(board);
						System.out.println("TIE GAME! NOBODY WINS!");
						System.out.println("Ooops!!!");
						gameOn = false;
					} else
						whosTurn = "PLAYER_1";
				}
			}
			// Inviting the player to run the game again
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
