package model.paint.strategies;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.balls.Ball;

/**
 * Concrete paint strategy that cycles through a sequence of paint strategies, painting 
 * one per paint update. Note: This paint strategy cannot be directly instantiated by the 
 * BallWorld system because it does not have a no-parameter constructor.
 * 
 * @author Yuchang Shen and Weiheng Qui
 *
 */
public abstract class AnimatePaintStrategy extends APaintStrategy {

	private APaintStrategy[] pstrats = new APaintStrategy[] {};
	private int count = 0;

	/**
	 * Constructor that instantiates an AffineTransform for internal use.
	 * @param pstrats 
	 * 		vararg input of the paint strategies to cycle through, in order.
	 */
	public AnimatePaintStrategy(APaintStrategy... pstrats) {
		this(new AffineTransform(), pstrats);
	}

	/**
	 * Constructor that uses the supplied AffineTransform for internal use.
	 * @param at 
	 * 		The AffineTransform to use.
	 * @param pstrats 
	 * 		vararg input of the paint strategies to cycle through, in order.
	 */
	public AnimatePaintStrategy(AffineTransform at, APaintStrategy... pstrats) {
		super(at);
		this.pstrats = pstrats;
	}

	@Override
	/**
	 * Paints the currently indexed paint strategy on the given Graphics context using the supplied 
	 * AffineTransform. Called by the inherited paint method.
	 */
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		// TODO Auto-generated method stub
		pstrats[count++ % pstrats.length].paintXfrm(g, host, at);
	}

	/**
	 * For test purpose.
	 * Print out the radius of the host ball and the "count" of that ball. 
	 */
	@Override
	public void paintCfg(Graphics g, Ball host) {
		System.out.print(host.getRadius());
		System.out.print(" count ");
		System.out.println(count);
	}

}
