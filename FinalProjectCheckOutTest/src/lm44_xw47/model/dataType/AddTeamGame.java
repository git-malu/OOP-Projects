package lm44_xw47.model.dataType;

import common.IChatRoom;
import common.IUserMessageType;

/**
 * add team game
 *
 */
public class AddTeamGame implements IUserMessageType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 2334886188849139766L;
	
	/**
	 * chatroom
	 */
	private IChatRoom team;
	
	/**
	 * set chatroom as team
	 * @param team
	 */
	public AddTeamGame(IChatRoom team) {
		this.team = team;
	}
	
	/**
	 * get chatroom as team
	 * @return chatroom
	 */
	public IChatRoom getTeam() {
		return team;
	}
	
}
