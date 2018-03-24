package util;

public class SetDispatcherSequential<TDispMsg> extends ASetDispatcher<TDispMsg> {
	/**
	 * Implementation: Sequential iteration through the collection of IObservers.
	 */
	@Override
	public void dispatch(TDispMsg msg) {
		getCollection().forEach(o -> {
			o.update(this, msg);
		});
	}

}
