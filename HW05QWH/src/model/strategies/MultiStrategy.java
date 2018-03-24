package model.strategies;

import model.balls.Ball;
import util.IDispatcher;

/**
 * A concrete composite strategy that is the combination of two other strategies.
 * @author Yuchang Shen and Yibing Zhang
 *
 */
public class MultiStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	private IUpdateStrategy<TDispMsg> s1 = new IUpdateStrategy.NullFactory<TDispMsg>().make(); //null-op
	private IUpdateStrategy<TDispMsg> s2 = new IUpdateStrategy.NullFactory<TDispMsg>().make(); //null-op

	/**
	 * constructor
	 * @param s1 the strategy to combine
	 * @param s2 the other strategy to combine
	 */
	public MultiStrategy(IUpdateStrategy<TDispMsg> s1, IUpdateStrategy<TDispMsg> s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub
		s1.updateState(ball, dispatcher);
		s2.updateState(ball, dispatcher);
	}

	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		s1.init(context);
		s2.init(context);
	}

}
