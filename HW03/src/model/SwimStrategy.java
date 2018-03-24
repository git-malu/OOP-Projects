package model;

import java.awt.Point;

import util.Randomizer;

/**
 * @author LuMa
 *
 */
public class SwimStrategy extends StraightStrategy implements IUpdateStrategy {
	private double breath_time = 0;
	Randomizer rand = Randomizer.getInstance();
	Point v = rand.randomVel();

	@Override
	public void updateState(Ball ball) {
		breath_time = (breath_time + 0.1) % (Math.PI * 0.5);
		if (ball.velocity.x < 0) {
			ball.velocity.x = -(int) (Math.sin(breath_time) * v.x + v.x * 0.2 + 1);
		} else {
			ball.velocity.x = (int) (Math.sin(breath_time) * v.x + v.x * 0.2 + 1);
		}

		if (ball.velocity.y < 0) {
			ball.velocity.y = -(int) (Math.sin(breath_time) * v.y + v.y * 0.2 + 1);
		} else {
			ball.velocity.y = (int) (Math.sin(breath_time) * v.y + v.y * 0.2 + 1);// need 1 to make the int number != 0
		}

	}

}
