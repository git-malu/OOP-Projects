package util;

import java.awt.Graphics;
import java.awt.Point;

import model.Ball;
import model.BallWorldModel;

public class BallCmd {
	public Graphics g;

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public BallCmd() {
		// TODO Auto-generated constructor stub
	}

	public void move(Ball ball) {
		ball.getLocation().translate(ball.getVelocity().x, ball.getVelocity().y);
	}

	/**
	 * bounce the ball when it hit the bounds, change its speed direction and location
	 */
	public void bounce(Ball ball) {
		Point location = ball.getLocation();
		Point velocity = ball.getVelocity();
		int radius = ball.getRadius();

		if (location.x < 0) {
			location.x = -location.x;
			velocity.x = -velocity.x;
		}

		if (location.x + 1 * radius > BallWorldModel.returnBounds().width) {
			location.x = BallWorldModel.returnBounds().width * 2 - location.x - 2 * radius;
			velocity.x = -velocity.x;

		}
		if (location.y < 0) {
			location.y = -location.y;
			velocity.y = -velocity.y;
		}
		if (location.y + 1 * radius > BallWorldModel.returnBounds().height) {
			location.y = BallWorldModel.returnBounds().height * 2 - location.y - 2 * radius;
			velocity.y = -velocity.y;

		}
	}

	public void paint(Ball ball) {
		g.setColor(ball.getColor());
		ball.getPaintStrategy().paint(g, ball);
		//_paintStrategy.paint(g, this);
	}

	public void updateState(Ball ball) {
		ball.getStraInterface().updateState(ball);
	}
}
