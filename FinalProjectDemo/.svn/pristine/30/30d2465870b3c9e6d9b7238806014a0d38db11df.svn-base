package lm44_xw47.chatRoom.model.dataPacketAlgo;

import java.util.Map;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import common.datatype.chatroom.ICRInstallCmdType;
import provided.datapacket.DataPacketAlgo;

public class CRInstallCmd extends DataPacketCRAlgoCmd<ICRInstallCmdType> {
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 3455543561084198579L;
	
	private transient ICRCmd2ModelAdapter cmd2ModelAdapter;
	
	private transient DataPacketAlgo<String, String> algo;
	
	private transient Map<Class<?>, DataPacketCR<?>> unknownMsgs;
	
	public CRInstallCmd(DataPacketAlgo<String, String> algo, Map<Class<?>, DataPacketCR<?>> unknownMsgs, ICRCmd2ModelAdapter cmd2ModelAdapter) {
		this.cmd2ModelAdapter = cmd2ModelAdapter;
		this.algo = algo;
		this.unknownMsgs = unknownMsgs;
	}

	@Override
	public String apply(Class<?> index, DataPacketCR<ICRInstallCmdType> host, String... params) {
		DataPacketCRAlgoCmd<?> cmd = host.getData().getCmd();
		cmd.setCmd2ModelAdpt(cmd2ModelAdapter);
		algo.setCmd(host.getData().getCmdId(), cmd);
		unknownMsgs.remove(host.getData().getCmdId()).execute(algo);
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = cmd2ModelAdapter;
	}

}
