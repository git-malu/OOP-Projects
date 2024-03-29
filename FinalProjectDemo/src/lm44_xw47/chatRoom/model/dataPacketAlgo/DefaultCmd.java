package lm44_xw47.chatRoom.model.dataPacketAlgo;

import java.io.Console;
import java.rmi.RemoteException;
import java.util.Map;

import javax.swing.SwingUtilities;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import common.ICRMessageType;
import common.IReceiver;
import common.datatype.IRequestCmdType;
import lm44_xw47.chatRoom.model.dataType.CRRequestCmdType;

public class DefaultCmd extends DataPacketCRAlgoCmd<ICRMessageType>{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 4996939621946843369L;
	
	private transient ICRCmd2ModelAdapter cmd2ModelAdpt;
	
	private transient Map<Class<?>, DataPacketCR<?>> unknownMsgs;
	
	private transient IReceiver receiverStub;
	
	public DefaultCmd(IReceiver receiverStub, ICRCmd2ModelAdapter cmd2ModelAdpt, Map<Class<?>, DataPacketCR<?>> unknownMsgs) {
		this.receiverStub = receiverStub;
		this.cmd2ModelAdpt = cmd2ModelAdpt;
		this.unknownMsgs = unknownMsgs;
	}

	@Override
	public String apply(Class<?> index, DataPacketCR<ICRMessageType> host, String... params) {
		ICRMessageType data = host.getData();
		String msg = "Default case called. data = " + data + "\n";
		IReceiver sender = host.getSender();
		System.out.println(index);
		System.out.println(data);
		System.out.println(unknownMsgs);
		unknownMsgs.put(index, host);
		try {
			sender.receive(new DataPacketCR<IRequestCmdType>(IRequestCmdType.class, new CRRequestCmdType(index), receiverStub));
		} catch (RemoteException e) {
			e.printStackTrace();
			
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					cmd2ModelAdpt.appendMsg(msg, "Default:");
				}
			});
		}
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}
	
}
