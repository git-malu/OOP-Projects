package lm44_xw47.model;

import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

import common.DataPacketCR;
import common.ICRCmd2ModelAdapter;
import common.ICRMessageType;
import common.IReceiver;
import common.IUser;
import common.datatype.IRequestCmdType;
import common.datatype.chatroom.IAddReceiverType;
import common.datatype.chatroom.ICRExceptionStatusType;
import common.datatype.chatroom.ICRInstallCmdType;
import common.datatype.chatroom.ICRRejectionStatusType;
import common.datatype.chatroom.IRemoveReceiverType;
import lm44_xw47.chatRoom.model.dataPacketAlgo.AddReceiverCmd;
import lm44_xw47.chatRoom.model.dataPacketAlgo.CRExceptionStatusCmd;
import lm44_xw47.chatRoom.model.dataPacketAlgo.CRInstallCmd;
import lm44_xw47.chatRoom.model.dataPacketAlgo.CRRejectionStatusCmd;
import lm44_xw47.chatRoom.model.dataPacketAlgo.CRRequestCmd;
import lm44_xw47.chatRoom.model.dataPacketAlgo.DefaultCmd;
import lm44_xw47.chatRoom.model.dataPacketAlgo.RemoveReceiverCmd;
import lm44_xw47.chatRoom.model.dataPacketAlgo.StringMsgCmd;
import provided.datapacket.DataPacketAlgo;

public class Receiver implements IReceiver{
	/**
	 * The user of this receiver.
	 */
	private IUser user;

	/**
	 * The unique id of this receier.
	 */
	private UUID uuid = UUID.randomUUID();

	/**
	 * The algo used to process different type of data.
	 */
	private DataPacketAlgo<String, String> algo;
	
	private Map<Class<?>, DataPacketCR<?>> unknownMsgs = new Hashtable<Class<?>, DataPacketCR<?>>();
	
	public Receiver(IUser userStub) {
		this.user = userStub;
	}
	
	/**
	 * Initialize the receiver.
	 */
	public void init(ICRCmd2ModelAdapter cmd2ModelAdpt, IReceiver receiverStub) {
		algo = new DataPacketAlgo<String, String>(new DefaultCmd(receiverStub, cmd2ModelAdpt, unknownMsgs));
		
		algo.setCmd(IAddReceiverType.class, new AddReceiverCmd(cmd2ModelAdpt));
		algo.setCmd(ICRExceptionStatusType.class, new CRExceptionStatusCmd(cmd2ModelAdpt));
		algo.setCmd(ICRInstallCmdType.class, new CRInstallCmd(algo, unknownMsgs, cmd2ModelAdpt));
		algo.setCmd(ICRRejectionStatusType.class, new CRRejectionStatusCmd(cmd2ModelAdpt));
		algo.setCmd(IRequestCmdType.class, new CRRequestCmd(cmd2ModelAdpt, algo, receiverStub));
		algo.setCmd(IRemoveReceiverType.class, new RemoveReceiverCmd(cmd2ModelAdpt));
		algo.setCmd(StringMsgCmd.class, new StringMsgCmd(cmd2ModelAdpt));
	}

	@Override
	public UUID getUUID() throws RemoteException {
		// TODO Auto-generated method stub
		return uuid;
	}

	@Override
	public <T extends ICRMessageType> void receive(DataPacketCR<T> data) throws RemoteException {
		data.execute(algo);
	}

	@Override
	public IUser getUserStub() throws RemoteException {
		return user;
	}
	
}
