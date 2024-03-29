package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IChatRoom;
import common.IUserCmd2ModelAdapter;
import lm44_xw47.chatRoom.model.ICmd2LobbyAdapter;
import lm44_xw47.model.dataType.RemoveTeamGame;
import provided.mixedData.MixedDataKey;

/**
 * remove team command
 * @author Lu Ma
 * @author Xiaojun Wu
 *
 */
public class RemoveTeamGameCmd extends DataPacketUserAlgoCmd<RemoveTeamGame>{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -3409057302568680787L;
	
	/**
	 * adapter
	 */
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	
	/**
	 * data key for search in the storage dictionary
	 */
	private MixedDataKey<ICmd2LobbyAdapter> key;
	
	public RemoveTeamGameCmd(MixedDataKey<ICmd2LobbyAdapter> key) {
		this.key = key;
	}
	
	/**
	 * get adapter from storage and use it to remove team
	 */
	@Override
	public String apply(Class<?> index, DataPacketUser<RemoveTeamGame> host, String... params) {
		IChatRoom team = host.getData().getTeam();
		ICmd2LobbyAdapter cmd2LobbyAdapter = cmd2ModelAdpt.get(key);
		cmd2LobbyAdapter.removeTeam(team);
		return "";
	}
	
	/**
	 * set adapter
	 */
	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}
	
}
