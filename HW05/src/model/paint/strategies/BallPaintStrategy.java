package model.paint.strategies;

import java.awt.Graphics;

import model.balls.Ball;

/**
 * the strategy to paint ball
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public class BallPaintStrategy implements IPaintStrategy {

	@Override
	/**
	 * Initiate the ball, by default do nothing.
	 */
	public void init(Ball host) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * Paint the ball with the given location and radius.
	 */
	public void paint(Graphics g, Ball host) {
		// TODO Auto-generated method stub
		g.setColor(host.getColor());
		g.fillOval(host.getLocation().x - host.getRadius(), host.getLocation().y - host.getRadius(),
				2 * host.getRadius(), 2 * host.getRadius());
	}

}
