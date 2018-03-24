package model.strategies;

import model.balls.Ball;
import util.IDispatcher;

/**
 * A concrete strategy that makes the ball moves in a straight line.
 * @author Yuchang Shen and Yibing Zhang
 *
 */
public class StraightStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		
	}

}
