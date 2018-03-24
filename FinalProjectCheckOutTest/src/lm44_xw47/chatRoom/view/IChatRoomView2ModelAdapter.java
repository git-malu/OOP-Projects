package lm44_xw47.chatRoom.view;

/**
 * Following defines the adpate that chat room view uses to communicate with chat room model.
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public interface IChatRoomView2ModelAdapter {
	/**
	 * Start the game.
	 */
	public void start();
	
	/**
	 * Send message to team.
	 * 
	 * @param msg Message being sent to team.
	 */
	public void sendMsg(String msg);
	
	/**
	 * Leave the chat room (team).
	 */
	public void leave();
	
	/**
	 * Null implementation of this interface.
	 */
	public static final IChatRoomView2ModelAdapter NULL_OBJECT = new IChatRoomView2ModelAdapter() {
		/**
		 * No-op.
		 */
		@Override
		public void start() {
		}

		/**
		 * No-op.
		 */
		@Override
		public void sendMsg(String msg) {
		}

		/**
		 * No-op.
		 */
		@Override
		public void leave() {
		}
		
	};
}
