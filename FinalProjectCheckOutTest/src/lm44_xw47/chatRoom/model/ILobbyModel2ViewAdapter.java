package lm44_xw47.chatRoom.model;

import common.IChatRoom;
import common.IUser;

/**
 * Following defines the adapter the lobby model uses to communicate with lobby view.
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public interface ILobbyModel2ViewAdapter {
	/**
	 * Add a user to the lobby view.
	 * 
	 * @param user The user being added to the lobby view.
	 */
	public void addUser(IUser user);
	
	/**
	 * Add a team to the lobby view.
	 * 
	 * @param team The team being added to the lobby view.
	 */
	public void addTeam(IChatRoom team);
	
	/**
	 * Null implementation of this interface.
	 */
	public static final ILobbyModel2ViewAdapter NULL_OBJECT = new ILobbyModel2ViewAdapter() {
		/**
		 * No-op.
		 */
		@Override
		public void addUser(IUser user) {
		}

		/**
		 * No-op.
		 */
		@Override
		public void addTeam(IChatRoom team) {
		}
		
	};
}
