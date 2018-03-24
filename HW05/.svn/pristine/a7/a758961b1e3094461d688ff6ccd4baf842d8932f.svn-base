package model.strategies;

import model.IStrategyFac;
import model.balls.Ball;
import util.IDispatcher;

/**
 * IUpdateStrategy is the interface that defines the common method that a strategy
 * should have. All strategies implement this interface with there own unique rules.
 * 
 * @author Yuchang Shen and Yibing Zhang
 */
public interface IUpdateStrategy<TDispMsg> {
	
	/**
	 * Initializes the strategy.   Should be called every time the Ball sets a new strategy.    
	 * @param context  The ball using this strategy.
	 */
	public void init(Ball context);
	
	/**
	 * Method that describe the behavior corresponding to the strategy.
	 * 
	 * @param ball
	 * 			The ball object to be updated with the strategy.
	 * @param dispatcher 
	 * 			dispatcher for ball to use
	 */
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher);
	
	/**
	 * the NULL representation of IUpdateStrategy
	 */
	public static final IUpdateStrategy<Object> NULL_OBJECT = new IUpdateStrategy<Object>() {
		public void updateState(Ball ball, IDispatcher<Object> dispatcher) {
		}

		@Override
		public void init(Ball context) {
			// TODO Auto-generated method stub
			
		}

	};
	
	public static final class NullFactory<TDispMsg> implements IStrategyFac<TDispMsg> {
	    /**
	     * Returns a no-op null strategy
	     */
	    @Override
	    public IUpdateStrategy<TDispMsg> make() {
	        return new IUpdateStrategy<TDispMsg>() {
	            @Override
	            /**
	             * No-op
	             * @param context Ignored
	             */
	            public void init(Ball context) {
	            }
	            @Override
	            /**
	             * No-op
	             * @param context Ignored
	             * @param dispatcher Ignored
	             */
	            public void updateState(Ball context, IDispatcher<TDispMsg> dispatcher) {
	            }
	                
	        };
	    }
	}

}
