package model.strategy;

import java.awt.Graphics;

import model.Ball;

/**
 * this strategy paints without a prototype.
 * @author malu
 *
 */
public class SquarePaintStrategy implements IPaintStrategy {
	public String toString() {
		return "Square";
	}

	/*
	 * No parameter constructor for the class
	 */
	public SquarePaintStrategy() {

	}

	/*
	 * Paints a square on the given graphics context using the color and radius
	 * provided by the host.
	 * param g The Graphics context that will be paint on
	 * param host The host Ball that the required information will be pulled from.
	 */
	public void paint(Graphics g, Ball host) {
		int halfSide = host.getRadius();
		g.setColor(host.getColor());
		g.fillRect(host.getLocation().x, host.getLocation().y, 2 * halfSide, 2 * halfSide);
	}

	/*
	 * By default, do nothing for initialization.
	 */
	public void init(Ball context) {

	}
}
