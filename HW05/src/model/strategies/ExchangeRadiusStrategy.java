/**
 * 
 */
package model.strategies;

import model.IBallCmd;
import model.balls.Ball;
import util.IDispatcher;

/**
 * @author Thinker Q
 *
 */
public class ExchangeRadiusStrategy implements IUpdateStrategy<IBallCmd> {

	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		context.setInteractStrat(new IInteractionStrategy() {
			Ball tempBall = context;

			@Override
			public void interact(Ball context, Ball target, IDispatcher<IBallCmd> dispatcher) {
				// TODO Auto-generated method stub
				if (tempBall != target) {
					int temp = context.getRadius();
					context.setRadius(target.getRadius());
					target.setRadius(temp);
					tempBall = target;
				}
			}

		});
	}

	@Override
	public void updateState(Ball context, IDispatcher<IBallCmd> dispatcher) {
		// TODO Auto-generated method stub
		dispatcher.dispatch(new IBallCmd() {
			@Override
			public void apply(Ball other, IDispatcher<IBallCmd> dispatcher) {
				// TODO Auto-generated method stub
				if (context.getLocation().distance(other.getLocation()) < context.getRadius() + other.getRadius()) {
					context.interactWith(other, dispatcher);
				}
			}

		});
	}

}