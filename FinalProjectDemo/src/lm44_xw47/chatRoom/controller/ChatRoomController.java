package lm44_xw47.chatRoom.controller;

import common.ICRCmd2ModelAdapter;
import common.ICRMessageType;
import common.IChatRoom;
import common.IComponentFactory;
import common.IReceiver;
import common.IUser;
import lm44_xw47.chatRoom.model.ChatRoomModel;
import lm44_xw47.chatRoom.model.IChatRoomModel2ViewAdapter;
import lm44_xw47.chatRoom.model.ILocalCRCmd2ModelAdapter;
import lm44_xw47.chatRoom.view.ChatRoomView;
import lm44_xw47.chatRoom.view.IChatRoomView2ModelAdapter;
import lm44_xw47.model.Receiver;
import lm44_xw47.view.MainViewFrame;
import provided.mixedData.MixedDataKey;

public class ChatRoomController {
	private ChatRoomView chatRoomView;
	
	private ChatRoomModel chatRoomModel;
	
	public ChatRoomController(IChatRoom chatRoom, IReceiver receiver, MainViewFrame<IUser> mainView, Receiver receiverHost) {
		chatRoomModel = new ChatRoomModel(chatRoom, new IChatRoomModel2ViewAdapter() {

			@Override
			public void appendMsg(String msg) {
				chatRoomView.appendMsg(msg);
			}

			@Override
			public ICRCmd2ModelAdapter createCRCmd2ModelAdapter() {
				return new ILocalCRCmd2ModelAdapter() {

					@Override
					public String getName() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public void appendMsg(String text, String name) {
						chatRoomView.appendMsg(name + text); 
					}

					@Override
					public void buildScrollableComponent(IComponentFactory fac, String label) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void buildNonScrollableComponent(IComponentFactory fac, String label) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public <T> T put(MixedDataKey<T> key, T value) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public <T> T get(MixedDataKey<T> key) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public <T extends ICRMessageType> void sendTo(IReceiver target, Class<T> id, T data) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public <T extends ICRMessageType> void sendToChatRoom(Class<T> id, T data) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void addReceiver(IReceiver receiver) {
						chatRoomModel.addReceiver(receiver);
					}

					@Override
					public void removeReceiver(IReceiver receiver) {
						chatRoomModel.removeReceiver(receiver);
					}
					
				};
			}
			
		}, receiver, receiverHost);
		
		chatRoomView = new ChatRoomView(new IChatRoomView2ModelAdapter() {

			@Override
			public void start() {
			}

			@Override
			public void sendMsg(String msg) {
				chatRoomModel.sendMsg(msg);
			}

			@Override
			public void leave() {
				chatRoomModel.leave();
				// lobbyView.removeTeamView(chatRoomView.getContentPnl());
			}
		});
		mainView.addMiniView(chatRoomView.getContentPnl(), chatRoom.getName());
		// lobbyView.addTeamView(chatRoomView.getContentPnl());
	}
	
	public void start() {
		chatRoomView.start();
	}
}