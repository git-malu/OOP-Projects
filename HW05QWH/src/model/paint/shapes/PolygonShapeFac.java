package model.paint.shapes;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

/**
 * Factory for polygons.
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public class PolygonShapeFac implements IShapeFac {

	private AffineTransform at = new AffineTransform();
	private Polygon poly = new Polygon();
	private double scaleFactor = 1.0;

	/**
	 * Constructor
	 * @param at the affine transform 
	 * @param scaleFactor the scale factor
	 * @param points the points of the polygon
	 */
	public PolygonShapeFac(AffineTransform at, double scaleFactor, Point... points) {
		this.at = at;
		this.scaleFactor = scaleFactor;
		for (Point pt : points) {
			this.poly.addPoint(pt.x, pt.y);
		}
	}

	@Override
	/**
	 * Instantiates a Shape object that is the prototype Polygon translated by the given (x, y) point 
	 * and scaled by given (xScale, yScale) factor times the internal scaleFactor. Note that this method 
	 * does *not* return a Polygon object, but rather a abstract Shape object. The return value *cannot* 
	 * be cast to Polygon.
	 * @param x x coordinate of the center location of the resultant Polygon
	 * @param y y coordinate of the center location of the resultant Polygon
	 * @param xScale The x-dimension of the resultant Polygon.
	 * @param yScale The y-dimension of the resultant Polygon.
	 * @return A Shape object that is the scaled prototype Polygon.
	 */
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		// TODO Auto-generated method stub
		at.setToTranslation(x, y);
		at.scale(xScale * scaleFactor, yScale * scaleFactor);
		return at.createTransformedShape(poly);
	}

}
