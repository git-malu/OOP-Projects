package model.paint.strategies;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import model.paint.shapes.PolygonShapeFac;

/**
 * Paint a upright triangle.
 * 
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public class UpRightTrianglePaintStrategy extends UpRightShapePaintStrategy {

	private static Point pt1 = new Point(-1, 0);
	private static Point pt2 = new Point(1, 0);
	private static Point pt3 = new Point(0, 1);

	/**
	 * No-parameter constructor that instantiates the AffineTransform for internal use
	 */
	public UpRightTrianglePaintStrategy() {
		this(new AffineTransform(), 0, 0, 2, 2);
	}

	/**
	 * Constructor that create a upright triangle
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
	public UpRightTrianglePaintStrategy(AffineTransform at, double x, double y, double width, double height) {
		super(at, new PolygonShapeFac(at, 1.0, pt1, pt2, pt3).makeShape(x, y, width, height));
	}
}
