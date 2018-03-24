package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IUser;
import common.IUserCmd2ModelAdapter;
import gov.nasa.worldwind.geom.Position;
import lm44_xw47.chatRoom.model.ICmd2LobbyAdapter;
import lm44_xw47.clientMap.ClientMapController;
import lm44_xw47.clientMap.ClientMapModel;
import lm44_xw47.clientMap.ICmd2ClientMapAdapter;
import lm44_xw47.model.dataType.InstallGameType;
import provided.mixedData.MixedDataKey;

/**
 * install game command
 *
 */
public class InstallGameCmd extends DataPacketUserAlgoCmd<InstallGameType>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5022860972167300955L;
	
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	
	private MixedDataKey<ICmd2LobbyAdapter> key;
	
	private MixedDataKey<ICmd2ClientMapAdapter> gameKey;
	
	public InstallGameCmd(MixedDataKey<ICmd2LobbyAdapter> key, MixedDataKey<ICmd2ClientMapAdapter> gameKey, IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.key = key;
		this.gameKey = gameKey;
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<InstallGameType> host, String... params) {
		// TODO Auto-generated method stub
		InstallGameType data = host.getData();
		ICmd2LobbyAdapter cmd2LobbyAdapter = cmd2ModelAdpt.get(key);
		ClientMapController mapController = new ClientMapController(cmd2LobbyAdapter, data.getUsers(), data.getTeams(), data.getServer(), data.getLocalUser());
		ClientMapModel _mapModel = mapController.getClientMapModel();
		ICmd2ClientMapAdapter cmd2ClientMapAdpt = new ICmd2ClientMapAdapter() {
			@Override
			public void pickBall(IUser user) {
				_mapModel.serverBallPick(user);
			}

			@Override
			public void shootBall(IUser user, Position dest) {
				_mapModel.serverBallShoot(user, dest);
			}

			@Override
			public void playerDie(IUser user) {
				_mapModel.serverPlayerDie(user);
			}

			@Override
			public void playerMove(IUser user, Position dest) {
				_mapModel.serverPlayerMove(user, dest);
			}

			@Override
			public void gameOver(String gameOverMessage) {
				// TODO Auto-generated method stub
				_mapModel.gameOver(gameOverMessage);
			}
			
		};
		cmd2ModelAdpt.put(gameKey, cmd2ClientMapAdpt);
		mapController.start();
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

}
