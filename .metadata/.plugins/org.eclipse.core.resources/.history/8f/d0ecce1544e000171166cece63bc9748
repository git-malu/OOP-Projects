package lm44_xw47.model.dataPacketAlgoCmd;

import java.util.Collection;
import java.util.Map;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IChatRoom;
import common.IUser;
import common.IUserCmd2ModelAdapter;
import common.datatype.user.IQuitType;

/**
 * quit game command
 *
 */
public class QuitCmd extends DataPacketUserAlgoCmd<IQuitType>{

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 127521086719804272L;
	
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	
	private transient Collection<IUser> users;
	
	private transient Collection<IUser> readiedUsers;
	
	private transient Map<IUser, IChatRoom> teamsByUser;
	
	public QuitCmd(IUserCmd2ModelAdapter cmd2ModelAdpt, Collection<IUser> users, Collection<IUser> readiedUsers, Map<IUser, IChatRoom> teamsByUser) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
		this.users = users;
		this.readiedUsers = readiedUsers;
		this.teamsByUser = teamsByUser;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<IQuitType> host, String... params) {
		IUser user = host.getData().getUserStub();
		users.remove(user);
		readiedUsers.remove(user);
		teamsByUser.remove(user);
		cmd2ModelAdpt.appendMsg("A user quit the app. \n", "System: ");
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}
	
}
