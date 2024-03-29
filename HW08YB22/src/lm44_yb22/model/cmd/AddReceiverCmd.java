package lm44_yb22.model.cmd;

import java.rmi.RemoteException;

import javax.swing.SwingUtilities;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.IAddReceiverType;
import common.ICmd2ModelAdapter;
import common.IReceiver;
import lm44_yb22.model.IReceiverAdapter;

public class AddReceiverCmd extends DataPacketAlgoCmd<IAddReceiverType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4203008964993515111L;
	
	private transient ICmd2ModelAdapter _cmd2ModelAdapter;
	
	public AddReceiverCmd(ICmd2ModelAdapter _cmd2ModelAdapter) {
		this._cmd2ModelAdapter = _cmd2ModelAdapter;
	}
	
	//use cmd as a key to the host lock
	//add receiver to my chat room
	@Override
	public String apply(Class<?> index, DataPacketChatRoom<IAddReceiverType> host, String... params) {
		IReceiver receiver = host.getData().getReceiverStub();
		try {
			String username = receiver.getUserStub().getName();
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					_cmd2ModelAdapter.appendMsg("have joined this room.", username);
					((IReceiverAdapter) _cmd2ModelAdapter).addReceiver(receiver);
				}
			});
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this._cmd2ModelAdapter = cmd2ModelAdpt;
	}
	
}
