package lm44_xw47.chatRoom.model.dataPacketAlgo;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import common.datatype.chatroom.ICRExceptionStatusType;

public class CRExceptionStatusCmd extends DataPacketCRAlgoCmd<ICRExceptionStatusType>{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 2224817525325326372L;
	
	private transient ICRCmd2ModelAdapter cmd2ModelAdapter;
	
	public CRExceptionStatusCmd(ICRCmd2ModelAdapter cmd2ModelAdapter) {
		this.cmd2ModelAdapter = cmd2ModelAdapter;
	}

	@Override
	public String apply(Class<?> index, DataPacketCR<ICRExceptionStatusType> host, String... params) {
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = cmd2ModelAdapter;
	}
	
}
