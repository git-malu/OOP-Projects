package model;

/**
 * @author LuMa
 *
 */
public class SwitchStrategy implements IUpdateStrategy {
	IUpdateStrategy switcherStra = IUpdateStrategy.nullStrategy;

	@Override
	public void updateState(Ball ball) {
		// TODO Auto-generated method stub
		switcherStra.updateState(ball);
	}

	/**
	 * @param newStra the strategy to update
	 */
	public void setStrategy(IUpdateStrategy newStra) {
		switcherStra = newStra;
	}

}
