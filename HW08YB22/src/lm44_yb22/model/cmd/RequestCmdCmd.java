package lm44_yb22.model.cmd;

import java.rmi.RemoteException;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
import common.IInstallCmdType;
import common.IReceiver;
import common.IRequestCmdType;
import lm44_yb22.model.dataType.InstallCmdType;
import provided.datapacket.DataPacketAlgo;

public class RequestCmdCmd extends DataPacketAlgoCmd<IRequestCmdType>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -696508281192755519L;
	public ICmd2ModelAdapter cmd2ModelAdapter;
	public IReceiver sender;
	public DataPacketAlgo<String, String> visitor;
	
	public RequestCmdCmd( ICmd2ModelAdapter adapter, DataPacketAlgo<String, String> visitor, IReceiver sender) {
		// TODO Auto-generated constructor stub
		this.visitor = visitor;
		cmd2ModelAdapter = adapter;
		this.sender = sender;
	}
	
	@Override
	public String apply(Class<?> index, DataPacketChatRoom<IRequestCmdType> host, String... params) {
		// TODO Auto-generated method stub
		//I
		
		try {
			host.getSender().receive(
					new DataPacketChatRoom<IInstallCmdType>(
							IInstallCmdType.class,  
							new InstallCmdType(    (DataPacketAlgoCmd<?>) visitor.getCmd(index)), 
							sender
					)
			);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		this.cmd2ModelAdapter = cmd2ModelAdpt;
	}

}
