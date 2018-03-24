package model;

import java.awt.Component;
import java.util.ArrayList;

import model.strategy.IPaintStrategy;

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

	public void paintStraListUpdate(ArrayList<IPaintStrategy> paintStra);

	public Component getCanvas();

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

		@Override
		public void paintStraListUpdate(ArrayList<IPaintStrategy> paintStra) {
			// TODO Auto-generated method stub

		}

		@Override
		public Component getCanvas() {
			// TODO Auto-generated method stub
			return null;
		}
	};

}