package model.strategy;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import model.Ball;

/**
 * Paint strategy that paints an image from a file, scaled to the host Ball's radius.
 * Note that this class cannot be used by the BallWar system directly as it is lacking a no-parameter constructor.
 * 
 * @author daiwei.ldw
 * */

public class ImagePaintStrategy extends APaintStrategy {

	/**
	 * Variables specifically for presenting image correctly
	 * */
	private double fillFactor;
	protected Image img;
	private ImageObserver imageObs;
	protected AffineTransform localAT = new AffineTransform();
	private double scaleFactor;
	protected AffineTransform tempAT;

	/**
	 * Constructor that takes an external AffineTransform, the filename of the image to paint and a fill factor of the image.
	 * @param at the AffineTransform for the image
	 * @param filename Corresponding filename for the image
	 * @param fillFactor The fill factor for the image
	 * */
	public ImagePaintStrategy(AffineTransform at, String filename, double fillFactor) {
		super(at);

		try {
			img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(filename));
		} catch (Exception e) {
			System.err.println("ImagePaintStrategy: Error reading file: " + filename + "\n" + e);
		}
		this.tempAT = at;
		this.fillFactor = fillFactor;

	}

	/**
	 * Initializes the internal ImageObserver reference from the host Ball Also calculates the net scale factor for the image.
	 * @param host Hosting ball
	 * */
	public void init(Ball host) {
		imageObs = host.getContainer();
		MediaTracker mt = new MediaTracker(host.getContainer());
		mt.addImage(img, 1);
		try {
			mt.waitForAll();
		} catch (Exception e) {
			System.out.println("ImagePaintStrategy.init(): Error waiting for image.  Exception = " + e);
		}

		scaleFactor = 2.0 / (fillFactor * (img.getWidth(imageObs) + img.getHeight(imageObs)) / 2.0);
	}

	/**
	 * Override function to paint image correctly
	 * @param g Graphics Object
	 * @param host Hosting ball
	 * */
	@Override
	public void paint(Graphics g, Ball host) {
		// TODO Auto-generated method stub

		double scale = host.getRadius();

		//calculate from down to up
		at.setToTranslation(host.getLocation().x, host.getLocation().y);
		at.rotate(host.getVelocity().x, host.getVelocity().y);
		at.scale(scale, scale);
		g.setColor(host.getColor());
		paintCfg(g, host);
		paintXfrm(g, host, at);
	}

	/**
	 * Constructor that takes the image filename and fill factor.
	 * @param filename Corresponding filename for the image
	 * @param fillFactor The fill factor for the image
	 * */
	public ImagePaintStrategy(java.lang.String filename, double fillFactor) {
		super(new AffineTransform());

		//    AffineTransform at = new AffineTransform();
		try {
			img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(filename));
		} catch (Exception e) {
			System.err.println("ImagePaintStrategy: Error reading file: " + filename + "\n" + e);
		}
		//    this.tempAT = at;
		this.fillFactor = fillFactor;

	}

	/**
	 * Override function to paint image correctly
	 * @param g Graphics Object
	 * @param host Hosting ball
	 * @para at the AffineTransform for the image
	 * */
	@Override
	void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		// TODO Auto-generated method stub
		localAT.setToScale(scaleFactor, scaleFactor);
		localAT.translate(-img.getWidth(imageObs) / 2.0, -img.getHeight(imageObs) / 2.0);
		localAT.preConcatenate(at);
		((Graphics2D) g).drawImage(img, localAT, imageObs);
	}

}
