package lm44_xw47.chatRoom.view;

import common.IChatRoom;
import common.IUser;

public interface ILobbyView2ModelAdapter {
	public void createTeam(String teamname);
	
	public void joinTeam(IChatRoom team);
	
	public void inviteUser(IUser user);
	
	public void readyToPlay();
	
	public static final ILobbyView2ModelAdapter NULL_OBJECT = new ILobbyView2ModelAdapter() {

		/**
		 * No-op
		 */
		@Override
		public void createTeam(String teamname) {
		}

		/**
		 * No-op
		 */
		@Override
		public void joinTeam(IChatRoom team) {
		}

		/**
		 * No-op
		 */
		@Override
		public void inviteUser(IUser user) {
		}
		
		/**
		 * No-op
		 */
		@Override
		public void readyToPlay() {
		}
		
	};
}
