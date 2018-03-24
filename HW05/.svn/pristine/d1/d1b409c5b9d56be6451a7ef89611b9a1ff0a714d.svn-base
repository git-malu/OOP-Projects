package view;

import java.awt.Graphics;

/**
 * Interface IView2ModelPaintAdapter that goes from the view to the model that
 * enables the view to talk to the model, and aks the model to paint the ball.
 *
 * @author Yuchang Shen and Yibing Zhang
 * based on HW02 by Yue Jiang and Yuchang Shen
 */
public interface IView2ModelPaintAdapter {

	/**
	 * The method to ask BallMode paint the ball
	 * 
	 * @param g
	 *            a graphics context to draw the ball
	 */
	public void paint(Graphics g);

	/**
	 * No-op singleton implementation of IView2ModelPaintAdapter
	 */
	public static final IView2ModelPaintAdapter NULL_OBJECT = new IView2ModelPaintAdapter() {
		@Override
		public void paint(Graphics g) {
		}
	};
}
