package lm44_xw47.model.dataType;

import common.DataPacketUser;
import common.IUserMessageType;
import common.datatype.user.IUserExceptionStatusType;

public class UserExceptionStatusType implements IUserExceptionStatusType{

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 5012309705577298083L;
	
	/**
	 * failure information
	 */
	private String failureInfo;
	
	/**
	 * data packet user
	 */
	private DataPacketUser<? extends IUserMessageType> dataPacketUser;

	public UserExceptionStatusType(String failureInfo, DataPacketUser<? extends IUserMessageType> dataPacketUser) {
		this.failureInfo = failureInfo;
		this.dataPacketUser = dataPacketUser;
	}
	
	/**
	 * get datapacket information
	 */
	@Override
	public DataPacketUser<? extends IUserMessageType> getOriginalData() {
		return dataPacketUser;
	}
	
	/**
	 * get failure informaiton
	 */
	@Override
	public String getFailureInfo() {
		// TODO Auto-generated method stub
		return failureInfo;
	}
	
}
