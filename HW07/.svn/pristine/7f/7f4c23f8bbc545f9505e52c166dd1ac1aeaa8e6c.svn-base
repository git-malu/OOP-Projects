package client.clientModel;

/**
 * Interface IViewAdapter that goes from the model to the view that enables the
 * model to talk to the view and ask the view to update.
 * 
 * @author Yue Jiang, Lu Ma
 *
 */
public interface IViewAdapter {

	/**
	 * Appends the string to the end of the text display on the view The view
	 * 
	 * @param s
	 *            The String to append
	 */
	public void append(String s);

	/**
	 * Sets the displayed remote host address.
	 * 
	 * @param hostAddress
	 *            The IP address or host name of the remote host.
	 */
	public void setRemoteHost(String hostAddress);

	/**
	 * No-op singleton implementation of IViewAdapter
	 */
	public static final IViewAdapter NULL_OBJECT = new IViewAdapter() {

		@Override
		public void append(String s) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setRemoteHost(String hostAddress) {
			// TODO Auto-generated method stub

		}

	};

}
