package model.paint.strategies;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.balls.Ball;

/**
 * The top-level affine transform-based paint strategy that provides services for its 
 * subclasses, plus default behaviors and abstract behaviors.
 * 
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public abstract class APaintStrategy implements IPaintStrategy {

	AffineTransform at = new AffineTransform();

	/**
	 * Constructor that initializes the strategy with an affine transform
	 * @param at
	 * 		The AffineTransform for this paint strategy to use.
	 */
	APaintStrategy(AffineTransform at) {
		this.at = at;
	}

	@Override
	/**
	 * By default, do nothing for initialization.
	 */
	public void init(Ball host) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * Paints on the given graphics context using the color, scale and direction provided by the host. This is done by setting up the AffineTransform to rotate then scale then translate. Calls paintXfrm to actually perform the painting, using the set up transform. Calls paintCfg just before calling paintXfrm
	 */
	public void paint(Graphics g, Ball host) {
		// TODO Auto-generated method stub
		double scale = host.getRadius();
		at.setToTranslation(host.getLocation().x, host.getLocation().y);
		at.scale(scale, scale);
		at.rotate(host.getVel().x, host.getVel().y);
		g.setColor(host.getColor());
		paintCfg(g, host);
		paintXfrm(g, host, at);

	}

	/**
	 * Used for doing additional configurations by a subclass. The translation, rotation and scaling transformations have already been applied to this object's AffineTransform instance. This method is called before the paint method's final delegation to paintXfrm. This method is designed to be overridden by the subclass. By default the behavior is a no-op.
	 * @param g 
	 * 		The Graphics context that will be drawn upon.
	 * @param host 
	 * 		The Ball to be painted.
	 */
	protected void paintCfg(Graphics g, Ball host) {

	}

	/**
	 * Paints the host onto the given Graphics context. The image is translated, scaled and rotated as determined by the given affine transformation. This method is intended to be called either by a class's (or superclass's) own paint method or by another paint strategy who is sharing the affine transform. This allows the same transformation to be shared amongst multiple paint strategies.
	 * @param g 
	 * 		The graphics context to draw upon.
	 * @param host 
	 * 		The host ball.
	 * @param at 
	 * 		The affine transform to use.
	 */
	public abstract void paintXfrm(Graphics g, Ball host, AffineTransform at);
	

	/**
	 * Getter for the affine transform
	 * @return The affine transform.
	 */
	public AffineTransform getAT() {
		return this.at;
	}

}
