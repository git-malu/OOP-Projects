package chatroom.model;

import common.DataPacketChatRoom;
import common.IChatRoom;
import common.IReceiver;

public class ChatroomModel {
	private IChatRoom chatroom;
	
	private IChatroomModel2ViewAdapter _chatroomModel2ViewAdapter = IChatroomModel2ViewAdapter.NULL_OBJECT;
	
	private IReceiver user;
	
	public ChatroomModel(IChatRoom chatroom, IChatroomModel2ViewAdapter _chatroomModel2ViewAdapter, IReceiver user) {
		this.chatroom = chatroom;
		this._chatroomModel2ViewAdapter = _chatroomModel2ViewAdapter;
		this.user = user;
	}
	
	public void sendMsg(String msg) {
		_chatroomModel2ViewAdapter.sendMsg(msg);
		chatroom.sendPacket(new DataPacketChatRoom<String>(String.class, msg, user));
	}
	
	public void leave() {
		_chatroomModel2ViewAdapter.sendMsg("You have left the chatroom. \n");
		chatroom.removeIReceiverStub(user);
		_chatroomModel2ViewAdapter.leave();
	}
	
}
