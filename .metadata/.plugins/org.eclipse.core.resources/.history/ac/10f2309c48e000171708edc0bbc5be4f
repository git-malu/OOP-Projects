package lm44_xw47.model;

import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.render.GlobeAnnotation;

/**
 * player model used in the game model
 * @author malu
 *
 */
public class Player {
	/**
	 * player name
	 */
	String playerName = "Player";
	
	/**
	 * annotation that is displayed on the map
	 */
	GlobeAnnotation playerAnnotation = new GlobeAnnotation(playerName, Position.fromDegrees(1, 1, 0));
	
	/**
	 * player destination
	 */
	Position destination = Position.fromDegrees(45, 90, 0);
	
	/**
	 * player team affiliation
	 */
	Boolean team = NORTH; // true means north team
	
	/**
	 * player moving status
	 */
	Boolean moving = false; //whether the player is moving
	
	/**
	 * whether player is carrying a ball
	 */
	Boolean carrying = false;
	/**
	 * whether player is dead.
	 */
	Boolean dead = false;
	
	/**
	 * the only ball in the game
	 */
	Ball myBall = null;
	
	static Boolean NORTH = true;
	static Boolean SOUTH = false;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public Player(String name, Boolean team) {
		Position birthPlace;
		this.playerName = name;
		this.team = team;
		if(team) {
			birthPlace = Position.fromDegrees(45, 90, 0);
		} else {
			birthPlace = Position.fromDegrees(-45, 90, 0);
		}
		playerAnnotation = new GlobeAnnotation(name, birthPlace);
		
	}
	
	/**
	 * getter for player destination
	 * @return player destination
	 */
	public Position getDestination() {
		return destination;
	}
	/**
	 * getter for player team affiliation
	 * @return team affiliation
	 */
	public Boolean getTeam(){
		return team;
	}
	
	/**
	 * team affiliation setter
	 * @param team
	 */
	public void setTeam(Boolean team) {
		this.team = team;
	}
	
	/**
	 * getter for player moving status
	 * @return player moving status
	 */
	public Boolean getMoving() {
		return moving;
	}
	
	/**
	 * setter for player moving status
	 */
	public void setMoving(Boolean moving) {
		this.moving = moving;
	}
	
	/**
	 * getter for player carrying status
	 * @return player carrying status
	 */
	public Boolean getCarrying() {
		return carrying;
	}
	
	/**
	 * setter for player carrying status
	 */
	public void setCarrying(Boolean carrying) {
		this.carrying = carrying;
	}
	
	@Override
	public String toString() {
		return playerName;
	}
	
	/**
	 * setter for player destination
	 */
	public void setDestination(Position dest) {
		destination = dest;
		moving = true;
	}
	
	/**
	 * setter for the ball
	 * @param ball ball in the game
	 */
	public void setBall(Ball ball) {
		myBall = ball;
	}
	/**
	 * getter for the player current position
	 * @return player current position
	 */
	public Position getPosition() {
		return this.playerAnnotation.getPosition();
	}
	
	/**
	 * player see if there is a ball near him. If yes, he picks up the ball.
	 * @param ball the ball in the game
	 */
	public void pickUpBall(Ball ball) {
		Position current = this.playerAnnotation.getPosition();
		double cur_lo = current.longitude.degrees;
		double cur_la = current.latitude.degrees;
		Position ballPosition = ball.ballMarker.getPosition();
		double dest_lo = ballPosition.longitude.degrees;
		double dest_la = ballPosition.latitude.degrees;
		double hypotenuse = Math.sqrt(Math.pow((dest_lo - cur_lo), 2) + Math.pow((dest_la - cur_la), 2));
		if (hypotenuse < 10 && ball.ballState == Ball.STOP) {
			ball.carrier = this;
			ball.ballState = Ball.CARRIED;
			myBall = ball;
			carrying = true;
		}
	}
	
	/**
	 * see if the player is hit by a ball. 
	 * player gets hit if a flying from opponent is close enough to him.
	 * @param ball the ball in the game
	 * @return whether the player is hit by the ball
	 */
	public Boolean hit(Ball ball) {
		Position current = this.playerAnnotation.getPosition();
		double cur_lo = current.longitude.degrees;
		double cur_la = current.latitude.degrees;
		Position ballPosition = ball.ballMarker.getPosition();
		double dest_lo = ballPosition.longitude.degrees;
		double dest_la = ballPosition.latitude.degrees;
		double hypotenuse = Math.sqrt(Math.pow((dest_lo - cur_lo), 2) + Math.pow((dest_la - cur_la), 2));
		System.out.println("hit: hypotenuse: " + hypotenuse);
		System.out.println("hit: ballState: " + ball.ballState);
		System.out.println("hit: team: " + team);
		System.out.println("hit: carrier: " + ball.carrier.team);
		return hypotenuse < 7 && ball.ballState == Ball.FLY && team != ball.carrier.team; // whether hit by a flying ball from opponent
		
	}
	
	/**
	 * make the player shoot the ball to a destination
	 * @param position ball shooting destination
	 */
	public void shoot(Position position) {
		myBall.destination = position;
		myBall.ballState = Ball.FLY;
		carrying = false;
	}
	
	/**
	 * player move one step toward destination
	 */
	public void moveTowardDest() {
		Position current = this.playerAnnotation.getPosition();
		double cur_lo = current.longitude.degrees;
		double cur_la = current.latitude.degrees;
		
		double dest_lo = this.destination.longitude.degrees;
		double dest_la = this.destination.latitude.degrees;
		
		
		//take the short path, for example, move from longitude -179 to longitude 179, you can just move 2 degrees instead of 2 * 179 degrees
		if(Math.abs(dest_lo - cur_lo) > 180) {
			if (dest_lo < cur_lo) {
				dest_lo += 360;
			}else {
				cur_lo += 360;
			}
		}
		
		//move only when hypotenuse > 1, otherwise don't move
		double hypotenuse = Math.sqrt(Math.pow((dest_lo - cur_lo), 2) + Math.pow((dest_la - cur_la), 2));
		if(hypotenuse > 1) {
			double delta_lo = (dest_lo - cur_lo)/hypotenuse *2;
			double delta_la = (dest_la - cur_la)/hypotenuse *2;
			current = current.add(Position.fromDegrees(delta_la, delta_lo, 0)); //move forward a bit
			this.playerAnnotation.moveTo(current);
		} else {
			moving = false;
		}
	}
}