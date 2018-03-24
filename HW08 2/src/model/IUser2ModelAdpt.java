package model;

/**
 * User to model adapter
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 14, 2016
 */
public interface IUser2ModelAdpt {

	/**
	 * Create a mini mvc
	 * @param chatServer The chat server to be added to the mini mvc
	 */
	void createMiniMVC(ChatServer chatServer);
}
