package util;

import java.util.Observable;

/**
 * A simplified Observable class that immediately notifies its Observers when its notifyAll() method is called.
 * The changed state of the Dispatcher does not need to be separately set.
 * @author LuMa
 */
public class Dispatcher extends Observable {
	/**
	 * name
	 */
	public String name;

	/**
	 * Immediately notifies all the Observers held.
	 * @param name An input parameter that is passed on to all the Observers.
	 */

	public Dispatcher(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	/**
	 * @param param notify objects
	 */
	public void notifyAll(Object param) {
		setChanged();
		notifyObservers(param);

	}
}
