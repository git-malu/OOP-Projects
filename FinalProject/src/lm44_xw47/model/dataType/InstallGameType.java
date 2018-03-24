package lm44_xw47.model.dataType;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import common.IChatRoom;
import common.IUser;
import common.IUserMessageType;

/**
 * install game command type
 *
 */
public class InstallGameType implements IUserMessageType {
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 476449171304650402L;
	
	/**
	 * game user list
	 */
	private Collection<IUser> users;
	
	/**
	 * team affiliation list
	 */
	private Map<IUser, IChatRoom> teamsByUser = new Hashtable<IUser, IChatRoom>();
	
	/**
	 * server stub
	 */
	private IUser server;
	
	/**
	 * local user
	 */
	private IUser localUser;
	
	public InstallGameType(Collection<IUser> users, Map<IUser, IChatRoom> teamsByUser, IUser server, IUser localUser) {
		this.users = users;
		this.teamsByUser = teamsByUser;
		this.server = server;
		this.localUser = localUser;
	}
	
	/**
	 * get game user list
	 * @return user list
	 */
	public Collection<IUser> getUsers() {
		return users;
	}
	/**
	 * get team affiliation
	 * @return team affiliation list
	 */
	public Map<IUser, IChatRoom> getTeams() {
		return teamsByUser;
	}
	
	/**
	 * get game server
	 * @return game server
	 */
	public IUser getServer() {
		return server;
	}
	
	/**
	 * get local user
	 * @return local user
	 */
	public IUser getLocalUser() {
		return localUser;
	}
}
