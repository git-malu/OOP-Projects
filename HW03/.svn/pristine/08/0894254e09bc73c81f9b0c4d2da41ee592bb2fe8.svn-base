package model;

import java.awt.Point;

import util.Randomizer;

/**
 * @author LauraHwa
 *
 */
public class DrunkenStrategy extends StraightStrategy implements IUpdateStrategy {
	Randomizer rand = Randomizer.getInstance();

	@Override
	public void updateState(Ball ball) {
		// TODO Auto-generated method stub
		double angle = (rand.randomDouble() - 0.5) * Math.PI;
		double vx = ball.velocity.getX();
		double vy = ball.velocity.getY();
		ball.velocity = new Point((int) Math.round((vx * Math.cos(angle) - vy * Math.sin(angle))),
				(int) Math.round((vy * Math.cos(angle) + vx * Math.sin(angle))));
	}

}
