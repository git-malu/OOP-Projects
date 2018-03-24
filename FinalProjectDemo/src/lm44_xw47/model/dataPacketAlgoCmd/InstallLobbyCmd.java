package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IChatRoom;
import common.IUser;
import common.IUserCmd2ModelAdapter;
import lm44_xw47.chatRoom.controller.LobbyController;
import lm44_xw47.chatRoom.model.ICmd2LobbyAdapter;
import lm44_xw47.chatRoom.view.LobbyView;
import lm44_xw47.model.Place;
import lm44_xw47.model.dataType.InstallLobbyType;
import lm44_xw47.view.MapView;
import provided.mixedData.MixedDataKey;

public class InstallLobbyCmd extends DataPacketUserAlgoCmd<InstallLobbyType> {

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -238717014094892202L;
	
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	private MixedDataKey<ICmd2LobbyAdapter> key;
	
	public InstallLobbyCmd(MixedDataKey<ICmd2LobbyAdapter> key) {
		this.key = key;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<InstallLobbyType> host, String... params) {
		InstallLobbyType data= host.getData();
		LobbyController lobbyController = new LobbyController(data.getUsers(), data.getTeams(), data.getLocalUser(), host.getSender());
		LobbyView lobbyView = lobbyController.getLobbyView();
		ICmd2LobbyAdapter cmd2LobbyAdapter = new ICmd2LobbyAdapter() {

			@Override
			public void addUser(IUser user) {
				lobbyView.addUser(user);
			}

			@Override
			public void addTeam(IChatRoom team) {
				lobbyView.addTeam(team);
			}

			@Override
			public void removeUser(IUser user) {
				lobbyView.removeUser(user);
			}

			@Override
			public void removeTeam(IChatRoom team) {
				lobbyView.removeTeam(team);
			}

			@Override
			public void addMapView(MapView<Place> mapView) {
				lobbyView.getPnlGame().add(mapView);
			}

			@Override
			public void addMapView2MainView(MapView<Place> mapView) {
				lobbyView.getPnlGame().add(mapView);
			}
			
		};
		cmd2ModelAdpt.put(key, cmd2LobbyAdapter);// put into client side local storage
		lobbyController.start();
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

}
