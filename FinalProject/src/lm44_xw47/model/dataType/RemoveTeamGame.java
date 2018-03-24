package lm44_xw47.model.dataType;

import common.IChatRoom;
import common.IUserMessageType;

/**
 * remove team game data type
 */
public class RemoveTeamGame implements IUserMessageType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -6941949205949166548L;
	
	/**
	 * chatroom
	 */
	private IChatRoom team;
	
	/**
	 * set team game
	 * @param team team to be removed
	 */
	public RemoveTeamGame(IChatRoom team) {
		this.team = team;
	}
	
	/**
	 * get team 
	 * @return team 
	 */
	public IChatRoom getTeam() {
		return team;
	}
	
}
