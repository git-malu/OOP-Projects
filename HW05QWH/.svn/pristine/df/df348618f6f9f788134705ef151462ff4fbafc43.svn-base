package view;

/**
 * Interface IView2ModelLoadandClear that goes from the view to the model that
 * enables the view to talk to the model, and asks model to make and clear the
 * ball
 *
 * @author Yuchang Shen and Yibing Zhang
 * based on HW02 by Yue Jiang and Yuchang Shen
 */
public interface IView2ModelLoadandClearAdapter {

	/**
	 * The method that tells the model to create a ball
	 * 
	 * @param ballType The class name of the ball.
	 */
	public void loadBall(String ballType);

	/**
	 * The method that clear all the balls from the canvas
	 */
	public void clearBalls();

	/**
	 * No-op singleton implementation of IView2ModelLoadandClear
	 */
	public static final IView2ModelLoadandClearAdapter NULL_OBJECT = new IView2ModelLoadandClearAdapter() {
		@Override
		public void loadBall(String ballType) {
		}

		@Override
		public void clearBalls() {
		}
	};

}
