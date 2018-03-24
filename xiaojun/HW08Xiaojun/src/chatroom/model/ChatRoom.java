package chatroom.model;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import common.DataPacketChatRoom;
import common.IAddReceiverType;
import common.IChatRoom;
import common.IReceiver;
import common.IRemoveReceiverType;
import model.dataType.AddReceiverType;
import model.dataType.RemoveReceiverType;

public class ChatRoom implements IChatRoom{
	
	/**
	 * Auto generated id for serialization.
	 */
	private static final long serialVersionUID = 7035920115160366063L;

	private String name = "";
	
	private UUID uuid = UUID.randomUUID();
	
	private Set<IReceiver> receivers = new HashSet<IReceiver>();
	
	public ChatRoom(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public UUID getUUID() {
		return uuid;
	}

	@Override
	public Iterable<IReceiver> getIReceiverStubs() {
		return receivers;
	}

	@Override
	public <T> void sendPacket(DataPacketChatRoom<T> data) {
		Thread newThread;
		for (IReceiver receiver : receivers) {
			newThread = new Thread() {
				public void run() {
					try {
						receiver.receive(data);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			};
			newThread.run();
		}
	}

	@Override
	public boolean addIReceiverStub(IReceiver receiver) {
		if (receivers.contains(receiver)) {
			return false;
		}
		
		sendPacket(new DataPacketChatRoom<IAddReceiverType>(IAddReceiverType.class, new AddReceiverType(receiver), receiver));
		
		return addIReceiverStubLocally(receiver);
	}

	@Override
	public boolean removeIReceiverStub(IReceiver receiver) {
		if (! receivers.contains(receiver)) {
			return false;
		}
		removeIReceiverStubLocally(receiver);
		sendPacket(new DataPacketChatRoom<IRemoveReceiverType>(IRemoveReceiverType.class, new RemoveReceiverType(receiver), receiver));
		return true;
	}

	@Override
	public boolean addIReceiverStubLocally(IReceiver receiver) {
		return receivers.add(receiver);
	}

	@Override
	public boolean removeIReceiverStubLocally(IReceiver receiver) {
		return receivers.remove(receiver);
	}
	
}