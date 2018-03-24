package model.strategies;

import model.balls.Ball;
import util.IDispatcher;
import util.SineMaker;

/**
 * A concrete strategy that makes the ball moves in a shaking pattern.
 * @author Yuchang Shen and Yibing Zhang
 */
public class ShakeStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub

		ball.setVel(ball.getVel().x, new SineMaker(-32, 32, 25).getIntVal());
	}

	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		
	}

}
