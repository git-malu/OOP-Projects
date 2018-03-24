package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IUser;
import common.IUserCmd2ModelAdapter;
import lm44_xw47.chatRoom.model.ICmd2LobbyAdapter;
import lm44_xw47.model.dataType.RemoveUserGame;
import provided.mixedData.MixedDataKey;

public class RemoveUserGameCmd extends DataPacketUserAlgoCmd<RemoveUserGame>{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 714801897211248088L;
	
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	
	private MixedDataKey<ICmd2LobbyAdapter> key;
	
	public RemoveUserGameCmd(MixedDataKey<ICmd2LobbyAdapter> key) {
		this.key = key;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<RemoveUserGame> host, String... params) {
		IUser user = host.getData().getUser();
		ICmd2LobbyAdapter cmd2LobbyAdapter = cmd2ModelAdpt.get(key);
		cmd2LobbyAdapter.removeUser(user);
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

}
