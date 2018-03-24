package lm44_xw47.chatRoom.model.dataType;

import common.DataPacketCR;
import common.ICRMessageType;
import common.datatype.chatroom.ICRExceptionStatusType;

/**
 * Following defines the data type of exception status.
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public class CRExceptionStatusType implements ICRExceptionStatusType {
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 1117629259942626033L;

	/**
	 * The data packet that calls exception.
	 */
	private DataPacketCR<? extends ICRMessageType> dataPacketCR;
	
	/**
	 * The failure information.
	 */
	private String failureInfo;
	
	/**
	 * Constructor.
	 * 
	 * @param failureInfo The failure information.
	 * @param dataPacketCR The data packet that calls exception.
	 */
	public CRExceptionStatusType(String failureInfo, DataPacketCR<? extends ICRMessageType> dataPacketCR) {
		this.failureInfo = failureInfo;
		this.dataPacketCR = dataPacketCR;
	}
	
	@Override
	public DataPacketCR<? extends ICRMessageType> getOriginalData() {
		return dataPacketCR;
	}

	@Override
	public String getFailureInfo() {
		return failureInfo;
	}
	
}