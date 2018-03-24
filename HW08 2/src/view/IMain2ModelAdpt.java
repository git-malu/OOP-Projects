package view;

import common.IChatroom;
import common.IUser;

/**
 * Main to model adapter
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 14, 2016
 */
public interface IMain2ModelAdpt {

	/**
	 * Connect to remote user
	 * @param ip Remote user ip address
	 * @return The user to be connected
	 */
	IUser connect(String ip);

	/**
	 * Join a chat room
	 * @param room The room to be joinded
	 */
	void joinChatRoom(IChatroom room);

	/**
	 * Create a new room
	 * @param roomname Room name
	 */
	void creatRoom(String roomname);

	/**
	 * Close the chat app
	 */
	void closeChatApp();
}
