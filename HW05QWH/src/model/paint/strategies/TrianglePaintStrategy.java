package model.paint.strategies;

import java.awt.Point;
import java.awt.geom.AffineTransform;

import model.paint.shapes.PolygonShapeFac;

/**
 * Paint strategy that paints a triangle using the polygon factory.
 * 
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public class TrianglePaintStrategy extends ShapePaintStrategy {

	private static Point pt1 = new Point(-1, 0);
	private static Point pt2 = new Point(1, 0);
	private static Point pt3 = new Point(0, -1);

	/**
	 * No-parameter constructor that instantiates the AffineTransform for internal use.
	 */
	public TrianglePaintStrategy() {
		this(new AffineTransform(), 0, 0, 2, 2);
	}

	/**
	 * Constructor that create a triangle
	 * @param at 
	 * 		The AffineTransform to use for internal calculations
	 * @param x 
	 * 		x-coordinate of the center of the triangle
	 * @param y 
	 * 		y-coordinate of the center of the triangle
	 * @param width 
	 * 		The x-dimension of the triangle
	 * @param height 
	 * 		The y-dimension of the triangle
	 */
	public TrianglePaintStrategy(AffineTransform at, double x, double y, double width, double height) {
		super(at, new PolygonShapeFac(at, 1, pt1, pt2, pt3).makeShape(x, y, width, height));
	}
}
