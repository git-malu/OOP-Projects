package model.strategy;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.Ball;
import model.factory.TriangleShapeFactory;

public class TrianglePaintStrategy extends ShapePaintStrategy {

	public String toString() {
		return "Triangle";
	}

	public TrianglePaintStrategy() {
		this(new AffineTransform(), -1, -0.25, 2, 0.5);//default size
	}//0, 0, 4.0/3.0, 2.0/3.0  unit size???

	public TrianglePaintStrategy(AffineTransform at, double x, double y, double width, double height) {
		super(at, TriangleShapeFactory.Singleton.makeShape());//make shape and assign it to the private member shape
	}

	public void paintCfg(Graphics g, Ball host) {
		super.paintCfg(g, host);
		if (Math.abs(Math.atan2(host.getVelocity().y, host.getVelocity().x)) > Math.PI / 2.0) {
			at.scale(1.0, -1.0);
		}
	}
}
