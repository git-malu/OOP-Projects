package lm44_yb22.model.cmd;


import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.IChatRoom;
import common.ICmd2ModelAdapter;
import common.IReceiver;
import common.IRemoveReceiverType;
import lm44_yb22.model.IReceiverAdapter;

public class RemoveReceiverCmd extends DataPacketAlgoCmd<IRemoveReceiverType> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2670861448499081499L;
	private transient ICmd2ModelAdapter _cmd2ModelAdapter;
	
	public RemoveReceiverCmd(ICmd2ModelAdapter adapter) {
		this._cmd2ModelAdapter = adapter;
		
	}
	
	//remove sender locally
	@Override
	public String apply(Class<?> index, DataPacketChatRoom<IRemoveReceiverType> host, String... params) {
		IReceiver sender =  host.getSender();
		IChatRoom chatRoom;

		
		chatRoom = ((IReceiverAdapter)_cmd2ModelAdapter).getChatRoom();
		chatRoom.removeIReceiverStubLocally(sender);
		
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this._cmd2ModelAdapter = cmd2ModelAdpt;
	}



}
