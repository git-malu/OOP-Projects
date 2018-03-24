package controller;

import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import common.IChatServer;
import common.IChatroom;
import common.IUser;
import model.ChatServer;
import model.IMain2ViewAdpt;
import model.IMini2ViewAdpt;
import model.IMiniMVCAdpt;
import model.MainModel;
import model.MiniModel;
import view.IMain2ModelAdpt;
import view.IMini2ModelAdpt;
import view.MainView;
import view.MiniView;

/**
 * The main controller where all things start
 * 
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 13, 2016
 */
public class MainController {
	/**
	 * Main Model
	 */
	MainModel mainModel;

	/**
	 * Main view
	 */
	MainView mainView;

	/**
	 * Constructor
	 */
	public MainController() {
		mainModel = new MainModel(new IMain2ViewAdpt() {
			private HashSet<IMiniMVCAdpt> miniMVCAdapterSet = new HashSet<>();

			@Override
			public IMiniMVCAdpt makeMiniMVC(IChatServer chatServer) {

				final IMiniMVCAdpt[] minis = new IMiniMVCAdpt[1];

				try {
					//Mini controller
					new MiniController() {
						//Mini view
						private MiniView<IChatServer> miniView;
						//Mini model
						private MiniModel miniModel;
						//Constructor 
						{
							//Mini model to view adapter
							IMini2ViewAdpt iMini2ViewAdpt = new IMini2ViewAdpt() {
								@Override
								public void addToList() {
									try {
										miniView.addToList(chatServer.getChatroom().getChatServers());
									} catch (RemoteException e) {
										e.printStackTrace();
									}
								}

								@Override
								public void append(String text) {
									miniView.append(text);
								}

								@Override
								public void addToList(IChatServer chatStub) {
									miniView.addToList(chatStub);
								}

								@Override
								public JPanel getPnlShow() {
									return miniView.getPnlShow();
								}

								@Override
								public void remove(IChatServer chatServer) {
									miniView.removeChatServer(chatServer);
								}
							};
							//Pass the iMini2ViewAdpt to chat server so that the chat server can 
							//access the miniView
							((ChatServer) chatServer).setAdpt(iMini2ViewAdpt);
							//Pass the chat server to the mini model for use later
							this.miniModel = new MiniModel(iMini2ViewAdpt, chatServer);

							//Hook the min mvc adapter and return, the main model can use
							//this to install a mini view to main view etc.
							minis[0] = new IMiniMVCAdpt() {
								@Override
								public void install() {
									mainView.install(miniView);
								}

								@Override
								public void uninstall() {
									// TODO Auto-generated method stub
									miniModel.leave();
									//mainView.leaveRoom(miniView);
								}
							};

							//Make a mini view, passing the chatroom in, 
							//The mini view will extract the chatservers from chatroom and 
							//instantiate the miniview.
							this.miniView = new MiniView<IChatServer>(chatServer.getChatroom(), new IMini2ModelAdpt() {
								@Override
								public void addToRemoteRoom(IChatServer s, String text) {
									miniModel.addToRemoteRoom(s, text);
								}

								@Override
								public void invite(String ip) {
									System.out.println("Main Controller invite called.");
									miniModel.invite(mainModel.connect(ip));
								}

								@Override
								public void leave() {
									System.out.println("Main Controller leave called.");
									miniModel.leave();
									mainView.leaveRoom(miniView);
									miniMVCAdapterSet.remove(minis[0]);
								}

								@Override
								public void sendImage(IChatServer chatServer, ImageIcon imageIcon) {
									miniModel.sendImage(chatServer, imageIcon);
								}

							});
							//Get the new room and add to user
							mainModel.getUser().addRoom(chatServer.getChatroom());
							//Add oneself into that new room
							chatServer.getChatroom().addChatServer(chatServer);
							//Add the chatservers to view
							miniView.addToList(chatServer.getChatroom().getChatServers());
							//Install the mini view
							mainView.install(miniView);
						}
					};
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				miniMVCAdapterSet.add(minis[0]);
				return minis[0];
			}

			//Append information to the info panel
			@Override
			public void appendInfo(String info) {
				mainView.appendInfo(info);
			}

			@Override
			public void closeAllRooms() {
				// TODO Auto-generated method stub
				for (IMiniMVCAdpt miniMVCAdpt : miniMVCAdapterSet) {
					miniMVCAdpt.uninstall();
				}
			}

		});

		/**
		 * Main View
		 */
		mainView = new MainView(new IMain2ModelAdpt() {
			@Override
			public IUser connect(String ip) {
				return mainModel.connect(ip);
			}

			@Override
			public void joinChatRoom(IChatroom room) {
				try {
					mainModel.joinChatroom(room);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void creatRoom(String roomname) {
				mainModel.createRoom(roomname);
			}

			@Override
			public void closeChatApp() {
				mainModel.closeAllRooms();

			}
		});
	}

	/**
	 * Start this controller 
	 */
	public void start() {
		mainModel.start();
		mainView.start();
	}

	/**
	 * The main function 
	 * @param args Input arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					MainController main = new MainController();
					main.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
