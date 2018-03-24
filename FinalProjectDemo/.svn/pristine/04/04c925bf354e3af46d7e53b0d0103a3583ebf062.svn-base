package lm44_xw47.chatRoom.model;

import java.rmi.RemoteException;
import java.util.Collection;

import common.DataPacketUser;
import common.IChatRoom;
import common.IUser;
import lm44_xw47.model.dataType.CreateTeamType;
import lm44_xw47.model.dataType.JoinTeamType;

public class LobbyModel {
	private ILobbyModel2ViewAdapter lobbyModel2ViewAdapter = ILobbyModel2ViewAdapter.NULL_OBJECT;
	
	private Collection<IUser> users;
	
	private Collection<IChatRoom> teams;
	
	// private IChatRoom team;
	
	private IUser localUser;
	
	private IUser serverUser;
	
	//private int port = 2150;
	
	public LobbyModel(ILobbyModel2ViewAdapter lobbyModel2ViewAdapter, Collection<IUser> users, Collection<IChatRoom> teams, IUser localUser, IUser serverUser) {
		this.lobbyModel2ViewAdapter = lobbyModel2ViewAdapter;
		this.users = users;
		this.teams = teams;
		this.localUser = localUser;
		this.serverUser = serverUser;
	}
	
	public void createTeam(String teamname) {
		try {
			serverUser.receive(new DataPacketUser<CreateTeamType>(CreateTeamType.class, new CreateTeamType(teamname), localUser));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void joinTeam(IChatRoom team) {
		joinTeam(team.getName());
	}
	
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
//		try {
//			serverUser.receive(new DataPacketUser<T>(c, data, sender));
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}
	
	public void start() {
		for (IUser user : users) {
			lobbyModel2ViewAdapter.addUser(user);
		}
		
		for (IChatRoom team: teams) {
			lobbyModel2ViewAdapter.addTeam(team);
		}
	}
}
