package lm44_yb22.model;


import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.UUID;


import javax.swing.ImageIcon;

import common.DataPacketChatRoom;
import common.IAddReceiverType;
import common.IInstallCmdType;
import common.IReceiver;
import common.IRemoveReceiverType;
import common.IRequestCmdType;
import common.IUser;
import lm44_yb22.model.cmd.AddReceiverCmd;
import lm44_yb22.model.cmd.DefalutCmd;
import lm44_yb22.model.cmd.ImageCmd;
import lm44_yb22.model.cmd.InstallCmdCmd;
import lm44_yb22.model.cmd.RemoveReceiverCmd;
import lm44_yb22.model.cmd.RequestCmdCmd;
import lm44_yb22.model.cmd.StringCmd;
import provided.datapacket.DataPacketAlgo;

public class Receiver implements IReceiver { //transmitted as a stub
	UUID uuid = UUID.randomUUID();
	IUser userStub;
	IReceiverAdapter receiverAdapter; // extends ICmd2ModelAdapter
	DefalutCmd defalutCmd ;
	DataPacketAlgo<String, String> visitor = new DataPacketAlgo<String, String>(defalutCmd);//default cmd request cmd for unknow data
	public Hashtable<Class<?>, DataPacketChatRoom<Object>> table = new Hashtable<>();
	
	
	public Receiver(IUser userStub, IReceiverAdapter adpt) {

		this.userStub = userStub;
		this.receiverAdapter = adpt;
		this.defalutCmd = new DefalutCmd(receiverAdapter, this);
		init();
	}
	
	//set all the commands
	public void init() {
		visitor.setCmd(String.class, new StringCmd(receiverAdapter));//install string cmd 
		visitor.setCmd(IAddReceiverType.class, new AddReceiverCmd(receiverAdapter));// install add receiver command
		visitor.setCmd(IRemoveReceiverType.class, new RemoveReceiverCmd(receiverAdapter));// install remove receiver command
		visitor.setCmd(IRequestCmdType.class, new RequestCmdCmd(receiverAdapter, visitor, this));
		visitor.setCmd(IInstallCmdType.class, new InstallCmdCmd(visitor, this));
		visitor.setCmd(ImageIcon.class, new ImageCmd(receiverAdapter));
		defalutCmd.setVisitor(visitor);
	}
	
	@Override
	public <T> void receive(DataPacketChatRoom<T> data) throws RemoteException {
		data.execute(visitor);
	}

	@Override
	public IUser getUserStub() throws RemoteException {

		return userStub;
	}

	@Override
	public UUID getUUID() throws RemoteException {

		return uuid;
	}
	
	@Override
	public boolean equals(Object obj) {

		if(obj == null) {
			return false;
		}else {
			if(obj instanceof Receiver) {
				return uuid.equals(((Receiver)obj).uuid);
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {

		return uuid.hashCode();
	}

}
