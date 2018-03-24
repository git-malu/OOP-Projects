package lm44_xw47.clientMap;

import common.IUser;
import gov.nasa.worldwind.geom.Position;

/**
 * server cmd to client adapter
 * @author xiaojun
 *
 */
public interface ICmd2ClientMapAdapter {
	/**
	 * ask the user to pick up the ball
	 * @param user player user
	 */
	public void pickBall(IUser user);
	
	/**
	 * ask the user to shoot the ball to destination
	 * @param user player user
	 * @param dest ball destination
	 */
	public void shootBall(IUser user, Position dest);
	
	/**
	 * ask the player to die
	 * @param user player user
	 */
	public void playerDie(IUser user);
	
	/**
	 * ask the player to move
	 * @param user player user
	 * @param dest moving destination
	 */
	public void playerMove(IUser user, Position dest);
	
	/**
	 * inform the client that the game is over
	 * @param gameOverMessage a message telling who has won
	 */
	public void gameOver(String gameOverMessage);
	
	public static final ICmd2ClientMapAdapter NULL_OBJECT = new ICmd2ClientMapAdapter() {
		/**
		 * No-op.
		 */
		@Override
		public void pickBall(IUser user) {
		}

		/**
		 * No-op.
		 */
		@Override
		public void shootBall(IUser user, Position dest) {	
		}

		/**
		 * No-op.
		 */
		@Override
		public void playerDie(IUser user) {	
		}

		/**
		 * No-op.
		 */
		@Override
		public void playerMove(IUser user, Position dest) {
		}
		
		/**
		 * No-op.
		 */
		@Override
		public void gameOver(String gameOverMessage) {
		}
		
	};
}
