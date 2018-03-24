package model;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import common.IChatServer;
import common.IChatroom;
import common.IUser;

/**
 * User
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 14, 2016
 */
public class User implements IUser {
	/**
	 * User name
	 */
	String username;

	/**
	 * User ip address
	 */
	String ip;

	/**
	 * UUID
	 */
	UUID uuid = UUID.randomUUID();

	/**
	 * Chat rooms
	 */
	HashSet<IChatroom> chatrooms = new HashSet<>();

	/**
	 * User to model adapter
	 */
	IUser2ModelAdpt usr2MdlAdpt;

	/**
	 * Constructor
	 * @param username User name
	 * @param ip User ip address
	 * @param usr2MdlAdpt User to model adapter
	 */
	public User(String username, String ip, IUser2ModelAdpt usr2MdlAdpt) {
		this.usr2MdlAdpt = usr2MdlAdpt;
		this.username = username;
		this.ip = ip;
	}

	/**
	 * Get id
	 */
	@Override
	public UUID getId() throws RemoteException {
		return uuid;
	}

	Map<String, IUser> map = new HashMap<>();

	/**
	 * Get user name
	 */
	@Override
	public String getName() throws RemoteException {
		return username;
	}

	/**
	 * Set user name
	 */
	@Override
	public void setName(String name) throws RemoteException {
		this.username = name;

	}

	/**
	 * Get user ip
	 */
	@Override
	public String getIP() throws RemoteException {
		return ip;
	}

	/**
	 * Get a list of chat rooms from the user
	 */
	@Override
	public HashSet<IChatroom> getChatrooms() throws RemoteException {
		return chatrooms;
	}

	/**
	 * Add room
	 */
	@Override
	public boolean addRoom(IChatroom chatroom) throws RemoteException {
		return chatrooms.add(chatroom);
	}

	/**
	 * Remove
	 */
	@Override
	public boolean removeRoom(IChatroom chatroom) throws RemoteException {
		return chatrooms.remove(chatroom);
	}

	/**
	 * Connect back to the previous connected user
	 */
	@Override
	public void connectBack(IUser userStub) throws RemoteException {
		System.out.println(userStub.getName() + "@" + userStub.getIP() + "connected!");
		map.put(userStub.getName() + "@" + userStub.getIP(), userStub);
	}

	/**
	 * Create a new Room Server
	 */
	@Override
	public IChatServer createNewRoomServer(IChatroom chatroom) throws RemoteException {
		ChatServer chatServer = new ChatServer(this, chatroom);
		usr2MdlAdpt.createMiniMVC(chatServer);
		for (IChatServer that : chatroom.getChatServers()) {
			that.joinChatroom(chatServer);
			chatroom.addChatServer(that);
		}
		addRoom(chatroom);
		chatroom.addChatServer(chatServer);
		return chatServer;
	}
}
