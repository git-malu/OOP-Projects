package model.strategy;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import model.Ball;

/**
 * It paints a composite flag shape that consists of an triangle and ellipse.
 * @author malu
 *
 */
public class FlagPaintStrategy extends MultiPaintStrategy {
	public ArrayList<ShapePaintStrategy> affinePaintStraList = new ArrayList<ShapePaintStrategy>();

	public FlagPaintStrategy() {
		super(new AffineTransform());
		// TODO Auto-generated constructor stub
		affinePaintStraList.add(new EllipsePaintStrategy());
		affinePaintStraList.add(new TrianglePaintStrategy());

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Flag";
	}

	public void paint(Graphics g, Ball host) {
		// TODO Auto-generated method stub
		//super.paint(g, host);
		for (ShapePaintStrategy each : affinePaintStraList) {
			each.paint(g, host);
		}
	}

}