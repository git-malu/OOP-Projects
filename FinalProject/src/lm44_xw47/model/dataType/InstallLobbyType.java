package lm44_xw47.model.dataType;

import java.util.Collection;

import common.IChatRoom;
import common.IUser;
import common.IUserMessageType;

/**
 * 
 * install lobby command type
 *
 */
public class InstallLobbyType implements IUserMessageType {

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -5974490432578562080L;
	
	/**
	 * user list
	 */
	private Collection<IUser> users;
	
	/**
	 * get team collection
	 */
	private Collection<IChatRoom> teams;
	
	/**
	 * get local user
	 */
	private IUser localUser;
	
	/**
	 * constructor
	 * @param users user list
	 * @param teams team affiliation list
	 * @param localUser local user
	 */
	
	public InstallLobbyType(Collection<IUser> users, Collection<IChatRoom> teams, IUser localUser) {
		this.users = users;
		this.teams = teams;
		this.localUser = localUser;
	}
	
	/**
	 * get user list
	 * @return user list
	 */
	public Collection<IUser> getUsers() {
		return users;
	}
	
	/**
	 * get local user
	 * @return local user
	 */
	public IUser getLocalUser() {
		return localUser;
	}
	
	/**
	 * get team affiliation list
	 * @return team affiliation list
	 */
	public Collection<IChatRoom> getTeams() {
		return teams;
	}
}
