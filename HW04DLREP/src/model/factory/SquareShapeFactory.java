package model.factory;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class SquareShapeFactory implements IShapeFactory {
	public static final SquareShapeFactory Singleton = new SquareShapeFactory();

	@Override
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		// TODO Auto-generated method stub
		Shape rectangle = new Rectangle2D.Double(x, y, xScale, yScale);
		return rectangle;
	}

}
