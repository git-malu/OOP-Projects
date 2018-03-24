package model;

import java.util.ArrayList;

/**
 * Interface that goes from the model to the view that enables the model to talk to the view
 * @author guoqz
 */
public interface IModel2ViewAdapter {
	/**
	 * The method that tells the view to update
	 */
	public void repaint();

	/**
	 * @param straFac update strategyFc
	 */
	public void facListUpdate(ArrayList<IStrategyFac> straFac);

	/**
	 * No-op "null" adapter
	 */
	public static final IModel2ViewAdapter NULL_OBJECT = new IModel2ViewAdapter() {
		public void repaint() {

		}

		@Override
		public void facListUpdate(ArrayList<IStrategyFac> straFac) {
			// TODO Auto-generated method stub

		}
	};
}
