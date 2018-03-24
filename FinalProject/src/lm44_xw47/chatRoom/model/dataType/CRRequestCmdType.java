package lm44_xw47.chatRoom.model.dataType;

import common.datatype.IRequestCmdType;

/**
 * Following defines the data type about requesting a new command.
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public class CRRequestCmdType implements IRequestCmdType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -4994555229329875873L;
	
	/**
	 * The command id for the requested command.
	 */
	private Class<?> cmdId;
	
	/**
	 * Constructor.
	 * 
	 * @param cmdId The command id for the requested command.
	 */
	public CRRequestCmdType(Class<?> cmdId) {
		this.cmdId = cmdId;
	}

	@Override
	public Class<?> getCmdId() {
		return cmdId;
	}

}
