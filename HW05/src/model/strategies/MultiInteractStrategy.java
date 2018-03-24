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
public class MultiInteractStrategy implements IInteractionStrategy {

	IInteractionStrategy s1, s2;

	/**
	 * @param s1 interact strategy 1
	 * @param s2 interact strategy 2
	 */
	public MultiInteractStrategy(IInteractionStrategy s1, IInteractionStrategy s2) {
		// TODO Auto-generated constructor stub
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void interact(Ball context, Ball target, IDispatcher<IBallCmd> dispatcher) {
		// TODO Auto-generated method stub
		s1.interact(context, target, dispatcher);
		s2.interact(context, target, dispatcher);
	}

}
