package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IChatRoom;
import common.IUserCmd2ModelAdapter;
import lm44_xw47.chatRoom.model.ICmd2LobbyAdapter;
import lm44_xw47.model.dataType.AddTeamGame;
import provided.mixedData.MixedDataKey;

public class AddTeamGameCmd extends DataPacketUserAlgoCmd<AddTeamGame>{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 5499700016792308152L;
	
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	
	private MixedDataKey<ICmd2LobbyAdapter> key;
	
	public AddTeamGameCmd(MixedDataKey<ICmd2LobbyAdapter> key) {
		this.key = key;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<AddTeamGame> host, String... params) {
		IChatRoom team = host.getData().getTeam();
		ICmd2LobbyAdapter cmd2LobbyAdapter = cmd2ModelAdpt.get(key);
		cmd2LobbyAdapter.addTeam(team);
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

}
