package lm44_yb22.controller;

import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.function.Consumer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import common.DataPacketChatRoom;
import common.IChatRoom;
import common.IComponentFactory;
import common.IReceiver;
import common.IRemoveReceiverType;
import common.IUser;
import lm44_yb22.model.IMainModelMainAdapter;
import lm44_yb22.model.IMiniModel2MiniViewAdpt;
import lm44_yb22.model.IReceiverAdapter;
import lm44_yb22.model.IMainModel2MiniMVCAdpt;
import lm44_yb22.model.MainModel;
import lm44_yb22.model.MiniModel;
import lm44_yb22.model.dataType.RemoveReceiverType;
import lm44_yb22.view.IMainViewAdapter;
import lm44_yb22.view.IMiniViewAdapter;
import lm44_yb22.view.MainView;
import lm44_yb22.view.MiniView;

/**
 * This is the engine controller of engine MVC.
 * @author malu
 *
 */
public class MainController {
	MainView mainView;
	MainModel mainModel;
	/**
	 * constructor who initializes engineModel and engineView
	 */
	public MainController() {
		mainView = new MainView(new IMainViewAdapter() {
			
			@Override
			public IUser connectTo(String ip) {
				// TODO Auto-generated method stub
				return mainModel.connectTo(ip);
			}

			@Override
			public void createChatRoom(String roomName) {
				// TODO Auto-generated method stub
				mainModel.createMyChatRoom(roomName);
			}
			
			@Override
			public void updateUserListView() {
				mainModel.updateUserListView();
			}
			
		});
		
		
		
		mainModel = new MainModel(new IMainModelMainAdapter() {
			//implement the adapter with a method of displaying to log
			@Override
			public Consumer<String> getLogDisplayMethod() {
				// TODO Auto-generated method stub
				return mainView.getDisplayToLogMethod();
			}

			@Override
			public IMainModel2MiniMVCAdpt makeMiniMVC(IChatRoom newChatRoom) {
				
				//make mini MVC and return adapter to main model
				IMainModel2MiniMVCAdpt adpt = facMakeMiniMVC(newChatRoom);
				mainView.addMiniView4ChatRoom(adpt.getMiniView4ChatRoom());
				return adpt;
			}

			@Override
			public void addMiniView4ChatRoom(JPanel miniView) {
				// TODO Auto-generated method stub
				mainView.addMiniView4ChatRoom(miniView);
			}

			@Override
			public void logDisplay(String log) {
				// TODO Auto-generated method stub
				mainView.logDisplay(log);
			}
		});
		
	}
	/**
	 * miniMVCAdpt for main model to communicate with mini MVC
	 * @param newChatRoom new chat room
	 * @return return mini mvc to main model
	 */
	//this method is for MainModelAdapter to use
	public IMainModel2MiniMVCAdpt facMakeMiniMVC(IChatRoom newChatRoom) {

		return new MiniController() {
			
			MiniView miniView;
			MiniModel miniModel;

			/**
			 * instantiate the miniView and MiniModel
			 * @param newChatRoom
			 * @return
			 */
			IMainModel2MiniMVCAdpt instantiate(IChatRoom newChatRoom) {
				//initialize miniView Adapter
				miniView = new MiniView(newChatRoom.getName(), new IMiniViewAdapter() {
					@Override
					public void sendMsg(String data) {
						miniModel.sendMsg(data);
					}
					
					
					// tell miniModel to do the leave room stuff
					@Override
					public void leaveRoom() {
						// TODO Auto-generated method stub
						mainView.removeMiniView(miniView);
						
						
						//remove the corresponding receiver from the chatroom's receiver list
						Collection<IReceiver> chatRoomReceivers = miniModel.getChatRoom().getIReceiverStubs();
						Collection<IReceiver> userReceivers = mainModel.getUser().getReceivers();
						
						/**
						 * here inform everyone remote to remove IReceiver stub from chat before remove the whole chatroom
						 */
						for (IReceiver eachRece : chatRoomReceivers) {
							try {
								// you need to do it by sending message
								IReceiver sender = miniModel.getReceiver();
								eachRece.receive(new DataPacketChatRoom<String>(String.class, mainModel.getUser().getName() + " left the chat room", sender));
								eachRece.receive(new DataPacketChatRoom<IRemoveReceiverType>(IRemoveReceiverType.class, new RemoveReceiverType(sender), sender));
								
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						//remove locally
						for (IReceiver eachRece : userReceivers) {
							if(chatRoomReceivers.contains(eachRece)) {
								chatRoomReceivers.remove(eachRece);// remove from chat room
								userReceivers.remove(eachRece);// remove from user
							}
						}
						
					
						
						// remove the chat room from user
						mainModel.removeChatRoomFromUser(miniModel.getChatRoom());
					}


					@Override
					public void sendImg(ImageIcon image) {
						// TODO Auto-generated method stub
						miniModel.sendImg(image);
					}

				});
				
				
				//remember to initialize miniModel Adapter here
				miniModel = new MiniModel(newChatRoom, new IMiniModel2MiniViewAdpt() {
					
					@Override
					public void updateUserListView(Collection<IReceiver> usrList) {
						// TODO Auto-generated method stub
						miniView.updateUserListView(usrList);
					}
				});
				
				
				//miniController return adapter to mainModel after instantiation
				return new IMainModel2MiniMVCAdpt() {
					
					@Override
					public MiniView getMiniView4ChatRoom() {
						// TODO Auto-generated method stub
						return miniView;
					}
					@Override
					public MiniModel getMiniModel4ChatRoom() {
						return miniModel;
					}
					//main model to mini model
					
					@Override
					public void updateUserListView() {
						miniModel.updateUserListView();
					}
					
					//get receiver to miniViewAdapter
					@Override
					public IReceiverAdapter getReceiverToMiniMVCAdpt() {
						//receiver to miniMVC adapter
						
						return new IReceiverAdapter() {

							@Override
							public void appendMsg(String text, String name) {
								miniView.append(name + ": " + text);
							}

							@Override
							public void buildScrollableComponent(IComponentFactory fac, String label) {
								
							}

							@Override
							public void buildNonScrollableComponent(IComponentFactory fac, String label) {

							}

							@Override
							public void addReceiver(IReceiver receiver) {
								// TODO Auto-generated method stub
								miniModel.addReceiver(receiver);
							}
							
							public IChatRoom getChatRoom() {
								return miniModel.getChatRoom();
							}

							@Override
							public void displayImage(ImageIcon image) {
								// TODO Auto-generated method stub
								miniView.append(image);
							}

						};
					}
				};
			}
		}.instantiate(newChatRoom); // miniController instantiate mini model & view
	}
	
	/**
	 * Launch the application.
	 * @param args main argument
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainController mainController = new MainController();
					mainController.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	/**
	 * start the controller
	 */
	public void start() {
		mainView.start();
		mainModel.start();
	}
	
	
}
