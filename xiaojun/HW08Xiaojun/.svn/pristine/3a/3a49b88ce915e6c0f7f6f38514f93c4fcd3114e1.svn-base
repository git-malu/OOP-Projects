package model;

import common.ICmd2ModelAdapter;
import common.IComponentFactory;
import common.IReceiver;

public interface ILocalCmd2ModelAdapter extends ICmd2ModelAdapter{
	/**
	 * Add  the given receiver to the local system.
	 * 
	 * @param receiver The receiver being added to the local system.
	 */
	public void addReceiver(IReceiver receiver);
	
	/**
	 * Remove the given receiver from the local system.
	 * 
	 * @param receiver The receiver being removed from the local system.
	 */
	public void removeReceiver(IReceiver receiver);
	
	public static final ILocalCmd2ModelAdapter NULL_OBJECT = new ILocalCmd2ModelAdapter() {
		/**
		 * No-op
		 */
		@Override
		public void appendMsg(String text) {
		}

		/**
		 * No-op
		 */
		@Override
		public void buildComponent(IComponentFactory fac) {
		}

		/**
		 * No-op
		 */
		@Override
		public void addReceiver(IReceiver receiver) {
		}

		/**
		 * No-op
		 */
		@Override
		public void removeReceiver(IReceiver receiver) {
		}
		
	};
}
