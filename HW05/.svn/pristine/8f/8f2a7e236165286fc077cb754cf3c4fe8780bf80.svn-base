package model.strategies;

import model.balls.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * A concrete strategy that makes the ball changes its radius randomly.
 * @author Yuchang Shen and Yibing Zhang
 *
 */
public class BreathingStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub
		ball.setRadius(Randomizer.singleton.randomInt(15, 20));
	}

	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub

	}

}
