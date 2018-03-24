package view;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * The interface of the adapter from the view to the model that enables the view to talk to the model.
 * @author guoqz
 */
public interface IView2ModelAdapter {
	/**
	 * The method that tells model to paint on canvas
	 * @param g
	 */
	public void paint(Graphics g);

	/**
	 * The method that tells model the type name of the ball need to create
	 * @param typename the name of the ball
	 */
	public void getName(String typename);

	/**
	 * The method that tells model the bounds of the canvas
	 * @param bounds the bounds of the canvas 
	 */
	public void getBounds(Rectangle bounds);

	/**
	 * The method that tells model to clean all balls on canvas
	 */
	public void clean();

	/**
	 * No-op singleton implementation of IView2ModelAdapter
	 */
	public static final IView2ModelAdapter NULL_OBJECT = new IView2ModelAdapter() {

		public void paint(Graphics g) {

		}

		public void getName(String temp) {

		}

		public void getBounds(Rectangle bounds) {

		}

		public void clean() {

		}
	};
}
