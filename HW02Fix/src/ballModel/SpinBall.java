package ballModel;

import java.awt.Color;
import java.awt.Point;

/**
 * used to create a ball that could spin
 */
public class SpinBall extends ABall {
	private Point spinvelocity;
	private double angle;

	/**
	 * constructor of spin ball
	 * @param location location of spin ball
	 * @param radius radius of spin ball
	 * @param v velocity of spin ball
	 * @param c color of spin ball
	 */
	public SpinBall(Point location, int radius, Point v, Color c) {
		super(location, radius, v, c);
		this.spinvelocity = v;
		angle = 0.2;
	}

	/**
	 * change the direction of velocity making it could spin in a circle
	 */
	public void updatestate() {
		spinvelocity.x = (int) Math.round((spinvelocity.x * Math.cos(angle) - spinvelocity.y * Math.sin(angle)));
		spinvelocity.y = (int) Math.round((spinvelocity.y * Math.cos(angle) + spinvelocity.x * Math.sin(angle)));
	}
}
