package lm44_xw47.model.dataType;

import common.IUser;
import common.IUserMessageType;

public class AddUserGame implements IUserMessageType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 335912948333959123L;
	
	private IUser user;
	
	public AddUserGame(IUser user) {
		this.user = user;
	}
	
	public IUser getUser() {
		return user;
	}
	
}
