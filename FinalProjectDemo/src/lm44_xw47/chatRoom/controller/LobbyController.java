package lm44_xw47.chatRoom.controller;

import java.awt.EventQueue;
import java.util.Collection;

import common.IChatRoom;
import common.IUser;
import lm44_xw47.chatRoom.model.ILobbyModel2ViewAdapter;
import lm44_xw47.chatRoom.model.LobbyModel;
import lm44_xw47.chatRoom.view.ILobbyView2ModelAdapter;
import lm44_xw47.chatRoom.view.LobbyView;

public class LobbyController {
	private LobbyModel lobbyModel;
	
	private LobbyView lobbyFrame;
	
	public LobbyController(Collection<IUser> users,Collection<IChatRoom> teams, IUser localUser, IUser serverUser) {
		lobbyModel = new LobbyModel(new ILobbyModel2ViewAdapter() {

			@Override
			public void addUser(IUser user) {
				lobbyFrame.addUser(user);
			}

			@Override
			public void addTeam(IChatRoom team) {
				lobbyFrame.addTeam(team);
			}
			
		}, users, teams, localUser, serverUser);
		
		lobbyFrame = new LobbyView(new ILobbyView2ModelAdapter() {

			@Override
			public void createTeam(String teamname) {
				lobbyModel.createTeam(teamname);
			}

			@Override
			public void joinTeam(IChatRoom Team) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void inviteUser(IUser user) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void readyToPlay() {
				// TODO Auto-generated method stub
				lobbyModel.readyToPlay();
			}
			
		}); 
	}
	
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				lobbyFrame.start();
				lobbyModel.start();
			}
		});
	}
	
	public LobbyView getLobbyView() {
		return lobbyFrame;
	}
}
