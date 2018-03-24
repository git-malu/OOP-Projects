package model.paint.shapes;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Factory for rectangles
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public class RectangleShapeFac implements IShapeFac {

	/**
	 * the singleton 
	 */
	public final static RectangleShapeFac singleton = new RectangleShapeFac();

	@Override
	/**
	 * Instantiates a Rectangle2D.Double object at the specified orign and size.
	 * @param x x coordinate of the center location of the prototype rectangle
	 * @param y y coordinate of the center location of the prototype rectangle
	 * @param xScale The x-dimension of the prototype rectangle.
	 * @param yScale The y-dimension of the prototype rectangle.
	 * @return A Rectangle2D.Double instance
	 */
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		// TODO Auto-generated method stub
		return new Rectangle2D.Double(x - xScale, y - yScale, 2 * xScale, 2 * yScale);
	}

}
