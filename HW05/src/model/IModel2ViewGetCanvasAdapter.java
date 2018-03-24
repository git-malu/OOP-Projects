package model;

import java.awt.Component;

/**
 * Interface IModel2ViewGetCanvasAdapter that goes from the model to the view
 * that enables the model to talk to the view and ask the view to get back the
 * canvas.
 *
 * @author Yuchang Shen and Weiheng Qiu
 * based on HW02 by Yue Jiang and Yuchang Shen
 */
public interface IModel2ViewGetCanvasAdapter {

	/**
	 * The method that get back the canvas
	 * 
	 * @return the Component canvas
	 */
	public Component getCanvas();

	/**
	 * No-op singleton implementation of IModel2ViewGetCanvasAdapter
	 */
	public static final IModel2ViewGetCanvasAdapter NULL_OBJECT = new IModel2ViewGetCanvasAdapter() {

		public Component getCanvas() {
			return null;
		}
	};

}
