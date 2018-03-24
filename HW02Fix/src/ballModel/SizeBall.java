package ballModel;

import java.awt.Color;
import java.awt.Point;

/**
 *  used to create a ball that could change size
 */
public class SizeBall extends ABall {
	private boolean flag;
	private int sizeradius;

	/**
	 * constructor of size ball
	 * @param location location of size ball
	 * @param radius radius of size ball
	 * @param v velocity of size ball
	 * @param c color of size ball
	 */
	public SizeBall(Point location, int radius, Point v, Color c) {
		super(location, radius, v, c);
		this.sizeradius = radius;
	}

	/**
	 * change the radius, that is size
	 */
	public void updatestate() {
		if (getRadius() >= sizeradius)
			flag = true;
		if (getRadius() <= 10)
			flag = false;
		if (flag)
			setRadius(getRadius() - 2);
		else
			setRadius(getRadius() + 2);
	}
}
