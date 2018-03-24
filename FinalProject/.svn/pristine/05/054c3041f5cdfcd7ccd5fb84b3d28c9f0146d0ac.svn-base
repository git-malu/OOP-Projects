package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IUserCmd2ModelAdapter;
import gov.nasa.worldwind.geom.Position;
import lm44_xw47.clientMap.ICmd2ClientMapAdapter;
import lm44_xw47.model.dataType.PlayerMoveType;
import provided.mixedData.MixedDataKey;

/**
 * command that orders players to move
 *
 */
public class PlayerMoveCmd extends DataPacketUserAlgoCmd<PlayerMoveType>{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 3031075969254806272L;

	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	
	private MixedDataKey<ICmd2ClientMapAdapter> gameKey;
	
	public PlayerMoveCmd(MixedDataKey<ICmd2ClientMapAdapter> gameKey, IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.gameKey = gameKey;
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}
	
	@Override
	public String apply(Class<?> index, DataPacketUser<PlayerMoveType> host, String... params) {
		ICmd2ClientMapAdapter cmd2ClientMapAdpt = cmd2ModelAdpt.get(gameKey);
		PlayerMoveType data = host.getData();
		Position dest = Position.fromDegrees(data.getLatitude(), data.getLongitude(), 0);
		cmd2ClientMapAdpt.playerMove(data.getUser(), dest);
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

}
