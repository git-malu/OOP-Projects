package model.paint.strategies;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import model.balls.Ball;

/**
 * Concrete class that defines invariant painting behaviors to paint Shape objects for all its subclasses. 
 * Note: This cannot be directly instantiated by the BallWorld system because it lacks a no-parameter constructor.
 * 
 *@author Yuchang Shen and Weiheng Qiu
 *
 */
public abstract class ShapePaintStrategy extends APaintStrategy {

	private Shape shape;

	/**
	 * Constructor that allocates a new AffineTransform for internal use.
	 * @param shape The Shape to be painted.
	 */
	ShapePaintStrategy(Shape shape) {
		this(new AffineTransform(), shape);
	}

	/**
	 * Constructor that uses a supplied AffineTransform for internal use.
	 * @param at 
	 * 		The AffineTransform to use
	 * @param shape 
	 * 		The Shape to be painted.
	 */
	ShapePaintStrategy(AffineTransform at, Shape shape) {
		super(at);
		setShape(shape);
	}

	/**
	 * Set the shape of the paint strategy.
	 * @param shape
	 * 		the required shape
	 */
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	/**
	 * Getter for the shape.
	 * @return The shape
	 */
	public Shape getShape() {
		return this.shape;
	}

	/**
	 * Set the affine transform for the paint strategy.
	 * @param at 
	 * 		The required affine transform
	 */
	public void setAt(AffineTransform at) {
		this.at = at;
	}

	/**
	 * Getter for the affine transform.
	 * @return the affine transform.
	 */
	public AffineTransform getAt() {
		return at;
	}

	/**
	 * Paints the shape on the given Graphics context using the supplied AffineTransform. Called by the inherited paint method.
	 */
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		((Graphics2D) g).fill(at.createTransformedShape(shape));
	}

}
