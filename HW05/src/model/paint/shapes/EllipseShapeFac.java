package model.paint.shapes;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * Factory for ellipse shapes.
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public class EllipseShapeFac implements IShapeFac {

	/**
	 * A static field for easy reference.
	 */
	public static final EllipseShapeFac singleton = new EllipseShapeFac();

	@Override
	/**
	 * 
	 * @param x 
	 * 		x coordinate of the center location of the ellipse
	 * @param y 
	 * 		y coordinate of the center location of the ellipse
	 * @param xScale 
	 * 		The x-dimension of the ellipse
	 * @param yScale 
	 * 		The y-dimension of the ellipse.
	 * @return An Ellipse2D.Double object.
	 */
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		// TODO Auto-generated method stub
		return new Ellipse2D.Double(x - xScale, y - yScale, 2 * xScale, 2 * yScale);
	}

}
