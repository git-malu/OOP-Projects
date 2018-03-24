package lm44_xw47.chatRoom.controller;

import java.rmi.RemoteException;

import common.DataPacketCR;
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
import provided.mixedData.MixedDataDictionary;
import provided.mixedData.MixedDataKey;

/**
 * Following defines the class the chat room controller.
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public class ChatRoomController {
	/**
	 * The view of the chat room.
	 */
	private ChatRoomView chatRoomView;
	
	/**
	 * The model of the chatroom.
	 */
	private ChatRoomModel chatRoomModel;
	
	/**
	 * Constructor.
	 * 
	 * @param chatRoom The chat room of this chat room MVC.
	 * @param receiver The local user's receiver stub.
	 * @param mainView The main view of the local system.
	 * @param receiverHost The local user's receiver server object.
	 */
	public ChatRoomController(IChatRoom chatRoom, IReceiver receiver, MainViewFrame<IUser> mainView, Receiver receiverHost) {
		chatRoomModel = new ChatRoomModel(chatRoom, new IChatRoomModel2ViewAdapter() {

			@Override
			public void appendMsg(String msg) {
				chatRoomView.appendMsg(msg);
			}

			@Override
			public ICRCmd2ModelAdapter createCRCmd2ModelAdapter() {
				return new ILocalCRCmd2ModelAdapter() {
					private MixedDataDictionary dict = new MixedDataDictionary();
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
						chatRoomView.getPanelOther().add(fac.makeComponent());
					}

					@Override
					public void buildNonScrollableComponent(IComponentFactory fac, String label) {
						// TODO Auto-generated method stub
						chatRoomView.getPanelOther().add(fac.makeComponent());
					}

					@Override
					public <T> T put(MixedDataKey<T> key, T value) {
						// TODO Auto-generated method stub
						return dict.put(key, value);
					}

					@Override
					public <T> T get(MixedDataKey<T> key) {
						// TODO Auto-generated method stub
						return dict.get(key);
					}

					@Override
					public <T extends ICRMessageType> void sendTo(IReceiver target, Class<T> id, T data) {
						try {
							target.receive(new DataPacketCR<T>(id, data, receiver));
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}

					@Override
					public <T extends ICRMessageType> void sendToChatRoom(Class<T> id, T data) {
						chatRoom.sendPacket(new DataPacketCR<T>(id, data, receiver));
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
	
	/**
	 * Start the chat room MVC.
	 */
	public void start() {
		chatRoomView.start();
	}
}