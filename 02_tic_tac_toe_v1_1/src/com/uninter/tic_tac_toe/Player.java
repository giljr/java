package com.uninter.tic_tac_toe;

/**
 * 
 * <p>Takes care about if the player human or not :)</p>
 * <p>Controls the variable name and marker</p>
 * <p>Please read the methods explanations :)</p>
 * 
 * @author Gilberto_jr_(RU_3326662)
 * @version 1.0_Aug_2021
 * @since 2021_08_01
 */
public class Player {

	private char marker;
	private boolean human;
	private String name;
	private int level = 0;
	
	/**
	 * <p>Getter - returns the marker of the Player.</p>
	 * <p>'X'-> 1 and 'O'-> 0 </p>
	 * 
	 * 
	 * @return char  the marker to play with ('X' or 'O')
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 1.0
	 * @version 1.0
	 */
	public char getMarker() {
		
		return marker;
	}

	/**
	 * <p>Setter - sets the marker of the Player.</p>
	 * <p>'X'-> 1 and 'O'-> 0 </p>
	 * 
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public void setMarker(char marker) {
		
		this.marker = marker;
	}

	/**
	 * <p>Probing - Asks if the Player is human.</p>
	 * 
	 * 
	 * @return boolean  if the player is human or not
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
     * @ since 2021-08-01
	 * @version 1.0
	 */
	
	/**
	 * <p>Probing - Asks if the player is human or not.</p>
	 * 
	 * 
	 * @return boolean  simply sets if the player is human or not
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public boolean isHuman() {	
		
		return human;
	}
	
	/**
	 * <p>Setter - sets the marker of the Player.</p>
	 * <p>'X'-> 1 and 'O'-> 0 </p>
	 * 
	 * 
	 * 
	 * @param human if the player is human or not
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public void setHuman(boolean human) {
		
		this.human = human;
	}

	/**
	 * <p>Getter - returns the marker of the Player.</p>
	 * 
	 * 
	 * @return 	char  the name of the player; options:
	 * 			<p>PLAYER_1"</p>
	 * 			<p>"PLAYER_2"</p>
	 * 			<p>"COMPUTER"</p>
	 * 
	 * @see GameController
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public String getName() {
		
		return name;
	}

	/**
	 * <p>Setter - Sets the marker of the Player.</p>
	 * <p>PLAYER_1"</p>
	 * <p>"PLAYER_2"</p>
	 * <p>"COMPUTER"</p>
	 * 
	 * @see GameController
	 * 
	 * @param name the name of the player
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public void setName(String name) {
		
		this.name = name;
	}
	
	/**
	 * <p>Getter - returns the level of the Player.</p>
	 * <p>Inverting the level -> 4-1 = 3; 4-2 = 2, 4-1 = 3</p>
	 * <p>The higher the level, the shorter the time :)</p>
	 * 
	 * @return 	char  the name of the player; options:
	 * 			<p>"NEWBIE = 1"</p>
	 * 			<p>"INTERMEDIATE = 2"</p>
	 * 			<p>ADVANCED = 3</p>
	 * 
	 * 
	 * @see GameController
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public int getLevel() {
		
		return level;
	}

	/**
	 * <p>Setter - sets the level of the Player.</p>
	 * <p>Inverting the level -> 4-1 = 3; 4-2 = 2, 4-1 = 3</p>
	 * <p>The higher the level, the shorter the time :)</p>
	 * <p>"NEWBIE = 1"</p>
	 * <p>"INTERMEDIATE = 2"</p>
	 * <p>ADVANCED = 3</p>
	 * 
	 * @param level the level in which to play
	 * 
	 * @see GameController
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.0_Aug_2021
	 * @since 2021_08_01
	 */
	public void setLevel(int level) {
		
		this.level = level;
	}
}
