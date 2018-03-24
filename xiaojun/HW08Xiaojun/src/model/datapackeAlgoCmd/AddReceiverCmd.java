package model.datapackeAlgoCmd;

import java.rmi.RemoteException;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.IAddReceiverType;
import common.ICmd2ModelAdapter;
import common.IReceiver;
import model.ILocalCmd2ModelAdapter;

public class AddReceiverCmd extends DataPacketAlgoCmd<IAddReceiverType>{

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -5084642554182543262L;
	
	private transient  ILocalCmd2ModelAdapter _localCmd2ModelAdpt;

	@Override
	public String apply(Class<?> index, DataPacketChatRoom<IAddReceiverType> host, String... params) {
		IReceiver receiver = host.getData().getReceiverStub();
		try {
			System.out.println(receiver.getUserStub().getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_localCmd2ModelAdpt.addReceiver(receiver);
		try {
			_localCmd2ModelAdpt.appendMsg(receiver.getUserStub().getName() + " has joined the chatroom. \n");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return receiver.toString();
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this._localCmd2ModelAdpt = (ILocalCmd2ModelAdapter) cmd2ModelAdpt;
	}
	
}
