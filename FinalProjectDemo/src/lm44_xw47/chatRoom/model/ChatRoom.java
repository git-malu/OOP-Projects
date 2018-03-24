package lm44_xw47.chatRoom.model;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import common.DataPacketCR;
import common.ICRMessageType;
import common.IChatRoom;
import common.IReceiver;

public class ChatRoom implements IChatRoom{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8318129351498068920L;
	
	/**
	 * Name of this chatroom.
	 */
	private String name = "";

	/**
	 * Unique for this chatroom.
	 */
	private UUID uuid = UUID.randomUUID();

	/**
	 * A set of receivers in this chatroom.
	 */
	private Set<IReceiver> receivers = new HashSet<IReceiver>();
	
	/**
	 * Constructor.
	 * 
	 * @param name The name of this chatroom.
	 */
	public ChatRoom(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public UUID getUUID() {
		// TODO Auto-generated method stub
		return uuid;
	}

	@Override
	public Collection<IReceiver> getIReceiverStubs() {
		return receivers;
	}

	@Override
	public <T extends ICRMessageType> void sendPacket(DataPacketCR<T> data) {
		Thread newThread;
		for (IReceiver receiver : receivers) {
			newThread = new Thread() {
				public void run() {
					try {
						System.out.println("Send image");
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
		return receivers.add(receiver);
	}

	@Override
	public boolean removeIReceiverStub(IReceiver receiver) {
		return receivers.remove(receiver);
	}
	
	@Override
	public String toString() {
		return getName();
	}

	@Override
	public boolean equals(Object o) {
		if (null != o) {
			if (o instanceof IChatRoom) {
				return uuid.equals(((IChatRoom) o).getUUID());
			}
		}

		return false;
	}

	@Override
	public int hashCode() {
		return uuid.hashCode();
	}

}
