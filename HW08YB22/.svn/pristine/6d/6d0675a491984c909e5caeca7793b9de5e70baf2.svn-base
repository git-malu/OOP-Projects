package lm44_yb22.model.cmd;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
import common.IInstallCmdType;
import lm44_yb22.model.Receiver;
import provided.datapacket.DataPacketAlgo;

public class InstallCmdCmd extends DataPacketAlgoCmd<IInstallCmdType>{
	public DataPacketAlgo<String, String> visitor;
	private Receiver receiver;
	public InstallCmdCmd(DataPacketAlgo<String, String> visitor, Receiver receiver) {
		// TODO Auto-generated constructor stub
		this.visitor = visitor;
		this.receiver = receiver;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1822115203331609846L;

	//install cmd
	@Override
	public String apply(Class<?> index, DataPacketChatRoom<IInstallCmdType> host, String... params) {
		// TODO Auto-generated method stub
		visitor.setCmd(host.getData().getCmd().getClass(), host.getData().getCmd()); 
		receiver.table.get(index).execute(visitor, params);
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		
	}

}
