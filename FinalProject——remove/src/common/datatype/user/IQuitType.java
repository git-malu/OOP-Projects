package common.datatype.user;

import java.io.Serializable;
import common.IUser;

/**
 * Common data type for quitting.
 * When a user quits the app, he/she will send such a data packet to all connected peers.
 */
public interface IQuitType extends Serializable  {

	/**
	 * Get the user stub who is quitting
	 * @return the quitting user
	 */
	public IUser getUserStub();
}
