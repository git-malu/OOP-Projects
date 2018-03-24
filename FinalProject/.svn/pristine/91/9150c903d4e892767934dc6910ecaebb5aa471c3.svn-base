package lm44_xw47.chatRoom.model.dataType;

import common.DataPacketCR;
import common.ICRMessageType;
import common.datatype.chatroom.ICRExceptionStatusType;

public class CRExceptionStatusType implements ICRExceptionStatusType {
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 1117629259942626033L;

	private DataPacketCR<? extends ICRMessageType> dataPacketCR;
	
	private String failureInfo;
	
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
