package model;

import java.util.ArrayList;

/**
 * @author LauraHwa
 *
 */
public class MultiStrategy implements IUpdateStrategy {
	ArrayList<IUpdateStrategy> listOfStra = new ArrayList<IUpdateStrategy>();

	/**
	 * @param a 1st strategy to combine
	 * @param b 2nd strategy to combine
	 */
	public MultiStrategy(IUpdateStrategy a, IUpdateStrategy b) {
		listOfStra.add(a);
		listOfStra.add(b);
	}

	@Override
	public void updateState(Ball ball) {
		// TODO Auto-generated method stub
		for (IUpdateStrategy stra : listOfStra) {
			stra.updateState(ball);
		}
	}

	/**
	 * @return the strategy list
	 */
	public ArrayList<IUpdateStrategy> getStraList() {
		return listOfStra;
	}

}
