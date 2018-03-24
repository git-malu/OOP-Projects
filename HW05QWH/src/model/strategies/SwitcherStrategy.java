package model.strategies;

import model.balls.Ball;
import util.IDispatcher;

/**
 * A decorator that encapsulate another strategy, which enables the strategy to be changed
 * at run time.
 * @author Yuchang Shen and Yibing Zhang
 *
 */
public class SwitcherStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	private IUpdateStrategy<TDispMsg> _strategy = new StraightStrategy<TDispMsg>();

	/**
	 * Setter for the strategy.
	 * @param newStrategy
	 * 			The new strategy for the switcher balls to be changed.
	 */
	public void setStrategy(IUpdateStrategy<TDispMsg> newStrategy) {
		_strategy = newStrategy;
	}

	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub
		_strategy.updateState(ball, dispatcher);
	}

	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		
	}

}
