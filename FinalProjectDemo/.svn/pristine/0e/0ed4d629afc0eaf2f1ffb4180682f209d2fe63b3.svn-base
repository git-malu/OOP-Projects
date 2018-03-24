package lm44_xw47.model;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import common.DataPacketUser;
import common.IChatRoom;
import common.IUser;
import common.IUserCmd2ModelAdapter;
import common.IUserMessageType;
import common.datatype.IRequestCmdType;
import common.datatype.user.IInvitationType;
import common.datatype.user.IQuitType;
import common.datatype.user.IUserExceptionStatusType;
import common.datatype.user.IUserInstallCmdType;
import common.datatype.user.IUserRejectionStatusType;
import lm44_xw47.chatRoom.model.ICmd2LobbyAdapter;
import lm44_xw47.model.dataPacketAlgoCmd.AddTeamGameCmd;
import lm44_xw47.model.dataPacketAlgoCmd.AddUserGameCmd;
import lm44_xw47.model.dataPacketAlgoCmd.CreateTeamCmd;
import lm44_xw47.model.dataPacketAlgoCmd.DefaultCmd;
import lm44_xw47.model.dataPacketAlgoCmd.InstallLobbyCmd;
import lm44_xw47.model.dataPacketAlgoCmd.InvitationCmd;
import lm44_xw47.model.dataPacketAlgoCmd.JoinTeamCmd;
import lm44_xw47.model.dataPacketAlgoCmd.QuitCmd;
import lm44_xw47.model.dataPacketAlgoCmd.RemoveTeamGameCmd;
import lm44_xw47.model.dataPacketAlgoCmd.RemoveUserGameCmd;
import lm44_xw47.model.dataPacketAlgoCmd.UserExceptionStatusCmd;
import lm44_xw47.model.dataPacketAlgoCmd.UserInstallCmd;
import lm44_xw47.model.dataPacketAlgoCmd.UserRejectionStatusCmd;
import lm44_xw47.model.dataPacketAlgoCmd.UserRequestCmd;
import lm44_xw47.model.dataType.AddTeamGame;
import lm44_xw47.model.dataType.AddUserGame;
import lm44_xw47.model.dataType.CreateTeamType;
import lm44_xw47.model.dataType.InstallLobbyType;
import lm44_xw47.model.dataType.JoinTeamType;
import lm44_xw47.model.dataType.RemoveTeamGame;
import lm44_xw47.model.dataType.RemoveUserGame;
import provided.datapacket.DataPacketAlgo;
import provided.mixedData.MixedDataKey;

/**
 * Following defines a user.
 * 
 * @author Lu Ma
 * @author Xiaojun Wu
 */
public class User implements IUser {
	/**
	 * The name of this user.
	 */
	private String name;

	/**
	 * The unique for this user.
	 */
	private UUID uuid = UUID.randomUUID();
	
	/**
	 * The chat rooms this user have joined.
	 */
	private Collection<IChatRoom> chatRooms = new ConcurrentLinkedQueue<IChatRoom>();
	
	/**
	 * The algo this user uses to handle message.
	 */
	private DataPacketAlgo<String, String> algo;
	
	/**
	 * A map used to store unknown messages.
	 */
	private Map<Class<?>, DataPacketUser<?>> unknownMsgs = new Hashtable<Class<?>, DataPacketUser<?>>();
	
	private Collection<IUser> users = new ConcurrentLinkedQueue<IUser>();
	
	private Map<IUser, IChatRoom> teamsByUser = new Hashtable<IUser, IChatRoom>();
	
	private Map<String, IChatRoom> teamsByName = new Hashtable<String, IChatRoom>();
	
	private IUser host;

	/**
	 * Constructor.
	 * 
	 * @param name The name of this user.
	 */
	public User(String name) {
		this.name = name;
	}
	
	public void init(IUserCmd2ModelAdapter cmd2ModelAdapter, IUser userStub) {
		// users.add(userStub);
		host = userStub;
		MixedDataKey<ICmd2LobbyAdapter> key = new MixedDataKey<ICmd2LobbyAdapter>(UUID.randomUUID(), "This is the key for cmd2LobbyAdapter.", ICmd2LobbyAdapter.class);
		algo = new DataPacketAlgo<String, String>(new DefaultCmd(userStub, cmd2ModelAdapter, unknownMsgs));
		
		algo.setCmd(IInvitationType.class, new InvitationCmd(cmd2ModelAdapter));
		algo.setCmd(IQuitType.class, new QuitCmd(cmd2ModelAdapter));
		algo.setCmd(IUserExceptionStatusType.class, new UserExceptionStatusCmd(cmd2ModelAdapter));
		algo.setCmd(IUserInstallCmdType.class, new UserInstallCmd(algo, unknownMsgs, cmd2ModelAdapter));
		algo.setCmd(IUserRejectionStatusType.class, new UserRejectionStatusCmd(cmd2ModelAdapter));
		algo.setCmd(IRequestCmdType.class, new UserRequestCmd(cmd2ModelAdapter, algo, userStub));
		algo.setCmd(InstallLobbyType.class, new InstallLobbyCmd(key));
		algo.setCmd(AddUserGame.class, new AddUserGameCmd(key));
		algo.setCmd(AddTeamGame.class, new AddTeamGameCmd(key));
		algo.setCmd(RemoveUserGame.class, new RemoveUserGameCmd(key));
		algo.setCmd(RemoveTeamGame.class, new RemoveTeamGameCmd(key));
		algo.setCmd(JoinTeamType.class, new JoinTeamCmd(cmd2ModelAdapter, teamsByUser, teamsByName, userStub));
		algo.setCmd(CreateTeamType.class, new CreateTeamCmd(cmd2ModelAdapter, teamsByName, users, userStub));
	}

	@Override
	public String getName() throws RemoteException {
		return name;
	}

	@Override
	public UUID getUUID() throws RemoteException {
		return uuid;
	}

	@Override
	public Collection<IChatRoom> getChatRooms() throws RemoteException {
		// TODO Auto-generated method stub
		return chatRooms;
	}

	@Override
	public void connect(IUser userStub) throws RemoteException {
		userStub.receive(new DataPacketUser<InstallLobbyType>(InstallLobbyType.class, new InstallLobbyType(users, chatRooms, userStub), host));
		users.add(userStub);
	}

	@Override
	public <T extends IUserMessageType> void receive(DataPacketUser<T> data) throws RemoteException {
		// TODO Auto-generated method stub
		data.execute(algo);
	}
}
