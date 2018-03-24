package view;

/**
 * Following defines a adapter that view uses to communicate with model.
 * 
 * @author 
 * @author 
 */

public interface IView2ModelAdapter<IDroplistItem> {
	/**
	 * Connects the remote user with the given ip.
	 * 
	 * @param ip The ip address of the remote user.
	 */
	public void connect(String ip);
	
	/**
	 * Create a chatroom with the given chatroom name.
	 * 
	 * @param name The name of the created chatroom.
	 */
	public void createChatroom(String name);
	
	/**
	 * Join the chatroom.
	 * 
	 * @param chatroom The chatroom the user wants to join.
	 */
	public void join(IDroplistItem chatroom);
	
	/**
	 * login a user by the given username.
	 * 
	 * @param username The username of the login user.
	 * @param port The port number this user uses.
	 */
	public void login(String username, int port);
	
	/**
	 * logout the existing user.
	 */
	// public void logout();
	
	/**
	 * Show the information panel.
	 */
	public void showInfo();
	
	/**
	 * Quit the chatApp.
	 */
	public void quit();
	
}