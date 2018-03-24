package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IUser;
import common.IUserCmd2ModelAdapter;
import lm44_xw47.chatRoom.model.ICmd2LobbyAdapter;
import lm44_xw47.model.dataType.AddUserGame;
import provided.mixedData.MixedDataKey;

/**
 * add user game command
 *
 */
public class AddUserGameCmd extends DataPacketUserAlgoCmd<AddUserGame>{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -6700111473532196176L;
	/**
	 * adapter
	 */
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	/**
	 * user data key
	 */
	private MixedDataKey<ICmd2LobbyAdapter> key;
	
	/**
	 * constructor
	 * @param key
	 */
	public AddUserGameCmd(MixedDataKey<ICmd2LobbyAdapter> key) {
		this.key = key;
	}

	/**
	 * command adapter
	 */
	@Override
	public String apply(Class<?> index, DataPacketUser<AddUserGame> host, String... params) {
		IUser user = host.getData().getUser();
		ICmd2LobbyAdapter cmd2LobbyAdapter = cmd2ModelAdpt.get(key);
		cmd2LobbyAdapter.addUser(user);
		return "";
	}
	/**
	 * set adapter
	 */
	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

}
