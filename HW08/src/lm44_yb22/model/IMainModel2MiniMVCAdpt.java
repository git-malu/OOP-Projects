package lm44_yb22.model;

import lm44_yb22.view.MiniView;

public interface IMainModel2MiniMVCAdpt {
	MiniView getMiniView4ChatRoom();
	MiniModel getMiniModel4ChatRoom();
	IReceiverAdapter getReceiverToMiniMVCAdpt();
	void updateUserListView();
}
