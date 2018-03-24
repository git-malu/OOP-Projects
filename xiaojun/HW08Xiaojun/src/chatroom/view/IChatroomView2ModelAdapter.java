package chatroom.view;

/**
 * Following defines an adapter that chatroom view uses to communicate chatroom model.
 * 
 * @author wuxiaojun
 */
public interface IChatroomView2ModelAdapter {
	/**
	 * Send text messages.
	 * 
	 * @param msg The text message being sent.
	 */
	public void sendMsg(String msg);
	
	public void sendImg();
	
	public void sendFile();
	
	public void leave();
	
	public static final IChatroomView2ModelAdapter NULL_OBJECT = new IChatroomView2ModelAdapter() {

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
		public void sendImg() {
		}

		/**
		 * No-op
		 */
		@Override
		public void sendFile() {
		}

		/**
		 * No-op
		 */
		@Override
		public void leave() {
		}
		
	};
}
