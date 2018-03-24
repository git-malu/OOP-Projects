package lm44_xw47.chatRoom.model.dataPacketAlgo;

import java.rmi.RemoteException;

import javax.swing.SwingUtilities;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import common.IReceiver;
import common.datatype.chatroom.IRemoveReceiverType;
import lm44_xw47.chatRoom.model.ILocalCRCmd2ModelAdapter;

public class RemoveReceiverCmd extends DataPacketCRAlgoCmd<IRemoveReceiverType>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6364258561225836292L;
	
	private transient ILocalCRCmd2ModelAdapter cmd2ModelAdpt;
	
	public RemoveReceiverCmd(ICRCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = (ILocalCRCmd2ModelAdapter) cmd2ModelAdpt;
	}

	@Override
	public String apply(Class<?> index, DataPacketCR<IRemoveReceiverType> host, String... params) {
		IReceiver receiver = host.getData().getReceiverStub();
		try {
			String username = receiver.getUserStub().getName();
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					cmd2ModelAdpt.removeReceiver(receiver);
					cmd2ModelAdpt.appendMsg(" has left the team. \n", username);
				}
			});
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = (ILocalCRCmd2ModelAdapter) cmd2ModelAdpt;
	}

}
