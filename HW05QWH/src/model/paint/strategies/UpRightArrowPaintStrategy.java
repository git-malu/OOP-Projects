package model.paint.strategies;

import java.awt.Graphics;

import model.balls.Ball;

/**
 * A composite paint strategy that paints an upright arrow by combining a triangle 
 * and a rectangle.
 * 
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public class UpRightArrowPaintStrategy extends MultiPaintStrategy {

	private static TrianglePaintStrategy strat1 = new TrianglePaintStrategy();

	private static RectanglePaintStrategy strat2 = new RectanglePaintStrategy();

	/**
	 * Constructor that makes a composite arrow with two different paint strategy.
	 * @param strat1
	 * 		the first paint strategy to be used
	 * @param strat2
	 * 		the second paint strategy to be used
	 */
	public UpRightArrowPaintStrategy(APaintStrategy strat1, APaintStrategy strat2) {
		super(strat1, strat2);
	}

	/**
	 * No-parameter constructor that instantiates the AffineTransform for internal use
	 */
	public UpRightArrowPaintStrategy() {
		this(strat1, strat2);
	}

	@Override
	/**
	 * Override the paintCfg method to make the shape upright.
	 */
	public void paintCfg(Graphics g, Ball host) {
		super.paintCfg(g, host);
		if (Math.abs(Math.atan2(host.getVel().y, host.getVel().x)) > Math.PI / 2.0) {
			at.scale(1.0, -1.0);
		}
	}
}
