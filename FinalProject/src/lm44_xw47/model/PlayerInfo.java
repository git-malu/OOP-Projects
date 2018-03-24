package lm44_xw47.model;

import gov.nasa.worldwind.geom.Position;

public class PlayerInfo {
	private Position pos;
	
	private Position origPos;
	
	private boolean carry;
	
	public PlayerInfo(Position pos, Position origPos) {
		this.pos = pos;
		this.origPos = origPos;
	}
	
	public Position getPostion() {
		return pos;
	}
	
	public void setPositon(Position pos) {
		this.pos = pos;
	}
	
	public boolean getCarry() {
		return carry;
	}
	
	public void setCarry(boolean carry) {
		this.carry = carry;
	}
	
	public Position getOrgiPosition() {
		return origPos;
	}
	
	public void setOrgiPositon(Position origPos) {
		this.origPos = origPos;
	}
}