package view;

/**
 * The interface of the adapter from the view to the model that enables the view to talk to the model.
 * @author LuMa
 * @param <TDropListItem> objects in JCombobox
 */
public interface IView2ModelAdapterCtrl<TDropListItem> {

	/**
	 * The method that tells model the type name of the ball need to create
	 * @param fac strategy of the ball
	 */
	public void makeBall(TDropListItem fac);

	/**
	 * @param fac strategy of the switch ball
	 */
	public void makeSwitchBall(TDropListItem fac);

	/**
	 * The method that tells model to clean all balls on canvas
	 */
	public void clean();

	/**
	 * @param facName name of strategy factory
	 */
	public void makeFac(String facName);

	/**
	 * @param a  1st strategy to combine
	 * @param b  2nd strategy to combine
	 */
	public void combineFac(TDropListItem a, TDropListItem b);

	/**
	 * @param a the strategy to switch
	 */
	public void switchStra(TDropListItem a);
	
	public void makePaintStrategy(String paintStraName);
	
	/**
	 * No-op singleton implementation of IView2ModelAdapter
	 */
	public static final IView2ModelAdapterCtrl<?> NULL_OBJECT = new IView2ModelAdapterCtrl<Object>() {
		//this is for make ball button
		public void makeBall(Object fac) {

		}

		@Override
		public void makeSwitchBall(Object fac) {
			// TODO Auto-generated method stub

		}

		public void combineFac(Object a, Object b) {

		}

		public void clean() {

		}

		//triggered by add to list button
		public void makeFac(String facName) {

		}

		@Override
		public void switchStra(Object a) {
			// TODO Auto-generated method stub

		}
		
		public void makePaintStrategy(String paintStraName) {
			
		}

	};
}
