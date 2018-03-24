package lm44_xw47.model.dataType;

import common.DataPacketUser;
import common.IUserMessageType;
import common.datatype.user.IUserExceptionStatusType;

public class UserExceptionStatusType implements IUserExceptionStatusType{

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 5012309705577298083L;
	
	private String failureInfo;
	
	private DataPacketUser<? extends IUserMessageType> dataPacketUser;

	public UserExceptionStatusType(String failureInfo, DataPacketUser<? extends IUserMessageType> dataPacketUser) {
		this.failureInfo = failureInfo;
		this.dataPacketUser = dataPacketUser;
	}
	
	@Override
	public DataPacketUser<? extends IUserMessageType> getOriginalData() {
		return dataPacketUser;
	}

	@Override
	public String getFailureInfo() {
		// TODO Auto-generated method stub
		return failureInfo;
	}
	
}
