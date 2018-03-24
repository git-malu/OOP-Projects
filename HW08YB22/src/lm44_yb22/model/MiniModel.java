package lm44_yb22.model;

import java.rmi.RemoteException;

import javax.swing.ImageIcon;

import common.DataPacketChatRoom;
import common.IChatRoom;
import common.IReceiver;


public class MiniModel {
	private IChatRoom chatRoom;
	private IReceiver myReceiver;
	private IMiniModel2MiniViewAdpt miniModel2MiniViewAdpt;
	
	public MiniModel(IChatRoom newChatRoom, IMiniModel2MiniViewAdpt adpt) {
		// TODO Auto-generated constructor stub
		chatRoom = newChatRoom;
		miniModel2MiniViewAdpt = adpt;
		//myReceiver = receiverStub;
	}
	/**
	 * getter for chatRoom
	 * @return
	 */
	public IChatRoom getChatRoom() {
		return chatRoom;
	}
	
	/**
	 * send message in the chatRoom
	 */
	public void sendMsg(String data) {
		System.out.println( "miniModel sendMsg: " + data);
		chatRoom.sendPacket(new DataPacketChatRoom<String>(String.class, data, myReceiver)); // receiver is sender
	}
	/**
	 * send image
	 * @param image
	 */
	public void sendImg(ImageIcon image) {
		for (IReceiver eachReceiver : chatRoom.getIReceiverStubs()) {
			try {
				eachReceiver.receive(new DataPacketChatRoom<ImageIcon>(ImageIcon.class, image, myReceiver));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * for initialization
	 * @param newReceiver
	 */
	public void setReceiver(IReceiver newReceiver) {
		myReceiver = newReceiver;
	}
	/**
	 * return receiver
	 * @return
	 */
	public IReceiver getReceiver() {
		return myReceiver;
	}
	/**
	 * add receiver to the chat room.
	 * @param receiver
	 */
	public void addReceiver(IReceiver receiver) {
		chatRoom.addIReceiverStubLocally(receiver);
	}
	
	/**
	 * give mini view the receivers to update user list view
	 */
	public void updateUserListView() {
		miniModel2MiniViewAdpt.updateUserListView(chatRoom.getIReceiverStubs());
	}
	
}
