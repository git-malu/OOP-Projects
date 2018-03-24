package model;

/**
 * @author LauraHwa
 *
 */
public class BreathingStrategy implements IUpdateStrategy {
	private int direction = 1;

	@Override
	public void updateState(Ball ball) {
		// TODO Auto-generated method stub
		int radius = ball.getRadius();
		if (radius <= 5) {
			ball.setRadius(radius + 1);
			direction = 1;
		} else if (radius >= 40) {
			ball.setRadius(radius - 1);
			direction = 0;
		} else {
			if (direction == 0) {
				ball.setRadius(radius - 1);
			} else {
				ball.setRadius(radius + 1);
			}
		}
	}

	//	/**
	//	 * @param ball
	//	 */
	//	public void move(Ball ball) {
	//
	//		//calculate next ball center
	//		double newCenterX = ball.location.getX() + ball.radius + ball.velocity.getX();
	//		double newCenterY = ball.location.getY() + ball.radius + ball.velocity.getY();
	//
	//		//calculate new radius, goes like sin function
	//		breath_time = (breath_time + 0.3) % (Math.PI * 2);
	//		ball.radius = (int) ((Math.sin(breath_time) + 2) * 10);
	//
	//		//new paint location
	//		ball.location.x = (int) (newCenterX - ball.radius);
	//		ball.location.y = (int) (newCenterY - ball.radius);
	//	}

	//	/**
	//	 * bounce the ball when it hit the bounds, change its speed direction and location
	//	 * @param ball 
	//	 */
	//	public void bounce(Ball ball) {
	//		if (ball.location.x < 0 || ball.location.x + 2 * ball.radius > BallWorldModel.returnBounds().getWidth()) {
	//			ball.velocity.x = -ball.velocity.x;
	//			ball.location.x = ball.location.x + 2 * ball.velocity.x;
	//		}
	//		if (ball.location.y < 0 || ball.location.y + 2 * ball.radius > BallWorldModel.returnBounds().getHeight()) {
	//			ball.velocity.y = -ball.velocity.y;
	//			ball.location.y = ball.location.y + 2 * ball.velocity.y;
	//		}
	//	}

}
