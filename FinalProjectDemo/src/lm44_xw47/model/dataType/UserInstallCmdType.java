package lm44_xw47.model.dataType;

import common.DataPacketUserAlgoCmd;
import common.datatype.user.IUserInstallCmdType;

public class UserInstallCmdType implements IUserInstallCmdType{

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 8455793138116778234L;
	
	/**
	 * The command that should be installed to remote receiver.
	 */
	private DataPacketUserAlgoCmd<?> cmd;

	/**
	 * The command id of the installed command.
	 */
	private Class<?> cmdId;
	
	public UserInstallCmdType(Class<?> cmdId, DataPacketUserAlgoCmd<?> cmd) {
		this.cmd = cmd;
		this.cmdId = cmdId;
	}

	@Override
	public DataPacketUserAlgoCmd<?> getCmd() {
		// TODO Auto-generated method stub
		return cmd;
	}

	@Override
	public Class<?> getCmdId() {
		// TODO Auto-generated method stub
		return cmdId;
	}
	
}
