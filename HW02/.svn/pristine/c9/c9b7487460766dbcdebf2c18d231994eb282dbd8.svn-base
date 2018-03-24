package ballModel;

import java.util.Observable;

public class Dispatcher extends Observable {

    /**
     * Immediately notifies all the Observers held.
     * @param param An input parameter that is passed on to all the Observers.
     */

    public void notifyAll(Object param) {
        setChanged();
        notifyObservers(param);
    }
}
