package lm44_yb22.model.cmd;

import java.rmi.RemoteException;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
import common.IReceiver;
import common.IRequestCmdType;
import lm44_yb22.model.Receiver;
import lm44_yb22.model.dataType.RequestCmdType;
import provided.datapacket.DataPacketAlgo;

public class DefalutCmd extends DataPacketAlgoCmd<Object>{
//	Hashtable<Class<?>, DataPacketChatRoom<Object>> table = new Hashtable<>();
	private ICmd2ModelAdapter cmd2ModelAdapter;
	private IReceiver sender;
	private DataPacketAlgo<String, String> visitor;
	public DefalutCmd(ICmd2ModelAdapter adpt, IReceiver sender) {
		cmd2ModelAdapter = adpt;
		this.sender = sender;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3509224954420899613L;

	@Override
	public String apply(Class<?> index, DataPacketChatRoom<Object> host, String... params) {
		((Receiver)sender).table.put(index, host);
		
		
		try {
			//request cmd
			host.getSender().receive(new DataPacketChatRoom<IRequestCmdType>(IRequestCmdType.class, new RequestCmdType(index), sender));
//			host.execute(visitor, params);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("use default command");
		return "use default command";
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = cmd2ModelAdpt;
	}
	
	public void setVisitor(DataPacketAlgo<String, String> visitor) {
		this.visitor = visitor;
	}
	
	
	
}
