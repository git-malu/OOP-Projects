package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IUserCmd2ModelAdapter;
import lm44_xw47.clientMap.ICmd2ClientMapAdapter;
import lm44_xw47.model.dataType.PlayerDieType;
import provided.mixedData.MixedDataKey;

/**
 * command that makes player die
 *
 */
public class PlayerDieCmd extends DataPacketUserAlgoCmd<PlayerDieType>{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 4000794724897235263L;
	
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	
	private MixedDataKey<ICmd2ClientMapAdapter> gameKey;
	
	public PlayerDieCmd(MixedDataKey<ICmd2ClientMapAdapter> gameKey, IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.gameKey = gameKey;
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<PlayerDieType> host, String... params) {
		ICmd2ClientMapAdapter cmd2ClientMapAdpt = cmd2ModelAdpt.get(gameKey);
		cmd2ClientMapAdpt.playerDie(host.getData().getUser());
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}
	
}
