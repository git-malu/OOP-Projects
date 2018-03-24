package lm44_xw47.model.dataType;

import common.IUser;
import common.IUserMessageType;

/**
 * remove user game
 */
public class RemoveUserGame implements IUserMessageType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 3008598978712539215L;
	
	/**
	 * user
	 */
	private IUser user;
	
	/**
	 * set user
	 * @param user user
	 */
	public RemoveUserGame(IUser user) {
		this.user = user;
	}
	/**
	 * get user
	 * @return user user
	 */
	public IUser getUser() {
		return user;
	}
}