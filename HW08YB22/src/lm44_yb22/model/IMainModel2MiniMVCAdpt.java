package lm44_yb22.model;

import lm44_yb22.view.MiniView;

public interface IMainModel2MiniMVCAdpt {
	/**
	 * get mini view for main model
	 * @return
	 */
	MiniView getMiniView4ChatRoom();
	
	/**
	 * get mini model for main model
	 * @return
	 */
	MiniModel getMiniModel4ChatRoom();
	
	/**
	 * get receiver adapter for receiver initialization
	 * @return
	 */
	IReceiverAdapter getReceiverToMiniMVCAdpt();
	
	/**
	 * update user list view
	 */
	void updateUserListView();
}
