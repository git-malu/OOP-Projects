package model.paint.strategies;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import model.balls.Ball;

/**
 * A shape painting strategy that adds a paintCfg override that keeps the shape upright no matter which way it is going.
 * 
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public abstract class UpRightShapePaintStrategy extends ShapePaintStrategy {

	/**
	 * Constructor that takes both a Shape and an affine transform
	 * @param at
	 * 		The affine transform object to use
	 * @param shape
	 * 		The prototype shape to use.
	 */
	public UpRightShapePaintStrategy(AffineTransform at, Shape shape) {
		super(at, shape);
	}

	/**
	 * Constructor that takes a Shape, generates its own affine transform.
	 * @param shape
	 * 		The prototype shape to use.
	 */
	public UpRightShapePaintStrategy(Shape shape) {
		this(new AffineTransform(), shape);
	}

	@Override
	/**
	 * Override paintCfg to add the transform needed to keep the shape upright at all times.
	 */
	protected void paintCfg(Graphics g, Ball host) {
		super.paintCfg(g, host);
		if (Math.abs(Math.atan2(host.getVel().y, host.getVel().x)) > Math.PI / 2.0) {
			at.scale(1.0, -1.0);
		}
	}

}
