package chatroom.controller;

import chatroom.model.ChatroomModel;
import chatroom.model.IChatroomModel2ViewAdapter;
import chatroom.view.ChatroomView;
import chatroom.view.IChatroomView2ModelAdapter;
import common.IChatRoom;
import common.IReceiver;

public class ChatroomController {
	private ChatroomView chatroomView;
	private ChatroomModel chatroomModel;
	
	public ChatroomController(IReceiver user, IChatRoom chatroom) {
		chatroomView = new ChatroomView(new IChatroomView2ModelAdapter() {

			@Override
			public void sendMsg(String msg) {
				chatroomModel.sendMsg(msg);
			}

			@Override
			public void sendImg() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void sendFile() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void leave() {
				chatroomModel.leave();
			}
			
		});
		
		chatroomModel = new ChatroomModel(chatroom, new IChatroomModel2ViewAdapter() {

			@Override
			public void sendMsg(String msg) {
				chatroomView.appendMsg(msg);
			}

			@Override
			public void addUser(String username) {
				chatroomView.addUser(username);
			}
			
			@Override
			public void removeUser(String username) {
				chatroomView.removeUser(username);
			}
			
			@Override
			public void leave() {
				
			}
			
		}, user);
	}
}
