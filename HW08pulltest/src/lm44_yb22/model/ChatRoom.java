package lm44_yb22.model;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import common.DataPacketChatRoom;
import common.IChatRoom;
import common.IReceiver;
/**
 * A chat room is a FULLY SERIALIZABLE object that is wholly transmitted from one machine to another machine
 * A chat room holds a set of IReceiver stubs.
 */
public class ChatRoom implements IChatRoom {
	private String chatRoomName;

	private UUID uuid = UUID.randomUUID();
	private HashSet<IReceiver> receiverStubs = new HashSet<>();
	
	private static final long serialVersionUID = 3770590535326651361L;
	
	
	public ChatRoom(String name){
		chatRoomName = name;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return chatRoomName;
	}
	

	@Override
	public UUID getUUID() {
		// TODO Auto-generated method stub
		return uuid;
	}
	
	@Override
	public Collection<IReceiver> getIReceiverStubs() {
		// TODO Auto-generated method stub
		return receiverStubs;
	}
	

	@Override
	public <T> void sendPacket(DataPacketChatRoom<T> data) {
		System.out.println(receiverStubs.size());
		// TODO Auto-generated method stub
		for (IReceiver eachReceiverStub : receiverStubs) {
			try {
				System.out.println(eachReceiverStub);
				eachReceiverStub.receive(data);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public boolean addIReceiverStubLocally(IReceiver receiver) {
		boolean t = receiverStubs.add(receiver);
		System.out.println("chat room size: "+receiverStubs.size());
		return t;
	}

	@Override
	public boolean removeIReceiverStubLocally(IReceiver receiver) {
		boolean t = receiverStubs.remove(receiver);
		System.out.println("chat room size: "+receiverStubs.size());
		return t;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null) {
			return false;
		}else {
			if(obj instanceof ChatRoom) {
				return uuid.equals(((ChatRoom)obj).uuid);
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return uuid.hashCode();
	}

}
