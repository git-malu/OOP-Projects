package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IUserCmd2ModelAdapter;
import common.datatype.user.IUserExceptionStatusType;

/**
 * 
 * This command handles user exception status
 * @author Lu Ma
 * @author Xiaojun Wu
 *
 */
public class UserExceptionStatusCmd extends DataPacketUserAlgoCmd<IUserExceptionStatusType>{

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -1325979615454321236L;
	
	public UserExceptionStatusCmd(IUserCmd2ModelAdapter cmd2ModelAdpt) {
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<IUserExceptionStatusType> host, String... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
	}
	
}