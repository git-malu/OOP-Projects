package model.strategy;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import model.Ball;

public class ShapePaintStrategy extends APaintStrategy{
	
	/*
	 * shape to be painted
	 * initialized by constructor
	 */
	private Shape shape; 
	
	ShapePaintStrategy(Shape shape){
		this(new AffineTransform(), shape);
	}
	//base constructor
	ShapePaintStrategy(AffineTransform at, Shape shape){
		super(at);
		this.shape = shape;
	}
	
	@Override
	void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		// TODO Auto-generated method stub
		Shape s = at.createTransformedShape(shape);
		Rectangle bounds = s.getBounds();
		at.setToIdentity();
		at.setToTranslation(bounds.getWidth()*0.5, bounds.getHeight()*0.5);
		((Graphics2D) g).fill(at.createTransformedShape(s));// fill -- final paint
		
	}

}
