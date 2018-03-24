package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IUserCmd2ModelAdapter;
import common.datatype.user.IQuitType;

public class QuitCmd extends DataPacketUserAlgoCmd<IQuitType>{

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 127521086719804272L;
	
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	
	public QuitCmd(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<IQuitType> host, String... params) {
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}
	
}
