package lm44_xw47.chatRoom.model.dataType;

import common.IReceiver;
import common.datatype.chatroom.IAddReceiverType;

/**
 * Following defines the data type that add a receiver.
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public class AddReceiverType implements IAddReceiverType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 1980907733138407764L;
	
	/**
	 * The receiver being added to chat room.
	 */
	private IReceiver receiver;
	
	/**
	 * Constructor.
	 * 
	 * @param receiver The receiver being added to chat room.
	 */
	public AddReceiverType(IReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public IReceiver getReceiverStub() {
		return receiver;
	}
	
}
