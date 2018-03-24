package lm44_yb22.view;

import javax.swing.ImageIcon;

import common.DataPacketChatRoom;

public interface IMiniViewAdapter {
	/**
	 * uninstall miniView from mainView
	 */
	public void leaveRoom();
	
	/**
	 * send messsage to 
	 */
	public void sendMsg(String data);
	/**
	 * send image
	 * @param image
	 */
	public void sendImg(ImageIcon image);
	
}
