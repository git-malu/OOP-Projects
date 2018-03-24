package model;

/**
 * @author LauraHwa
 *
 */
public interface IStrategyFac {

	/**
	 * @return strategy made
	 */
	public IUpdateStrategy makeStrategy();

	public String toString();

	/**
	 * null object
	 */
	public static IStrategyFac nullFac = new IStrategyFac() {
		public IUpdateStrategy makeStrategy() {
			return null; //return null strategy
		}
	};

}
