package lm44_xw47.chatRoom.model;

import common.IChatRoom;
import common.IUser;
import lm44_xw47.controller.IMapCtrl2MainViewAdapter;
import lm44_xw47.model.Place;
import lm44_xw47.view.MapView;

public interface ICmd2LobbyAdapter extends IMapCtrl2MainViewAdapter {
	public void addUser(IUser user);
	
	public void addTeam(IChatRoom team);
	
	public void removeUser(IUser user);
	
	public void removeTeam(IChatRoom team);
	
	public void addMapView(MapView<Place> mapView);
	
	public static final ICmd2LobbyAdapter NULL_OBJECT = new ICmd2LobbyAdapter() {
		/**
		 * No-op.
		 */
		@Override
		public void addUser(IUser user) {
		}

		/**
		 * No-op.
		 */
		@Override
		public void addTeam(IChatRoom team) {
		}

		/**
		 * No-op.
		 */
		@Override
		public void removeUser(IUser user) {
		}

		/**
		 * No-op.
		 */
		@Override
		public void removeTeam(IChatRoom team) {
		}
		
		/**
		 * 
		 */
		public void addMapView(MapView<Place> mapView) {
		}

		/**
		 * No-op.
		 */
		@Override
		public void addMapView2MainView(MapView<Place> mapView) {
		}
		
	};
}
