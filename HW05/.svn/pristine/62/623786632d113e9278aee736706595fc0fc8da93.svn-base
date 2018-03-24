package model.strategies;

import model.balls.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * A concrete strategy that makes the ball moves at random velocity.
 * @author Yuchang Shen and Yibing Zhang
 *
 */
public class CrazyStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub

		ball.setVel(Randomizer.singleton.randomInt(-75, 75), Randomizer.singleton.randomInt(-75, 75));
	}

	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub

	}

}
