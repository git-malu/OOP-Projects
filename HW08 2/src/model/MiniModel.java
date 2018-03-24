package model;

import java.rmi.RemoteException;
import javax.swing.ImageIcon;
import common.DataPacketGroupF;
import common.IChatServer;
import common.IUser;
import provided.rmiUtils.RMIUtils;
import provided.util.IVoidLambda;

/**
 * Mini model
 * 
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 14, 2016
 */
public class MiniModel {
	/**
	 * Mini to view adapter
	 */
	IMini2ViewAdpt mini2ViewAdpt;

	/**
	 * Chat server
	 */
	IChatServer chatServer;

	/**
	 * RMI utility tool
	 */
	RMIUtils utils = new RMIUtils(new IVoidLambda<String>() {
		@Override
		public void apply(String... params) {
			System.out.println(params);
		}
	});

	/**
	 * Constructor
	 * 
	 * @param mini2ViewAdpt
	 *            Mini to view adapter
	 * @param chatServer
	 *            Chat server
	 */
	public MiniModel(IMini2ViewAdpt mini2ViewAdpt, IChatServer chatServer) {
		this.mini2ViewAdpt = mini2ViewAdpt;
		this.chatServer = chatServer;
	}

	/**
	 * Send message to remote room
	 * 
	 * @param s
	 *            Chat server stub
	 * @param text
	 *            Text to be sent
	 */
	public void addToRemoteRoom(IChatServer s, String text) {
		new Thread(() -> {
			try {
				s.receive(new DataPacketGroupF<String>(String.class, text, chatServer));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}).start();
	}

	/**
	 * Invite remote user
	 * 
	 * @param remoteUser
	 *            Remote user to be invited
	 */
	public void invite(IUser remoteUser) {
		System.out.println("MiniModel invite:" + remoteUser.toString());
		try {
			remoteUser.createNewRoomServer(chatServer.getChatroom());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Leave the room.
	 */
	public void leave() {
		System.out.println("MiniModel leave called");
		try {
			chatServer.leaveChatroom(chatServer);
			for (IChatServer remoteChatServer : chatServer.getChatroom().getChatServers()) {
				new Thread(() -> {
					try {
						remoteChatServer.leaveChatroom(chatServer);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}).start();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send image to remote user
	 * 
	 * @param s
	 *            Remote chat server stub
	 * @param imageIcon
	 *            Image Icon
	 */
	public void sendImage(IChatServer s, ImageIcon imageIcon) {
		new Thread(() -> {
			try {
				s.receive(new DataPacketGroupF<ImageIcon>(ImageIcon.class, imageIcon, chatServer));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
