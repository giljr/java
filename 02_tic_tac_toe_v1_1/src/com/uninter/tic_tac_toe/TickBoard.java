package com.uninter.tic_tac_toe;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Extends the BOARD class to add random code and time set up :)
 * </p>
 * 
 * @author Gilberto_jr_(RU_3326662)
 * @version 1.0_Aug_2021
 * @since 2021_08_01
 */
public class TickBoard extends Board {

	private static final int MIN = 1;
	private static final int MAX = 9;
	
	/**
	 * <p>Returns a the position for AUTOPLAY mode.</p>
	 * <p>The sleep parameter are inverted to set the time</p>
	 * <p>The higher the level, the shorter the time :)</p>
	 *
	 * @param sleep  Time for sleep inverted.
	 * 
	 * @return integer 	an integer raging 1-9
	 * @see java.util.Random#nextInt(int)
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.1_Aug_2021
	 * @since 2021_08_01
	 */	
	public int getPosition(int sleep) {

		int position = (int) randInt(MIN, MAX);
		try {
			TimeUnit.SECONDS.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return position;
	}

	/**
	 * Returns a pseudo-random number between min and max, inclusive. The difference
	 * between min and max can be at most <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min 	Minimum value
	 * @param max 	Maximum value. Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 * 
	 * @author Gilberto_Jr_j3
	 * @version 1.1_Aug_2021
	 * @since 2021_08_01
	 */
	public static int randInt(int min, int max) {

		Random rand = new Random();
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

}
