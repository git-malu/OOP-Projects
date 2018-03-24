package lm44_xw47.chatRoom.model.dataType;

import common.DataPacketCRAlgoCmd;
import common.datatype.chatroom.ICRInstallCmdType;

public class CRInstallCmdType implements ICRInstallCmdType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 6094428186338208906L;
	
	private Class<?> cmdId;
	
	private DataPacketCRAlgoCmd<?> cmd;
	
	public CRInstallCmdType(Class<?> cmdId, DataPacketCRAlgoCmd<?> cmd) {
		this.cmdId = cmdId;
		this.cmd = cmd;
	}

	@Override
	public DataPacketCRAlgoCmd<?> getCmd() {
		return cmd;
	}

	@Override
	public Class<?> getCmdId() {
		return cmdId;
	}
	
}
