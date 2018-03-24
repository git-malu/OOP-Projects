package model.factory;

import java.awt.Polygon;
import java.awt.Shape;

public class TriangleShapeFactory implements IShapeFactory {
	public static final TriangleShapeFactory Singleton = new TriangleShapeFactory();

	@Override
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		// TODO Auto-generated method stub

		int[] xpoints = { 0, 1, 0 };
		int[] ypoints = { 1, 0, -1 };
		int npoints = 3;

		return new Polygon(xpoints, ypoints, npoints);

	}

	public Shape makeShape() {
		// TODO Auto-generated method stub
		//default
		int[] xpoints = { 1, 2, 1 };
		int[] ypoints = { 0, 0, -1 };
		int npoints = 3;

		return new Polygon(xpoints, ypoints, npoints);
	}

}
