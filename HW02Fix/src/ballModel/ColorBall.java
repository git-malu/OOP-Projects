package ballModel;

import java.awt.Color;
import java.awt.Point;

/**
 * used to create a ball that could change color
 */
public class ColorBall extends ABall {
	/**
	 * constructor of color ball
	 * @param location location of color ball
	 * @param radius radius of color ball
	 * @param v velocity of color ball
	 * @param c color of color ball
	 */
	public ColorBall(Point location, int radius, Point v, Color c) {
		super(location, radius, v, c);
	}

	/**
	 * change the color
	 */
	public void updatestate() {
		setColor(new Color((new Double(Math.random() * 128)).intValue() + 128,
				(new Double(Math.random() * 128)).intValue() + 128,
				(new Double(Math.random() * 128)).intValue() + 128));
	}
}
