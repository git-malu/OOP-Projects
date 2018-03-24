package lm44_yb22.model;

import java.util.function.Consumer;

import javax.swing.JPanel;

import common.IChatRoom;
import common.IReceiver;

public interface IMainModelMainAdapter {
	public Consumer<String> getLogDisplayMethod();
	
	/**
	 * make miniMVC for a new chatRoom
	 * @param chatRoom
	 * @return
	 */
	public IMainModel2MiniMVCAdpt makeMiniMVC(IChatRoom chatRoom);
	
	public void addMiniView4ChatRoom(JPanel miniview);
	
	public void logDisplay(String log);
	
}
