package model;

import java.awt.Container;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.ImageIcon;
import common.ADataPacketAlgoCmdGroupF;
import common.DataPacketGroupF;
import common.IChatServer;
import common.IChatroom;
import common.ICmd2ModelAdapter;
import common.IUser;
import provided.datapacket.ADataPacket;
import provided.datapacket.DataPacketAlgo;

/**
 * Chat server object contains the chatroom and user
 * Represents a remote object, can be instantiated directly 
 * and sent as a stub to be used by the client
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 14, 2016
 */
public class ChatServer extends UnicastRemoteObject implements IChatServer {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = -5729717964337102687L;

	/**
	 * User in the chat server
	 */
	private IUser user;

	/**
	 * Room in the chat server
	 */
	private IChatroom room;

	/**
	 * Mini model to view adapter
	 */
	transient IMini2ViewAdpt viewAdpt;

	/**
	 * Cmd to model adapter
	 */
	private ICmd2ModelAdapter cmd2ModelAdpt;

	/*
	 * Data packet algorithm
	*/
	@SuppressWarnings("serial")
	DataPacketAlgo<String, IChatServer> dataPacketAlgo = new DataPacketAlgo<>(new ADataPacketAlgoCmdGroupF<Object>() {
		//Default command, when no algorithm is found
		//That means we have an unknown data type, we need to ask 
		//the sender for an command to process that algorithm
		@Override
		public String apply(Class<?> index, DataPacketGroupF<Object> host, IChatServer... params) {
			try {
				ADataPacketAlgoCmdGroupF<?> newCommand = host.getSender().getNewCommand(index);
				newCommand.setCmd2ModelAdpt(cmd2ModelAdpt);
				dataPacketAlgo.setCmd(index, newCommand);
				host.execute(dataPacketAlgo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		}
	});

	/**
	 * Constructor
	 * @param user User
	 * @param room Chat room
	 * @throws RemoteException Remote exception
	 */
	public ChatServer(IUser user, IChatroom room) throws RemoteException {
		this.user = user;
		this.room = room;
	}

	/**
	 * Constructor
	 * @param user User
	 * @param room Chat Room
	 * @param viewAdpt View Adapter
	 * @throws RemoteException Remote exception
	 */
	public ChatServer(IUser user, IChatroom room, IMini2ViewAdpt viewAdpt) throws RemoteException {
		this.user = user;
		this.room = room;
		this.viewAdpt = viewAdpt;
	}

	/**
	 * Get User
	 */
	@Override
	public IUser getUser() throws RemoteException {
		return user;
	}

	/**
	 * Get chat room
	 */
	@Override
	public IChatroom getChatroom() throws RemoteException {
		return room;
	}

	/**
	 * Join chat room
	 */
	@Override
	public boolean joinChatroom(IChatServer chatStub) throws RemoteException {
		viewAdpt.addToList(chatStub);
		return room.addChatServer(chatStub);
	}

	/**
	 * Leave the room
	 */
	@Override
	public boolean leaveChatroom(IChatServer chatServer) throws RemoteException {
		viewAdpt.remove(chatServer);
		return room.removeChatServer(chatServer);
	}

	/**
	 * Send message to remote
	 */
	@Override
	public void receive(ADataPacket message) throws RemoteException {
		setAdpt(this.viewAdpt);
		message.execute(dataPacketAlgo);
	}

	@Override
	public void refresh() throws RemoteException {
		System.out.println("This refresh function has not been used");
	}

	/**
	 * To String fuction
	 */
	@Override
	public String toString() {
		try {
			return user.getName() + "@" + user.getIP();
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Wrong getting chatserver";
		}
	}

	/**
	 * Set mini to view adapter
	 * @param adpt The mini to view adapter to be set
	 */
	public void setAdpt(IMini2ViewAdpt adpt) {
		this.viewAdpt = adpt;
		cmd2ModelAdpt = new ICmd2ModelAdapter() {
			@Override
			public Container getScrollable() {
				return viewAdpt.getPnlShow();
			}

			@Override
			public Container getNonScrollable() {
				return viewAdpt.getPnlShow();
			}
		};
		//Set string and image algorithm
		ImageDataPacketAlgoCmd imageDataPacketAlgoCmd = new ImageDataPacketAlgoCmd();
		imageDataPacketAlgoCmd.setCmd2ModelAdpt(cmd2ModelAdpt);
		StringDataPacketAlgoCmd stringDataPacketAlgoCmd = new StringDataPacketAlgoCmd();
		stringDataPacketAlgoCmd.setCmd2ModelAdpt(cmd2ModelAdpt);
		dataPacketAlgo.setCmd(String.class, stringDataPacketAlgoCmd);
		dataPacketAlgo.setCmd(ImageIcon.class, imageDataPacketAlgoCmd);
	}

	/**
	 * Get the command from the client when we have a unknown data type
	 */
	@Override
	public ADataPacketAlgoCmdGroupF<?> getNewCommand(Class<?> requestClass) throws RemoteException {
		return (ADataPacketAlgoCmdGroupF<?>) dataPacketAlgo.getCmd(requestClass);
	}

	/**
	 * Set data packet algorithm
	 */
	@Override
	public void setDataPacketAlgo(DataPacketAlgo<String, IChatServer> dataPacketAlgo) throws RemoteException {
		this.dataPacketAlgo = dataPacketAlgo;
	}
}
