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
public class TeleportStrategy implements IUpdateStrategy<IBallCmd> {

	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		context.setInteractStrat(new IInteractionStrategy() {
			@Override
			public void interact(Ball context, Ball target, IDispatcher<IBallCmd> dispatcher) {
				// TODO Auto-generated method stub
				target.getLocation().setLocation(
						Randomizer.singleton.randomInt(context.getLocation().x - 150, context.getLocation().x + 150),
						Randomizer.singleton.randomInt(context.getLocation().y - 150, context.getLocation().y + 150));
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
				if (context.getLocation().distance(other.getLocation()) > 350) {
					context.interactWith(other, dispatcher);
				}
			}

		});
	}

}
