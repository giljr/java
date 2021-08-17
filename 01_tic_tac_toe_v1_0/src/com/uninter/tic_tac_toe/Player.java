package com.uninter.tic_tac_toe;

public class Player {

	private char marker;
	
	/**
	 * <p>Getter and Setter - returns / sets the marker of the Player.</p>
	 * <p>'X'-> 1 and 'O'-> 0 </p>
	 * 
	 * 
	 * @return 		char or void
	 * 
	 * @apiNote 	while(): user must enter input 'X' or 'O'.
	 * 
	 * @author: 	Gilberto Jr.(j3)
	 * @version     %I%, %G%
	 * @since       1.0
	 */
	public char getMarker() {
		return marker;
	}

	public void setMarker(char marker) {
		this.marker = marker;
	}
}
