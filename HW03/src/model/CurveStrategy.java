package model;

import java.awt.Point;

/**
 * @author LauraHwa
 *
 */
public class CurveStrategy implements IUpdateStrategy {

	@Override
	public void updateState(Ball ball) {
		// TODO Auto-generated method stub
		double angle = 0.2;
		double vx = ball.velocity.getX();
		double vy = ball.velocity.getY();
		ball.velocity = new Point((int) Math.round((vx * Math.cos(angle) - vy * Math.sin(angle))),
				(int) Math.round((vy * Math.cos(angle) + vx * Math.sin(angle))));
	}

}
