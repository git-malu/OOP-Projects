package model.paint.strategies;

import java.awt.Graphics;

import model.balls.Ball;

/**
 * Paint strategy that paints a filled square with the Ball's radius. 
 * The class demonstrates a direct implementation of IPaintStrategy.
 * 
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public class SquarePaintStrategy implements IPaintStrategy {

	@Override
	/**
	 * Initiate the ball, by default do nothing.
	 */
	public void init(Ball host) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * Paints a square on the given graphics context using the color and radius provided by the host. param g The Graphics context that will be paint on param host The host Ball that the required information will be pulled from.
	 */
	public void paint(Graphics g, Ball host) {
		// TODO Auto-generated method stub
		int halfSide = host.getRadius();
		g.setColor(host.getColor());
		g.fillRect(host.getLocation().x - halfSide, host.getLocation().y - halfSide, 2 * halfSide, 2 * halfSide);

	}

}
