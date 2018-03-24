package ballModel;

import java.awt.Color;
import java.awt.Point;

/**
 *  used to create a normal ball without special behavior
 */
public class StraightBall extends ABall {
	/**
	 * constructor of straight ball ball
	 * @param location location of straight ball
	 * @param radius radius of straight ball
	 * @param v velocity of straight ball
	 * @param c color of straight ball
	 */
	public StraightBall(Point location, int radius, Point v, Color c) {
		super(location, radius, v, c);
	}

	/**
	 * just a normal ball with easy move and bounce behavior
	 */
	public void updatestate() {
	}
}
