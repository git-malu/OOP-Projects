package lm44_xw47.chatRoom.model;

import common.DataPacketCR;
import common.IChatRoom;
import common.IReceiver;
import common.datatype.chatroom.IRemoveReceiverType;
import lm44_xw47.chatRoom.model.dataType.RemoveReceiverType;
import lm44_xw47.chatRoom.model.dataType.StringMsgType;
import lm44_xw47.model.Receiver;

public class ChatRoomModel {
	private IChatRoom chatRoom;
	
	private IChatRoomModel2ViewAdapter chatRoomModel2ViewAdapter;
	
	private IReceiver receiver;   
	
	private Receiver receiverHost;
	
	public ChatRoomModel(IChatRoom chatRoom, IChatRoomModel2ViewAdapter chatRoomModel2ViewAdapter, IReceiver receiver, Receiver receiverHost) {
		this.chatRoom = chatRoom;
		this.chatRoomModel2ViewAdapter = chatRoomModel2ViewAdapter;
		this.receiver = receiver;
		this.receiverHost = receiverHost;
		init();
	}
	
	private void init() {
		receiverHost.init(chatRoomModel2ViewAdapter.createCRCmd2ModelAdapter(), receiver);
	}
	
	public void sendMsg(String msg) {
		chatRoom.sendPacket(new DataPacketCR<StringMsgType>(StringMsgType.class, new StringMsgType(msg), receiver));
	}
	
	public void leave() {
		chatRoom.removeIReceiverStub(receiver);
		chatRoom.sendPacket(new DataPacketCR<IRemoveReceiverType>(IRemoveReceiverType.class, new RemoveReceiverType(receiver), receiver));
	}
	
	public void addReceiver(IReceiver receiver) {
		chatRoom.addIReceiverStub(receiver);
	}
	
	public void removeReceiver(IReceiver receiver) {
		chatRoom.removeIReceiverStub(receiver);
	}
}
