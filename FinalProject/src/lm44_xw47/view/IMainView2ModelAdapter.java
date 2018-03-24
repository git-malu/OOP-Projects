package lm44_xw47.view;

/**
 * Following defines an adapter that main view used to communicate with model.
 * 
 * @author Lu Ma
 * @author Xiaojun Wu
 *
 * @param <TListItem> The type of droplist item.
 */
public interface IMainView2ModelAdapter<TListItem> {
	/**
	 * Connect a remote user by the given ip address.
	 * 
	 * @param ip The ip address of remote user.
	 * @return A list item.
	 */
	public TListItem connect(String ip);
}
