package lm44_xw47.model.dataType;

import common.IUserMessageType;

/**
 * create team 
 *
 */
public class CreateTeamType implements IUserMessageType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -7171979375655844408L;
	
	/**
	 * team name
	 */
	private String teamname;
	
	/**
	 * set team name
	 * @param teamname
	 */
	public CreateTeamType(String teamname) {
		this.teamname = teamname;
	}
	/**
	 * get team name
	 * @return team name
	 */
	public String getTeamname() {
		return teamname;
	}
	
}
