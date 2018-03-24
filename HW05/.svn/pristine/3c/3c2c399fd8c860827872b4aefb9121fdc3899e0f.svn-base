package model.paint.strategies;

import java.awt.geom.AffineTransform;

import model.paint.shapes.EllipseShapeFac;

/**
 * Paint strategy to paint an ellipse shape
 * 
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public class EllipsePaintStrategy extends ShapePaintStrategy {

	/**
	 * No parameter constructor that creates a prototype ellipse that has twice the width as height but an average radius of 1.
	 */
	public EllipsePaintStrategy() {
		this(new AffineTransform(), 0, 0, 4.0 / 3.0, 2.0 / 3.0);
	}

	/**
	 * Constructor that allows the specification of the location, x-radius and y-radius of the prototype ellipse. The AffineTransform to use is given.
	 * @param at 
	 * 		The AffineTransform to use for internal calculations
	 * @param x 
	 * 		floating point x-coordinate of center of circle
	 * @param y 
	 * 		floating point y-coordinate of center of circle
	 * @param width 
	 * 		floating point x-radius of the circle (ellipse)
	 * @param height 
	 * 		floating point y-radius of the circle (ellipse)
	 */
	public EllipsePaintStrategy(AffineTransform at, double x, double y, double width, double height) {
		super(at, EllipseShapeFac.singleton.makeShape(x, y, width, height));
	}
}
