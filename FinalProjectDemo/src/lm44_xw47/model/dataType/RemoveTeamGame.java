package lm44_xw47.model.dataType;

import common.IChatRoom;
import common.IUserMessageType;

public class RemoveTeamGame implements IUserMessageType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -6941949205949166548L;
	
	private IChatRoom team;
	
	public RemoveTeamGame(IChatRoom team) {
		this.team = team;
	}
	
	public IChatRoom getTeam() {
		return team;
	}
	
}
