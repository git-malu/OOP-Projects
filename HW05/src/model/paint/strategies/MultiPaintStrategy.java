package model.paint.strategies;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.balls.Ball;

/**
 * A composite design pattern extension of APaintStrategy that paints a set of paint strategies. 
 * Note: This paint strategy cannot be used directly by the BallWorld system because it lacks a 
 * no-parameter constructor.
 * 
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public abstract class MultiPaintStrategy extends APaintStrategy {

	private APaintStrategy[] pstrats = new APaintStrategy[] {};

	/**
	 * Constructor that takes the paint strategies that will part of the composite. An AffineTransform is instantiated for internal use.
	 * @param pstrats
	 * 		Vararg parameter that are the paint strategies that will make up the composite.
	 */
	public MultiPaintStrategy(APaintStrategy... pstrats) {
		this(new AffineTransform(), pstrats);
	}

	/**
	 * Constructor that takes the paint strategies that will part of the composite. An external AffineTransform is supplied for internal use.
	 * @param at
	 * 		The AffineTransform to use.
	 * @param pstrats
	 * 		Vararg parameter that are the paint strategies that will make up the composite.
	 */
	public MultiPaintStrategy(AffineTransform at, APaintStrategy... pstrats) {
		super(at);
		this.pstrats = pstrats;
	}

	@Override
	/**
	 * Delegates to all the IPaintStrategies in the composite. Paints using given Graphics 
	 * context using the supplied AffineTransform. Called by the inherited paint method.
	 */
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		// TODO Auto-generated method stub
		for (APaintStrategy ps : pstrats) {
			ps.paintXfrm(g, host, at);
		}
	}

	@Override
	/**
	 * Delegates to all the IPaintStrategies in the composite. Used to initialize the paint strategies.
	 */
	public void init(Ball host) {

	}

	@Override
	/**
	 * Call the paintCfg method of all the components.
	 */
	public void paintCfg(Graphics g, Ball host) {
		for (APaintStrategy ps : pstrats) {
			ps.paintCfg(g, host);
		}
	}

}
