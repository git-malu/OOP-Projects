package ballModel;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
import java.util.RandomAccess;

/**
 * Random number generator that produces various types of random numbers
 */
public class Randomizer implements RandomAccess {
	private static Randomizer instance;
	private Random rnd;

	/**
	 * Create a new random number generator.
	 */
	public Randomizer() {
		rnd = new Random();
	}

	/**
	 * Creates an instance of a class using singleton mode
	 * @return instance
	 */
	public static Randomizer getInstance() {
		if (instance == null) {
			instance = new Randomizer();
		}
		return instance;
	}

	/**
	 * generate a random location
	 * @param bounds location bounds
	 * @param radius the radius of ball, location minus radius must within bounds
	 * @return random location
	 */
	public Point randomLoc(Rectangle bounds, int radius) {
		int max_x = (int) bounds.getWidth();
		int max_y = (int) bounds.getHeight();
		int x = rnd.nextInt(max_x - 2 * radius);
		int y = rnd.nextInt(max_y - 2 * radius);
		return new Point(x, y);
	}

	/**
	 * generate a random integer, which is radius
	 * @param min the minimum limit of radius 
	 * @param max the maximum limit of radius
	 * @return a random integer
	 */
	public int randomInt(int min, int max) {
		int x = rnd.nextInt(max - min + 1) + min;
		return x;
	}

	/**
	 * generate a random double, which could be angle of the curve
	 * @return a random double
	 */
	public double randomDouble() {
		return rnd.nextDouble();
	}

	/**
	 * generate a random velocity
	 * @return velocity
	 */
	public Point randomVel() {
		int x = rnd.nextInt(20 + 1);
		int y = rnd.nextInt(20 + 1);
		return new Point(x, y);
	}

	/**
	 * generate a random color 
	 * @return color
	 */
	public Color randomColor() {
		Color color = new Color((new Double(Math.random() * 128)).intValue() + 128,
				(new Double(Math.random() * 128)).intValue() + 128, (new Double(Math.random() * 128)).intValue() + 128);
		return color;
	}
}
