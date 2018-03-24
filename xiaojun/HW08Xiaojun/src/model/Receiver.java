package model;

import java.rmi.RemoteException;
import java.util.UUID;

import common.DataPacketChatRoom;
import common.IAddReceiverType;
import common.IReceiver;
import common.IRemoveReceiverType;
import common.IUser;
import model.datapackeAlgoCmd.AddReceiverCmd;
import model.datapackeAlgoCmd.DefaultCmd;
import model.datapackeAlgoCmd.RemoveReceiverCmd;
import model.datapackeAlgoCmd.StringCmd;
import provided.datapacket.DataPacketAlgo;

public class Receiver implements IReceiver{
	private IUser user;
	
	private UUID uuid = UUID.randomUUID();
	
	private DataPacketAlgo<String, String> algo = new DataPacketAlgo<String, String>(new DefaultCmd());
	
	private ILocalCmd2ModelAdapter _localCmd2Model2Adapter;
	
	public Receiver(IUser user, ILocalCmd2ModelAdapter _localCmd2ModelAdapter) {
		this.user = user;
		this._localCmd2Model2Adapter = _localCmd2ModelAdapter;
	}
	
	private void init() {
		StringCmd stringCmd = new StringCmd();
		stringCmd.setCmd2ModelAdpt(_localCmd2Model2Adapter);
		AddReceiverCmd addReceiverCmd = new AddReceiverCmd();
		addReceiverCmd.setCmd2ModelAdpt(_localCmd2Model2Adapter);
		RemoveReceiverCmd removeReceiverCmd = new RemoveReceiverCmd();
		removeReceiverCmd.setCmd2ModelAdpt(_localCmd2Model2Adapter);
		algo.setCmd(String.class, stringCmd);
		algo.setCmd(IAddReceiverType.class, addReceiverCmd);
		algo.setCmd(IRemoveReceiverType.class, removeReceiverCmd);
	}

	@Override
	public <T> void receive(DataPacketChatRoom<T> data) throws RemoteException {
		data.execute(algo);
	}

	@Override
	public IUser getUserStub() throws RemoteException {
		return user;
	}

	@Override
	public UUID getUUID() throws RemoteException {
		return uuid;
	}
	
	public void setLocalCmd2ModelAdapter(ILocalCmd2ModelAdapter _localCmd2ModelAdapter) {
		this._localCmd2Model2Adapter = _localCmd2ModelAdapter;
		init();
	}
	
	@Override 
	public String toString() {
		try {
			return user.getName();
		} catch (RemoteException e) {
			e.printStackTrace();
			return "A server error occured when get receiver name";
		}
	}
}
