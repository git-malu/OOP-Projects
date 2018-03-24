package model;

import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;

import common.IChatRoom;
import common.IReceiver;

/**
 * Following defines the interface that model uses to communicate with view.
 * 
 * @author wuxiaojun
 *
 */
public interface IModel2ViewAdapter {
	/**
	 * Add a button for a chatroom to the view.
	 * 
	 * @param btnChatroom The button for a chatroom.
	 */
	public void addBtnChatroom(JButton btnChatroom);
	
	/**
	 * Adds a panel for the chatroom to the view.
	 * 
	 * @param pnlChatroom
	 */
	public void addPnlChatroom(JPanel pnlChatroom);
	
	/**
	 * Create a new chatroom panel.
	 */
	public ILocalCmd2ModelAdapter createChatroomPnl(IChatRoom chatroom, IReceiver receiver);
	
	/**
	 * Send connecting info to the view.
	 * 
	 * @param info The connecting info.
	 */
	public void sendConnectInfo(String info);
	
	
	/**
	 * Add selectable chatrooms to the view.
	 * 
	 * @param chatrooms The selectable chatrooms.
	 */
	public void addSelectableChatrooms(Set<IChatRoom> chatrooms);
	
	public static final IModel2ViewAdapter NULL_OBJECT = new IModel2ViewAdapter() {
		/**
		 * No-op.
		 */
		@Override
		public void addBtnChatroom(JButton btnChatroom) {	
		}
		
		/**
		 * No-op.
		 */
		@Override
		public void addPnlChatroom(JPanel pnlChatroom) {
		}
		
		/**
		 * No-op
		 */
		public ILocalCmd2ModelAdapter createChatroomPnl(IChatRoom chatroom, IReceiver receiver) {
			return null;
		}
		
		/**
		 * No-op
		 */
		@Override
		public void sendConnectInfo(String info) {
		}
		
		/**
		 * No-op
		 */
		@Override
		public void addSelectableChatrooms(Set<IChatRoom> chatrooms) {
		}
	};
}
