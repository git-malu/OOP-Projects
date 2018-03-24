package model;

/**
 * Interface IModel2ViewUpdateViewAdapter that goes from the model to the view
 * that enables the model to talk to the view and ask the view to update.
 *
 * @author Yuchang Shen and Weiheng Qiu
 * based on HW02 by Yue Jiang and Yuchang Shen
 */
public interface IModel2ViewUpdateViewAdapter {

	/**
	 * The method that tells the view to update
	 */
	public void updateView();

	/**
	 * No-op singleton implementation of IModel2ViewUpdateViewAdapter
	 */
	public static final IModel2ViewUpdateViewAdapter NULL_OBJECT = new IModel2ViewUpdateViewAdapter() {
		public void updateView() {
		}
	};
}
