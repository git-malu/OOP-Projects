package lm44_xw47.model.dataType;

import common.DataPacketUserAlgoCmd;
import common.datatype.user.IUserInstallCmdType;

/**
 * install cmd datapacket type
 *
 */
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
	
	/**
	 * constructor 
	 * @param cmdId
	 * @param cmd
	 */
	public UserInstallCmdType(Class<?> cmdId, DataPacketUserAlgoCmd<?> cmd) {
		this.cmd = cmd;
		this.cmdId = cmdId;
	}

	/**
	 * get command
	 */
	@Override
	public DataPacketUserAlgoCmd<?> getCmd() {
		// TODO Auto-generated method stub
		return cmd;
	}

	/**
	 * get command id
	 */
	@Override
	public Class<?> getCmdId() {
		// TODO Auto-generated method stub
		return cmdId;
	}
	
}
