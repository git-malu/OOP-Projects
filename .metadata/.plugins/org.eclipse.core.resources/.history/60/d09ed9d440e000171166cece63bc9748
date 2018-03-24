package lm44_xw47.chatRoom.model;

import java.rmi.RemoteException;
import java.util.Collection;

import common.DataPacketUser;
import common.IChatRoom;
import common.IUser;
import common.datatype.user.IQuitType;
import lm44_xw47.model.dataType.CreateTeamType;
import lm44_xw47.model.dataType.JoinTeamType;
import lm44_xw47.model.dataType.QuitType;
import lm44_xw47.model.dataType.ReadyToPlayType;

/**
 * Following defines the class for the lobby model.
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public class LobbyModel {
	/**
	 * The adapter the lobby model uses to communicate with lobby view.
	 */
	private ILobbyModel2ViewAdapter lobbyModel2ViewAdapter = ILobbyModel2ViewAdapter.NULL_OBJECT;
	
	/**
	 * The collection of users join this lobby.
	 */
	private Collection<IUser> users;
	
	/**
	 * The collection of teams that user can join.
	 */
	private Collection<IChatRoom> teams;
	
	/**
	 * The local user stub.
	 */
	private IUser localUser;
	
	/**
	 * The server stub.
	 */
	private IUser serverUser;
	
	/**
	 * Constructor.
	 * 
	 * @param lobbyModel2ViewAdapter The adapter the lobby model uses to communicate with lobby view.
	 * @param users The collection of users join this lobby.
	 * @param teams The collection of teams that user can join.
	 * @param localUser The local user stub.
	 * @param serverUser The server stub.
	 */
	public LobbyModel(ILobbyModel2ViewAdapter lobbyModel2ViewAdapter, Collection<IUser> users, Collection<IChatRoom> teams, IUser localUser, IUser serverUser) {
		this.lobbyModel2ViewAdapter = lobbyModel2ViewAdapter;
		this.users = users;
		this.teams = teams;
		this.localUser = localUser;
		this.serverUser = serverUser;
	}
	
	/**
	 * Create a team.
	 * 
	 * @param teamname The teamname of this created team.
	 */
	public void createTeam(String teamname) {
		try {
			serverUser.receive(new DataPacketUser<CreateTeamType>(CreateTeamType.class, new CreateTeamType(teamname), localUser));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Join a team.
	 * 
	 * @param team The team user want to join.
	 */
	public void joinTeam(IChatRoom team) {
		joinTeam(team.getName());
	}
	
	/**
	 * Join a team by team name. The true method interact with server.
	 * 
	 * @param teamName The team name of joined team.
	 */
	private void joinTeam(String teamName) {
		try {
			serverUser.receive(new DataPacketUser<JoinTeamType>(JoinTeamType.class, new JoinTeamType(teamName), localUser));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * inform the server that I'm ready to play.
	 */
	public void readyToPlay() {
		try {
			serverUser.receive(new DataPacketUser<ReadyToPlayType>(ReadyToPlayType.class, new ReadyToPlayType(), localUser));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Quit the game lobby.
	 */
	public void quit() {
		try {
			serverUser.receive(new DataPacketUser<IQuitType>(IQuitType.class, new QuitType(localUser), localUser));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Start the lobby model.
	 */
	public void start() {
		for (IUser user : users) {
			lobbyModel2ViewAdapter.addUser(user);
		}
		
		for (IChatRoom team: teams) {
			lobbyModel2ViewAdapter.addTeam(team);
		}
	}
}
