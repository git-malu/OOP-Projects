package model;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;
import common.IChatServer;
import common.IChatroom;
import common.IUser;
import provided.rmiUtils.IRMI_Defs;
import provided.rmiUtils.RMIUtils;
import provided.util.IVoidLambda;

/**
 * Main model
 * 
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 14, 2016
 */
public class MainModel {
	/**
	 * The only user associated with this chat app
	 */
	private IUser user;

	/**
	 * User stub
	 */
	private IUser userStub;

	/**
	 * RMI utility tool
	 */
	private RMIUtils utils = new RMIUtils(new IVoidLambda<String>() {
		@Override
		public void apply(String... params) {
			System.out.println(params);
		}
	});

	/**
	 * RMI register
	 */
	private Registry registry;

	/**
	 * Main model to view adapter
	 */
	private IMain2ViewAdpt main2ViewAdpt;

	/**
	 * Construtor
	 * 
	 * @param main2ViewAdpt
	 *            Main model to view adapter
	 */
	public MainModel(IMain2ViewAdpt main2ViewAdpt) {
		this.main2ViewAdpt = main2ViewAdpt;
	}

	/**
	 * Start the main model
	 */
	public void start() {
		utils.startRMI(IRMI_Defs.CLASS_SERVER_PORT_SERVER);
		try {
			user = new User(JOptionPane.showInputDialog("Input a username:"), utils.getLocalAddress(),
					new IUser2ModelAdpt() {
						@Override
						public void createMiniMVC(ChatServer chatServer) {
							main2ViewAdpt.makeMiniMVC(chatServer);
						}
					});
			main2ViewAdpt.appendInfo("Instantiated new User: " + user + "\n");
			userStub = (IUser) UnicastRemoteObject.exportObject(user, IUser.BOUND_PORT);
			main2ViewAdpt.appendInfo("Looking for registry..." + "\n");
			registry = utils.getLocalRegistry();
			main2ViewAdpt.appendInfo("Found registry: " + registry + "\n");
			registry.rebind(IUser.BOUND_NAME, userStub);
			main2ViewAdpt.appendInfo("IUser bound to " + IUser.BOUND_NAME + "\n");
			ChatRoom chatRoom = new ChatRoom();
			chatRoom.setName(user.getName());
			main2ViewAdpt.makeMiniMVC(new ChatServer(user, chatRoom));
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get user
	 * 
	 * @return The user
	 */
	public IUser getUser() {
		return user;
	}

	/**
	 * Connect to remote user
	 * 
	 * @param ip
	 *            The ip address of remote user
	 * @return The remote user
	 */
	public IUser connect(String ip) {
		try {

			Registry remoteRegistry = utils.getRemoteRegistry(ip);
			IUser remoteUser = (IUser) remoteRegistry.lookup(IUser.BOUND_NAME);
			remoteUser.connectBack(userStub);
			return remoteUser;
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Join to a chat room
	 * @param room The chat room
	 * @return The chat server
	 * @throws RemoteException Remote Exception
	 */
	public IChatServer joinChatroom(IChatroom room) throws RemoteException {
		IChatroom chatroom = new ChatRoom();
		chatroom.setName(room.getName());
		IChatServer newChatServer = new ChatServer(user, chatroom);
		for (IChatServer chatroomMember : room.getChatServers()) {
			chatroom.addChatServer(chatroomMember);
			chatroomMember.joinChatroom(newChatServer);
		}
		main2ViewAdpt.makeMiniMVC(newChatServer);
		chatroom.addChatServer(newChatServer);
		this.user.addRoom(chatroom);
		return newChatServer;
	}

	/**
	 * Create a new room
	 * @param roomname The room name
	 * @return Return the chat server
	 */
	public IChatServer createRoom(String roomname) {
		try {
			ChatRoom chatRoom = new ChatRoom();
			chatRoom.setName(roomname);
			ChatServer chatServer = new ChatServer(user, chatRoom);
			main2ViewAdpt.makeMiniMVC(chatServer);
			chatRoom.addChatServer(chatServer);
			user.addRoom(chatRoom);
			return chatServer;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Close all rooms
	 */
	public void closeAllRooms() {
		main2ViewAdpt.closeAllRooms();
	}
}