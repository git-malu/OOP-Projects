package lm44_xw47.model;

import common.IChatRoom;
import common.IReceiver;
import common.IUserCmd2ModelAdapter;

/**
 * cmd adapter
 * @author Lu Ma
 * @author Xiaojun Wu
 *
 */
public interface ILocalUserCmd2ModelAdapter extends IUserCmd2ModelAdapter{
	public IReceiver joinTeam(IChatRoom team);
}
