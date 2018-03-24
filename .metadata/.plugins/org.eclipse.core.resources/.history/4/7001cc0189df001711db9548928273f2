package lm44_xw47.model.dataType;

import common.DataPacketUser;
import common.IUserMessageType;
import common.datatype.user.IUserRejectionStatusType;

public class UserRejectionStatusType implements IUserRejectionStatusType {

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -320036311324352859L;
	
	private String failureInfo;
	
	private DataPacketUser<? extends IUserMessageType> dataPacketUser;

	public UserRejectionStatusType(String failureInfo, DataPacketUser<? extends IUserMessageType> dataPacketUser) {
		this.failureInfo = failureInfo;
		this.dataPacketUser = dataPacketUser;
	}

	@Override
	public DataPacketUser<? extends IUserMessageType> getOriginalData() {
		// TODO Auto-generated method stub
		return dataPacketUser;
	}

	@Override
	public String getFailureInfo() {
		// TODO Auto-generated method stub
		return failureInfo;
	}
	
}
