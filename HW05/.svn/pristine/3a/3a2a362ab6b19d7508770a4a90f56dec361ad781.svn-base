package model.paint.strategies;

import java.awt.Graphics;

import model.balls.Ball;

/**
 * Top-level interface that represents a strategy used by a Ball when asked 
 * to perform variant paint operations. A Ball has only one IPaintStrategy
 * 
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public interface IPaintStrategy {

	/**
	 * Paints the host onto the given Graphics context. The image is translated, scaled and rotated as determined by the host's location, radius, and velocity
	 * @param host
	 * 		The ball to initialize.
	 */
	public void init(Ball host);

	/**
	 * Paints the host onto the given Graphics context. The image is translated, scaled and rotated as determined by the host's location, radius, and velocity
	 * @param g
	 * 		The graphics context to draw upon.
	 * @param host
	 * 		The host ball.
	 */
	public void paint(Graphics g, Ball host);

	/**
	 * The singleton null object instance for this interface, which does nothing.
	 */
	static final IPaintStrategy NULL_OBJECT = new IPaintStrategy() {
		public void init(Ball host) {

		}

		public void paint(Graphics g, Ball host) {

		}
	};

}
