package controller;

import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;

import chatroom.model.ChatroomModel;
import chatroom.model.IChatroomModel2ViewAdapter;
import chatroom.view.ChatroomView;
import chatroom.view.IChatroomView2ModelAdapter;
import common.IChatRoom;
import common.IComponentFactory;
import common.IReceiver;
import model.ChatAppModel;
import model.ILocalCmd2ModelAdapter;
import model.IModel2ViewAdapter;
import view.ChatAppFrame;
import view.IView2ModelAdapter;

public class Controller {
	private ChatAppModel chatAppModel;
	
	private ChatAppFrame<IChatRoom> chatAppFrame;
	
	private ChatroomView chatroomView;
	
	private ChatroomModel chatroomModel;
	
	public Controller() {
		chatAppModel = new ChatAppModel(new IModel2ViewAdapter() {

			@Override
			public void addBtnChatroom(JButton btnChatroom) {
				// TODO Auto-generated method stub
				chatAppFrame.addChatroomBtn(btnChatroom);
			}

			@Override
			public void addPnlChatroom(JPanel pnlChatroom) {
				// TODO Auto-generated method stub
				chatAppFrame.addComponent(pnlChatroom);
			}
			
			@Override
			public ILocalCmd2ModelAdapter createChatroomPnl(IChatRoom chatroom, IReceiver receiver) {
				ILocalCmd2ModelAdapter localCmd2ModelAdapter;
				chatroomView = new ChatroomView(new IChatroomView2ModelAdapter() {

					@Override
					public void sendMsg(String msg) {
						chatroomModel.sendMsg(msg);
					}

					@Override
					public void sendImg() {
						
					}

					@Override
					public void sendFile() {
						
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
					public void leave() {
						
					}

					@Override
					public void removeUser(String username) {
						chatroomView.removeUser(username);
					}
					
				}, receiver);
				
				chatAppFrame.addTab(new JButton(chatroom.getName()), chatroomView.getContentPnl());
				localCmd2ModelAdapter = new ILocalCmd2ModelAdapter() {

					@Override
					public void appendMsg(String text) {
						System.out.println("xixi: " + text);
						chatroomView.appendMsg(text);
					}

					@Override
					public void buildComponent(IComponentFactory fac) {
						
					}

					@Override
					public void addReceiver(IReceiver receiver) {
						try {
							chatroomView.addUser(receiver.getUserStub().getName());
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}

					@Override
					public void removeReceiver(IReceiver receiver) {
						try {
							chatroomView.removeUser(receiver.getUserStub().getName());
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
				};
				// chatroomModel = null;
				// chatroomView = null;
				return localCmd2ModelAdapter;
			}

			@Override
			public void sendConnectInfo(String info) {
				// TODO Auto-generated method stub
				chatAppFrame.appendInfo(info);
			}

			@Override
			public void addSelectableChatrooms(Set<IChatRoom> chatrooms) {
				// TODO Auto-generated method stub
				chatAppFrame.addJoinableChatrooms(chatrooms);
			}
			
		});
		
		chatAppFrame = new ChatAppFrame<IChatRoom>(new IView2ModelAdapter<IChatRoom>() {

			@Override
			public void connect(String ip) {
				// TODO Auto-generated method stub
				chatAppModel.connect(ip);
			}
			
			@Override
			public void createChatroom(String name) {
				chatAppModel.createChatroom(name);
			}

			@Override
			public void join(IChatRoom chatroom) {
				// TODO Auto-generated method stub
				chatAppModel.join(chatroom);
			}

			@Override
			public void login(String username, int port) {
				// TODO Auto-generated method stub
				chatAppModel.login(username, port);
			}

			@Override
			public void showInfo() {
				// TODO Auto-generated method stub
			}

			@Override
			public void quit() {
				// TODO Auto-generated method stub
				chatAppModel.quit();
			}
			
		});
	}
	
	public void start() {
		chatAppFrame.start();
		chatAppModel.start();
	}
	
	/**
	 * Start the application.
	 * 
	 * @param args The arguments passes from the command-line.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller controller = new Controller();
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
