package chatroom.model;

public interface IChatroomModel2ViewAdapter {
	public void sendMsg(String msg);
	
	public void addUser(String username);
	
	public void leave();
	
	public void removeUser(String username);
	
	public static final IChatroomModel2ViewAdapter NULL_OBJECT = new IChatroomModel2ViewAdapter() {

		/**
		 * No-op
		 */
		@Override
		public void sendMsg(String msg) {
		}

		/**
		 * No-op
		 */
		@Override
		public void addUser(String username) {
		}
		
		/**
		 * No-op
		 */
		@Override
		public void removeUser(String username) {
		}
		
		/**
		 * No-op
		 */
		public void leave() {
		}
	};
}
