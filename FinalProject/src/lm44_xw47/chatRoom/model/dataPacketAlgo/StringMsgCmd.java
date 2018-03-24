package lm44_xw47.chatRoom.model.dataPacketAlgo;

import java.rmi.RemoteException;

import javax.swing.SwingUtilities;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import lm44_xw47.chatRoom.model.dataType.StringMsgType;

/**
 * Following defines the command that process string messages.
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public class StringMsgCmd extends DataPacketCRAlgoCmd<StringMsgType>{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 8341684903297434325L;
	
	/**
	 * The adapter this command uses to communicate with local system.
	 */
	private transient ICRCmd2ModelAdapter cmd2ModelAdpt;
	
	/**
	 * Constructor.
	 * 
	 * @param cmd2ModelAdpt The adapter this command uses to communicate with local system.
	 */
	public StringMsgCmd(ICRCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

	@Override
	public String apply(Class<?> index, DataPacketCR<StringMsgType> host, String... params) {
		String msg = host.getData().getMsg();
		System.out.println("msg: " + msg);
		try {
			String sender = host.getSender().getUserStub().getName();
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					cmd2ModelAdpt.appendMsg(": " + msg + "\n", sender);
				}
			});
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}
	
}
