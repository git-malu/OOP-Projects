package lm44_xw47.chatRoom.view;

import common.IChatRoom;
import common.IUser;

/**
 * Following defines the adapter that lobby view uses to communicate with lobby model.
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public interface ILobbyView2ModelAdapter {
	/**
	 * Create a team.
	 * 
	 * @param teamname The team name of the created team.
	 */
	public void createTeam(String teamname);
	
	/**
	 * Join a team
	 * 
	 * @param team The team the user want to join.
	 */ 
	public void joinTeam(IChatRoom team);
	
	/**
	 * Invite a user.
	 * 
	 * @param user The user being invited.
	 */
	public void inviteUser(IUser user);
	
	/**
	 * Ready to play game.
	 */
	public void readyToPlay();
	
	/**
	 * Quit the game.
	 */
	public void quit();
	
	/**
	 * Null implementation of this interface.
	 */
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
		
		/**
		 * No-op.
		 */
		@Override
		public void quit() {
		}
	};
}
