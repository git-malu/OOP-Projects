package model.strategy;

import java.awt.geom.AffineTransform;

import model.factory.EllipseShapeFactory;

public class EllipsePaintStrategy extends ShapePaintStrategy {
	public String toString() {
		return "Ellipse";
	}

	/**
	 * the constructor will give a default size of the prototype of an ellipse
	 */
	public EllipsePaintStrategy() {
		this(new AffineTransform(), -1, -0.25, 2, 0.5);//x,y, length, width//-1, -0.25, 2, 0.5
	}//0, 0, 4.0/3.0, 2.0/3.0  unit size???

	public EllipsePaintStrategy(AffineTransform at, double x, double y, double width, double height) {
		super(at, EllipseShapeFactory.Singleton.makeShape(x, y, width, height));//make shape
	}

}
