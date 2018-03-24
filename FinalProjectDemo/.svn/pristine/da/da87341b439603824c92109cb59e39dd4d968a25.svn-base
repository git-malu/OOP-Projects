package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IUserCmd2ModelAdapter;
import lm44_xw47.chatRoom.model.ICmd2LobbyAdapter;
import lm44_xw47.controller.MapController;
import lm44_xw47.model.dataType.InstallGameType;
import provided.mixedData.MixedDataKey;

public class InstallGameCmd extends DataPacketUserAlgoCmd<InstallGameType>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5022860972167300955L;
	
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	
	private MixedDataKey<ICmd2LobbyAdapter> key;
	
	public InstallGameCmd(MixedDataKey<ICmd2LobbyAdapter> key) {
		this.key = key;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<InstallGameType> host, String... params) {
		// TODO Auto-generated method stub
		ICmd2LobbyAdapter cmd2LobbyAdapter = cmd2ModelAdpt.get(key);
		MapController mapController = new MapController(cmd2LobbyAdapter);
		mapController.start();
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

}
