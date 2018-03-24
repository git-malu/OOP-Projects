package lm44_xw47.model.dataType;

import common.IUserMessageType;

public class JoinTeamType implements IUserMessageType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -4796853568909678228L;
	
	private String teamName;
	
	public JoinTeamType(String teamName) {
		this.teamName = teamName;
	}
	
	public String getTeamName() {
		return teamName;
	}
}
