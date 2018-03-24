package common;

/**
 * This adapter is for the externally-sourced commands to  interact with the local system,
 * specifically the DataPacketCRAlgoCmd.
 */
public interface ICRCmd2ModelAdapter extends ICmd2ModelAdapter<IReceiver> {
	
	/**
	 * Send a data packet to the chat room corresponding with the receiver
	 * @param id the class id, i.e. message type
	 * @param data the data
	 */
	public <T> void sendToChatRoom(Class<T> id, T data);
}
