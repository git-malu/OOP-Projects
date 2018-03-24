package model;

import java.util.HashSet;
import java.util.UUID;
import common.IChatServer;
import common.IChatroom;
import provided.datapacket.ADataPacket;

/**
 * Chat Room
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 14, 2016
 */
public class ChatRoom implements IChatroom {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 352627430011632595L;

	/**
	 * UUID
	 */
	private UUID id = UUID.randomUUID();

	/**
	 * Chat room name
	 */
	private String name;

	/**
	 * List of chat servers in the this room
	 */
	private HashSet<IChatServer> chatServers = new HashSet<>();

	/**
	 * Get room id
	 */
	@Override
	public UUID getId() {
		return id;
	}

	/**
	 * Get room name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Set room name
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get chat servers contained in this chat room
	 */
	@Override
	public HashSet<IChatServer> getChatServers() {
		return chatServers;
	}

	/**
	 * Add chat server to this 
	 */
	@Override
	public boolean addChatServer(IChatServer chatServer) {
		return chatServers.add(chatServer);
	}

	/**
	 * Remove chat server from this room
	 */
	@Override
	public boolean removeChatServer(IChatServer chatServer) {
		return chatServers.remove(chatServer);
	}

	/**
	 * Send a message 
	 */
	@Override
	public void send(ADataPacket message) {

	}

	/**
	 * To String 
	 */
	@Override
	public String toString() {
		return this.name;
	}

}
