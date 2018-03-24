package model.paint.strategies;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import model.balls.Ball;

/**
 * Paint strategy that paints an image from a file, scaled to the host Ball's radius. Note that this class 
 * cannot be used by the BallWar system directly as it is lacking a no-parameter constructor.
 * 
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public abstract class ImagePaintStrategy extends APaintStrategy {

	private double fillFactor;
	private Image image;
	private ImageObserver imageObs;
	private AffineTransform localAT = new AffineTransform();
	//	private AffineTransform tempAt = new AffineTransform();
	private double scaleFactor = 1.0;

	/**
	 * Constructor that takes an external AffineTransform, the filename of the image to paint and a fill factor of the image.
	 * @param at 
	 * 		The AffineTransform to use internally.
	 * @param filename 
	 * 		The filename of the image file to use.
	 * @param fillFactor 
	 * 		The ratio of the desired average diameter of the image to the actual average of the image's width and height.
	 */
	public ImagePaintStrategy(AffineTransform at, String filename, double fillFactor) {
		super(at);
		this.fillFactor = fillFactor;
		try {
			image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(filename));
		} catch (Exception e) {
			System.err.println("ImagePaintStrategy: Error reading file: " + filename + "\n" + e);
		}
	}

	/**
	 * Constructor that takes the image filename and fill factor. An AffineTransform is instantiated for internal use. GIF, JPG, PNG and any other file that can be loaded by an ImageIcon object can be used, including animated GIF's as the above files are.
	 * @param filename
	 * 		The filename of the image file to use.
	 * @param fillFactor
	 * 		The ratio of the desired average diameter of the image to the actual average of the image's width and height.
	 */
	public ImagePaintStrategy(String filename, double fillFactor) {
		this(new AffineTransform(), filename, fillFactor);
	}

	@Override
	/**
	 * Draws the image on the given Graphics context using the given affine transform in combination with the local affine transform.
	 */
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		// TODO Auto-generated method stub
		localAT.setToScale(scaleFactor, scaleFactor);
		localAT.translate(-image.getWidth(imageObs) / 2.0, -image.getHeight(imageObs) / 2.0);
		localAT.preConcatenate(at);
		((Graphics2D) g).drawImage(image, localAT, imageObs);
	}

	@Override
	/**
	 * Initializes the internal ImageObserver reference from the host Ball Also calculates the net scale factor for the image.
	 */
	public void init(Ball host) {
		imageObs = host.getCanvas();
		MediaTracker mt = new MediaTracker(host.getCanvas());
		mt.addImage(image, 1);
		try {
			mt.waitForAll();
		} catch (Exception e) {
			System.out.println("ImagePaintStrategy.init(): Error waiting for image.  Exception = " + e);
		}

		scaleFactor = 2.0 / (fillFactor * (image.getWidth(imageObs) + image.getHeight(imageObs)) / 2.0);
	}

}
