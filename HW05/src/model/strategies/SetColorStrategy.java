/**
 * 
 */
package model.strategies;

import model.IBallCmd;
import model.balls.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * @author Thinker Q
 *
 */
public class SetColorStrategy implements IUpdateStrategy<IBallCmd> {

	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		context.setInteractStrat(new IInteractionStrategy() {
			@Override
			public void interact(Ball context, Ball target, IDispatcher<IBallCmd> dispatcher) {
				// TODO Auto-generated method stub
				target.setColor(Randomizer.singleton.randomColor());
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
				if (context.getColor() != other.getColor()
						&& context.getLocation().distance(other.getLocation()) > 330) {
					context.interactWith(other, dispatcher);
				}
			}

		});
	}

}
