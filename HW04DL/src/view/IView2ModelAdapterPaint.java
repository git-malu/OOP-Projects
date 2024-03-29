package view;

import java.awt.Graphics;

/**
 * @author LuMa
 *
 */
public interface IView2ModelAdapterPaint {
	/**
	 * The method that tells model to paint on canvas
	 * @param g
	 */
	public void paint(Graphics g);

	/**
	 * No-op singleton implementation of IView2ModelAdapter
	 */
	public static final IView2ModelAdapterPaint NULL_OBJECT = new IView2ModelAdapterPaint() {

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub

		}
		
	};
	
	
}
