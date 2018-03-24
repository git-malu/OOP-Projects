package lm44_xw47.model;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.UUID;

import common.DataPacketUser;
import common.IChatRoom;
import common.IUser;

public class User implements IUser {
	private String name;
	private UUID uuid = UUID.randomUUID();
	
	public User(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() throws RemoteException {
		return name;
	}

	@Override
	public UUID getUUID() throws RemoteException {
		return uuid;
	}

	@Override
	public Collection<IChatRoom> getChatRooms() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connect(IUser userStub) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void receive(DataPacketUser<T> data) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
