package shape;

import java.awt.Color;
import java.awt.Graphics;

public class ATriangle extends AShape{
	/**
	 * new fields
	 */
	int[] xPoints = {250, 300, 350};
	int[] yPoints = {100 ,50 ,100};
	int nPoints = 3;
	
	/**
	 * constructor
	 */
	public ATriangle(){
		color = Color.ORANGE;
		size = new int[] {80, 90};
		location = new int[] {100, 50};
	}
	/**
	 * paint the triangle.
	 */
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillPolygon(xPoints, yPoints, nPoints);
	}
}
