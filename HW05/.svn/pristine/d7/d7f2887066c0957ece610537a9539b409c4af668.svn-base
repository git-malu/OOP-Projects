package model;

/**
 * Interface IModelCtrlAdpt that enable the view to control the model.
 * 
 * @author Yuchang Shen and Weiheng Qiu
 * based on HW02 by Yue Jiang and Yuchang Shen
 *
 * @param <TDropListItem1>
 * 			The generic type that the drop list is operating.
 * @param <TDropListItem2>
 * 			The generic type that the drop list is operating.
 */
public interface IModelCtrlAdpt<TDropListItem1, TDropListItem2> {

	/**
	 * The method that add a strategy to the drop list.
	 * 
	 * @param className
	 * 			The class name of the strategy.
	 * @return A TDropListItem correspond to the class name.
	 */
	public TDropListItem1 addStrategy(String className);

	/**
	 * The method that add a paint strategy to the list
	 * @param className
	 *          The class name of the paint strategy.
	 * @return A TDropListItem2 correspond to the class name.
	 */
	public TDropListItem2 addPaintStrategy(String className);

	/**
	 * Make a Ball object with a selected strategy from the drop list.
	 * 
	 * @param selectedItem1
	 * 			The selected item from the drop list.
	 * @param selectedItem2
	 *          The selected item from the drop list.
	 */
	public void makeBall(TDropListItem1 selectedItem1, TDropListItem2 selectedItem2);

	/**
	 * Clear all the Ball objects from the canvas.
	 */
	public void clearBalls();

	/**
	 * The method that combine the two strategies selected from the drop list.
	 * 
	 * @param item1
	 * 			The first selected item.
	 * @param item2
	 * 			The second selected item.
	 * @return A drop list item corresponding to the combination of the two selected items.
	 */
	public TDropListItem1 combineStrategy(TDropListItem1 item1, TDropListItem1 item2);

	/**
	 * Make a switcher ball.
	 * @param selectedItem2
	 * 		the paint strategy
	 */
	public void makeSwitcherBall(TDropListItem2 selectedItem2);

	/**
	 * Switch the strategy of the switcher balls with the selected item.
	 * 
	 * @param selectedItem
	 * 			The strategy from the drop list for the switcher balls to switch.
	 */
	public void switchStrategy(TDropListItem1 selectedItem);

	/**
	 * the NULL representation of IModelCtrlAdpt
	 */
	public static final IModelCtrlAdpt<Object, Object> NULL_OBJECT = new IModelCtrlAdpt<Object, Object>() {
		public Object addStrategy(String className) {
			return null;
		}

		public Object addPaintStrategy(String className) {
			return null;
		}

		public void makeBall(Object selectedItem1, Object selectedItem2) {

		}

		public void clearBalls() {

		}

		public Object combineStrategy(Object item1, Object item2) {
			return null;
		}

		public void makeSwitcherBall(Object selectedItem2) {

		}

		public void switchStrategy(Object selectedItem) {

		}
	};
}
