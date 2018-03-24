package lm44_xw47.chatRoom.model.dataType;

import common.DataPacketCRAlgoCmd;
import common.datatype.chatroom.ICRInstallCmdType;

/**
 * Following defines the data type about installing a new command.
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public class CRInstallCmdType implements ICRInstallCmdType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 6094428186338208906L;
	
	/**
	 * The command id for the installed command.
	 */
	private Class<?> cmdId;
	
	/**
	 * The installed command.
	 */
	private DataPacketCRAlgoCmd<?> cmd;
	
	/**
	 * Constructor.
	 * 
	 * @param cmdId The command id for the installed command.
	 * @param cmd The installed command.
	 */
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
