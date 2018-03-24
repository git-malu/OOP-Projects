package lm44_xw47.chatRoom.model.dataType;

import common.DataPacketCR;
import common.ICRMessageType;
import common.datatype.chatroom.ICRRejectionStatusType;

public class CRRejectionStatusType implements ICRRejectionStatusType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -5903827727004035023L;
	
	private String failureInfo;
	
	private DataPacketCR<? extends ICRMessageType> dataPacketCR;
	
	public CRRejectionStatusType(String failureInfo, DataPacketCR<? extends ICRMessageType> dataPacketCR) {
		this.failureInfo = failureInfo;
		this.dataPacketCR = dataPacketCR;
	}
	@Override
	public DataPacketCR<? extends ICRMessageType> getOriginalData() {
		// TODO Auto-generated method stub
		return dataPacketCR;
	}

	@Override
	public String getFailureInfo() {
		// TODO Auto-generated method stub
		return failureInfo;
	}
	
}
