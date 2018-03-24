package model.paint.strategies;

/**
 * Subclass of AnimatePaintStrategy that alternates between a Fish1PaintStrategy and a Fish2PaintStrategy.
 * 
 * @author Yuchang Shen and Weiheng Qiu
 *
 */
public class SwimFishPaintStrategy extends AnimatePaintStrategy {

	private static Fish1PaintStrategy fish1 = new Fish1PaintStrategy();
	private static Fish2PaintStrategy fish2 = new Fish2PaintStrategy();

	/**
	 * No-parameter constructor that instantiates an AffineTransform for internal use.
	 */
	public SwimFishPaintStrategy() {
		this(fish1, fish1, fish2, fish2);
	}

	/**
	 * Constructor that take in several fish paint strategy to make a swimming fish.
	 * @param strat1
	 * 		the first fish strategy
	 * @param strat2
	 * 		the second fish strategy
	 * @param strat3
	 * 		the third fish strategy
	 * @param strat4
	 * 		the forth fish strategy
	 */
	public SwimFishPaintStrategy(APaintStrategy strat1, APaintStrategy strat2, APaintStrategy strat3,
			APaintStrategy strat4) {
		super(strat1, strat2, strat3, strat4);
	}
}
