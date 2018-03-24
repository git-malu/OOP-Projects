package lm44_xw47.model.dataType;

import common.datatype.IRequestCmdType;

public class RequestCmdType implements IRequestCmdType{

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -2712913509436490013L;

	private Class<?> cmdId;
	
	public RequestCmdType(Class<?> cmdId) {
		this.cmdId = cmdId;
	}

	@Override
	public Class<?> getCmdId() {
		return cmdId;
	}

}
