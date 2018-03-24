package model.datapackeAlgoCmd;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
import common.IReceiver;
import common.IRemoveReceiverType;
import model.ILocalCmd2ModelAdapter;

public class RemoveReceiverCmd extends DataPacketAlgoCmd<IRemoveReceiverType>{

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 460184533829822932L;
	
	private transient ILocalCmd2ModelAdapter _localCmd2ModelAdpt;

	@Override
	public String apply(Class<?> index, DataPacketChatRoom<IRemoveReceiverType> host, String... params) {
		IReceiver receiver = host.getData().getReceiverStub();
		_localCmd2ModelAdpt.removeReceiver(receiver);
		_localCmd2ModelAdpt.appendMsg(receiver.toString() + " has left the chatroom");
		return receiver.toString();
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this._localCmd2ModelAdpt = (ILocalCmd2ModelAdapter) cmd2ModelAdpt;
	}

}
