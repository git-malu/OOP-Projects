package model.strategies;

import model.balls.Ball;
import util.IDispatcher;

/**
 * A concrete strategy that makes the ball moves in a curve pattern.
 * @author Yuchang Shen and Yibing Zhang
 *
 */
public class CurveStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub
		int Vxold = ball.getVel().x;
		int Vyold = ball.getVel().y;
		ball.setVel((int) Math.round((Math.cos(Math.PI / 20) * Vxold - Math.sin(Math.PI / 20) * Vyold)),
				(int) Math.round(Math.cos(Math.PI / 20) * Vyold + Math.sin(Math.PI / 20) * Vxold));
	}

	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub

	}

}
