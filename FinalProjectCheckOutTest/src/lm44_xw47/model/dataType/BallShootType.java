package lm44_xw47.model.dataType;

import common.IUser;
import common.IUserMessageType;

/**
 * ball shoot command type
 *
 */
public class BallShootType implements IUserMessageType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 7685755995510918795L;
	
	/**
	 * user info
	 */
	private IUser user;
	
	/**
	 * latitude info
	 */
	private Double latitude;
	
	/**
	 * longitude info
	 */
	private Double longitude;
	
	public BallShootType(IUser user, Double latitude, Double longitude) {
		this.user = user;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * get user who shoots the ball
	 * @return user that shoots ball
	 */
	public IUser getUser() {
		return user;
	}
	/**
	 * get latitude position that ball shoot
	 * @return latitude position
	 */
	public Double getLatitude() {
		return latitude;
	}
	/**
	 * get longitude position that ball shoot
	 * @return longitude position
	 */
	public Double getLongitude() {
		return longitude;
	}

}
