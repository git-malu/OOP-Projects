package lm44_xw47.chatRoom.model;

import common.DataPacketCR;
import common.IChatRoom;
import common.IReceiver;
import common.datatype.chatroom.IRemoveReceiverType;
import lm44_xw47.chatRoom.model.dataType.RemoveReceiverType;
import lm44_xw47.chatRoom.model.dataType.StringMsgType;
import lm44_xw47.model.Receiver;

/**
 * Following defines the model of the chat room.
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public class ChatRoomModel {
	/**
	 * The chatroom for the local chatroom MVC.
	 */
	private IChatRoom chatRoom;
	
	/**
	 * The adapter this chat room model uses to communicate with chat room view.
	 */
	private IChatRoomModel2ViewAdapter chatRoomModel2ViewAdapter;
	
	/**
	 * The receiver stub for the local user.
	 */
	private IReceiver receiver;   
	
	/**
	 * The receiver server object for the local user.
	 */
	private Receiver receiverHost;
	
	/**
	 * Constructor.
	 * 
	 * @param chatRoom The chat room of this chat room MVC.
	 * @param chatRoomModel2ViewAdapter The adapter this chat room model uses to communicate with chat room view.
	 * @param receiver The local user's receiver stub.
	 * @param receiverHost The local user's receiver server object.
	 */
	public ChatRoomModel(IChatRoom chatRoom, IChatRoomModel2ViewAdapter chatRoomModel2ViewAdapter, IReceiver receiver, Receiver receiverHost) {
		this.chatRoom = chatRoom;
		this.chatRoomModel2ViewAdapter = chatRoomModel2ViewAdapter;
		this.receiver = receiver;
		this.receiverHost = receiverHost;
		init();
	}
	
	/**
	 * Initialize the local reciever server object.
	 */
	private void init() {
		receiverHost.init(chatRoomModel2ViewAdapter.createCRCmd2ModelAdapter(), receiver);
	}
	
	/**
	 * Send message to users in this chat room.
	 * 
	 * @param msg Message being sent to users in this chatroom.
	 */
	public void sendMsg(String msg) {
		chatRoom.sendPacket(new DataPacketCR<StringMsgType>(StringMsgType.class, new StringMsgType(msg), receiver));
	}
	
	/**
	 * Leave the chat room.
	 */
	public void leave() {
		chatRoom.removeIReceiverStub(receiver);
		chatRoom.sendPacket(new DataPacketCR<IRemoveReceiverType>(IRemoveReceiverType.class, new RemoveReceiverType(receiver), receiver));
	}
	
	/**
	 * Add a receiver to the chat room.
	 * 
	 * @param receiver The receiver being added to this chat room.
	 */
	public void addReceiver(IReceiver receiver) {
		chatRoom.addIReceiverStub(receiver);
	}
	
	/**
	 * Remove a receiver from the chat room.
	 * 
	 * @param receiver The receiver being removed from this chat room.
	 */
	public void removeReceiver(IReceiver receiver) {
		chatRoom.removeIReceiverStub(receiver);
	}
}
