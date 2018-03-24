package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IUserCmd2ModelAdapter;
import common.datatype.user.IUserRejectionStatusType;

/**
 * This command handles user rejection datapacket.
 * @author Lu Ma
 * @author Xiaojun Wu
 *
 */
public class UserRejectionStatusCmd extends DataPacketUserAlgoCmd<IUserRejectionStatusType> {

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -123858600835223730L;
	
	/**
	 * command to user model adapter
	 */
	public transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	
	public UserRejectionStatusCmd(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<IUserRejectionStatusType> host, String... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		
	}
	
}
