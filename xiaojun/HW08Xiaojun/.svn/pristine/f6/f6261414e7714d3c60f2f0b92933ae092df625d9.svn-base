package model;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import common.IChatRoom;
import common.IUser;

public class User implements IUser{
	private Set<IChatRoom> chatrooms = new HashSet<IChatRoom>();
	
	private UUID uuid = UUID.randomUUID();
	
	private String username;
	
	public User(String username) {
		this.username = username;
	}
	
	@Override
	public String getName() throws RemoteException {
		return username;
	}

	@Override
	public UUID getUUID() throws RemoteException {
		return uuid;
	}

	@Override
	public Iterable<IChatRoom> getChatRooms() throws RemoteException {
		return chatrooms;
	}

	@Override
	public void connect(IUser userStub) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public void joinChatroom(IChatRoom chatroom) {
		chatrooms.add(chatroom);
	}
	
}
