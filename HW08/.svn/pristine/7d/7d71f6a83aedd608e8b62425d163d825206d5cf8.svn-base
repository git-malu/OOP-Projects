package client.clientView;

/**
 * Adapter the view uses to communicate to the model
 * 
 * @author Yue Jiang, Lu Ma
 *
 * @param <TDropListItem>
 *            The droplist item
 */
public interface IModelAdapter<TDropListItem> {

	/**
	 * Requests that model connect to the RMI Registry at the given remote host
	 * 
	 * @param s
	 *            The remote host to connect to.
	 * @return A status string regarding the connection result
	 */
	public String connectTo(String s);

	/**
	 * Quits the applications and gracefully shuts down the RMI-related resources.
	 */
	public void quit();

	/**
	 * Send the message to remote host
	 * 
	 * @param s
	 *            The message needed to send
	 */
	public void sendMsgToRemoteHost(String s);

	/**
	 * Run task
	 * 
	 * @param item
	 *            The selected item
	 * @param s
	 *            The parameter need to initial the task
	 * @return The desired task
	 */
	public String runTask(TDropListItem item, String s);

	/**
	 * Add task to combo list
	 * 
	 * @param s
	 *            The name of the desired task
	 * @return The desrired task
	 */
	public TDropListItem addTask(String s);

	/**
	 * Return a new object to put on both lists, given two items from the lists.
	 * 
	 * @param item1
	 *            An object from one drop list
	 * @param item2
	 *            An object from the other drop list
	 * @return An object to put back on both lists.
	 */
	public TDropListItem combineTasks(TDropListItem item1, TDropListItem item2);

}
