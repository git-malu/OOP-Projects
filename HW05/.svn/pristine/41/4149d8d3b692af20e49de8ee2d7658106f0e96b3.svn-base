package model.paint.strategies;

import java.awt.Point;
import java.awt.geom.AffineTransform;

import model.paint.shapes.PolygonShapeFac;

/**
 * Paint strategy that paints a close-mouth fish-shaped Polygon.
 * 
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public class Fish2PaintStrategy extends ShapePaintStrategy {
	private static Point pt1 = new Point(-20, 10);
	private static Point pt2 = new Point(-9, 3);
	private static Point pt3 = new Point(-8, 4);
	private static Point pt4 = new Point(-4, 5);
	private static Point pt5 = new Point(2, 7);
	private static Point pt6 = new Point(4, 7);
	private static Point pt7 = new Point(9, 6);
	private static Point pt8 = new Point(12, 5);
	private static Point pt9 = new Point(14, 4);
	private static Point pt10 = new Point(15, 3);
	private static Point pt11 = new Point(16, 2);
	private static Point pt12 = new Point(17, 0);
	private static Point pt13 = new Point(16, -2);
	private static Point pt14 = new Point(15, -3);
	private static Point pt15 = new Point(14, -4);
	private static Point pt16 = new Point(12, -5);
	private static Point pt17 = new Point(9, -6);
	private static Point pt18 = new Point(4, -7);
	private static Point pt19 = new Point(2, -7);
	private static Point pt20 = new Point(-4, -5);
	private static Point pt21 = new Point(-8, -4);
	private static Point pt22 = new Point(-9, -3);
	private static Point pt23 = new Point(-20, -10);

	/**
	 * No-parameter constructor that instantiates the AffineTransform for internal use.
	 */
	public Fish2PaintStrategy() {
		this(new AffineTransform(), 0, 0, 2, 2);
	}

	/**
	 * Constructor that create a fish 
	 * @param at 
	 * 		The AffineTransform to use for internal calculations
	 * @param x 
	 * 		x-coordinate of the center of the fish
	 * @param y 
	 * 		y-coordinate of the center of the fish
	 * @param 
	 * 		width The x-dimension of the fish
	 * @param 
	 * 		height The y-dimension of the fish
	 */
	public Fish2PaintStrategy(AffineTransform at, double x, double y, double width, double height) {
		super(at, new PolygonShapeFac(at, 0.035, pt1, pt2, pt3, pt4, pt5, pt6, pt7, pt8, pt9, pt10, pt11, pt12, pt13,
				pt14, pt15, pt16, pt17, pt18, pt19, pt20, pt21, pt22, pt23).makeShape(x, y, width, height));
	}
}
