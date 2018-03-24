package model.strategy;

import java.awt.Graphics;

import model.Ball;

/**
 * An image painting strategy that adds a paintCfg override that keeps the image upright no matter which way it is going.
 * 
 * @author daiwei.ldw
 * */
public class UprightImagePaintStrategy extends ImagePaintStrategy {

	/**
	 * Constructor for an image painting strategy
	 * @param filename Corresponding filename for the image
	 * @param fillFactor The fill factor for the image
	 * */
	public UprightImagePaintStrategy(String filename, double fillFactor) {
		super(filename, fillFactor);
	}

	/**
	 * Override function to paint image correctly
	 * @param g Graphics Object
	 * @param host Hosting ball
	 * */
	protected void paintCfg(Graphics g, Ball host) {
		super.paintCfg(g, host);
		if (Math.abs(Math.atan2(host.getVelocity().y, host.getVelocity().x)) > Math.PI / 2.0) {
			at.scale(1.0, -1.0);
		}
	}

}
